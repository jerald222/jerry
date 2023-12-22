package matexScraping.MatexScraping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class HCL_2 {
    static WebDriver driver;
    static String Download_Path="/home/admin/Documents/HCL_Candidates";
   
    public static void openBrowser() throws IOException, InterruptedException, AWTException {
        FileInputStream fis= new FileInputStream("Overall.properties");
        Properties p = new Properties();
        p.load(fis);
        String Executables = p.getProperty("driver_Execeutables");
        String Chrome_path = p.getProperty("Chrome_path");
        String username= p.getProperty("HCL_UserName");
        String password= p.getProperty("HCL_Password");
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
        String url = p.getProperty("HCL_URL");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_user = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txttpaUserId']"));
        login_user.sendKeys(username);
        WebElement login_password = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txttpaPassword']"));
        login_password.sendKeys(password);
        WebElement submit = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnLogin']"));
        submit.click();
        WebElement Pending_Vendors = driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_grdSummary_ctl02_lnkViewdetail']"));
        Pending_Vendors.click();
        Excel_Read();
    }

    @Test(priority = 1)
    public static void Excel_Read() throws IOException, InterruptedException, AWTException {
        System.out.println("##### Entering Excel_Read() method.!! #####");
        try {
            String[] id_numbers;

            //Opening Excel sheet
            FileInputStream fis= new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(fis);
            System.out.println("Loaded");
            String excel = p.getProperty("HCL_Excel");
            FileInputStream inputStream= new FileInputStream(excel);
            XSSFWorkbook workbook =new  XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int columnIndex = 0;
            List<String> columnValues = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    boolean skipRow = false;
                    for (int j = 0; j <= columnIndex; j++) {
                        Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                        if (cell == null) {
                            // Skip the entire row if any cell is empty
                            skipRow = true;
                            break;
                        }
                    }
                    if (!skipRow) {
                        Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                        if (cell != null) {
                            System.out.println("Entering cell");

                            switch (cell.getCellType()) {
                            case NUMERIC:
                                double numericValue = cell.getNumericCellValue();
                                columnValues.add(String.valueOf((int) numericValue));
                                break;
                            default:
                                continue;
                            }
                            System.out.println("Exiting cell");
                        }
                    }
                }
            }
            for (String id : columnValues) {
                System.out.println("Working ID is " + id);
                Download_Files(id);
            }
        afterTest();
        }catch(NullPointerException n) {
        }
    }

    private static void Download_Files(String id) throws InterruptedException, AWTException {
        System.out.println("Entering Download_Files method");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    try {
        WebElement text_area = driver.findElement(By.xpath("//textarea[@id='ctl00_ContentPlaceHolder1_txtTransferEmpCode']"));
        text_area.clear();
        text_area.sendKeys(id);
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSearch']"));
        search.click();
        Thread.sleep(7000);
            WebElement edit = driver.findElement(By.xpath("//a[text()='Edit/Update']"));

            edit.click();
            Thread.sleep(5000);

            String windowHandle1 = driver.getWindowHandle();
            for (String handle1 : driver.getWindowHandles()) {
                if (!handle1.equals(windowHandle1)) {
                    driver.switchTo().window(handle1);
                    System.out.println("Switching to second new Page");
                    WebElement package_name = driver.findElement(By.xpath("//span[@id='lblPkgname']"));
                    package_name.getText();
                    System.out.println("Pacakage Name is ======>>"+package_name);
                    Thread.sleep(3000);
                    WebElement download_all = driver.findElement(By.xpath("//input[@id='btnDownload']"));
                    download_all.click();
                    Thread.sleep(3000);
                    driver.close();
                }
            }

            driver.switchTo().window(windowHandle1);

            WebElement Joining_form = driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_grdTPAView_ctl02_lnkJoiningForm']"));
            Joining_form.click();
            Thread.sleep(5000);

            String windowHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(windowHandle)) {
                    driver.switchTo().window(handle);
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    js.executeScript("window.scrollBy(0,3000)");
                    System.out.println("Entering new page");
                    Thread.sleep(3000);
                    WebElement download = driver.findElement(By.xpath("//a[text()='Download']"));
                    download.click();
                    Thread.sleep(5000);
                    driver.close();
                }
            }
            driver.switchTo().window(windowHandle);
            Folder_creation(id);
            }
                catch(Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
                System.out.println("Skipping to the next ID.");
            }
 }

    public static void Folder_creation(String id) throws InterruptedException {
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
                        Thread.sleep(10000);
                        System.out.println("File moved successfully for ID: " + id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
            driver.get("https://wf6.myhcl.com/SmartVerifyRevampTPA/Vendor/TPAView.aspx");
    }

    @AfterTest
    public static void afterTest() {
        System.out.println("AfterTest");
        driver.close();
    }

}
