package matexScraping.MatexScraping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
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

public class Cognizant {

	static	Logger log =Logger.getLogger(Cognizant.class);
	static WebDriver driver;

// 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
	private static String desired_filepath = "/home/admin/Documents/Cognizant";

	public static void main(String[] args ) throws InterruptedException, IOException {

	//	String[] args = {"userID","password","CandidateId" };	
		
		Cognizant1(args);
	
		Cognizant2(args);
	
	}

	public static void Cognizant1(String[] args) throws InterruptedException, IOException {
		
	
		String userID ="Sivaraj.b@matrixbsindia.com";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

//		String password ="Pass@789";// 2531691
//		if (args[1] != "") {
//			password = args[1]; 
//		}
//		
		
	
		String CaseRegistrationId = "";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("profile.default_content_settings.popups", 0);
		hm.put("download.default_directory", desired_filepath);
		// hm.put("download.default_directory",desired_filepath);
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", hm);
		options.setCapability("disable-dev-shm-usage", true);
		options.addArguments("--remote-allow-origins=*"); 
		 //options.addArguments("--disable-application-cache");
		 options.addArguments("--incognito");
		 
		//options.addArguments("--user-data-dir=/path/to/custom/directory");

		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
//	
//		 System.setProperty("webdriver.gecko.driver","/home/admin/eclipse-workspace/selinum_export/geckodriver");
//			
//			
//	       // Set Firefox profile to enable automatic file downloads
//	        FirefoxProfile profile = new FirefoxProfile();
//	        profile.setPreference("browser.download.folderList", 2); // Use custom download folder
//	        profile.setPreference("browser.download.dir", desired_filepath); // Specify the download folder path
//	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream"); // Disable download prompt
//	        profile.setPreference("pdfjs.disabled", true); // Optional: Disable built-in PDF viewer
//	        profile.setPreference("browser.link.open_newwindow", 3);
//
//	          // Set FirefoxOptions with the configured profile
//	        FirefoxOptions options = new FirefoxOptions();
//	        options.setProfile(profile);
//	        options.addArguments("-private");
//	        // options.addArguments("--remote-allow-origins=*"); 
//			
//		// get url for Capegemini
//		log.info("*******URL*******");
//	 driver = new FirefoxDriver(options);
//		
//		
		
		
		// get url for cognizant
		driver.get("https://onecognizantexternal.cognizant.com/2190/Vendor/TimeLine?requestid=2074711&doj=1%2F6%2F2022%2012%3A00%3A00%20AM&customerid=1206901&customername=Microsoft%20Corporation&projectid=1000310289&projectname=Microsoft%20Incentive%20Project&bu=BPO%20-%20India&department=DBO%20-%20Tech%20Delivery&bgvtype=Client&bgvsubtype=None#link_CTSECMIN_109284163z");
		
			
		
		
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		//driver.navigate().refresh();
		Thread.sleep(3000);
		
		//RE -URL
		//driver.get("https://onecognizantexternal.cognizant.com/2190/Vendor/TimeLine?requestid=2074711&doj=1%2F6%2F2022%2012%3A00%3A00%20AM&customerid=1206901&customername=Microsoft%20Corporation&projectid=1000310289&projectname=Microsoft%20Incentive%20Project&bu=BPO%20-%20India&department=DBO%20-%20Tech%20Delivery&bgvtype=Client&bgvsubtype=None#link_CTSECMIN_109284163z");
		Thread.sleep(1000);
		// username
		driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


	
	//sign in button
	WebElement Next =	driver.findElement(By.id("idSIButton9"));
	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	executor3.executeScript("arguments[0].click();", Next);
	Thread.sleep(60000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	

Thread.sleep(2000);
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));




	
		
		
	}
	
	
	
	//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
		public static  void Cognizant2(String[] args) throws InterruptedException, IOException {
			String desired_filepath = "/home/admin/Documents/2032454";

			//System.out.println("Candidate Id===========" + args[0]);
			WebElement Sign_in1 = driver.findElement(By.id("idSIButton9"));
			Thread.sleep(2000);

			Sign_in1.click();
			Thread.sleep(60000);

		 SimpleDateFormat dateFormat1;
		 dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		 String Datewise ="";// 2531691
		if (args[0] != "") {
			Datewise = args[0];
		}
	
		String Datewise1 ="";// 2531691
		if (args[1] != "") {
			Datewise1 = args[1];
		}
		
		String CandidateId ="";// 2531691
		if (args[2] != "") {
			CandidateId = args[2];
		}
		
		//Sign in button clicking
	

//		
		//Re-entring url , cause of cache  
		driver.get("https://onecognizantexternal.cognizant.com/2190/");
		
		//Vendor button click
		WebElement  Vendor = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/ul/li/a"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", Vendor);
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


		
		 //search till data 
		 WebElement todate =driver.findElement(By.id("AdvTo"));
		 todate.sendKeys(Datewise);
			
		 //todate.sendKeys("07/10/2023");
		 Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		
		//  search From date
		WebElement fromdate =driver.findElement(By.id("ADvfrom"));
		fromdate.sendKeys(Datewise1);
		
		//fromdate.sendKeys("06/10/2023");
		 Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


		
		
		 
		//Submit button
		 WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/div/form/button[1]"));
		 JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", submit);
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


		 
	        WebElement Candidate  = driver.findElement(By.id("AdvCan"));
	         
	         Thread.sleep(2000);
	        Candidate.sendKeys(CandidateId);
	         Thread.sleep(2000);
	 		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	        
	         //Submit button
			 WebElement submit1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/div/form/button[1]"));
			 JavascriptExecutor executor3 = (JavascriptExecutor) driver;
				executor3.executeScript("arguments[0].click();", submit1);
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


				//Candidate details clicking								
				 WebElement Candidatesdetails = driver.findElement(By.xpath("//*[@id=\"DashTableDiv\"]/div/div[2]/div/div[1]/a/ul[1]"));
				 JavascriptExecutor executor4 = (JavascriptExecutor) driver;
					executor4.executeScript("arguments[0].click();", Candidatesdetails);
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


					
					//candidate arrow clicking for getting details for the candidate
					 //chrome//WebElement candidatearrow = driver.findElement(By.xpath("//*[@id=\"BGVBody\"]/div[2]/div[2]/div[1]/div[1]/h4/span[1]/span"));
					 WebElement candidatearrow = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/h4/span[1]/span"));
						
					 JavascriptExecutor executor5 = (JavascriptExecutor) driver;
						executor5.executeScript("arguments[0].click();", candidatearrow);
						Thread.sleep(2000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


						
	 		//Getting details of the candidate in text format
						 WebElement Candidatetext = driver.findElement(By.xpath("//*[@id=\"BGVBody\"]/div[2]/div[2]/div[1]/div[1]/h4/span[2]/div/div"));
						 JavascriptExecutor executor6 = (JavascriptExecutor) driver;
							executor6.executeScript("arguments[0].click();", Candidatetext);
		
							//getting data to a string 
							String tabledata = Candidatetext.getText();
							log.info(tabledata);
							Thread.sleep(2000);

			//Personal details of the candidate in text format 
							
							 WebElement Candidatepersonal = driver.findElement(By.xpath("//*[@id=\"BGV_TL\"]/div"));
							 JavascriptExecutor executor7 = (JavascriptExecutor) driver;
								executor7.executeScript("arguments[0].click();", Candidatepersonal);
			
								//getting data to a string 
								String tabledata1 = Candidatepersonal.getText();
								log.info(tabledata1);
								Thread.sleep(2000);
								//Personal details of the candidate in text format 
				
							
			// screenshort for the candidates
								// Take the screenshot
							        File screenshot7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							     // ===========scroll========//
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("window.scrollBy(0,100)");
									Thread.sleep(2000);

							        // Define the destination path and file name for the screenshot
							        String destinationPath7 = "/home/admin/Documents/cognizant/test0.png";
							       
							    	System.out.println("screenshot");
									
							        try {
							            // Copy the screenshot file to the specified destination
							            Files.copy(screenshot7.toPath(), new File(destinationPath7).toPath());
							            System.out.println("Screenshot file saved successfully .");
							        } catch (IOException e) {
							            System.out.println("Failed to save court screenshot: " + e.getMessage());
							        }	
								 
				//Screenshort for the candidate for deatails
									
									// ===========scroll========//
									JavascriptExecutor js2 = (JavascriptExecutor) driver;
									js2.executeScript("window.scrollBy(0,300)");
									Thread.sleep(2000);

							    	log.info("consent");
							    	// Take the screenshot
							        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							    	
							        // Define the destination path and file name for the screenshot
							        String destinationPath2 = "/home/admin/Documents/cognizant/test.png";
							       
							    	System.out.println("screenshot");
									
							        try {
							            // Copy the screenshot file to the specified destination
							            Files.copy(screenshot1.toPath(), new File(destinationPath2).toPath());
							            System.out.println("Screenshot file saved successfully .");
							        } catch (IOException e) {
							            System.out.println("Failed to save court screenshot: " + e.getMessage());
							        }	
								
							      //Screenshort for the candidate for deatails
								     // ===========scroll========//
										JavascriptExecutor js1 = (JavascriptExecutor) driver;
										js1.executeScript("window.scrollBy(0,600)");
										Thread.sleep(2000);
		log.info("screenshot 2");
								    	// Take the screenshot
								        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
								    	
								        // Define the destination path and file name for the screenshot
								        String destinationPath3 = "/home/admin/Documents/cognizant/test1.png";
								       
								    	System.out.println("screenshot");
										
								        try {
								            // Copy the screenshot file to the specified destination
								            Files.copy(screenshot3.toPath(), new File(destinationPath3).toPath());
								            System.out.println("Screenshot file saved successfully .");
								        } catch (IOException e) {
								            System.out.println("Failed to save court screenshot: " + e.getMessage());
								        }			 
						
								      //Screenshort for the candidate for deatails
									     // ===========scroll========//
											JavascriptExecutor js11 = (JavascriptExecutor) driver;
											js11.executeScript("window.scrollBy(0,1000)");
											Thread.sleep(2000);
			log.info("screenshot 3");
									    	// Take the screenshot
									        File screenshot13 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
									    	
									        // Define the destination path and file name for the screenshot
									        String destinationPath13 = "/home/admin/Documents/cognizant/test1.png";
									       
									    	System.out.println("screenshot");
											
									        try {
									            // Copy the screenshot file to the specified destination
									            Files.copy(screenshot13.toPath(), new File(destinationPath13).toPath());
									            System.out.println("Screenshot file saved successfully .");
									        } catch (IOException e) {
									            System.out.println("Failed to save court screenshot: " + e.getMessage());
									        }        
								        
								        
								        
								        
								        //component Verfication clicking
							        WebElement Componentverification = driver.findElement(By.id("Docsverify"));
							        JavascriptExecutor executor8 = (JavascriptExecutor) driver;
									executor8.executeScript("arguments[0].click();", Componentverification);
									Thread.sleep(2000);
							        
									

//							// Find the table element
							   WebElement table1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/table"));

							   // Find all the <a> tags within the table
							   List<WebElement> links = table1.findElements(By.tagName("a"));
							   System.out.println("Inner row  size "  + links.size() );													
//								
							   System.out.println("linkcheck");
//					    		
							   // Iterate through each <a> tag and click it
							   for (WebElement link : links) {
							       link.click();
							       Thread.sleep(1000); 
							       System.out.println("loop not running");
						    		
							   
							   }
		//Back arrow 
		WebElement back =driver.findElement(By.xpath("//*[@id=\"BGVBody\"]/div[2]/div[2]/div[1]/div[1]/h4/a/span"));
		
		  JavascriptExecutor executor88 = (JavascriptExecutor) driver;
			executor88.executeScript("arguments[0].click();", back);
		

			
		
		}
}