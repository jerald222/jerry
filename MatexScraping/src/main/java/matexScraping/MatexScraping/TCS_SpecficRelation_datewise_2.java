package matexScraping.MatexScraping;

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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCS_SpecficRelation_datewise_2 {

    static WebDriver driver;
    static String Download_Path="/home/admin/Documents/TCS_SpecficRelation_Datewise";
    static Workbook workbookOutput = new XSSFWorkbook();
     static Sheet sheetOutput = workbookOutput.createSheet("TCS_SpecficRelation_Datewise_logsheet");
    static String excelOutput = "/home/admin/Documents/TCS_SpecficRelation_Datewise_Statusbook.xlsx";
	public static void main(String[] args ) throws InterruptedException, IOException, AWTException {
		
		Open_Browser(args);
		
		}
	 
    @BeforeTest
    public static void Open_Browser(String[] args) throws IOException, InterruptedException, AWTException {
      
    	 SimpleDateFormat dateFormat;
		 dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String Datewise ="";// 2531691
		if (args[0] != "") {
			Datewise = args[0];
		}
	
		String Datewise1 ="";// 2531691
		if (args[1] != "") {
			Datewise1 = args[1];
		}
    	
    	
    	FileInputStream fis= new FileInputStream("Overall.properties");
            Properties p = new Properties();
            p.load(fis);
            String Executables = p.getProperty("driver_Execeutables");
            String Chrome_path = p.getProperty("Chrome_path");
            String username= p.getProperty("TCS_username");
            String password= p.getProperty("TCS_password");
            System.setProperty(Executables, Chrome_path);
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
            String url = p.getProperty("TCS_URL");
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement login_username = driver.findElement(By.xpath("//input[@id='loginForm:j_idt21']"));
            login_username.sendKeys(username);
            WebElement login_password = driver.findElement(By.xpath("//input[@id='loginForm:j_idt26']"));
            login_password.sendKeys(password);
            Thread.sleep(10000);
            WebElement login_button = driver.findElement(By.xpath("//input[@id='loginForm:addNewMiddle2']"));
            login_button.click();
            WebElement BGC_docs = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"));
            BGC_docs.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement Adv_filters = driver.findElement(By.xpath("//a[text()='Advanced Filters :']"));
            Adv_filters.click();
            WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
            BGC_type.click();
//            WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
//            Exp_professional.click();
            WebElement Relation_specific = driver.findElement(By.xpath("//li[text()='Relationship Specific BGC']"));
            Relation_specific.click();
         
            Thread.sleep(2000);
            WebElement start_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:fromDate_input']"));
            start_date.sendKeys(Datewise);
            Thread.sleep(1000);
            WebElement end_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:toDate_input']"));
            end_date.sendKeys(Datewise1);
            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
            Thread.sleep(3000);
            Robot r= new Robot();
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
            ID_input();  
    }

  @Test(priority = 1)
  private static void ID_input() throws InterruptedException, AWTException {
      System.out.println("Entering ID_input();");
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      int columnIndex = 0;
        System.out.println("Column index =0");
         CellStyle headerStyle = workbookOutput.createCellStyle();
          Font headerFont = workbookOutput.createFont();
          headerFont.setBold(true);
          headerStyle.setFont(headerFont);
          headerStyle.setAlignment(HorizontalAlignment.CENTER);
          CellStyle dataStyle = workbookOutput.createCellStyle();
          dataStyle.setAlignment(HorizontalAlignment.CENTER);
          //Write to new Excel Sheet
            logAndWriteToExcel(sheetOutput, "Applicant-ID", 0, 0 , headerStyle);
            logAndWriteToExcel(sheetOutput, "Employee-ID", 0, 1 , headerStyle);
            logAndWriteToExcel(sheetOutput, "Ref-no", 0, 2 , headerStyle);
            logAndWriteToExcel(sheetOutput, "Status", 0, 3 , headerStyle);
            logAndWriteToExcel(sheetOutput, "Remarks", 0, 4 , headerStyle);

    try {
      int table = driver.findElements(By.xpath("//tr[@role='row']")).size();
     System.out.println(table);
     for(int i=0;i<table-1;i++) {
         String App_id = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:"+ i +":applicantEmployeeID']")).getText();
         Thread.sleep(1000);
         String Emp_id = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:"+ i +":employeeID']")).getText();
         Thread.sleep(1000);
         WebElement Applicant_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt58']"));
         Thread.sleep(1000);
         WebElement Employee_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt49']"));
         Applicant_ID.sendKeys(App_id);
         Thread.sleep(1000);
         Employee_ID.sendKeys(Emp_id);
         Thread.sleep(1000);
         logAndWriteToExcel(sheetOutput, App_id, i+1, 0, dataStyle);
         logAndWriteToExcel(sheetOutput, Emp_id, i+1, 1, dataStyle);
         driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
         Robot r= new Robot();
            r.keyPress(KeyEvent.VK_PAGE_DOWN);
            r.keyRelease(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(2000);
         String BGC_Type = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:bgcType']")).getText();
            System.out.println("BGC_Type is ===>>> "+BGC_Type);
            String Region = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:candidateRegion']")).getText();
            System.out.println("Region is ===>>>> "+Region);
            String Assigned_date = driver.findElement(By.xpath("//td[@style='width:6%;'][3]")).getText();
            System.out.println("Assigned_date is "+Assigned_date);

//        WebElement BGC_Form = driver.findElement(By.xpath("//a[text()='BGC Form']"));
//        BGC_Form.click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//a[text()='View BGC Form']")).click();
//        Thread.sleep(2000);
//        if(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).isDisplayed()) {
//            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
//        }
//        Thread.sleep(2000);
//        WebElement resume = driver.findElement(By.xpath("//a[text()='Resume']"));
//        resume.click();
//        Thread.sleep(2000);
        WebElement Action_req = driver.findElement(By.xpath("//a[@id='agencySearchViewForm:checksDatatable:0:actionRequired']"));
        Action_req.click();
        Thread.sleep(3000);
         List<WebElement> documents = driver.findElements(By.xpath("//a[@class='ui-commandlink ui-widget linkStyle']"));
         System.out.println("Total number of Links =========>>"+documents.size());
         for(int k=1; k<=documents.size();k++) {      //Outer FOR loop
             try {
                 System.out.println("Number of Iteration===>> "+k);
               WebElement document = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr[1]/td/div/div/div/div/table/tbody/tr["+ k +"]/td[3]/a"));
                    System.out.println("First for loop");
                    Thread.sleep(2000);
                    document.click();
                    Thread.sleep(2000);
                    JavascriptExecutor js = (JavascriptExecutor)driver;
                    js.executeScript("window.scrollBy(0,70)");
                    System.out.println("Document click");
        List<WebElement> links = driver.findElements(By.xpath("//a[@class='linkStyle']"));
        System.out.println(links.size());
        for(int j=1;j<=links.size();j++) {                //Inner FOR loop
            System.out.println("Number of links ===>>"+links.size());
            WebElement link = driver.findElement(By.xpath("//a[@class='linkStyle']"));
                    System.out.println("Second for loop");
                    link.click();
                    Thread.sleep(2000);
                    System.out.println("Link clicked");
                    if(!link.isDisplayed()) {
                    break;
                    }
                }
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(2000);
             }catch(ElementClickInterceptedException e) {}
        }
         Folder_creation(App_id , Emp_id, i, dataStyle);
     }
    }catch(ElementNotInteractableException | StaleElementReferenceException e) {
        e.printStackTrace();
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

  private static void Folder_creation(String App_id, String Emp_id,int i,  CellStyle dataStyle ) throws InterruptedException, AWTException {
      if(Emp_id.isEmpty()) {
            System.out.println("Creating subfolder on Applicant id");
        String base_path = Download_Path;
      String subfolder_path ="";
      subfolder_path = base_path + File.separator + App_id;
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
              System.out.println("fileName is ======>>>>>>"+fileName);
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
                      System.out.println("File moved successfully for ID: " + App_id);
                      logAndWriteToExcel(sheetOutput, "pass", i+1, 3, dataStyle);
                      logAndWriteToExcel(sheetOutput, "ID scrapped successfully", i+1, 4, dataStyle);
                  } catch (IOException e) {
                      e.printStackTrace();
                          }
                      }
                  }
              }
      driver.findElement(By.xpath("//a[text()='Home']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
      Thread.sleep(2000);
        WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
        BGC_type.click();
        Thread.sleep(2000);
        WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
        Exp_professional.click();
        Thread.sleep(2000);
        WebElement start_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:fromDate_input']"));
        start_date.sendKeys("01-12-2023");
        Thread.sleep(1000);
        WebElement end_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:toDate_input']"));
        end_date.sendKeys("15-12-2023");
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        System.out.println("Completing the Loop");
      }
      else if(App_id.isEmpty()) {
            System.out.println("Creating subfolder on Employee id ");
            String base_path = Download_Path;
            String subfolder_path ="";
            subfolder_path = base_path + File.separator +Emp_id;
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
                    System.out.println("fileName is ======>>>> "+fileName);
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
                            logAndWriteToExcel(sheetOutput, "pass", i+1, 3, dataStyle);
                            logAndWriteToExcel(sheetOutput, "ID scrapped successfully", i+1, 4, dataStyle);
                            System.out.println("File moved successfully for ID: " + Emp_id);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            driver.findElement(By.xpath("//a[text()='Home']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
            Thread.sleep(2000);
              WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
              BGC_type.click();
              Thread.sleep(2000);
              WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
              Exp_professional.click();
              Thread.sleep(2000);
              WebElement start_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:fromDate_input']"));
              start_date.sendKeys("01-12-2023");
              Thread.sleep(1000);
              WebElement end_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:toDate_input']"));
              end_date.sendKeys("15-12-2023");
              driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
      }
      else {
          System.out.println("Creating subfolder on Applicant id");
            String base_path = Download_Path;
          String subfolder_path ="";
          subfolder_path = base_path + File.separator +App_id;
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
                          logAndWriteToExcel(sheetOutput, "pass", i+1, 3, dataStyle);
                            logAndWriteToExcel(sheetOutput, "ID scrapped successfully", i+1, 4, dataStyle);
                          System.out.println("File moved successfully for ID: " + App_id);
                      } catch (IOException e) {
                          e.printStackTrace();
                              }
                          }
                      }
                  }
          System.out.println("Staring to Loop");
          driver.findElement(By.xpath("//a[text()='Home']")).click();
          Thread.sleep(3000);
          driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
          Thread.sleep(2000);
            WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
            BGC_type.click();
            Thread.sleep(2000);
            WebElement Relation_specific = driver.findElement(By.xpath("//li[text()='Relationship Specific BGC']"));
            Relation_specific.click();
            Thread.sleep(2000);
            WebElement start_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:fromDate_input']"));
            start_date.sendKeys("01-12-2023");
            Thread.sleep(1000);
            WebElement end_date = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:advanceSearchPanel:toDate_input']"));
            end_date.sendKeys("15-12-2023");
            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
            System.out.println("Completing the Loop");
      }

}

@AfterTest
  public void afterTest() {
    try (FileOutputStream fileOut = new FileOutputStream(excelOutput)) {
        workbookOutput.write(fileOut);
    } catch (IOException e) {
        System.out.println("Error writing to output file: " + e.getMessage());
        e.printStackTrace();
    }
      System.out.println("After Test");
      driver.close();
  }


}
