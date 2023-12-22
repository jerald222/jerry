package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TechMahindra {

	static	Logger log =Logger.getLogger(TechMahindra.class);
	static WebDriver driver;

// 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
	private static String desired_filepath = "/home/admin/Documents/Tech_Mahindra";

	public static void main(String[] args ) throws InterruptedException, IOException {

	//	String[] args = {"userID","password","CandidateId" };	
		
		TechMahindra1(args);
	
		TechMahindra2(args);
	
	}

	public static void TechMahindra1(String[] args) throws InterruptedException, IOException {
		
	
		String userID ="ePC16223";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password ="Pass@789";// 2531691
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
		//options.addArguments("--user-data-dir=/path/to/custom/directory");

		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
		
		// get url for Tech_mahindra
		driver.get("https://vchannel.techmahindra.com/VPlogin.aspx?pSession=1");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		// username
		driver.findElement(By.id("txtUserName")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		// password
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	
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

	
	}
	
	
	
	//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
		public static  void TechMahindra2(String[] args) throws InterruptedException, IOException {
			String desired_filepath = "/home/admin/Documents/TECH_Mahindra";

			//System.out.println("Candidate Id===========" + args[0]);

		String CandidateId ="";// 2531691
		if (args[0] != "") {
			CandidateId = args[0];
		}


	// clicking employee button to dropdown
	WebElement Empsearch = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtReqAppID"));
	
try {	
	if (!CandidateId.isEmpty()) {
		System.out.println("test");
		//driver.close();
		
		Empsearch.sendKeys(CandidateId);
	}else if(CandidateId.isEmpty()) {
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
	
if(Ver.equals(CandidateId)) {
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
					   
			    	   //continue;
			    	   //link.click();
			              }
}
			   WebElement Urn = driver.findElement(By.xpath("//*[@id=\"ctl00_apVendor_content_rptVendor_ctl00_lnkVendor\"]"));
			   Urn.click();
			   Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				 System.out.println("2");
				   log.info("Clicking urn");
		   }else if(!Ver.equals(CandidateId)) {
			// Click to another candidate to scrap
			   WebElement Urn = driver.findElement(By.xpath("//*[@id=\"ctl00_apVendor_content_rptVendor_ctl00_lnkVendor\"]"));
			   Urn.click();
			   Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				 System.out.println("2");
				   
				 log.info("id  found so scrapped for the candiate");	
		   }
		
		}catch (Exception e2) {
	System.out.println("id not found fo ID "+CandidateId +"so skipped to another id");
	log.info("id not found fo ID "+CandidateId +"so skipped to another id");	
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
}
