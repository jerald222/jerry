package matexScraping.MatexScraping;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
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

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.DeathByCaptcha.Captcha;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;

public class Indusind_2 {
	 static WebDriver driver;
	  static	Logger log =Logger.getLogger(TechMahindra_2.class);
	  static String Download_Path="/home/admin/Documents/Indusind_Candidates";
	    public static void openBrowser(String[]args) throws IOException, InterruptedException, AWTException {
	        FileInputStream fis= new FileInputStream("Overall.properties");
	        Properties p = new Properties();
	        p.load(fis);
	        String Executables = p.getProperty("driver_Execeutables");
	        String Chrome_path = p.getProperty("Chrome_path");
	        String username= p.getProperty("Indusind_UserName");
	        String password= p.getProperty("Indusind_Password");
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
	        String url = p.getProperty("Indusind_URL");
	        driver.get(url);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement login_user = driver.findElement(By.id("txtLoginID"));
	        login_user.sendKeys(username);
	        WebElement login_password = driver.findElement(By.id("txtPassword"));
	        login_password.sendKeys(password);
	    	// NAVIGATING TO CAPTCH TEXT BOX
			String captchatext = "";
			String userID ="Matrix5";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password1 ="Matrix5@123";// 2531691
		if (args[1] != "") {
			password1 = args[1]; 
		}
		
	//====bypassing the captcha=========//
			
			//captcha username			
			String dbcusrname ="jerald.berchmans@likemindtech.com";
			//captcha password
			String dbcpsswd ="1222K3806@jb";
			
//			String args[] = null; 
			System.out.println(args.length);
		        Client client;
		        // using http API
		
		        if(args.length == 3){
		            client = (Client)(new HttpClient(dbcusrname, dbcpsswd));
		        }else if(args.length == 2){
		            client = (Client)(new HttpClient(args[0]));
		        }else{
		            System.out.println("Wrong number of arguments");
		            System.out.println("You must use username/password combination");
		            System.out.println("Or API key");
		            return;
		        }
			
		        client.isVerbose = true;

		     
			try {
		            try {
		                System.out.println("Your balance is " + client.getBalance() + " US cents");
		            } catch (IOException e) {
		                System.out.println("Failed fetching balance: "+ e.toString() );
		                return;
		            }
		        	//=================================================//
		 		   
		            WebElement element12 = driver.findElement(By.cssSelector("#trCaptchaImage > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > div > img"));
		            //driver.findElement(By.cssSelector("#captchaImg"));
				    Thread.sleep(2000);

				    // Take a screenshot
				    File srcFile1 = element12.getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(srcFile1, new File("/home/admin/Documents/captcha.png"));

				    Thread.sleep(2000);
				    log.info("sending captcha image");
		            
		        	String imageFilePath = "/home/admin/Documents/captcha.png";
		        	  Captcha captcha = null;
		            try {
		                // Upload a CAPTCHA and poll for its status with 120 seconds timeout.
		                // Put you CAPTCHA image file name, file object, input stream, or
		                // vector of bytes, and optional solving timeout (in seconds) here.
		                System.out.println(args);
		            	if (args.length == 3){
		                    //captcha = client.decode(args[2], 120);
		                    captcha = client.decode(imageFilePath,120);
		                }else if (args.length == 2){
		                    captcha = client.decode(args[1], 120);
		                }else{
		                    System.out.println("Failed uploading CAPTCHA - args");
		                    return;    
		                }
		                
		            } catch (IOException e) {
		                System.out.println("Failed uploading CAPTCHA");
		                return;
		            }
		            if (null != captcha) {
		                System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);
		                System.out.println(captcha.text);

		            	 captchatext = (captcha.text);
	       
		        				Thread.sleep(2000);
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			//Applying value  to the text field as captcha
			WebElement Text = driver.findElement(By.id("txtinput"));
			Text.sendKeys(captchatext);
			Thread.sleep(2000);
			
			//login button*****************************
			WebElement element3 = driver.findElement(By.name("btnLogin"));
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element3);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			
			WebElement frame =driver.findElement(By.name("btnResetSession"));
			
			if (frame.isDisplayed()) {
				frame.click();
				Thread.sleep(1000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			}else {
				// clicking for the Bgv Document button
				WebElement BGV =driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/nav/ul/li[2]/a"));
				BGV.click();
				Thread.sleep(1000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				
			}
			
			
			
			Thread.sleep(2000);
		            } 
		            else {
		               System.out.println("Failed solving CAPTCHA");
		            }
		        } catch (com.DeathByCaptcha.Exception e) {
		            System.out.println(e);
		    		Thread.sleep(3000);
		        }
	        Excel_Read();
	    }
	    @Test(priority=1)
		public static void Excel_Read() throws IOException, InterruptedException {
	    	  System.out.println("##### Entering Excel_Read() method.!! #####");
		        try {
		            String[] id_numbers;

		            //Opening Excel sheet
		            FileInputStream fis= new FileInputStream("Overall.properties");
		            Properties p = new Properties();
		            p.load(fis);
		            System.out.println("Loaded");
		            String excel = p.getProperty("Indusind_Excel");
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

//		
//			String id ="";// 2531691
//		if (args[0] != "") {
//			id = args[0];
//		}
		
		// clicking for the Bgv Document button
		WebElement BGV =driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/nav/ul/li[2]/a"));
		BGV.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		
		// Applying text for the text field
		WebElement seek = driver.findElement(By.id("TXTECN"));

		try {
		    if (seek.isDisplayed()) {
		        seek.sendKeys(id);
		        // You can remove the pageLoadTimeout line as it seems unnecessary in this context
		     // clicking for the Search button
				WebElement Search =driver.findElement(By.id("BTN_Search"));
				Search.click();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
				//clicking for the Download all button
				WebElement Downlaod =driver.findElement(By.id("btnDownLoadZip"));
				Thread.sleep(2000);
				Downlaod.click();
				log.info("Downloaded all documents");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
		    
		    } else {
		        System.out.println("Text field not found. Closing the browser.");
		        driver.quit(); // Use quit() to close the browser and end the WebDriver session
		    }
			 Folder_creation(id);
		} catch (Exception e) {
		    System.out.println("Error occurred while interacting with the text field. Closing the browser.");
		    System.out.println("Exception occurred: " + e.getMessage());
            System.out.println("Skipping to the next ID."); // Use quit() to close the browser and end the WebDriver session
		}
				
		}
		private static void Folder_creation(String id) throws InterruptedException {
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
//		        driver.get("https://disha.darwinbox.in/onboarding/bgvemployees");
		    }
		@AfterMethod
		public static void afterTest() {
			log.info("no ID found to scrap, closing the browser ");
			driver.close();	
		}
	
}
