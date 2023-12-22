package matexScraping.MatexScraping;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
	import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
//import org.sikuli.api.Screen;
//import org.sikuli.script.FindFailed;
	//import org.sikuli.script.Pattern;
	//import org.sikuli.script.Screen;
import org.testng.annotations.Test;
// import org.sikuli.script.Screen;
// import org.sikuli.script.Pattern;
//import com.gargoylesoftware.htmlunit.javascript.host.Screen;

	public class Genpact_2 {
		
	    static WebDriver driver;
	    static String Download_Path ="/home/admin/Documents/Genpact_Candidates";
	    static String Default_Screenshot_path="/home/admin/Pictures";
	     static FileInputStream fileInputStream;
	     static	Logger log =Logger.getLogger(Genpact_2.class);
	private static String desired_filepath ="/home/admin";
//		public static void main(String []args) throws FindFailed, InterruptedException, IOException {
//	public static void main(String[]args) throws  InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException, AWTException {
//		
//			GenPact_id();
//			genpact1();
//		}
		
		public static void GenPact_id() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException, AWTException {
			
//			  try {
//		       log.info("jerry*#$*@&*%@&%&$%&$#%&$&%&$");
//		       try {
//		            FileInputStream loginCredentials = new FileInputStream("Overall.properties");
//		            Properties p = new Properties();
//		            p.load(loginCredentials);
//		            String Executables = p.getProperty("driver_Execeutables");
//		            String Chrome_path = p.getProperty("Chrome_path");
//		            loginCredentials.close();
//		            String loginemail = p.getProperty("Genpact_email");
//		            String loginpassword = p.getProperty("Genpact_password");
//		            System.setProperty(Executables, Chrome_path);
//
//		            // Initialize the ChromeOptions and chromePrefs outside the loop
//		            ChromeOptions options = new ChromeOptions();
//		            HashMap<String, Object> chromePrefs = new HashMap<>();
//		            options.setExperimentalOption("prefs", chromePrefs);
//		            options.addArguments("--remote-allow-origins=*"); 
//		            chromePrefs.put("download.default_directory", Download_Path);
//
//		            // Initialize the Chrome WebDriver with the specified options
//		            options.setCapability("acceptSslCerts", true); // Accept SSL certificates
//		            driver = new ChromeDriver(options);
//		            driver.manage().window().maximize();
//		            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		            driver.manage().deleteAllCookies();
//
//		            String url = p.getProperty("Genpact_URL");
//		            driver.get(url);
//		            Thread.sleep(1000);
//
//		            WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
//		            email.sendKeys(loginemail);
//		            Thread.sleep(1000);
//		            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
//		            password.sendKeys(loginpassword);
//		            Thread.sleep(1000);
//		            driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
//		            genpact1();
//		       } catch (JsonException j) {
//		       
//		       } 
//		       }catch(FileAlreadyExistsException e) {
//		      
//		       }
		
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
		            login();
			  } catch (JsonException j) {
		        }catch(FileAlreadyExistsException e) {
		        	
		        }
		    }
	  
		   @Test(priority = 1)
		    private static void login() throws InterruptedException, AWTException, EncryptedDocumentException, IOException, InvalidFormatException, NullPointerException {
		        try {
		            FileInputStream loginCredentials= new FileInputStream("Overall.properties");
		            Properties p = new Properties();
		            p.load(loginCredentials);
		            Thread.sleep(2000);
		            String Genpact_Excel=p.getProperty("Genpact_Excel");
		            FileInputStream fileInputStream = new FileInputStream(Genpact_Excel);
		            XSSFWorkbook workbook =new  XSSFWorkbook(fileInputStream);
		            Sheet sheet = workbook.getSheetAt(0);
		            int columnIndex = 0;
		            // Create a list to store the column values
		            List<Integer> columnValues = new ArrayList<Integer>();
		            System.out.println(columnValues);
		            // Iterate through rows to read data from the specified column
		            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		                Row row = sheet.getRow(i);
		                if(row == null) {
		                    continue;
		                }
		                Cell cell = row.getCell(columnIndex);
		                // Get data from the Excel cell
		                double data = cell.getNumericCellValue();
		                String id = String.valueOf((int) data);
		                System.out.println("Id is ======>>>>"+ id);
		                // Add the data to the list
		                columnValues.add((int) data);
		                driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[2]/ng-select/div/span")).click();
		                Thread.sleep(2000);
		                driver.findElement(By.xpath("//span[text()='In Progress']")).click();
		                Thread.sleep(2000);
		                WebElement id_input = driver.findElement(By.xpath("//input[@class='form__input']"));
		                id_input.clear();
		                id_input.sendKeys(id);
		                Thread.sleep(4000);
		                Robot r= new Robot();
		                r.keyPress(KeyEvent.VK_ENTER);
		                r.keyRelease(KeyEvent.VK_ENTER);
		                Thread.sleep(3000);
		                Downloads(id);
		                }

		            }catch( Exception e) {
		                System.out.println("Skipping to next ID from excel method");
		        }
		        afterTest();
		   }
			
		private static void Downloads(String id) {
		    System.out.println("Working ID is "+id);
            try {
                System.out.println("Fetching element");
                WebElement drop_down = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[6]/div/div[1]/img"));
                drop_down.click();
                System.out.println("Element fetched");
                Thread.sleep(5000);
                WebElement viewDetail = driver.findElement(By.xpath("//button[text()='View detail']"));
                viewDetail.click();

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
             log.info("Sikuli code to be generated#######################");
                
                //*************************************************************
                // Find the parent <div> element containing the rows
    	        WebElement tableDiv = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div")); // Replace with the appropriate locator
    	        												  ///html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div
    	        // Find the child <div> elements representing the rows
    	        java.util.List<WebElement> rowDivs = tableDiv.findElements(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div"));

    	        // Determine the row size
    	        int rowSize = rowDivs.size();

    	        // Print the row size
    	        System.out.println("Row size: " + rowSize);

    	    	for (int l = 1; l < rowSize+1; l++) {                
    	    		//Downloading of files for the candidate       /html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div[0]/div/div[1]/div/div/div/div[1]
    				WebElement file1 =driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div["+ l +"]/div/div[1]/div/div/div/div[1]"));
    													  
    				if (file1.isDisplayed()&& file1.equals(file1)){
    						
    					System.out.println("1st window");
    					JavascriptExecutor js12 = (JavascriptExecutor) driver;
    					js12.executeScript("arguments[0].click();",file1);
    					
    					//file.click();								  
    					Thread.sleep(2000);
    				}
    				else {
    					//driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[1]/div/div/div/svg")).click();
    				
    					System.out.println("2nd window");
    				}
    				
    						WebElement opennewWindow1 = driver.findElement(By.cssSelector("span.u-margin-right-vsmall"));
    				Thread.sleep(1000);										
    					opennewWindow1.click();									
    						System.out.println("clicked for the new window");
    			opennewWindow1.getText();
//    			String name = opennewWindow1.getText();
    			log.info("click the download link");
    			Thread.sleep(1000);

    			// Get the window handles
    				Set<String> windowHandles = driver.getWindowHandles();
    				System.out.println("window handles ");
    				
    				 	Thread.sleep(1000);	
    				 	log.info("check for the screenshot");
    						Thread.sleep(1000);	
    						try {
    						  System.out.println("jjjjjjjjjjjj@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
							 System.out.println("699999999868978@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

//							 try {
////								    Screen screen = new Screen();
////								    Pattern image1 = new Pattern("C:/Users/Public/Documents/image1.png");
////								    screen.wait(image1, 2000);
////								    screen.click(image1);
//
////								    Pattern image2 = new Pattern("C:/Users/Public/Documents/image3.png");
////								    screen.wait(image2, 2000);
////								    screen.click(image2);
//
//								} catch (FindFailed sikuliException) {
//								    // SikuliX exception handling
//								    sikuliException.printStackTrace();
//								    
//								    // Additional handling, logging, or actions can be added here
//								    
//								    // If SikuliX fails, capture the screen using Robot
								    try {
								        Thread.sleep(1000);
								        Robot s = new Robot();
								        s.keyPress(KeyEvent.VK_PRINTSCREEN);
								        s.keyRelease(KeyEvent.VK_PRINTSCREEN);
								        Thread.sleep(4000);
								    } catch (InterruptedException | AWTException robotException) {
								        robotException.printStackTrace();
								    }
//								} catch (Exception generalException) {
//								    // Handle other exceptions here
//								    generalException.printStackTrace();
//								}
							 
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
    	                        	  log.info("first catch");
    	                          } catch (NoSuchWindowException n) {
    	                        	  log.info("second catch");
    	                          }catch(Exception e) {
    	                        	  log.info("third catch");
    	                          }
    	                  driver.switchTo().window(windowHandles.iterator().next());
    				   JavascriptExecutor js1 = (JavascriptExecutor) driver;
    					js1.executeScript("window.scrollBy(0,65)");

    					System.out.println("Take screen shot");
    	       	}
                test2(id);
                System.out.println("Exiting TRY");
            }
           
            catch(Exception e) {
                e.printStackTrace();
                log.info(" No element, Skipping to next ID");
                return ;
            }
//            afterTest();
        }

		

//		public static void genpact1() throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
//			 System.out.println("##### Entering Excel_Read() method.!! #####");
//			    
//			 String excelFilePath = "/home/admin/Documents/id_sheet.xlsx";
//		        String[] id_numbers;
//			 try {
//		            FileInputStream loginCredentials= new FileInputStream("Overall.properties");
//		            Properties p = new Properties();
//		            p.load(loginCredentials);
//		            String url= p.getProperty("Genpact_URL");
//		            Thread.sleep(2000);
//		            String Genpact_Excel=p.getProperty("Genpact_Excel");
//		            FileInputStream fileInputStream = new FileInputStream(Genpact_Excel);
//		            XSSFWorkbook workbook =new  XSSFWorkbook(fileInputStream);
//		            Sheet sheet = workbook.getSheetAt(0);
//		            int columnIndex = 0;
//		            int rowIndex =0;
//		            // Create a list to store the column values
//		            List<Integer> columnValues = new ArrayList<Integer>();
//		            System.out.println(columnValues);
//		            // Iterate through rows to read data from the specified column
//		            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//		                Row row = sheet.getRow(i);
//		                if(row == null) {
//		                    continue;
//		                }
//		                Cell cell = row.getCell(columnIndex);
//
//		                // Get data from the Excel cell
//		                double data = cell.getNumericCellValue();
//		                String id = String.valueOf((int) data);
//		                // Add the data to the list
//		                columnValues.add((int) data);
//		            }
//
//		            for (Integer value : columnValues) {
//		                System.out.println("The value is  "+value);  //Printing the next ID number
//		                id_numbers = new String[] {value.toString()};
//		                driver.findElement(By.xpath("//span[text()='All Cases']")).click();
//		                Thread.sleep(2000);
//		                driver.findElement(By.xpath("//span[text()='In Progress']")).click();
//		                Thread.sleep(2000);
//		                System.out.println(id_numbers);
//
//		                for (String id : id_numbers) {
//		                    rowIndex++;
//		                    System.out.println("Working ID is "+id);
//		                    WebElement id_input = driver.findElement(By.xpath("//input[@class='form__input']"));
//		                    id_input.clear();
//		                    id_input.sendKeys(id);
//		                    Thread.sleep(8000);
//		                    Robot r= new Robot();
//		                    r.keyPress(KeyEvent.VK_ENTER);
//		                    r.keyRelease(KeyEvent.VK_ENTER);
//		                    Thread.sleep(3000);
//		                    WebElement drop_down = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[6]/div/div[1]/img"));
//		                    drop_down.click();
//		                    Thread.sleep(5000);
//		                    WebElement viewDetail = driver.findElement(By.xpath("//button[text()='View detail']"));
//		                    viewDetail.click();
//		                    if (fileInputStream != null) {
//		                        try {
//		                            fileInputStream.close();
//		                        } catch (IOException e) {
//		                            e.printStackTrace();
//		                        }
//		                    }
//
//		                    //Retrieving all the data from left side after clicking on view detail button
//		                    Thread.sleep(5000);
//		                    Map<String, String> elementMap = new HashMap<>();
//		                    String email = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/a")).getText();
//		                    elementMap.put("Email", email);
//
//		                    String Department = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[2]/div[2]")).getText();
//		                    elementMap.put("Department", Department);
//
//		                    String Location = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div[2]")).getText();
//		                    elementMap.put("Location", Location);
//
//		                    String Recruiter = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[4]/div[2]")).getText();
//		                    elementMap.put("Recruiter", Recruiter);
//
//		                    String RecruiterEmail = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[5]/div[2]/a")).getText();
//		                    elementMap.put("RecruiterEmail", RecruiterEmail);
//
//		                    String Phone_Number = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[6]/div[2]")).getText();
//		                    elementMap.put("Phone_Number", Phone_Number);
//
//		                    String Agent_name = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[7]/div[2]")).getText();
//		                    elementMap.put("Agent_name", Agent_name);
//
//		                    String Joining_date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[8]/div[2]")).getText();
//		                    elementMap.put("Joining_date", Joining_date);
//
//		                    String UID = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[9]/div[2]")).getText();
//		                    elementMap.put("UID", UID);
//
//		                    String Employee_code = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[10]/div[2]")).getText();
//		                    elementMap.put("Employee_code", Employee_code);
//
//		                    String Case_Allocation_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[11]/div[2]")).getText();
//		                    elementMap.put("Case_Allocation_Date", Case_Allocation_Date);
//
//		                    String Case_Claim_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[12]/div[2]")).getText();
//		                    elementMap.put("Case_Claim_Date", Case_Claim_Date);
//
//		                    String Case_Close_Date = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[13]/div[2]")).getText();
//		                    elementMap.put("Case_Close_Date", Case_Close_Date);
//
//		                    String PID = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[14]/div[2]")).getText();
//		                    elementMap.put("PID", PID);
//
//		                    String Project_Name = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[15]/div[2]")).getText();
//		                    elementMap.put("Project_Name", Project_Name);
//
//		                    String Band = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[16]/div[2]")).getText();
//		                    elementMap.put("Band", Band);
//
//		                    String SDO = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[17]/div[2]")).getText();
//		                    elementMap.put("SDO", SDO);
//
//		                    String Legal_Entity = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[18]/div[2]")).getText();
//		                    elementMap.put("Legal_Entity", Legal_Entity);
//
//		                    String COE = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[19]/div[2]")).getText();
//		                    elementMap.put("COE", COE);
//
//		                    System.out.println(elementMap);
//
//		                    WebElement viewForm = driver.findElement(By.xpath("//div[text()=' View Form ']"));
//		                    viewForm.click();
//		                    Thread.sleep(6000);
//		                    driver.findElement(By.xpath("//div[text()=' Download ']")).click();
//		                    Thread.sleep(5000);
//		                    driver.findElement(By.xpath("//div[@class='btn btn__icon u-margin-right-vsmall']")).click();
//		                    Thread.sleep(2000);
//		                    WebElement viewDoc = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div[2]"));
//		                    viewDoc.click();
//		                    System.out.println("Clicking on viewDoc button");
//		                    Thread.sleep(2000);
//		                  
//		                    System.out.println("Clicking on viewDoc button");
//		                    Thread.sleep(2000);
//		                 log.info("Sikuli code to be generated#######################");
//		                    
//		                    //*************************************************************
//		                    // Find the parent <div> element containing the rows
//		        	        WebElement tableDiv = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div")); // Replace with the appropriate locator
//		        	        												  ///html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div
//		        	        // Find the child <div> elements representing the rows
//		        	        java.util.List<WebElement> rowDivs = tableDiv.findElements(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div"));
//
//		        	        // Determine the row size
//		        	        int rowSize = rowDivs.size();
//
//		        	        // Print the row size
//		        	        System.out.println("Row size: " + rowSize);
//
//		        	    	for (int l = 1; l < rowSize+1; l++) {                
//		        	    		//Downloading of files for the candidate       /html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div[0]/div/div[1]/div/div/div/div[1]
//		        				WebElement file1 =driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div["+ l +"]/div/div[1]/div/div/div/div[1]"));
//		        													  
//		        				if (file1.isDisplayed()&& file1.equals(file1)){
//		        						
//		        					System.out.println("1st window");
//		        					JavascriptExecutor js12 = (JavascriptExecutor) driver;
//		        					js12.executeScript("arguments[0].click();",file1);
//		        					
//		        					//file.click();								  
//		        					Thread.sleep(2000);
//		        				}
//		        				else {
//		        					//driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[1]/div/div/div/svg")).click();
//		        				
//		        					System.out.println("2nd window");
//		        				}
//		        				
//		        						WebElement opennewWindow1 = driver.findElement(By.cssSelector("span.u-margin-right-vsmall"));
//		        				Thread.sleep(1000);										
//		        					opennewWindow1.click();									
//		        						System.out.println("clicked for the new window");
//		        			opennewWindow1.getText();
////		        			String name = opennewWindow1.getText();
//		        			log.info("click the download link");
//		        			Thread.sleep(1000);
//
//		        			// Get the window handles
//		        				Set<String> windowHandles = driver.getWindowHandles();
//		        				System.out.println("window handles ");
//		        				
//		        				 	Thread.sleep(1000);	
//		        				 	log.info("check for the screenshot");
//		        						Thread.sleep(1000);	
//		        						try {
//		        						  System.out.println("jjjjjjjjjjjj@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		    							 System.out.println("699999999868978@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//
////		    							 try {
//////		    								    Screen screen = new Screen();
//////		    								    Pattern image1 = new Pattern("C:/Users/Public/Documents/image1.png");
//////		    								    screen.wait(image1, 2000);
//////		    								    screen.click(image1);
//		//
//////		    								    Pattern image2 = new Pattern("C:/Users/Public/Documents/image3.png");
//////		    								    screen.wait(image2, 2000);
//////		    								    screen.click(image2);
//		//
////		    								} catch (FindFailed sikuliException) {
////		    								    // SikuliX exception handling
////		    								    sikuliException.printStackTrace();
////		    								    
////		    								    // Additional handling, logging, or actions can be added here
////		    								    
////		    								    // If SikuliX fails, capture the screen using Robot
//		    								    try {
//		    								        Thread.sleep(1000);
//		    								        Robot s = new Robot();
//		    								        s.keyPress(KeyEvent.VK_PRINTSCREEN);
//		    								        s.keyRelease(KeyEvent.VK_PRINTSCREEN);
//		    								        Thread.sleep(4000);
//		    								    } catch (InterruptedException | AWTException robotException) {
//		    								        robotException.printStackTrace();
//		    								    }
////		    								} catch (Exception generalException) {
////		    								    // Handle other exceptions here
////		    								    generalException.printStackTrace();
////		    								}
//		    							 
//		    							 String windowHandle1 = driver.getWindowHandle();
//		        	                            for (String handle : driver.getWindowHandles()) {
//		        	                                if (!handle.equals(windowHandle1)) {
//		        	                                    driver.switchTo().window(handle);
//		        	                                    Thread.sleep(3000);
//		        	                                    driver.close();
//		        	                                }
//		        	                            }
//		        	                            driver.switchTo().window(windowHandle1);
//
//		        	                          } catch (ElementClickInterceptedException e) {
//		        	                        	  log.info("first catch");
//		        	                          } catch (NoSuchWindowException n) {
//		        	                        	  log.info("second catch");
//		        	                          }catch(Exception e) {
//		        	                        	  log.info("third catch");
//		        	                          }
//		        	                  driver.switchTo().window(windowHandles.iterator().next());
//		        				   JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		        					js1.executeScript("window.scrollBy(0,65)");
//
//		        					System.out.println("Take screen shot");
//		        	       	}
//		                    test2(id);
//		                }
//
//		            }
//		            afterTest();  
//		        }catch(FileSystemException e) {}
//			 log.info("Moving files to the id");
//		}
			
		
		 private static void test2(String id) throws InterruptedException, IOException, AWTException, EncryptedDocumentException, InvalidFormatException {
		        System.out.println("Entering test2() method");

		        FileInputStream loginCredentials = new FileInputStream("Overall.properties");
		        Properties p = new Properties();
		        p.load(loginCredentials);
		        String url = p.getProperty("Genpact_URL");
		        Thread.sleep(2000);
		        // Define the base path
		        String basePath = "/home/admin/Documents/Genpact_Candidates";
		        String subfolderPath ="";
		        String screenshot_path=Default_Screenshot_path;
		        subfolderPath = basePath + File.separator + id;
		        System.out.println("Row   FolderPath "+subfolderPath);
		        File download_folder = new File(Download_Path);
		        File[] files = download_folder.listFiles();
		        if (files != null) {
		            for (File file : files) {
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

		        driver.get(url);

		        Robot pg_UP = new Robot();
		        pg_UP.keyPress(KeyEvent.VK_PAGE_UP);
		        pg_UP.keyRelease(KeyEvent.VK_PAGE_UP);

		        }
		
		
		
		  
		  
		    @AfterMethod
		    private static void afterTest() {
				 System.out.println("AfterTest");
			        driver.close();
			}
	}		
	
	