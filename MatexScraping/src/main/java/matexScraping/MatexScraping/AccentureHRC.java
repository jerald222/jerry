package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class AccentureHRC {

	static	Logger log =Logger.getLogger(AccentureHRC.class);
	static WebDriver driver;

// 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
	private static String desired_filepath = "/home/admin/Documents/Accenture";

	public static void main(String[] args ) throws InterruptedException, IOException {

	//	String[] args = {"userID","password","CandidateId" };	
		
		Accenture1(args);
	
		Accenture2(args);
	
	}

	public static void Accenture1(String[] args) throws InterruptedException, IOException {
		
	
		String userID ="ramachandran.rm@accenture.com";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password ="Rsubashini@19";// 2531691
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
		options.addArguments("--remote-allow-origins=*"); 

		options.addArguments("--no-sandbox"); // Avoid sandbox issues
	        options.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues
	        options.addArguments("--disable-popup-blocking"); // Disable popup blocking
	        options.addArguments("--disable-infobars"); // Disable Chrome infobars
	        options.addArguments("--disable-extensions"); // Disable Chrome extensions
	        options.addArguments("--disable-notifications"); // Disable notifications
	        options.addArguments("--disable-translate"); // Disable translation prompt
	        options.addArguments("--disable-logging"); // Disable logging

	        // Set the download directory
	        options.addArguments("--download.default_directory=" + "/home/admin/Documents/Accenture" );
//
		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//		 //System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);

	
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");

//		 System.setProperty("webdriver.gecko.driver","/home/admin/eclipse-workspace/selinum_export/geckodriver");
			
			
//	       // Set Firefox profile to enable automatic file downloads
//	        FirefoxProfile profile = new FirefoxProfile();
//	        profile.setPreference("browser.download.folderList", 2); // Use custom download folder
//	        profile.setPreference("browser.download.dir", desired_filepath); // Specify the download folder path
//	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream"); // Disable download prompt
//	        profile.setPreference("pdfjs.disabled", true); // Optional: Disable built-in PDF viewer
//	        profile.setPreference("browser.link.open_newwindow", 3);
//
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
		
		
		// get url for tcs
		driver.get("https://support.accenture.com/now/nav/ui/classic/params/target/hr_case.do%3Fsys_id%3Da8c3894497ccb558bb54f737f053af52%26sysparm_record_list%3Dnumber%253dHRC2288230%255eORDERBYnumber%26sysparm_record_row%3D1%26sysparm_record_rows%3D1%26sysparm_record_target%3Dhr_case%26sysparm_view%3Dbgc_case%26sysparm_view_forced%3Dtrue");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));


		
		// username
		driver.findElement(By.id("i0116")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		//next button 
		WebElement Another = driver.findElement(By.id("idSIButton9"));
		Thread.sleep(2000);
		Another.click();
			
		
		// password
		driver.findElement(By.id("i0118")).sendKeys(password);
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	
		
	//signin button
	WebElement login =	driver.findElement(By.id("idSIButton9"));
	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	executor3.executeScript("arguments[0].click();", login);
	Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

//verify your identity  								//*[@id="idSIButton9"]
	WebElement	Verify	= driver.findElement(By.xpath("//*[@id=\"idDiv_SAOTCS_Proofs\"]/div/div/div/div[2]/div"));
	Verify.click();									//*[@id="idDiv_SAOTCS_Proofs"]/div/div/div/div[2]
	Thread.sleep(2000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
		
	WebElement	Verify1	= driver.findElement(By.id("idTxtBx_SAOTCC_OTC"));
	Verify1.sendKeys("?");
	Thread.sleep(60000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
	
WebElement	Verify2	= driver.findElement(By.id("idSubmit_SAOTCC_Continue"));
	Verify2.click();
	Thread.sleep(4000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
	
	// get url for tcs
			driver.get("https://support.accenture.com/hr_case_list.do");
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
	
	}
	
	
	
	//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
		public static  void Accenture2(String[] args) throws InterruptedException, IOException {
			String desired_filepath = "/home/admin/Documents/2032454";

			//System.out.println("Candidate Id===========" + args[0]);

		String CandidateId ="";// 2531691
		if (args[0] != "") {
			CandidateId = args[0];
		
		
		//dropdown  search for numbers	
			//WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"2cd819e6c308fd50f2a4b75605013151_select\"]"))
					  WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/span[1]/span/select"));

	        // Create a Select object from the dropdown element
	        Select select = new Select(dropdown);

	        // Select by visible text
	        select.selectByVisibleText("Number");
		
			
			
			//Search for the candidate
			WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input"));
			Search.sendKeys(CandidateId);
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
			//Submiting the candidate id
			Search.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
		//Clicking the hyperlink of the candidate			    
			WebElement Hyperlink = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/div[7]/div[1]/table/tbody/tr/td[3]/a"));
			JavascriptExecutor executor3 = (JavascriptExecutor) driver;
			executor3.executeScript("arguments[0].click();", Hyperlink);
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
			//Getting the text of the candidate 
			WebElement Text = driver.findElement(By.id("35ea28781b97149c270c11b6bc4bcb9e"));
			Text.getText();
			String Details = Text.getText();
			log.info(Details);

			//Getting the Document of the  candidate to download 
			WebElement Document = driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h2"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true)",Document);
			Thread.sleep(2000);

 			//Clicking candidate Documents link to download
			
			WebElement DocClick = driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/ul/li[2]/a"));
			Thread.sleep(2000);
			DocClick.click();
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
			// Find the table element
			   WebElement table1 = driver.findElement(By.id("window.BGC Candidate Documents"));
			   												
			   // Find all the <a> tags within the table
			   List<WebElement> links = table1.findElements(By.tagName("a"));
			   System.out.println("Inner row  size "  + links.size() );													
//				
			   System.out.println("linkcheck");
//	 		
			   // Iterate through each <a> tag and click it
			   for (WebElement link : links) {
			      
				   
				   try {
					   Thread.sleep(2000);
					   link.click();
				   Thread.sleep(1000);
				   log.info("clicking the links");
				   
				   }catch (Exception e) {
					   
				   }
			   }
		
			
					 //closing the loop
				   WebElement closeloop = driver.findElement(By.xpath("//*[@id=\"popup_close_image\"]"));
				   Thread.sleep(2000);
				   closeloop.click();
				   
					WebElement DocClick1 = driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/ul/li[2]/a"));
					Thread.sleep(2000);
					DocClick1.click();
					
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
				   
				   
	//clicking the loop for the second time
				// Find the table element
				   WebElement table12 = driver.findElement(By.id("window.BGC Candidate Documents"));
				   												
				   // Find all the <a> tags within the table
				   List<WebElement> links2 = table12.findElements(By.tagName("a"));
				   System.out.println("Inner row  size "  + links2.size() );													
//					
				   System.out.println("linkcheck");
//		 		
				   // Iterate through each <a> tag and click it
				   for (WebElement link1 : links2) {
				      
					   
					   try {
						   Thread.sleep(2000);
						   link1.click();
					   Thread.sleep(5000);
					   log.info("clicking the links");
					   
					   }catch (Exception e) {
						   log.info(" link not clicked");
					   }


				   }  
			   
			   
			   WebElement close = driver.findElement(By.xpath("//*[@id=\"popup_close_image\"]"));
		 Thread.sleep(2000);
		 close.click();
		 						
	 WebElement backbutton = driver.findElement(By.xpath("/html/body/div[1]/span/span/nav/div/div[1]/button[1]"));
	 JavascriptExecutor js31 = (JavascriptExecutor) driver;
		js31.executeScript("arguments[0].scrollIntoView(true)",backbutton);
		 backbutton.click();
	 Thread.sleep(2000);
		}
		
}
}