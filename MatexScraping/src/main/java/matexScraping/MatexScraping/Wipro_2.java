package matexScraping.MatexScraping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Wipro_2 {
	  	static	Logger log =Logger.getLogger(Wipro_2.class);
	  	static WebDriver driver;
	    static String Download_Path ="/home/admin/Documents/Wipro_candidates";
	    static Workbook workbookOutput = new XSSFWorkbook();
	    static Sheet sheetOutput = workbookOutput.createSheet("Wipro_logsheet");
	    static String excelOutput = "/home/admin/Documents/Wipro_Statusbook.xlsx";
	    @BeforeTest
	    public static void open_Browser() throws IOException, InterruptedException, AWTException {
	        FileInputStream fis= new FileInputStream("Overall.properties");
	        Properties p =new Properties();
	        p.load(fis);
	        String executables = p.getProperty("driver_Execeutables");
	        String chrome_path= p.getProperty("Chrome_path");

	        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	        chromePrefs.put("profile.default_content_settings.popups", 0);

	        //Setting the variables
	        System.setProperty(executables,chrome_path);
	        ChromeOptions options = new ChromeOptions();
	        chromePrefs.put("download.default_directory", Download_Path);
	        options.setExperimentalOption("prefs", chromePrefs);
	        options.addArguments("--remote-allow-origins=*"); 
			  
	        // Set Chrome capabilities directly in ChromeOptions
	        options.setCapability(ChromeOptions.CAPABILITY, options);
	        options.setCapability("acceptSslCerts", true); // Accept SSL certificates
	        driver= new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	        driver.manage().deleteAllCookies();
	        String url=p.getProperty("Wipro_URL");
	        driver.get(url);
	        String email=p.getProperty("Wipro_email");
	        String password=p.getProperty("Wipro_password");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[@id='next']")).click();
	        Thread.sleep(3000);

	        //Clicking the "SENDING VERIFICATION CODE" BUTTON
	        driver.findElement(By.xpath("//button[@id='ReadOnlyEmail_ver_but_send']")).click();
	        Thread.sleep(60000);

	        //OTP will be sent, should apply manually to automate next processes.
	        driver.findElement(By.xpath("//button[@class='verifyButton']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[@id='continue']")).click();
	        Thread.sleep(3000);
	        Excel_Read();
	        }

	    @Test(priority = 1)
	    public static void Excel_Read() throws InterruptedException, IOException, AWTException {
	        String[] id_numbers;

	        //Handling the employee dropdown
	        driver.findElement(By.xpath("//b[text()='Employee']")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//a[text()='Employee Verification New']")).click();
	        Thread.sleep(5000);
	        FileInputStream readExcel= new FileInputStream("Overall.properties");
	        Properties p = new Properties();
	        p.load(readExcel);
	        String WiproExcel= p.getProperty("Wipro_Excel");
	        FileInputStream fileInputStream = new FileInputStream(WiproExcel);
	        XSSFWorkbook workbook =new  XSSFWorkbook(fileInputStream);
	        Sheet sheet = workbook.getSheetAt(0);
	        int columnIndex = 0;
	        List<Integer> columnValues = new ArrayList<Integer>();
	        CellStyle headerStyle = workbookOutput.createCellStyle();
	        Font headerFont = workbookOutput.createFont();
	        headerFont.setBold(true);
	        headerStyle.setFont(headerFont);
	        headerStyle.setAlignment(HorizontalAlignment.CENTER);

	        //Write to new Excel Sheet
	        logAndWriteToExcel(sheetOutput, "ID", 0, 0 , headerStyle);
	        logAndWriteToExcel(sheetOutput, "Ref-no", 0, 1 , headerStyle);
	        logAndWriteToExcel(sheetOutput, "Status", 0, 2 , headerStyle);
	        logAndWriteToExcel(sheetOutput, "Remarks", 0, 3 , headerStyle);

	        CellStyle dataStyle = workbookOutput.createCellStyle();
	        dataStyle.setAlignment(HorizontalAlignment.CENTER);
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if(row == null) {
	                System.out.println("Row "+ i + " is Empty");
	                logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
	                logAndWriteToExcel(sheetOutput, "No ID found", i, 3 , dataStyle);
	                continue;
	            }
	            Cell cell = row.getCell(columnIndex);

	            // Get data from the Excel cell
	            double data = cell.getNumericCellValue();
	            String id = String.valueOf((int) data);
	            // Add the data to the list
	            columnValues.add((int) data);
	            logAndWriteToExcel(sheetOutput, id, i, 0 , dataStyle);
	            sendApplicationId(id, i, sheet, dataStyle);
	        }
	        close_Browser();
	    }

	    public static void logAndWriteToExcel(Sheet sheet, String message, int i, int columnIndex, CellStyle style) {
	        // Create a new row or get the existing row
	        Row row = sheet.getRow(i);
	        if (row == null) {
	            row = sheet.createRow(i);
	        }

	        // Create a new cell in the specified column
	        Cell cell = row.createCell(columnIndex);

	        // Set the cell value to the log message
	        cell.setCellValue(message);
	        cell.setCellStyle(style);
	        sheet.autoSizeColumn(columnIndex);
	    }

	    public static void sendApplicationId(String id , int i, Sheet sheet ,CellStyle dataStyle ) throws InterruptedException, AWTException, IOException, ElementClickInterceptedException {

	         String[] xpaths= {
	                 "//label[text()='Lateral']",
	                 "//label[text()='Contract']",
	                 "//label[text()='Internal']",
	                 "//label[text()='Campus']",
	           };
	         for (String xpath : xpaths) {
	        try {
	             System.out.println("### Entering For Loop ###");
	             WebElement element = driver.findElement(By.xpath(xpath));
	             element.click();
	             Thread.sleep(2000);
	             System.out.println("Element found: " + element.getText());
	             WebElement input_Field = driver.findElement(By.xpath("//input[@id='searchBar']"));
	             input_Field.clear();
	             Thread.sleep(1000);
	             input_Field.sendKeys(id);
	             Thread.sleep(1000);
	             Robot r= new Robot();
	             driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div")).click();     //Clicking on Search icon
	             Thread.sleep(2000);
	             r.keyPress(KeyEvent.VK_PAGE_UP);
	              r.keyRelease(KeyEvent.VK_PAGE_UP);

	              WebElement text = driver.findElement(By.xpath("//span[@class='col-xs-12 no_pad ng-star-inserted']"));
	              String text1 = text.getText();
	                  if(text.isDisplayed()) {
	                 System.out.println("Entering try to verify.!");
	                 WebElement verify_button = driver.findElement(By.xpath("//button[text()='VERIFY']"));
	                 verify_button.click();
	                 Thread.sleep(2000);
	                 WebElement consent = driver.findElement(By.xpath("//img[@alt='Consent']"));
	                 consent.click();
	                 Thread.sleep(1000);
	                 WebElement download_icon = driver.findElement(By.xpath("//span[@class='icon-file_download icon_download_color pull-right']"));
	                 download_icon.click();
	                 Thread.sleep(2000);
	                 JavascriptExecutor js=  (JavascriptExecutor) driver;
	                 js.executeScript("window.scrollBy(0,50)");
	                 WebElement download_All = driver.findElement(By.xpath("//span[text()='Download All documents']"));
	                 Thread.sleep(2000);
	                 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", download_All);
                      download_All.click();
	                 Thread.sleep(2000);

	                 js.executeScript("window.scrollBy(0,500)");
	                  List<WebElement> text_elements = driver.findElements(By.xpath("//span[@class='extra_dots']"));
	                  Thread.sleep(2000);
	                  for(WebElement elements:text_elements) {
	                     try {
	                     System.out.println("Elements displayed");
	                     elements.click();
	                     Thread.sleep(1000);
	                     Map<String, String> elementMap = new HashMap<>();
	                      WebElement details = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
	                      String Employee_details=details.getText();
	                      elementMap.put("Employment Details", Employee_details);
	                     System.out.print(elementMap);
	                     log.info("Details For the candidates ::" +elementMap);
	                     if(!details.isDisplayed()) {
	                     System.out.print(elementMap);
//	                     Thread.sleep(2000);
	                     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	                     }else {
	                         Thread.sleep(1000);
	                         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	                       }
	                      }catch (ElementClickInterceptedException e) {
	                          if(driver.findElement(By.xpath("//span[text()='Document not available']")).isDisplayed()) {
	                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	                             }
	                          }
	                         }
	                      }
	                  if(text1.contains(id))
	                 {
	                 createFolder(id, i, sheet, dataStyle);
	                 System.out.println("Calling createFolder() method..!!");
	                 break;
	                 }
	                  System.out.println("Exiting try to Catch Exception.!");
	            }catch(Exception e) {
	                System.out.println("Clicking NO and entering next method");
	                driver.findElement(By.xpath("//button[text()='OK']")).click();
	                logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
	                logAndWriteToExcel(sheetOutput, "Incorrect ID", i, 3 , dataStyle);
	            }
	         }
	    }

	    public static void createFolder(String id, int i, Sheet sheet,  CellStyle dataStyle) throws InterruptedException {
	        String base_path = "/home/admin/Documents/Wipro_candidates";
	        String subfolder_path ="";
	        subfolder_path = base_path + File.separator + id;
	         File subfolder = new File(subfolder_path);
	            if (!subfolder.exists() && subfolder.mkdirs()) {
	                System.out.println("Subfolder created: " + subfolder_path);
	            } else if (subfolder.exists()) {
	                System.out.println("Subfolder already exists: " + subfolder_path);
	            } else {
	                System.err.println("Failed to create subfolder: " + subfolder_path);
	            }
	        File download_folder = new File(Download_Path);
	        File[] files = download_folder.listFiles();
	        if (files != null) {
	            for (File file : files) {
	                String fileName = file.getName();
	                if (!subfolder.exists()) {
	                    subfolder.mkdirs();
	                    System.out.println("Directory is created");
	                }
	                if (file.isFile()) {      //This method will move only files not the directory which is present in default download path
	                    try {
	                        System.out.println("#############  Entering TRY  ##############");
	                        Path source = file.toPath();
	                        Path destination = new File(subfolder, file.getName()).toPath();
	                        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
	                        System.out.println("File moved successfully for ID: " + id);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if(subfolder.exists()) {
	                    logAndWriteToExcel(sheetOutput, "Pass", i , 2, dataStyle);
	                    logAndWriteToExcel(sheetOutput, "Scrapped successfully", i , 3, dataStyle);
	                }
	            else {
	                    logAndWriteToExcel(sheetOutput, "Fail", i , 2 , dataStyle);
	                    logAndWriteToExcel(sheetOutput, "Not scrapped", i, 3 , dataStyle);
	            }
	            }
	        }
	        driver.get("https://iverify.wipro.com/iVerify#/iVerify/va");
	    }

	     @AfterTest
	        public static void close_Browser() {
	         try (FileOutputStream fileOut = new FileOutputStream(excelOutput)) {
	                workbookOutput.write(fileOut);
	            } catch (IOException e) {
	                System.out.println("Error writing to output file: " + e.getMessage());
	                e.printStackTrace();
	            }
	            System.out.println("After_Test");
	            driver.close();
	        }
	}
























