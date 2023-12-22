package matexScraping.MatexScraping;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RBL_Bank2 {
        static Logger log =Logger.getLogger(RBL_Bank2.class);
        static Workbook workbookOutput = new XSSFWorkbook();
        static Sheet sheetOutput = workbookOutput.createSheet("RBL_Bank_logsheet");
        static String excelOutput = "/home/admin/Documents/RBL_Bank_Statusbook.xlsx";
        static WebDriver driver;
        static String Download_Path="/home/admin/Documents/RBLbank_Candidates";
        @BeforeMethod
        public static  void openBrowser() throws IOException, InterruptedException, AWTException {
            FileInputStream fis= new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(fis);
            String Executables = p.getProperty("driver_Execeutables");
            String Chrome_path = p.getProperty("Chrome_path");
            String username= p.getProperty("RBLbank_UserName");
            String password= p.getProperty("RBLbank_Password");
            System.setProperty(Executables, Chrome_path);
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--remote-allow-origins=*");

            chromePrefs.put("download.default_directory", Download_Path);

            // Initialize the Chrome WebDriver with the specified options
            options.setCapability("acceptSslCerts", true);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            String url = p.getProperty("RBLbank_URL");
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement login_user = driver.findElement(By.id("dialogTemplate-dialogForm-content-login-name1"));

            login_user.sendKeys(username);
            WebElement login_password = driver.findElement(By.id("dialogTemplate-dialogForm-content-login-password"));

            login_password.sendKeys(password);

          //Clicking on Sign in button
            WebElement Sign =driver.findElement(By.xpath("//*[@id=\"dialogTemplate-dialogForm-content-login-defaultCmd\"]/span/span/span"));
            Sign.click();
            Thread.sleep(1000);

            //clicking the Recuriting button
            WebElement Recurit = driver.findElement(By.id("menuTemplate-menuForm-globalHeader-pageRibbonSubView-j_id_id29pc12-0-ribbonItemText"));
            Recurit.click();
            Thread.sleep(1000);
        RBLbank_Excel_Read();
        }
        @Test(priority = 1)
        private static void  RBLbank_Excel_Read() throws IOException, InterruptedException {
             System.out.println("##### Entering Excel_Read() method.!! #####");
                try {
                    String[] id_numbers;

                    //Opening Excel sheet
                    FileInputStream fis= new FileInputStream("Overall.properties");
                    Properties p = new Properties();
                    p.load(fis);
                    System.out.println("Loaded");
                    String excel = p.getProperty("RBL_Excel");
                    FileInputStream inputStream= new FileInputStream(excel);
                    XSSFWorkbook workbook =new  XSSFWorkbook(inputStream);
                    Sheet sheet = workbook.getSheetAt(0);
                    int columnIndex = 0;
                    List<String> columnValues = new ArrayList<>();
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
                        if (row != null) {
                            boolean skipRow = false;
                            for (int j = 0; j <= columnIndex; j++) {
                                Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                                if (cell == null) {
                                      System.out.println("Row " + i + " is empty.");
                                      logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
                                      logAndWriteToExcel(sheetOutput, "No ID found", i, 3 , dataStyle);
                                    // Skip the entire row if any cell is empty
                                    skipRow = true;
                                    break;
                                }
                            }
                            if (!skipRow) {
                                Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                                if (cell != null) {
                                    System.out.println("Entering cell");
                                    String id;
                                    switch (cell.getCellType()) {
                                    case NUMERIC:
                                        double numericValue = cell.getNumericCellValue();
                                        id= String.valueOf((int) numericValue);
                                        columnValues.add(String.valueOf((int) numericValue));
                                        break;
                                    default:
                                        continue;
                                    }
                                    System.out.println("Exiting cell");
                                    log.info("ID is "+ id);
                                    logAndWriteToExcel(sheetOutput, id, i, 0 , dataStyle);
                                  Download_Files(id, i, sheet, dataStyle);
                                }
                            }
                        }
                        else {
                                System.out.println("Row " + i + " is empty.");
                                logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
                                logAndWriteToExcel(sheetOutput, "No ID found", i, 3 , dataStyle);
                          }
                    }
                afterTest();
                }catch(NullPointerException n) {
                log.info("Moving files to the id");
                }
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


        private static  void Download_Files(String id , int i, Sheet sheet ,CellStyle dataStyle ) throws InterruptedException {
        	//			  Thread.sleep(15000);
			   By elementLocator = By.xpath("//input[@id='oj-inputsearch-input-search-input']");

		        // Set the maximum time to wait for the element to be visible (in seconds)
		        int timeoutInSeconds = 60;

		        // Create a WebDriverWait instance with the specified timeout
		        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

//		        try {
		            // Wait for the element to be visible
		            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	  
//			  WebElement input = driver.findElement(By.xpath("//input[@id='oj-inputsearch-input-search-input']"));
		        Thread.sleep(1000);
		        input.clear();
		        Thread.sleep(1000);
		        input.sendKeys(id);
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("/html/body/div[4]/div/header/nav/div/quick-search/div[2]/div/div/div[1]/a")).click();
		        Thread.sleep(2000);

		         if(driver.findElement(By.xpath("//h1[@id='content_titlebar']")).isDisplayed()) {            //If TitleBar is displayed.
		            log.info("No Alert is present");
		            Thread.sleep(4000);
//		            driver.findElement(By.xpath("//span[text()='Back to Center Stage']")).click();                //Clicking a button for next iteration
		         
		            try {
						WebElement tabledatapro1 = driver.findElement(By.id("oj-collapsible-702-content"));
						log.info("5333333333333334");
						tabledatapro1.getText();
					String ll = tabledatapro1.getText();
					log.info(ll);
						log.info("check**************************");
//						WebElement verify = driver.findElement(By.cssSelector("#oj-collapsible-1-content > div > div > div.summary__section.summary__section--basic.summary-application > candidate-info-renderer > h4 > small:nth-child(2) > span:nth-child(2)"));
//						log.info("check**************************454545454");
//						verify.getText();
//						log.info("check**************************7078708");
//						String Ver = verify.getText();
//						log.info("check**************************86876");
//				log.info(Ver);
//					 System.out.println(Ver);
//					
						WebElement tabledata = driver.findElement(By.id("oj-collapsible-699-content"));
							
						
					 if(tabledata.isDisplayed()) {	 
					 
					 
					System.out.println("1*********");
					
						//clicking on personal information
						
						System.out.println("2********8");
						
						//taking table data for the personal information
						tabledata.getText();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						System.out.println("3*******8");
						
						//converting tabletext into string
						String tabletext = tabledata.getText();
						log.info(tabletext);
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						System.out.println("4********");
						
							//##############################################3333
						System.out.println("5*******");
						// ===========scroll========//
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,5000)");
						Thread.sleep(2000);

						//##############################################3333	
						
						//clicking on Experience and Credentials information
						WebElement Experience = driver.findElement(By.id("703-header"));
						Experience.click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						//taking table data for the personal information
						WebElement tabledataexp = driver.findElement(By.id("oj-collapsible-703-content"));
						tabledataexp.getText();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						//converting tabletext into string
						String tabletextexp = tabledataexp.getText();
						log.info(tabletextexp);
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
							
						//##############################################3333
						// ===========scroll========//
								JavascriptExecutor js1 = (JavascriptExecutor) driver;
								js1.executeScript("window.scrollBy(0,5000)");
								Thread.sleep(2000);
								System.out.println("6*******");
						//##############################################3333	
						
						//clicking on Profile information
						WebElement Profile = driver.findElement(By.id("702-header"));
						Profile.click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						//taking table data for the personal information
						WebElement tabledatapro = driver.findElement(By.id("oj-collapsible-702-content"));
						tabledatapro.getText();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						//converting tabletext into string
						String tabletextpro = tabledatapro.getText();
						log.info(tabletextpro);
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						//##############################################3333
						// ===========scroll========//
								JavascriptExecutor js2 = (JavascriptExecutor) driver;
								js2.executeScript("window.scrollBy(0,5000)");
								Thread.sleep(3000);
								System.out.println("7*******");
						
						//##############################################3333	
						
						//clicking on Submission information
						WebElement Submission = driver.findElement(By.id("701-header"));
						Submission.click();
						System.out.println("7999*******");
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						JavascriptExecutor js11 = (JavascriptExecutor) driver;
						js11.executeScript("window.scrollBy(0,2000)");
						Thread.sleep(2000);

						//taking table data for the personal information//  
						WebElement tabledataSub = driver.findElement(By.xpath("//*[@id=\"oj-collapsible-701-content\"]"));
						// ===========scroll========//
						JavascriptExecutor js3 = (JavascriptExecutor) driver;
						js3.executeScript("window.scrollBy(0,5000)");
						Thread.sleep(2000);

						tabledataSub.getText();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						//converting tabletext into string
						String tabletextSub = tabledataSub.getText();
						log.info(tabletextSub);
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						System.out.println("8*******");
					
						//##############################################3333
								// ===========scroll========//
								JavascriptExecutor js9 = (JavascriptExecutor) driver;
								js9.executeScript("window.scrollTo(0, 0);");
					Thread.sleep(2000);
							
						//clicking on Attachments to downlaod
								WebElement Attach = driver.findElement(By.xpath("//*[@id=\"profile-attachment-tab\"]"));
								//Scrolling to the particular text
								System.out.println("8hvfgkh*******");	
								
								Attach.click();
								Thread.sleep(2000);
									Thread.sleep(1000);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
								//attachments for downlaods
								WebElement table = driver.findElement(By.xpath("//*[@id=\"profileAttachmentsTable\"]/table")); // Replace 'your-table-id' with the actual ID of your table
								List<WebElement> rows = table.findElements(By.tagName("tr"));
								//int rowSize = rows.size();
								System.out.println(rows.size()); // Output the row size to the console
			         
							    //int rowCount = innerRows.size();
					            System.out.println("Inner row  size "  + rows.size() );													
						   try {
					            //looping for the inner table 
							     for (int l = 1; l < rows.size(); l++) {				
					    	 	WebElement Doc = driver.findElement(By.xpath("html/body/div[4]/div/div[4]/div[1]/section/div[2]/div/div[2]/div[5]/div[3]/oj-table/table/tbody/tr["+l+"]/td[1]/div/div/div[2]/button[3]"));
							    	 			
							    	 	JavascriptExecutor Downloadclick = (JavascriptExecutor) driver;
										Downloadclick.executeScript("arguments[0].click();", Doc);
										Thread.sleep(1000);
										System.out.println("clickedugyigy");
										
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
										Thread.sleep(1000);
								    		System.out.println("Document downloading for Row =   in "+l+ " Document is downloaded");
							     System.out.println("wating to download the document ");

							     }
							  
							     }catch (StaleElementReferenceException e){
							    	 System.out.println("Element has faced some problems" +  e);
								     
							     }
						
						   Thread.sleep(3000);
						   //clicking  recuring for the  scrapping for other id's
						   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
						   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
						   Recuring12.executeScript("arguments[0].click();", Recuring);
							Thread.sleep(2000);
						
						  
						   Thread.sleep(2000);
						   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
							  
						 // clicking  the search for the candidate to scrap for existing id's
						   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
						   search1.click();
						   Thread.sleep(2000);
						   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
							   
					 }else if(!driver.findElement(By.xpath("//*[@id=\"ui-id-110\"]")).isDisplayed()){
							log.info("else");
						 //clicking  recuring for the  scrapping for other id's
					   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
					   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
					   Recuring12.executeScript("arguments[0].click();", Recuring);
						Thread.sleep(2000);
					
					  
					   Thread.sleep(2000);
					   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						  
					 // clicking  the search for the candidate to scrap for existing id's
					   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
					   search1.click();
					   Thread.sleep(2000);
					   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					 }
//					 Folder_creation(id);
					 Folder_creation(id, i, sheet, dataStyle);
					}catch(Exception e2) {
						
						log.info("catch exception");
						System.out.println("id not found fo ID "+id +"so skipped to another id");
							log.info("id not found fo ID "+id +"so skipped to another id");	
							// Click to another candidate to scrap
							//clicking  recuring for the  scrapping for other id's
							   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
							   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
							   Recuring12.executeScript("arguments[0].click();", Recuring);
								Thread.sleep(2000);
							
							  
							   Thread.sleep(2000);
							   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
								  
							 // clicking  the search for the candidate to scrap for existing id's
							   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
							   search1.click();
							   Thread.sleep(2000);
							   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					 }	
				
		         
		            
		         }
		        else if(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/button/div/span")).isDisplayed()) {        //If pop up is displayed
		        	log.info("Third condition block");
			        logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
	                   logAndWriteToExcel(sheetOutput, "Incorrect ID", i, 3 , dataStyle);
		        	Thread.sleep(4000);
		            log.info("Clicking on close button on pop up");
		            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/button/div/span")).click();                    //Clicking on close button
		            Thread.sleep(2000);
		            log.info("Sandwich element fetched (else if)");
		            driver.findElement(By.xpath("/html/body/div[5]/div/header/nav/div/div[1]/div/div/ul/li[1]/div/i")).click();                //Clicking on sandwich button
		            Thread.sleep(2000);
		            log.info("Clicked on home button ()");
		            driver.findElement(By.xpath("/html/body/div[5]/div/header/nav/div/div[1]/div/div/ul/li[1]/ul/li[1]/a/span")).click();    //Clicking on home button for next iteration
		            Thread.sleep(2000);
		            driver.findElement(By.xpath("//a[text()='Recruiting']")).click();                    //Clicking on Recruiting button
		            
		        }
		        else {
		            log.info("Third condition block");
		        logAndWriteToExcel(sheetOutput, "Fail", i, 2 , dataStyle);
                   logAndWriteToExcel(sheetOutput, "Incorrect ID", i, 3 , dataStyle);
}
		        log.info("Getting URL");
		}
        


        private static void Folder_creation(String id, int i, Sheet sheet,  CellStyle dataStyle) throws InterruptedException {

            String base_path = Download_Path;
                String subfolder_path ="";
                subfolder_path = base_path + File.separator +id;
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
                        System.out.println("fileName is =====>>>>"+fileName);
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
//                    driver.get("https://rblbank.taleo.net/enterprise/fluid?isNavigationCompleted=true");
            }

        @AfterMethod
        private static void afterTest() {
            try (FileOutputStream fileOut = new FileOutputStream(excelOutput)) {
                workbookOutput.write(fileOut);
            } catch (IOException e) {
                System.out.println("Error writing to output file: " + e.getMessage());
                e.printStackTrace();
            }
             System.out.println("AfterTest");
                driver.close();
        }

        }