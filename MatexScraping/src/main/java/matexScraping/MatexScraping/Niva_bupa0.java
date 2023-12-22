package matexScraping.MatexScraping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

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
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Niva_bupa0 {
    static WebDriver driver;
    static String Download_Path="/home/admin/Documents/NivaBupa";
 @BeforeTest
    public static void openBrowser() throws IOException, InterruptedException {
        FileInputStream fis= new FileInputStream("Overall.properties");
        Properties p = new Properties();
        p.load(fis);
        String Executables = p.getProperty("driver_Execeutables");
        String Chrome_path = p.getProperty("Chrome_path");
        String username= p.getProperty("NivaBupa_UserName");
        String password= p.getProperty("NivaBupa_Pasword");
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
        String url = p.getProperty("NivaBupa_URL");
        driver.get(url);
        WebElement login_user = driver.findElement(By.xpath("//input[@id='BgvLogin_username']"));
        login_user.sendKeys(username);
        WebElement login_password = driver.findElement(By.xpath("//input[@id='BgvLogin_password']"));
        login_password.sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-submit']")).click();
        Excel_Read();
    
    }
    @Test(priority = 1)
    public static void Excel_Read() throws IOException, InterruptedException {
        System.out.println("##### Entering Excel_Read() method.!! #####");
        try {
            //Opening Excel sheet
            FileInputStream fis= new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(fis);
            System.out.println("Loaded");
            String excel = p.getProperty("NivaBupa_Excel");
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

                                case STRING:
                                    String stringValue = cell.getStringCellValue();
                                    columnValues.add(stringValue);
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

    private static void Download_Files(String id) throws InterruptedException, IOException {
        System.out.println("Entered Download Method...!!!");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    try {
        WebElement id_Input = driver.findElement(By.xpath("//input[@id='candidate_search']"));
        id_Input.clear();
        Thread.sleep(2000);
        id_Input.sendKeys(id);
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='search-item']"));
        dropdown.click();
        Thread.sleep(3000);
        WebElement candidate_id = driver.findElement(By.xpath("//td[@class='sticky-col active-scroll first-col sorting_1']"));
        String text = candidate_id.getText();
        System.out.println(text);
        if(text.contains(id)) {
            System.out.println("Entering IF statement");
            WebElement candidate_name = driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tbody/tr/td[1]/a[2]"));
            candidate_name.click();
            Thread.sleep(5000);

            String windowHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(windowHandle)) {
                    System.out.println("Entering next page");
                    driver.switchTo().window(handle);
                    Thread.sleep(4000);
                    WebElement drop_down = driver.findElement(By.xpath("//span[@class='caret']"));
                    drop_down.click();
                    Thread.sleep(2000);
                    WebElement First_opt = driver.findElement(By.xpath("//a[text()='Filled version of the form']"));
                    First_opt.click();
                    Thread.sleep(5000);
                    WebElement drop_down1 = driver.findElement(By.xpath("//span[@class='caret']"));
                    drop_down1.click();
                    Thread.sleep(2000);
                    WebElement Third_opt = driver.findElement(By.xpath("//a[text()='Attachments in form']"));
                    Third_opt.click();
                    Thread.sleep(3000);
                    driver.close();
                }
            }
            driver.switchTo().window(windowHandle);
            Folder_Creation(id);
            }
        }catch(Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Skipping to the next ID.");
           }
     }

    private static void Folder_Creation(String id) {
        String basePath = Download_Path;
        String subfolderPath ="";
        subfolderPath = basePath + File.separator + id;
        System.out.println("Row   FolderPath "+subfolderPath);
        File download_folder = new File(Download_Path);
        File[] files = download_folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                System.out.println("File name is ====>>>>"+fileName);
                File subfolder = new File(subfolderPath);
                if (!subfolder.exists()) {
                    subfolder.mkdirs();
                    System.out.println("Directory is created");
                }
                if (file.isFile()) {
                    try {
                        System.out.println("############# TRYING TO MOVE FILES TO SUB-FOLDER  ##############");
                        Path source = file.toPath();
                        Path destination = new File(subfolder, file.getName()).toPath();
                        if (Files.exists(source)) {
                            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
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
        System.out.println("### Exiting Folder creation ###");
        driver.get("https://disha.darwinbox.in/onboarding/bgvemployees");
    }
    @AfterTest
    public static void afterTest() {
        System.out.println("After Test");
        driver.close();
    }

}