package matexScraping.MatexScraping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Capgemini_2 {
	static	Logger log =Logger.getLogger(Capgemini_2.class);
    static WebDriver driver;
    static String Download_Path="/home/admin/Documents/Capgemini";
    static String Default_Screenshot_path="/home/admin/Pictures";

    @BeforeTest
    public static void beforeTest() throws IOException, InterruptedException, AWTException {
        FileInputStream fis= new FileInputStream("Overall.properties");
        Properties p = new Properties();
        p.load(fis);
        String Executables = p.getProperty("driver_Execeutables");
        String Chrome_path = p.getProperty("Chrome_path");
        String username= p.getProperty("Capgemini_Username");
        String password= p.getProperty("Capgemini_Password");
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
        String url = p.getProperty("Capgemini_URL");
        driver.get(url);
        WebElement login_user = driver.findElement(By.xpath("//input[@id='txtEmailId']"));
        login_user.sendKeys(username);
        WebElement login_password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        login_password.sendKeys(password);
        WebElement otp = driver.findElement(By.xpath("//span[text()='Send OTP']"));
        otp.click();
        Thread.sleep(50000);
        driver.findElement(By.xpath("//span[text()='Verify OTP']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();                 //Clicking the Dropdown
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div[1]/span")).click();        // Clicking the Candidate ID option
        Excel_Read();
    }
    @Test(priority = 1)
    public static void Excel_Read() throws IOException, InterruptedException, AWTException {
        System.out.println("Entering Excel_Read() method..!! ");
        try {
        FileInputStream fis= new FileInputStream("/home/admin/Documents/Capgemini.xlsx");
        Workbook workbook =new  XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int columnIndex = 0;
        List<Integer> columnValues = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
             Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Cell cell = row.getCell(columnIndex);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    double data = cell.getNumericCellValue();
                    String id = String.valueOf((int) data);
                    ID_input(id);
                } else {
                    System.out.println("Skipping row " + i + " as the cell is not numeric");
                }
        }
    }catch(NullPointerException n) {
        n.printStackTrace();
    }
}

    public static void ID_input(String id) throws InterruptedException, AWTException {
        System.out.println("Entering ID_input() method..!!");
   log.info("Entering ID_input() method..!!");
   log.debug(id);
   try {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement input_field = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[2]/div/field-control/input"));
        input_field.clear();
        Thread.sleep(2000);
        input_field.sendKeys(id);
        driver.findElement(By.xpath("//button[text()='Search ']")).click();               // Clicking on Search button
        WebElement id_ref = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[2]/grid-dispctrl/div[2]/div/table/tbody/tr/td[1]/field-control/div[1]/div/p/span"));
        if(id.equals(id_ref.getText())) {
            WebElement view = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[2]/grid-dispctrl/div[2]/div/table/tbody/tr/td[14]/field-control/ul/li[1]/a/i"));
            view.click();
            Thread.sleep(2000);
            }
        if(driver.findElement(By.xpath("/html/body/modal-popup[1]/div/div/div/div[1]/button")).isDisplayed()) {
        driver.findElement(By.xpath("/html/body/modal-popup[1]/div/div/div/div[1]/button")).click();            // Clicking the close button
        Thread.sleep(2000);
        }
        Thread.sleep(2000);
        Downloads(id);

        }catch(Exception e) {
        System.out.println("Exception occurred: " + e.getMessage());
        System.out.println("Skipping to the next ID.");
    }
    }

        public static void Downloads(String id) throws AWTException, InterruptedException {
            try {
                System.out.println("Entering Downloads() method..!!");

                //Handling Overview Option
                WebElement overview = driver.findElement(By.xpath("//a[@id='Overview']"));
                if(overview.isDisplayed()) {
                overview.click();
                Actions a = new Actions(driver);
                a.moveToElement(driver.findElement(By.xpath("//a[text()='Initiation Details']")));
                String overview_details = driver.findElement(By.xpath("//div[@class=\"contentScroll full p-3\"]")).getText();
                driver.findElement(By.xpath("//a[text()='Profile Details']")).click();                        //Clicking on the particular element to print the page.
                System.out.println("overview_details ====>>>"+ overview_details);
                Robot r= new Robot();
                r.keyPress(KeyEvent.VK_PRINTSCREEN);
                r.keyRelease(KeyEvent.VK_PRINTSCREEN);
                Thread.sleep(2000);
                r.keyPress(KeyEvent.VK_PAGE_DOWN);
                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(2000);
                r.keyPress(KeyEvent.VK_PRINTSCREEN);
                r.keyRelease(KeyEvent.VK_PRINTSCREEN);
                Thread.sleep(3000);
                }else {
                    System.out.println("overview is not displayed..!!");
                }

                //Handling Education Option
                WebElement education = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[3]/a"));
                if(education.isDisplayed()) {
                Robot r= new Robot();
                education.click();
                r.keyPress(KeyEvent.VK_PAGE_DOWN);
                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(1000);
                List<WebElement> education_options = driver.findElements(By.xpath("//button[@class='accordion-button collapsed justify-content-between']"));
                for(WebElement edu : education_options ) {
                    edu.click();
                    Thread.sleep(1000);
                    WebElement education_details = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[1]/div[1]/div/div[1]/div"));
                    String education_detail = education_details.getText();
                    System.out.println("education_details ====>>>"+ education_detail);
                    Thread.sleep(2000);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", edu);
//                    r.keyPress(KeyEvent.VK_PAGE_DOWN);
//                    r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                    Thread.sleep(2000);
                    r.keyPress(KeyEvent.VK_PRINTSCREEN);
                    r.keyRelease(KeyEvent.VK_PRINTSCREEN);
                    Thread.sleep(2000);
//                    r.keyPress(KeyEvent.VK_PAGE_UP);
//                    r.keyRelease(KeyEvent.VK_PAGE_UP);
                    Thread.sleep(2000);
                    edu.click();
                            }                                //For loop ends
                    }else {
                        System.out.println("education is not displayed..!!");
                    }


                    //Handling Employment Option

                    WebElement Employment_option = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[4]/a"));
                    if(Employment_option.isDisplayed()) {

                    if(driver.findElement(By.xpath("//*[@id=\"notificationDialog\"]/div/div/div[2]/div/label")).isDisplayed()) {
                        driver.findElement(By.xpath("//*[@id=\"notificationDialog\"]/div/div/div[1]/div/div/i[3]")).click();
                        }
                    else{
                        Employment_option.click();
                        Robot r= new Robot();
                        r.keyPress(KeyEvent.VK_PAGE_DOWN);
                        r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                        Thread.sleep(1000);

                        List<WebElement> employments = driver.findElements(By.xpath("//button[@class='accordion-button collapsed justify-content-between']"));
                    for(WebElement employment : employments) {
                        employment.click();
                        Thread.sleep(1000);
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", employment);
                        Thread.sleep(1000);

                        System.out.println("Employment details are available..!!");

                        r.keyPress(KeyEvent.VK_PRINTSCREEN);
                        r.keyRelease(KeyEvent.VK_PRINTSCREEN);
                        Thread.sleep(1000);
                        employment.click();
                            }                                        //For Loop ends
                        }

                    }else {
                        System.out.println("Employment_option is not displayed..!!");
                    }

            //Handling Database Option
            WebElement database_option = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[5]/a"));
            if(database_option.isDisplayed()) {
                database_option.click();
                Robot r= new Robot();
                r.keyPress(KeyEvent.VK_PAGE_DOWN);
                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(1000);
            List<WebElement> databases = driver.findElements(By.xpath("//button[@class='accordion-button collapsed justify-content-between']"));
            for(WebElement database : databases) {
            database.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", database);
            Thread.sleep(1000);
            r.keyPress(KeyEvent.VK_PRINTSCREEN);
            r.keyRelease(KeyEvent.VK_PRINTSCREEN);
            Thread.sleep(1000);
            Thread.sleep(3000);
            database.click();
                }                            //For loop ends
            }else {
                System.out.println("database_option is not displayed..!!");
            }


            //Handling CourtRecord option
            WebElement CourtRecord_option = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[6]/a"));
            if(CourtRecord_option.isDisplayed()) {
                CourtRecord_option.click();
                Robot r= new Robot();
                Thread.sleep(1000);
                r.keyPress(KeyEvent.VK_PAGE_DOWN);
                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(1000);
                List<WebElement> CourtRecords = driver.findElements(By.xpath("//button[@class='accordion-button collapsed justify-content-between']"));
            for(WebElement courtRecord: CourtRecords) {
                courtRecord.click();
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", courtRecord);
            Thread.sleep(1000);
            Thread.sleep(2000);
            r.keyPress(KeyEvent.VK_PRINTSCREEN);
            r.keyRelease(KeyEvent.VK_PRINTSCREEN);
            Thread.sleep(1000);
            Thread.sleep(3000);
            courtRecord.click();
                }                                    //For loop ends
            }else {
                System.out.println("CourtRecord_option is not displayed..!!");
            }


            //Handing UAN option
        try {
            WebElement UAN_option = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[7]/a"));
            if(UAN_option.isDisplayed()) {
            Robot r = new Robot();
            UAN_option.click();
            Thread.sleep(2000);
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
            List<WebElement> UAN = driver.findElements(By.xpath("//button[@class='accordion-button collapsed justify-content-between']"));
            Thread.sleep(1000);
            for(WebElement uan : UAN) {
            uan.click();
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uan);
            Thread.sleep(1000);
            r.keyPress(KeyEvent.VK_PRINTSCREEN);
            r.keyRelease(KeyEvent.VK_PRINTSCREEN);
            Thread.sleep(3000);
            uan.click();
            }

            }else {
                System.out.println("UAN_option is not displayed..!!");
            }
            }catch(Exception e) {
            System.out.println("Exception Occured :");
            e.printStackTrace();
            }

            //Handling Update option
            WebElement Update_option = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[1]/ul/li[8]/a"));
            if(Update_option.isDisplayed()) {
            Robot r = new Robot();
            Update_option.click();
            Thread.sleep(2000);
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(1000);
            r.keyPress(KeyEvent.VK_PRINTSCREEN);
            r.keyRelease(KeyEvent.VK_PRINTSCREEN);
            Thread.sleep(3000);

            }else {
                System.out.println("Update_option is not displayed..!!");
            }

            //Downloading Attachments
            WebElement Attachments = driver.findElement(By.xpath("//i[@id='Attachment']"));
            Attachments.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[3]/div[3]/div/button[2]")).click();
            Thread.sleep(2000);
            //Clicking on close button..
            driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[3]/div[1]/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"notificationDialog\"]/div/div/div[1]/div/div/i[3]")).click();    // Clicking on close button in alert pop up1
            Thread.sleep(2000);

            //Downloading Resume
            WebElement Resume = driver.findElement(By.xpath("//a[text()='Download Resume']"));
            Resume.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"notificationDialog\"]/div/div/div[1]/div/div/i[3]")).click();    // Clicking on close button in alert pop up
            Thread.sleep(2000);

            }catch(Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
                System.out.println("Skipping to the next ID.");
            }

            Folder_creation(id);
    }

    public static boolean Folder_creation (String id) throws InterruptedException {
        // Define the base path
        String basePath = "/home/admin/Documents/Capgemini";
        String subfolderPath ="";
        String screenshot_path=Default_Screenshot_path;
        subfolderPath = basePath + File.separator + id;
        System.out.println("Row   FolderPath "+subfolderPath);
        File download_folder = new File(Download_Path);
        File[] files = download_folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                File subfolder = new File(subfolderPath);
                File screenshot = new File(screenshot_path);
                if (!subfolder.exists()) {
                    subfolder.mkdirs();
                    System.out.println("Directory is created");
                }
                if (file.isFile()) {
                    try {
                        System.out.println("#############  Entering TRY  ##############");
                        Path source = file.toPath();
                        Path destination = new File(subfolder, file.getName()).toPath();
                        if (Files.exists(source)) {
                            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);

                            // Move the corresponding screenshot
                            File screenshotFile = new File(screenshot, file.getName());
                            Path screenshots = screenshotFile.toPath();

                            if (Files.exists(screenshots)) {
                                Files.move(screenshots, destination, StandardCopyOption.REPLACE_EXISTING);
                                System.out.println("File and screenshot moved successfully for ID: " + id);
                            } else {
                                System.err.println("Screenshot not found: " + screenshots);
                            }
                        } else {
                            System.err.println("Source file not found: " + source);
                        }
                        System.out.println("File moved successfully for ID: " + id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

         File sourceFolder = new File("/home/admin/Pictures");
            File subfolder = new File(subfolderPath);

            if (!subfolder.exists()) {
                subfolder.mkdirs();
                System.out.println("Subfolder is created");
            }

            if (sourceFolder.isDirectory() && sourceFolder.exists()) {
                File[] imageFiles = sourceFolder.listFiles(new FilenameFilter() {

                    public boolean accept(File dir, String name) {
                        // Filter image files (you can customize this based on your file types)
                        return name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png");
                    }
                });

                for (File imageFile : imageFiles) {
                    try {
                        System.out.println("Moving image: " + imageFile.getName());
                        Path source = imageFile.toPath();
                        Path destination = new File(subfolder, imageFile.getName()).toPath();

                        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Image moved successfully for ID: " + id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            driver.get("https://bgv.capgemini.com/External/#/External/app/home/search");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();                 //Clicking the Dropdown
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div[1]/span")).click();        // Clicking the Candidate ID option
            return true;
        }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
        driver.close();
    }

}
