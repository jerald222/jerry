package matexScraping.MatexScraping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Capgemini_DateWise {

	static	Logger log =Logger.getLogger(Direct_Trainee_Datewise.class);
	static WebDriver driver;
	private static String desired_filepath = "/home/admin/Documents/capegemini";
	
	public static void main(String[] args ) throws InterruptedException, IOException {
		
		//	String[] args = {"userID","password","CandidateId" };	
			
		Cape_gemini_id(args);
		
		//Cape_gemini(args);
		
		}

	public static void Cape_gemini_id(String[] args ) throws InterruptedException, IOException {
		
		String userID ="sivaraj.b@matrixbsindia.com";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

			String password ="Matex@2022";// 2531691
			if (args[1] != "") {
				password = args[1]; 
			}
			
			String CaseRegistrationId = "";
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("profile.default_content_settings.popups", 0);
			hm.put("download.default_directory", desired_filepath);
			// hm.put("download.default_directory",desired_filepath);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", hm);
			options.setCapability("disable-dev-shm-usage", true);
	
		
		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
		
		//https://bgv.capgemini.com/External/#/External/login
			
			// get url for Capegemini
			log.info("*******URL*******");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

			
			// get url for tcs
						log.info("*****************************************************URL*************************");
						driver.get("https://bgv.capgemini.com/External/#/External/login");
						
			
			// username for capegemini
				driver.findElement(By.id("txtEmailId")).sendKeys(userID);
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				// password for capgemini
				driver.findElement(By.id("txtPassword")).sendKeys(password);
			
				//Clicked to send OTP button
				driver.findElement(By.xpath("/html/body/app-root/app-login/div[1]/div/div/div[2]/div/div[2]/div/div/div/div/div[3]/div/button")).click();
				Thread.sleep(60000);
	
				//clicked on verify OTP button
				driver.findElement(By.xpath("//*[@id=\"bodyContainer\"]/div/div/div[2]/div/div[2]/div/div/div/div/div[3]/div/button[2]")).click();
				System.out.println("OTP entring");
				Thread.sleep(3000);
	
//	}	
			
	
			//	public static void Cape_gemini(String[] args ) throws InterruptedException, IOException {
						
			//Second method for the capegemini for scraping and screenshots
					/*String value ="";// 2531691
					if (args[0] != "") {
						value = args[0]; //7276924
					}
               */				
				// String desired_filepath = "/home/admin/Documents/capegemini";
				
			/*	 SimpleDateFormat dateFormat;
				 dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				 String Datewise ="";// 2531691
				if (args[0] != "") {
					Datewise = args[0];
				}
			
				String Datewise1 ="";// 2531691
				if (args[1] != "") {
					Datewise1 = args[1];
				}
			*/	
						
		//	String CaseRegistrationId = "";
			
		//	HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("profile.default_content_settings.popups", 0);
			hm.put("download.default_directory", desired_filepath);
		
				//dropdown for candidate 
				 WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[1]/div/field-control/ng-select/div/div/div[2]/input"));
				dropdown.click();
				Thread.sleep(2000);
				System.out.println("dropdown");
				
				// selecting the candidate
				driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div[1]")).click();
				Thread.sleep(1000);
				System.out.println("dropdown select ");
				String date = "31-May-2023";
			
				WebElement Dateapply =driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[3]/div/field-control/div[1]/input"));
				Dateapply.sendKeys(date);//Datewise
				 Thread.sleep(2000);

			//	 if (Datewise.isEmpty()) {
				
					 //driver.close();
			//	} else {
			
					 WebElement Dateapply1 =driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[4]/div/field-control/div[1]/input"));
						
					 Dateapply1.sendKeys(date);//Datewise1
						 Thread.sleep(2000);
//					
						// if (Datewise1.isEmpty()) {
							 //driver.close();
						// }else {
							 // -----submit button----//
								WebElement element4 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[2]/button[1]"));
								JavascriptExecutor executor3 = (JavascriptExecutor) driver;
								executor3.executeScript("arguments[0].click();", element4);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500)); 
						// }
					  // }
		
				//##################### Finding table row and data and sending employee id #######################//
				  
					//listing the No:Rows in the first table
						List<WebElement> tabelrowdate = driver.findElements(By.cssSelector("div.table-responsive>table>tbody>tr"));
				        // Get the number of rows in the outer table						
				        System.out.println( tabelrowdate.size());
					    Thread.sleep(1000);
					   //	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					   	int count = tabelrowdate.size();
					   	String countString = String.valueOf(count);
					   	System.out.println(countString);
				try {
				
					if(countString != null) {
						
					}
					for(int i =0; i< tabelrowdate.size(); i++) {
						
						Thread.sleep(1000);				
					    // WebElement id = driver.findElement(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr>td"));
					 
						WebElement id = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[1]/grid-dispctrl/div[2]/div/table/tbody/tr[1]/td[1]"));
						 String Candidatename = id.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
					
						
						WebElement id1 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[1]/grid-dispctrl/div[2]/div/table/tbody/tr[1]/td[3]"));
						 String CandidateId = id1.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
						 System.out.println("Candidate name =" +Candidatename +"Candidate id =" +CandidateId);
						
						 Thread.sleep(1000);
						log.info("Applicant id for scrapping is  =" +CandidateId);

						//dropdown for candidate 
						 WebElement dropdown1 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[1]/div/field-control/ng-select/div/div/div[2]/input"));
						dropdown1.click();
						Thread.sleep(2000);
						System.out.println("dropdown");
						
						// selecting the candidate
						driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div[1]")).click();
						Thread.sleep(1000);
				
						
						//applying value for the candiadte
						driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/searchby/div/div/div/div[1]/customform/form/div/div[2]/div/field-control/input")).sendKeys(CandidateId);
						Thread.sleep(1000);
						System.out.println("applying value ");
						
					
						
					
					 if (CandidateId.isEmpty()) {
					
						 driver.close();
					} else {
					    System.out.println("Clicking on submit");
					  
					/* // -----submit button----//
						WebElement element4 = driver.findElement(By.name(""));
						JavascriptExecutor executor3 = (JavascriptExecutor) driver;
						executor3.executeScript("arguments[0].click();", element4);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
*/
						// clicking on search for  the candidate
						driver.findElement(By.xpath("//*[@id=\"bodyContainer\"]/div/div/div/app-home/div[1]/searchby/div/div/div/div[2]/button[1]")).click();
						Thread.sleep(2000);
						System.out.println("searching ");
					  
					}
					 
				 
				 
				
				  
				WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[2]/grid-dispctrl/div[2]/div/table/tbody/tr/td[3]/field-control/div[1]/div/p/span"));
				String nametxt = name.getText();
				
				
				// Find the <i> element
		     	WebElement iElement = driver.findElement(By.className("fa-eye"));

		        // Execute JavaScript to click on the <i> element
		        JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", iElement);
		        Thread.sleep(1000);//s/html/body/app-root/app-main/div[1]/div/div/div/app-home/div[1]/div/div/div[2]/grid-dispctrl/div[2]/div/table/tbody/tr/td[14]/field-control/ul/li[1]/a
				System.out.println("view icon ");
				//*[@id="notificationDialog"]/div/div/div[1]/div/div/i[3]
			
				
				//clicking on the close button
				WebElement close = driver.findElement(By.xpath("//*[@id=\"clientReference\"]/div/div/div/div[1]/button"));
				
				WebElement tabledata=	driver.findElement(By.xpath("//*[@id=\"bodyContainer\"]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/tabset/div"));
				
				if (close.isDisplayed() ) {
					System.out.println("close button ");
					Thread.sleep(2000);
					close.click();
					}else if (tabledata.isDisplayed()) {
				tabledata.click();
						Thread.sleep(1000);
						 System.out.println("tabledata button clicked");
					}else {
						System.out.println("both  button are not clicked");
						
					}
				
				
				
			//getting data from the candidate table
			String tabletext = tabledata.getText();
			log.info(tabletext);
			
			System.out.println("Profile details for the candidate is =" + tabletext );
			System.out.println("getting data from the table ");
			System.out.println("done" );
			
				
				//clicking in the Education field
			WebElement edu = driver.findElement(By.xpath("//*[@id=\"Education\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	        executor1.executeScript("arguments[0].click();", edu);
	        Thread.sleep(1000);
	        System.out.println("Education button ");
	        
	        //clicking on the education details
			WebElement scroll = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/h2/button"));
			 scroll.click();
			Thread.sleep(2000);
			//driver.switchTo().frame(scroll);
			// ===========scroll========//
			//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			//jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scroll);

			WebElement eee = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/div/div[1]/div/div[1]/customform/form/div/div[1]/div/label"));
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true)",eee);
			Thread.sleep(2000);

			
			// Take the screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath = "/home/admin/Documents/capegemini/"+nametxt+".png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot.toPath(), new File(destinationPath).toPath());
	            System.out.println("Screenshot saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Failed to save the screenshot: " + e.getMessage());
	        }
	
	        WebElement edulevel = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/div/div[1]/div/div[1]/customform/form/div/div[5]/div/label"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].scrollIntoView(true)",edulevel);
			Thread.sleep(2000);
	
			   // Take the screenshot
	        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath1 = "/home/admin/Documents/capegemini/"+nametxt+"1.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot1.toPath(), new File(destinationPath1).toPath());
	            System.out.println("Screenshot saved for 1st successfully.");
	        } catch (IOException e) {
	            System.out.println("Failed to save  for the 1st screenshot: " + e.getMessage());
	        }
	        
	    	//clicking in the Employment field
			WebElement emp = driver.findElement(By.xpath("//*[@id=\"Employment\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
	        executor2.executeScript("arguments[0].click();", emp);
	        Thread.sleep(3000);
	        System.out.println(" Previous Employment button ");
	  
	        //clicking on the employment field
	    	
	         WebElement empl = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[1]/div[1]/h2/button"));
	        empl.click();
	         System.out.println( empl  );
	        Thread.sleep(2000);	
	        WebElement emp1 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[1]/div[1]/div/div[1]/div/div[1]/customform/form/div/div[1]/div/label"));
			
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView(true)",emp1);
			Thread.sleep(2000);
	
			
			   // Take the screenshot
	        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath3 = "/home/admin/Documents/capegemini/"+nametxt+"2.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot3.toPath(), new File(destinationPath3).toPath());
	            System.out.println("Screenshot 2nd saved successfully .");
	        } catch (IOException e) {
	            System.out.println("Failed to save the 2nd screenshot: " + e.getMessage());
	        }
	
		/*	
	    	//clicking in the Employment1 field
			WebElement empl1 = driver.findElement(By.xpath("//*[@id=\"Employment\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	        executor3.executeScript("arguments[0].click();", empl1);
	        Thread.sleep(1000);
	        System.out.println(" previous Employment1 button ");
	  
	        //clicking on the employment1 field
	        WebElement employment1 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[2]/div[1]/h2/button"));
	        employment1.click();
	        
	        WebElement employment2 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[2]/div[1]/div/div[1]/div/div[1]/customform/form/div/div[1]/div/label"));
			
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js4.executeScript("arguments[0].scrollIntoView(true)",employment2);
			Thread.sleep(2000);
	
			
			   // Take the screenshot
	        File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath4 = "/home/admin/Documents/capegemini/"+nametxt+"3.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot4.toPath(), new File(destinationPath4).toPath());
	            System.out.println("Screenshot 3rd saved successfully .");
	        } catch (IOException e) {
	            System.out.println("Failed to save the 3rd screenshot: " + e.getMessage());
	        }
	
	    	//clicking in the Employment2 field
			WebElement empl2 = driver.findElement(By.xpath("//*[@id=\"Employment\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor4 = (JavascriptExecutor) driver;
	        executor4.executeScript("arguments[0].click();", empl2);
	         Thread.sleep(1000);
	        System.out.println("Employment button ");

	        		 WebElement employment14 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[3]/div[1]/h2/button/div[1]"));
			
	        		 JavascriptExecutor js7 = (JavascriptExecutor) driver;
	     			js7.executeScript("arguments[0].scrollIntoView(true)",employment14);
	     			Thread.sleep(2000);
	     	
	        
	        //clicking on the employment2 field
	        WebElement employment3 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[3]/div[1]/h2/button"));
	        employment3.click();
	        
	        WebElement employment4 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document[3]/div[1]/div/div[1]/div/div[1]/customform/form/div/div[1]/div/label"));
			
	        JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("arguments[0].scrollIntoView(true)",employment4);
			Thread.sleep(2000);
	
			
			   // Take the screenshot
	        File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath5 = "/home/admin/Documents/capegemini/"+nametxt+"4.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot5.toPath(), new File(destinationPath5).toPath());
	            System.out.println("Screenshot 4thd saved successfully .");
	        } catch (IOException e) {
	            System.out.println("Failed to save the 4th screenshot: " + e.getMessage());
	        }
	     */   
	    // clicking on database
	        
	     
			WebElement empl3 = driver.findElement(By.xpath("//*[@id=\"Database\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor5 = (JavascriptExecutor) driver;
	        executor5.executeScript("arguments[0].click();", empl3);
	         Thread.sleep(1000);
	        System.out.println("Database button ");

	        
	        //clicking on the employment2 field
	        WebElement employment8 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/h2/button"));
	        employment8.click();
	        
	        WebElement employment9 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/div/div[1]/div/div[1]/customform/form/div/div[1]/div/label"));
			
	        JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("arguments[0].scrollIntoView(true)",employment9);
			Thread.sleep(2000);
	
			
			   // Take the screenshot
	        File screenshot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath6 = "/home/admin/Documents/capegemini/"+nametxt+" database.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot6.toPath(), new File(destinationPath6).toPath());
	            System.out.println("Screenshot database saved successfully .");
	        } catch (IOException e) {
	            System.out.println("Failed to save database screenshot: " + e.getMessage());
	        }
	        
	        //clicking on court record
	        
	    	WebElement empl4 = driver.findElement(By.xpath("//*[@id=\"Court Record\"]"));
			  // Execute JavaScript to click on the <i> element
	        JavascriptExecutor executor6 = (JavascriptExecutor) driver;
	        executor6.executeScript("arguments[0].click();", empl4);
	         Thread.sleep(1000);
	        System.out.println("Court record  button ");

	        		
	        //clicking on the employment2 field
	        WebElement employment11 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/h2/button"));
	        employment11.click();
	        Thread.sleep(2000);
	        WebElement employment12 = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div/check/div[1]/div/div[2]/div/document/div[1]/div/div[1]/div/div[1]/customform/form/div/div[2]/div/label"));
	        System.out.println("clicked for screenshot ");												   
	        JavascriptExecutor js10 = (JavascriptExecutor) driver;
			js10.executeScript("arguments[0].scrollIntoView(true)",employment12);
			Thread.sleep(2000);
	
			
			// Take the screenshot
	        File screenshot7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	
	        // Define the destination path and file name for the screenshot
	        String destinationPath7 = "/home/admin/Documents/capegemini/"+nametxt+" Court.png";
	        //String destinationPath1 = "/home/admin/Documents/capegemini/capegemini1.png";

	        try {
	            // Copy the screenshot file to the specified destination
	            Files.copy(screenshot7.toPath(), new File(destinationPath7).toPath());
	            System.out.println("Screenshot court saved successfully .");
	        } catch (IOException e) {
	            System.out.println("Failed to save court screenshot: " + e.getMessage());
	        }
	        
	//Downloading all attached files click
	        WebElement filesDownload = driver.findElement(By.xpath("//*[@id=\"bodyContainer\"]/div/div/div/request/div[1]/div/div/div[1]/h2/div/ul/li[1]/a"));
	        filesDownload.click();
	        Thread.sleep(2000);
	  	  //Downloading all files 
	        WebElement downloading =driver.findElement(By.xpath("//*[@id=\"open-attachments\"]/div[3]/div/button[2]"));
	        downloading.click();
	        Thread.sleep(2000);
	  	
	  //Downloading complete popup close button
	        WebElement closing = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[3]/notification/div/div/div/div[1]/div/div/i[3]"));
	        closing.click();
	        Thread.sleep(2000);
	     
	      //closing all attached box
	        WebElement xclose = driver.findElement(By.xpath("/html/body/app-root/app-main/div[1]/div/div/div/request/div[3]/div[1]/button"));
	        xclose.click();
	        Thread.sleep(2000);
	      //Downloading resume
	        WebElement resume = driver.findElement(By.xpath("//*[@id=\"bodyContainer\"]/div/div/div/request/div[1]/div/div/div[1]/h2/div/ul/li[2]/a"));
	        JavascriptExecutor executor9 = (JavascriptExecutor) driver;
	        executor9.executeScript("arguments[0].click();", resume);
	         Thread.sleep(2000);
	      
	     //clicking home button for other id's to download
	         
	         WebElement Home = driver.findElement(By.xpath("/html/body/app-root/app-main/nav/a/img"));
	         JavascriptExecutor executor10 = (JavascriptExecutor) driver;
		        executor10.executeScript("arguments[0].click();", Home);
		         Thread.sleep(2000);
		    
					}
					}catch (Exception e){
					    System.out.println("employee id is not found");	
				        
					}  
	         
	           
				}        
}      
	
	




