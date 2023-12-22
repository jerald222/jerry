package MatexScraping.MatexScraping;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;



public class Genpact_Latest {
    static WebDriver driver;
    static String Download_Path ="/home/admin/Documents/Genpact_Candidates";
    static Logger log = Logger.getLogger(Genpact_Latest.class.getName());
    static FileInputStream fileInputStream;

    @BeforeTest
    public void openBrowser() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException, AWTException {
        try {
            FileInputStream loginCredentials = new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(loginCredentials);
            String Executables = p.getProperty("driver_Execeutables");
            String Chrome_path = p.getProperty("Chrome_path");
            loginCredentials.close();
            String loginemail = p.getProperty("Genpact_email");
            String loginpassword = p.getProperty("Genpact_password");
            System.setProperty(Executables, Chrome_path);

            // Initialize the ChromeOptions and chromePrefs outside the loop
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--remote-allow-origins=*"); 
    		
            chromePrefs.put("download.default_directory", Download_Path);

            // Initialize the Chrome WebDriver with the specified options
            options.setCapability("acceptSslCerts", true); // Accept SSL certificates
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();

            String url = p.getProperty("Genpact_URL");
            driver.get(url);
            Thread.sleep(1000);

            WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
            email.sendKeys(loginemail);
            Thread.sleep(1000);
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys(loginpassword);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
        } catch (JsonException j) {
        }catch(FileAlreadyExistsException e) {}
    }

    @Test(priority = 1)
    public void login() throws InterruptedException, AWTException, EncryptedDocumentException, IOException, InvalidFormatException {
        String excelFilePath = "/home/admin/Documents/id_sheet.xlsx";
        String[] id_numbers;
        try {
            FileInputStream loginCredentials= new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(loginCredentials);
            String url= p.getProperty("Genpact_URL");
            Thread.sleep(2000);
            String Genpact_Excel=p.getProperty("Genpact_Excel");
            FileInputStream fileInputStream = new FileInputStream(Genpact_Excel);
            XSSFWorkbook workbook =new  XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int columnIndex = 0;
            int rowIndex =0;
            // Create a list to store the column values
            List<Integer> columnValues = new ArrayList<Integer>();
            System.out.println(columnValues);
            // Iterate through rows to read data from the specified column
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
//                Cell cell = row.getCell(columnIndex);

                for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    DataFormatter formatter = new DataFormatter();
     
                log.info(formatter);
                System.out.print(formatter.formatCellValue(cell) + "\t");
                
                   String data1 = formatter.formatCellValue(cell);
      
                try {
                    Integer intValue = Integer.parseInt(data1);
                    // Add the data to the list as a string
                    columnValues.add(intValue);
                } catch (NumberFormatException e) {
                    // Handle the case where the value cannot be converted to an integer
                    e.printStackTrace();
                }
               }
                }

