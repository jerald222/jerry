package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class RBLBank {

	static	Logger log =Logger.getLogger(RBLBank.class);
	static WebDriver driver;

// 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
	private static String desired_filepath = "/home/admin/Documents/RBLBank";

	public static void main(String[] args ) throws InterruptedException, IOException {

	//	String[] args = {"userID","password","CandidateId" };	
		
		RBL1(args);
	
		RBL2(args);
	
	}

	public static void RBL1(String[] args) throws InterruptedException, IOException {
		
	
		String userID ="BGV_Vendor1";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password ="Taleo@1234";// 2531691
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
		 options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 options.setCapability(ChromeOptions.CAPABILITY, options);
	 	
		
		//options.addArguments("--user-data-dir=/path/to/custom/directory");

	
		
		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
		
		// get url for tcs
		driver.get("https://rblbank.taleo.net/smartorg/iam/accessmanagement/login.jsf?lang=en&redirectionURI=http://rblbank.taleo.net");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.navigate().refresh();
		// username
		driver.findElement(By.id("dialogTemplate-dialogForm-content-login-name1")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		// password
		driver.findElement(By.id("dialogTemplate-dialogForm-content-login-password")).sendKeys(password);
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		//Clicking on Sign in button 
		WebElement Sign =driver.findElement(By.xpath("//*[@id=\"dialogTemplate-dialogForm-content-login-defaultCmd\"]/span/span/span"));
		Sign.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
		//clicking the Recuriting button	
		WebElement Recurit = driver.findElement(By.id("menuTemplate-menuForm-globalHeader-pageRibbonSubView-j_id_id29pc12-0-ribbonItemText"));
		Recurit.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	}	
		
	//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
	public static  void RBL2(String[] args) throws InterruptedException, IOException {
		String desired_filepath = "/home/admin/Documents/2032454";

		//System.out.println("Candidate Id===========" + args[0]);

	String CandidateId ="";// 2531691
	if (args[0] != "") {
		CandidateId = args[0];
	}
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	WebElement search = driver.findElement(By.id("oj-inputsearch-input-search-input"));
try {
	log.info(CandidateId);
	
	if (!CandidateId.isEmpty()) {
		search.clear(); // Clear the search field before entering the new value
	    search.sendKeys(CandidateId);
	    search.sendKeys(Keys.ENTER); // Press ENTER key after entering the value
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	} else if(CandidateId.isEmpty()) {
	      System.out.println("Candidate ID is empty. Closing the browser.");
	    driver.quit();
	}
	}catch(Exception e) {
		log.info(" catch Exception candidate's id not found so browser closed" );
		driver.quit();

	}
//clicking on search
//WebElement CLickIcon = driver.findElement(By.xpath("/html/body/div[4]/div/header/nav/div/quick-search/div[2]/div/div/div[1]/a"));
//CLickIcon.click();
//Thread.sleep(1000);
//WebElement searchButton = driver.findElement(By.cssSelector("/html/body/div[4]/div/header/nav/div/quick-search/div[2]/div/div/div[1]/a"));
//JavascriptExecutor executor = (JavascriptExecutor) driver;
//executor.executeScript("arguments[0].click();", searchButton);

	//##############################################3333	
		//clicking on General Profile 
		//WebElement General = driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div[1]/section/div[2]/div/div[2]/div[3]/div[4]/div/div[3]/ul/li[1]/div/a/span"));
		//General.click();
		//verifying the candidate
	
	try {
		WebElement tabledatapro1 = driver.findElement(By.id("oj-collapsible-702-content"));
		tabledatapro1.getText();
	String ll = tabledatapro1.getText();
	log.info(ll);
		log.info("check**************************");
		WebElement verify = driver.findElement(By.cssSelector("#oj-collapsible-1-content > div > div > div.summary__section.summary__section--basic.summary-application > candidate-info-renderer > h4 > small:nth-child(2) > span:nth-child(2)"));
		log.info("check**************************454545454");
		verify.getText();
		log.info("check**************************7078708");
		String Ver = verify.getText();
		log.info("check**************************86876");
log.info(Ver);
	 System.out.println(Ver);
	
	 if(Ver.equals(CandidateId)) {	 
	 
	 
	System.out.println("1*********");
	
		//clicking on personal information
		
		System.out.println("2********8");
		
		//taking table data for the personal information
		WebElement tabledata = driver.findElement(By.id("oj-collapsible-699-content"));
		tabledata.getText();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		System.out.println("3*******8");
		
		//converting tabletext into string
		String tabletext = tabledata.getText();
		log.info(tabletext);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		System.out.println("4********");
		
		/*//Again clicking on personal information
		WebElement personal1 = driver.findElement(By.xpath("//*[@id=\"699-header\"]/span"));
		Thread.sleep(2000);
		//Scrolling to the particular text
		JavascriptExecutor js61 = (JavascriptExecutor) driver;
		js61.executeScript("arguments[0].scrollIntoView(true)",personal1);
		Thread.sleep(2000);
		personal1.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	*/
	//##############################################3333
		System.out.println("5*******");
		// ===========scroll========//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(2000);

		
		
		//##############################################3333	
		
		//clicking on Experience and Credentials information
		WebElement Experience = driver.findElement(By.id("703-header"));
		Experience.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		//taking table data for the personal information
		WebElement tabledataexp = driver.findElement(By.id("oj-collapsible-703-content"));
		tabledataexp.getText();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		//converting tabletext into string
		String tabletextexp = tabledataexp.getText();
		log.info(tabletextexp);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
		//##############################################3333
		// ===========scroll========//
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,5000)");
				Thread.sleep(2000);
				System.out.println("6*******");
		//##############################################3333	
		
		//clicking on Profile information
		WebElement Profile = driver.findElement(By.id("702-header"));
		Profile.click();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		//taking table data for the personal information
		WebElement tabledatapro = driver.findElement(By.id("oj-collapsible-702-content"));
		tabledatapro.getText();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		//converting tabletext into string
		String tabletextpro = tabledatapro.getText();
		log.info(tabletextpro);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
		//##############################################3333
		// ===========scroll========//
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("window.scrollBy(0,5000)");
				Thread.sleep(3000);
				System.out.println("7*******");
		
		//##############################################3333	
		
		//clicking on Submission information
		WebElement Submission = driver.findElement(By.id("701-header"));
		Submission.click();
		System.out.println("7999*******");
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);

		//taking table data for the personal information//  
		WebElement tabledataSub = driver.findElement(By.xpath("//*[@id=\"oj-collapsible-701-content\"]"));
		// ===========scroll========//
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(2000);

		tabledataSub.getText();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		//converting tabletext into string
		String tabletextSub = tabledataSub.getText();
		log.info(tabletextSub);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				System.out.println("8*******");
	
		//##############################################3333
				// ===========scroll========//
				JavascriptExecutor js9 = (JavascriptExecutor) driver;
				js9.executeScript("window.scrollTo(0, 0);");
	Thread.sleep(2000);
			
		//clicking on Attachments to downlaod
				WebElement Attach = driver.findElement(By.xpath("//*[@id=\"profile-attachment-tab\"]"));
				//Scrolling to the particular text
				System.out.println("8hvfgkh*******");	
				
				Attach.click();
				Thread.sleep(2000);
					Thread.sleep(1000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
		//attachments for downlaods
				 
				WebElement table = driver.findElement(By.xpath("//*[@id=\"profileAttachmentsTable\"]/table")); // Replace 'your-table-id' with the actual ID of your table
				List<WebElement> rows = table.findElements(By.tagName("tr"));
				//int rowSize = rows.size();
				System.out.println(rows.size()); // Output the row size to the console

				
				
				         
			    //int rowCount = innerRows.size();
	            System.out.println("Inner row  size "  + rows.size() );													
		   try {
	            //looping for the inner table 
			     for (int l = 1; l < rows.size(); l++) {				
			    	 												 // /html/body/div[4]/div/div[4]/div[1]/section/div[2]/div/div[2]/div[5]/div[3]/oj-table/table/tbody/tr[1]/td[1]/div/div/div[2]/button[3]																				
			    	 	WebElement Doc = driver.findElement(By.xpath("html/body/div[4]/div/div[4]/div[1]/section/div[2]/div/div[2]/div[5]/div[3]/oj-table/table/tbody/tr["+l+"]/td[1]/div/div/div[2]/button[3]"));
			    	 	//*[@id="profileAttachmentsTable:_hdrCol0_1684288644"]/div/div/div[1]
			    	 	//*[@id="profileAttachmentsTable:_hdrCol0_1684259005"]/div/div/div[2]/button[3]		
			    	 			
			    	 			
			    	 			
			    	 	JavascriptExecutor Downloadclick = (JavascriptExecutor) driver;
						Downloadclick.executeScript("arguments[0].click();", Doc);
						Thread.sleep(1000);
						System.out.println("clickedugyigy");
						
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(1000);
				    		System.out.println("Document downloading for Row =   in "+l+ " Document is downloaded");
			     System.out.println("wating to download the document ");

			     }
			  
			     }catch (StaleElementReferenceException e){
			    	 System.out.println("Element has faced some problems" +  e);
				     
			     }
		
		   Thread.sleep(3000);
		   //clicking  recuring for the  scrapping for other id's
		   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
		   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
		   Recuring12.executeScript("arguments[0].click();", Recuring);
			Thread.sleep(2000);
		
		  
		   Thread.sleep(2000);
		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			  
		 // clicking  the search for the candidate to scrap for existing id's
		   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
		   search1.click();
		   Thread.sleep(2000);
		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			   
	 }else if(!Ver.equals(CandidateId));{
			log.info("else");
		 //clicking  recuring for the  scrapping for other id's
	   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
	   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
	   Recuring12.executeScript("arguments[0].click();", Recuring);
		Thread.sleep(2000);
	
	  
	   Thread.sleep(2000);
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		  
	 // clicking  the search for the candidate to scrap for existing id's
	   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
	   search1.click();
	   Thread.sleep(2000);
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	 }
	 
	}catch(Exception e2) {
		
		log.info("catch exception");
		System.out.println("id not found fo ID "+CandidateId +"so skipped to another id");
			log.info("id not found fo ID "+CandidateId +"so skipped to another id");	
			// Click to another candidate to scrap
			//clicking  recuring for the  scrapping for other id's
			   WebElement Recuring = driver.findElement(By.xpath("//*[@id=\"mainmenu-centerstage\"]/a/span/span"));
			   JavascriptExecutor Recuring12 = (JavascriptExecutor) driver;
			   Recuring12.executeScript("arguments[0].click();", Recuring);
				Thread.sleep(2000);
			
			  
			   Thread.sleep(2000);
			   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				  
			 // clicking  the search for the candidate to scrap for existing id's
			   WebElement search1 = driver.findElement(By.id("oj-inputsearch-input-search-input"));
			   search1.click();
			   Thread.sleep(2000);
			   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			 
			
			
	 }
	 
	 }
	
	
}
