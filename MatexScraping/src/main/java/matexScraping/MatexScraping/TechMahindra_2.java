package matexScraping.MatexScraping;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TechMahindra_2 {
	  static WebDriver driver;
	  static	Logger log =Logger.getLogger(TechMahindra_2.class);
	  static String Download_Path="/home/admin/Documents/TechMahindra_Candidates";
	    public static void openBrowser() throws IOException, InterruptedException, AWTException {
	        FileInputStream fis= new FileInputStream("Overall.properties");
	        Properties p = new Properties();
	        p.load(fis);
	        String Executables = p.getProperty("driver_Execeutables");
	        String Chrome_path = p.getProperty("Chrome_path");
	        String username= p.getProperty("TechMahindra_UserName");
	        String password= p.getProperty("TechMahindra_Password");
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
	        String url = p.getProperty("TechMahindra_URL");
	        driver.get(url);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement login_user = driver.findElement(By.id("txtUserName"));
	        login_user.sendKeys(username);
	        WebElement login_password = driver.findElement(By.id("txtPassword"));
	        login_password.sendKeys(password);
	    	//login button
	    	WebElement login =	driver.findElement(By.id("btnLogin"));
	    	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	    	executor3.executeScript("arguments[0].click();", login);
	    	Thread.sleep(60000);
	    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	    	//login button
	    	WebElement submitopt =	driver.findElement(By.id("btnsubmitotp"));
	    	JavascriptExecutor executor4 = (JavascriptExecutor) driver;
	    	executor4.executeScript("arguments[0].click();", submitopt);
	    	Thread.sleep(2000);
	   		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	    	//clicking on the submit BV button
	   		WebElement BV =	driver.findElement(By.id("divbv"));
	   		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
	   		executor6.executeScript("arguments[0].click();", BV);
	   		Thread.sleep(2000);
	   		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	        Excel_Read();
	    }
	    @Test(priority = 1)
	    public static void Excel_Read() throws IOException, InterruptedException {
			  System.out.println("##### Entering Excel_Read() method.!! #####");
		        try {
		            String[] id_numbers;

		            //Opening Excel sheet
		            FileInputStream fis= new FileInputStream("Overall.properties");
		            Properties p = new Properties();
		            p.load(fis);
		            System.out.println("Loaded");
		            String excel = p.getProperty("TechMahindra_Excel");
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
		
		public static void Download_Files(String id) throws InterruptedException {
		
	// clicking employee button to dropdown
	WebElement Empsearch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtReqAppID"));
	
try {	
	if (!id.isEmpty()) {
		System.out.println("test");
			Empsearch.sendKeys(id);
	}else if(id.isEmpty()) {
		log.info("candidate's id not found so browser closed" );
		driver.quit();
		}
	
}catch(Exception e) {
	log.info(" catch Exception candidate's id not found so browser closed" );
	driver.quit();

}
Thread.sleep(2000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
	
	//Clicking on search for the candidate
	WebElement Search =driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_btnCheck\"]"));
	JavascriptExecutor executor77 = (JavascriptExecutor) driver;
	executor77.executeScript("arguments[0].click();",Search );
	
	try {
	// verifying the candidate
	WebElement verify = driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvVendor_ctl02_lnkrequestid"));
	 verify.getText();
	 String Ver = verify.getText();
System.out.println(Ver);
	
if(Ver.equals(id)) {
	//Clicking on search for the candidate
			WebElement Search1 =driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_gvVendor_ctl02_lnkrequestid\"]"));
			JavascriptExecutor executor771 = (JavascriptExecutor) driver;
			executor771.executeScript("arguments[0].click();",Search1 );
			
			// Find the table element
			   WebElement table1 = driver.findElement(By.xpath("//*[@id=\"TABLE1\"]"));

			   // Find all the <a> tags within the table
			   List<WebElement> links = table1.findElements(By.tagName("a"));
			   System.out.println("Inner row  size "  + links.size() );													
//				
			   System.out.println("linkcheck");
//	 		
			   // Iterate through each <a> tag and click it
			   int linkCount = 0;
			   for (WebElement link : links) {
			       linkCount++;
			       if (linkCount == 2) {
			           continue; // Skip the 2nd link
			       }
			       try {
			           link.click();
			           System.out.println("clicked the link");
					    Thread.sleep(2000);  
			           // Rest of your code to handle the alert
			       } catch (Exception e1) {
			    	   System.out.println("Exception occurred");
					           }
}
			   WebElement Urn = driver.findElement(By.xpath("//*[@id=\"ctl00_apVendor_content_rptVendor_ctl00_lnkVendor\"]"));
			   Urn.click();
			   Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				 System.out.println("2");
				   log.info("Clicking urn");
		   }else if(!Ver.equals(id)) {
			// Click to another candidate to scrap
			   WebElement Urn = driver.findElement(By.xpath("//*[@id=\"ctl00_apVendor_content_rptVendor_ctl00_lnkVendor\"]"));
			   Urn.click();
			   Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				 System.out.println("2");
				   
				 log.info("id  found so scrapped for the candiate");	
		   }
		
		}catch (Exception e2) {
	System.out.println("id not found fo ID "+id +"so skipped to another id");
	log.info("id not found fo ID "+id +"so skipped to another id");	
	// Click to another candidate to scrap

	log.info("candidate not found , so cleared the ");
	WebElement Empsearch1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtReqAppID"));
	Empsearch1.clear();
	WebElement Urn = driver.findElement(By.xpath("//*[@id=\"ctl00_apVendor_content_rptVendor_ctl00_lnkVendor\"]"));
			   Urn.click();
			   Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				 System.out.println("2");
				 log.info("when id not equals to candidate id clicks urn");

		}
		}  
		@AfterMethod
		public static void afterTest() {
			log.info("no ID found to scrap, closing the browser ");
			driver.close();
		}
}