            for (Integer value : columnValues) {
                System.out.println("The value is  "+value);  //Printing the next ID number
                id_numbers = new String[] {value.toString()};
                driver.findElement(By.xpath("//span[text()='All Cases']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[text()='In Progress']")).click();
                Thread.sleep(2000);
                System.out.println(id_numbers);

                for (String id : id_numbers) {
                    rowIndex++;
                    System.out.println("Working ID is "+id);
                    WebElement id_input = driver.findElement(By.xpath("//input[@class='form__input']"));
                    id_input.clear();
                    id_input.sendKeys(id);
                    Thread.sleep(4000);
                    Robot r= new Robot();
                    r.keyPress(KeyEvent.VK_ENTER);
                    r.keyRelease(KeyEvent.VK_ENTER);
                    Thread.sleep(3000);
                    WebElement drop_down = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[6]/div/div[1]/img"));
                    drop_down.click();
                    Thread.sleep(5000);
                    WebElement viewDetail = driver.findElement(By.xpath("//button[text()='View detail']"));
                    viewDetail.click();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    //Retrieving all the data from left side after clicking on view detail button
                    Thread.sleep(5000);
                    Map<String, String> elementMap = new HashMap<>();
                    String email = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/a")).getText();
                    elementMap.put("Email", email);

                    String Department = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[2]/div[2]")).getText();
                    elementMap.put("Department", Department);

                    String Location = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div[2]")).getText();
                    elementMap.put("Location", Location);

                    String Recruiter = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[4]/div[2]")).getText();
                    elementMap.put("Recruiter", Recruiter);

                    String RecruiterEmail = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[5]/div[2]/a")).getText();
                    elementMap.put("RecruiterEmail", RecruiterEmail);

                    String Phone_Number = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[6]/div[2]")).getText();
                    elementMap.put("Phone_Number", Phone_Number);

                    String Agent_name = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[7]/div[2]")).getText();
                    elementMap.put("Agent_name", Agent_name);

                    String Joining_date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[8]/div[2]")).getText();
                    elementMap.put("Joining_date", Joining_date);


                    String UID = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[9]/div[2]")).getText();
                    elementMap.put("UID", UID);

                    String Employee_code = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[10]/div[2]")).getText();
                    elementMap.put("Employee_code", Employee_code);

                    String Case_Allocation_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[11]/div[2]")).getText();
                    elementMap.put("Case_Allocation_Date", Case_Allocation_Date);

                    String Case_Claim_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[12]/div[2]")).getText();
                    elementMap.put("Case_Claim_Date", Case_Claim_Date);

                    String Case_Close_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[13]/div[2]")).getText();
                    elementMap.put("Case_Close_Date", Case_Close_Date);

                    String PID = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[14]/div[2]")).getText();
                    elementMap.put("PID", PID);

                    String Project_Name = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[15]/div[2]")).getText();
                    elementMap.put("Project_Name", Project_Name);

                    String Band = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[16]/div[2]")).getText();
                    elementMap.put("Band", Band);

                    String SDO = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[17]/div[2]")).getText();
                    elementMap.put("SDO", SDO);

                    String Legal_Entity = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[18]/div[2]")).getText();
                    elementMap.put("Legal_Entity", Legal_Entity);

                    String COE = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[19]/div[2]")).getText();
                    elementMap.put("COE", COE);

                    System.out.println(elementMap);

                    WebElement viewForm = driver.findElement(By.xpath("//div[text()=' View Form ']"));
                    viewForm.click();
                    Thread.sleep(6000);
                    driver.findElement(By.xpath("//div[text()=' Download ']")).click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//div[@class='btn btn__icon u-margin-right-vsmall']")).click();
                    Thread.sleep(2000);
                    WebElement viewDoc = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div[2]"));
                    viewDoc.click();
                    System.out.println("Clicking on viewDoc button");
                    Thread.sleep(2000);
                    List<WebElement> commonClass = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
                    for (WebElement element : commonClass) {
                        try {
                            element.click();
                            Thread.sleep(2000);
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                            driver.findElement(By.xpath("//span[text()='Open in new window']")).click();
                            Thread.sleep(4000);
                            String windowHandle1 = driver.getWindowHandle();
                            for (String handle : driver.getWindowHandles()) {
                                if (!handle.equals(windowHandle1)) {
                                    driver.switchTo().window(handle);
                                    Thread.sleep(3000);
                                    driver.close();
                                }
                            }
                            driver.switchTo().window(windowHandle1);

                        } catch (ElementClickInterceptedException e) {
                        } catch (NoSuchWindowException n) {
                        }catch(Exception e) {
                        }
                    }
                    test2(id);
                }

            }
        }catch(FileSystemException e) {}
    }

    @Test(priority = 2)
    public void test2(String id2) throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
        System.out.println("Entering test2() method");
        FileInputStream loginCredentials = new FileInputStream("Overall.properties");
        Properties p = new Properties();
        p.load(loginCredentials);
        String url = p.getProperty("Genpact_URL");
        Thread.sleep(2000);
        String Genpact_Excel = p.getProperty("Genpact_Excel");
        FileInputStream fileInputStream = new FileInputStream(Genpact_Excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int columnIndex = 0;
        int rowIndex=0;
        // Define the base path
        String basePath = "/home/admin/Documents/Genpact_Candidates";
        String subfolderPath ="";

        subfolderPath = basePath + File.separator + id2;
        System.out.println("Row   FolderPath "+subfolderPath);

        File download_folder = new File(Download_Path);
        File[] files = download_folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                File subfolder = new File(subfolderPath);
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
                        Thread.sleep(10000);
                        System.out.println("File moved successfully for ID: " + id2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }}
            }}
        driver.get(url);

        Robot pg_UP = new Robot();
        pg_UP.keyPress(KeyEvent.VK_PAGE_UP);
        pg_UP.keyRelease(KeyEvent.VK_PAGE_UP);
    }

    @AfterTest
    public void afterTest() {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("AfterTest");
    }

}