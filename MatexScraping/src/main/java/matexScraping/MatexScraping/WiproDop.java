package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WiproDop {
	
	static	Logger log =Logger.getLogger(WiproDop.class);
	static WebDriver driver;
	static String CandidateId =" ";
 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
//	private static String desired_filepath = "/home/admin/Documents/Wipro";
	
	public static void main(String[] args ) throws InterruptedException, IOException {

		
		//	String[] args = {"userID","password","CandidateId" };	
		
		Wipro1(args);
	
		Wipro2(args);
	
	}

	public static void Wipro1(String[] args) throws InterruptedException, IOException {
		
	
		String userID ="Sivaraj.b@matrixbsindia.com";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password ="Wipro@2022";// 2531691
		if (args[2] != "") {
			password = args[2]; 
		}
		
		
	
		String CaseRegistrationId = "";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("profile.default_content_settings.popups", 0);
		hm.put("download.default_directory", desired_filepath);
		// hm.put("download.default_directory",desired_filepath);

		hm.put("download.prompt_for_download", false);
		hm.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
	
			//Turns off download prompt

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", hm);
		options.setCapability("disable-dev-shm-usage", true);
		options.addArguments("--remote-allow-origins=*"); 
		options.addArguments("--safebrowsing-disable-download-protection"); // disable safe browsing download protection

		//options.addArguments("--incognito"); 
		
		//options.addArguments("--user-data-dir=/path/to/custom/directory");

//		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
		
		// get url for tcs
		driver.get("https://wiproaadb2c.b2clogin.com/WiproAADB2C.onmicrosoft.com/B2C_1_iVerify_SignIn/oauth2/v2.0/authorize?response_type=code&scope=openid&redirect_uri=https%3A%2F%2Fiverify.wipro.com%2Fiverify%2FVendorAAD&client_id=638b638d-d4ed-40bc-8d76-3a007c63bb66&response_mode=form_post&nonce=9dd2ffd8-84ef-47f4-aa35-f9ae8d023301&prompt=login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		// username
		driver.findElement(By.id("email")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		// password
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	
	//Sign in button
	WebElement Sign =	driver.findElement(By.id("next"));
	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	executor3.executeScript("arguments[0].click();", Sign);
	Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		  // Refresh the page
        driver.navigate().refresh();
	
        //Repating the process after the refresh
    	// username
		driver.findElement(By.id("email")).sendKeys(userID);
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		// password
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	
	//Sign in button
	WebElement Sign1 =	driver.findElement(By.id("next"));
	JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	executor1.executeScript("arguments[0].click();", Sign1);
	Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		
		
	//Send new verification code
		driver.findElement(By.id("ReadOnlyEmail_ver_but_send")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		
		
		
	// applying verification code
		driver.findElement(By.id("ReadOnlyEmail_ver_input")).sendKeys("jfj");
		Thread.sleep(60000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		 System.out.println("2");
	//clicking on the verfiy code button
		WebElement code = driver.findElement(By.id("ReadOnlyEmail_ver_but_verify"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", code);

		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
		//clicking on the continue button
	WebElement next =	driver.findElement(By.id("continue"));
	JavascriptExecutor executor5 = (JavascriptExecutor) driver;
	executor5.executeScript("arguments[0].click();", next);
	Thread.sleep(2000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	
	
//	//Selecting account name
//	WebElement Accname	= driver.findElement(By.xpath("//select[@class='inputgrey']"));
//	JavascriptExecutor executor55 = (JavascriptExecutor) driver;
//	executor55.executeScript("arguments[0].click();", Accname);
//	
	  // Locate the dropdown element using XPath
    WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='inputgrey']"));

    // Initialize the Select class
    Select dropdown = new Select(dropdownElement);

    // Select an option by its visible text
    dropdown.selectByVisibleText("Wipro DO&P"); // Replace with the desired option text

	
	
	// clicking employee button to dropdown
		WebElement Emp = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/ul/li[1]"));
		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
		executor6.executeScript("arguments[0].click();",Emp );
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		
		//clicking on the dropdown for employee
		WebElement Empver =driver.findElement(By.xpath(("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/ul/li[1]/ul/li/a")));
		JavascriptExecutor executor7 = (JavascriptExecutor) driver;
		executor7.executeScript("arguments[0].click();",Empver );
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	
	
	}
	
	

	
	//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
		public static  void Wipro2(String[] args) throws InterruptedException, IOException {
			String desired_filepath = "/home/admin/Documents/2032454";

			//System.out.println("Candidate Id===========" + args[0]);

		String CandidateId ="";// 2531691
		if (args[0] != "") {
			CandidateId = args[0];
		}


	
	


	   // Find the search element and submit button
    WebElement searchElement = driver.findElement(By.id("searchBar"));
    WebElement searchclick = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div"));

      
  log.info("array");
    
   
	   searchElement.sendKeys(CandidateId);
		
	   
	   if (CandidateId.isEmpty()) {
			
			 driver.close();
		} else {
		    System.out.println("Clicking on submit");
		  
		    Thread.sleep(2000);
			   searchclick.click();
			 
		 
		}
	
	   
//	   Thread.sleep(2000);
//	   searchclick.click();
//	   
	   //Clicking verify									
	   WebElement CheckingID = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']"));
	   CheckingID.getText();								
	   String check =CheckingID.getText();
	   String numbersOnly = check.replaceAll("[^0-9]", "");
	log.info(numbersOnly);
	log.info(CandidateId);								
		
	if(numbersOnly.equals(CandidateId)) {					
		WebElement verify1 = driver.findElement(By.xpath("//button[text()='VERIFY']"));
		
		 
				Thread.sleep(2000);																				 
		   if(verify1.isDisplayed()) {					
			   log.info("verify1 clicked");
			   verify1.click();
			  //calling lateral method 
			   Lateral(); 
		   }else if(!verify1.isDisplayed()) {										
				 WebElement verify2 = driver.findElement(By.xpath("//div[@class='col-xs-12 pad15 border_bottom paddltrgt ng-star-inserted']/div[@class='col-xs-2 no_pad pull-right']/button[@class='view_btn pull-right font-color bold']"));
				 Thread.sleep(2000);								//div[@class='col-xs-12 pad15 border_bottom paddltrgt ng-star-inserted']/div[@class='col-xs-2 no_pad pull-right']/button[text()='VERIFY']		
				 verify2.click();
				 //calling lateral method 
				   Lateral(); 
			
				 
					
		   log.info("verify2 clicked");
			 }else {
		
				 WebElement verify3 = driver.findElement(By.xpath("//div[@class='col-xs-12 pad15 border_bottom paddltrgt ng-star-inserted']/div[@class='col-xs-2 no_pad pull-right']/button]"));
				  Thread.sleep(2000);	
				 verify3.click();
				 log.info("verify3 clicked");
				 //calling lateral method 
				   Lateral(); 
			
			 }
		 	 }else {
				 WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
				 
				 snap.click();
			  log.info("snap clicked");
			   
			   WebElement Contract = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'Contract')]"));
		   Thread.sleep(2000);
			Contract.click();
			Contract(CandidateId);
			 }
	   
	    
		}
 
  
  
	public static void Lateral() throws InterruptedException {
		
	
 //	getting candidate details
    //WebElement details =driver.findElement(By.xpath("//*[@id=\"rightBorderDiv\"]/div[5]/div/span/span"));
    WebElement details =driver.findElement(By.xpath("//span[@class='cursor call_mail_txt pull-right clr_blue']"));

      WebElement details1 =driver.findElement(By.xpath("//span[@class='ng-star-inserted' and contains(text(),'Candidate details')]")); 
      if(details.isDisplayed()) {
    	JavascriptExecutor js5 = (JavascriptExecutor) driver;
    	js5.executeScript("arguments[0].click();",details);
    	Thread.sleep(2000);
    	
    }else {
    	JavascriptExecutor js5 = (JavascriptExecutor) driver;
    	js5.executeScript("arguments[0].click();",details1);
    	Thread.sleep(2000);
    	
    }
    
	Thread.sleep(2000);//html/body/div[2]/div[2]/div/mat-dialog-container/confirm/div/div/div[2]
	WebElement detailstext = driver.findElement(By.xpath("//div[@class='modal-body modal_scroll']"));
	Thread.sleep(2000);
	detailstext.getText();									
	
	  
	//getting data to a string 
	String tabledata = detailstext.getText();
	log.info(tabledata);
	Thread.sleep(2000);

	//closing the table box
	WebElement Close = driver.findElement(By.xpath("//button[@class='close']"));
	Thread.sleep(2000);
	 Close.click(); 
	
	//downloading documents for the candidates
    WebElement consent =driver.findElement(By.xpath("//div/span[text()='Consent']"));
    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("arguments[0].scrollIntoView(true)",consent);
	Thread.sleep(2000);
	log.info("consent");
	//clicking on consent 
	
	     
//consent download
		WebElement consent2 =driver.findElement(By.xpath("//div/span/img[@alt='Consent']"));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();",consent2);
		Thread.sleep(2000);
		log.info("consent click download");
     
//Download all documents
		WebElement AllDoc = driver.findElement(By.xpath("//span[@class='font-color font13 ml5' and contains(text(),'Download All documents')]"));
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].scrollIntoView(true)",AllDoc);
		Thread.sleep(2000);
			log.info("All download");
			
			//clicking downlaod doc
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			js7.executeScript("arguments[0].click();",AllDoc);

			
			

////////////////////////////////////////////
//	
//			WebElement test = driver.findElement(By.xpath("//div[@class='qualification_details ng-star-inserted']"));
//			java.util.List<WebElement> rowDivs = test.findElements(By.xpath("//div[@class='qualification_details ng-star-inserted']"));
//
//			 int rowSize = rowDivs.size();
//			
//				for (int l = 1; l < rowSize+1; l++) {                
//		    		//Downloading of files for the candidate      
//					WebElement file =driver.findElement(By.xpath(""));
//														  
//					if (file.isDisplayed()&& file.equals(file)){
//							
//						System.out.println("1st window");
//						JavascriptExecutor js12 = (JavascriptExecutor) driver;
//						js12.executeScript("arguments[0].click();",file);
//						
//						//file.click();								  
//						Thread.sleep(2000);
//					}
//					else {
//						//driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[1]/div/div/div/svg")).click();
//						Thread.sleep(2000);
//						System.out.println("2nd window");
//					}
//				}
			
			//Resume Validation
			WebElement  resume = driver.findElement(By.xpath("//div[@class='qualification_details ng-star-inserted' and contains(text(),'Resume Validation-1')]"));
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			js8.executeScript("arguments[0].scrollIntoView(true)",resume);
			Thread.sleep(1000);
			
			//clicking resume doc
			WebElement  resume0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[1]/span/span/div/div/div/span[1]/img"));
			JavascriptExecutor js9 = (JavascriptExecutor) driver;
			js9.executeScript("arguments[0].click();",resume0);
			Thread.sleep(1000);
			
			
			//clicking resume download
			WebElement Resume1 = driver.findElement(By.xpath("//div/span[@class='doc_color font13 ml5 pull-right']"));
			JavascriptExecutor js10 = (JavascriptExecutor) driver;
			js10.executeScript("arguments[0].click();",Resume1);
			Thread.sleep(1000);

////////////////////////////////////////////
			
////Education 1
//WebElement  education0 = driver.findElement(By.xpath("//div[@class='qualification_details ng-star-inserted' and contains(text(),'Education-1')]"));
//JavascriptExecutor js11 = (JavascriptExecutor) driver;
//js11.executeScript("arguments[0].scrollIntoView(true)",education0);
//Thread.sleep(1000);
//
////clicking education1 doc
//WebElement  education1 = driver.findElement(By.xpath("//div[@class='qualification_details ng-star-inserted' and contains(text(),'Education-1')]"));
//JavascriptExecutor js12 = (JavascriptExecutor) driver;
//js12.executeScript("arguments[0].click();",education1);
//Thread.sleep(1000);
//
//
////clicking education1 download
//WebElement education2 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//  String edu1 = education2.getText();
//  log.info(edu1);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//			
//////////////////////////////////////////////
//
////Education 2
//WebElement  education20 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[2]/div[3]/div[1]"));
//JavascriptExecutor js14 = (JavascriptExecutor) driver;
//js14.executeScript("arguments[0].scrollIntoView(true)",education20);
//Thread.sleep(1000);
//
////clicking education2 doc
//WebElement  education21 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[2]/div[3]/div[2]/span/span/div/span[1]/img"));
//JavascriptExecutor js15 = (JavascriptExecutor) driver;
//js15.executeScript("arguments[0].click();",education21);
//Thread.sleep(1000);
//
//
////clicking education2 getting text
//WebElement education22 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String edu2 =education22.getText();
//log.info(edu2);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//
//////////////////////////////////////////////
//
////gradution 1
//WebElement  graduation0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[2]/div[4]/span/div"));
//JavascriptExecutor js16 = (JavascriptExecutor) driver;
//js16.executeScript("arguments[0].scrollIntoView(true)",graduation0);
//Thread.sleep(1000);
//
////clicking gradution1 doc
//WebElement  graduation1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[2]/div[4]/div/span/span/div/span[1]/img"));
//JavascriptExecutor js17 = (JavascriptExecutor) driver;
//js17.executeScript("arguments[0].click();",graduation1);
//Thread.sleep(1000);
//
//
////clicking education2 getting text
//WebElement graduation3 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String edu3 =graduation3.getText();
//log.info(edu3);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//
//////////////////////////////////////////////
//
////Previous Employment Check-1
//WebElement  Employment1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[3]/div[2]/div[1]"));
//JavascriptExecutor js18 = (JavascriptExecutor) driver;
//js18.executeScript("arguments[0].scrollIntoView(true)",Employment1);
//Thread.sleep(1000);
//
////clicking gradution1 doc
//WebElement  Employment2 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[3]/div[2]/div[2]/span/span/div/span[1]/img"));
//JavascriptExecutor js19 = (JavascriptExecutor) driver;
//js19.executeScript("arguments[0].click();",Employment2);
//Thread.sleep(1000);
//
//
////clicking education2 getting text
//WebElement Employment3 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String gra3 =Employment3.getText();
//log.info(gra3);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//
//////////////////////////////////////////////
//
////Previous Employment Check-2
//WebElement  Employment10 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[4]/div[2]/div[1]"));
//JavascriptExecutor js20 = (JavascriptExecutor) driver;
//js20.executeScript("arguments[0].scrollIntoView(true)",Employment10);
//Thread.sleep(1000);
//
////Previous Employment Check-2
//WebElement  Employment20 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//JavascriptExecutor js21 = (JavascriptExecutor) driver;
//js21.executeScript("arguments[0].click();",Employment20);
//Thread.sleep(1000);
//
//
////Previous Employment Check-2 getting text
//WebElement Employment30 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String gra30 =Employment30.getText();
//log.info(gra30);
//Thread.sleep(1000);

////////////////////////////////////////////


////////////////////////////////////////////

//criminal Check-1
//WebElement  criminal0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[5]/div[2]/div[1]"));
//JavascriptExecutor js22 = (JavascriptExecutor) driver;
//js22.executeScript("arguments[0].scrollIntoView(true)",criminal0);
//Thread.sleep(1000);
//
////criminal Check-1
//WebElement  criminal1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[5]/div[2]/div[2]/div/span/img"));
//JavascriptExecutor js23 = (JavascriptExecutor) driver;
//js23.executeScript("arguments[0].click();",criminal1);
//Thread.sleep(1000);
//
//
////criminal Check-1 getting text
//WebElement criminal2 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String cri =criminal2.getText();
//log.info(cri);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//
//////////////////////////////////////////////
//
////drug Check-1
//WebElement  drug0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[6]/div[2]/div[1]"));
//JavascriptExecutor js24 = (JavascriptExecutor) driver;
//js24.executeScript("arguments[0].scrollIntoView(true)",drug0);
//Thread.sleep(1000);
//
////drug Check-1
//WebElement  drug1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[6]/div[2]/div[2]/div/span/img"));
//JavascriptExecutor js25 = (JavascriptExecutor) driver;
//js25.executeScript("arguments[0].click();",drug1);
//Thread.sleep(1000);
//
//
////drug Check-1 getting text
//WebElement drug3 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String drug =drug3.getText();
//log.info(drug);
//Thread.sleep(1000);
//
//////////////////////////////////////////////
//
////database Check-1
//WebElement  database0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[7]/div[2]/div[1]"));
//JavascriptExecutor js26 = (JavascriptExecutor) driver;
//js26.executeScript("arguments[0].scrollIntoView(true)",database0);
//Thread.sleep(1000);
//
////database Check-1
//WebElement  database1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[7]/div[2]/div[2]/div/span/img"));
//JavascriptExecutor js27 = (JavascriptExecutor) driver;
//js27.executeScript("arguments[0].click();",database1);
//Thread.sleep(1000);
//
//
////database Check-1 getting text
//WebElement database2 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[2]/div"));
//String data =database2.getText();
//log.info(data);
//Thread.sleep(1000);

			
			WebElement back = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[1]/span[1]"));
			back.click();
			
////////////////////////////////////////////
		
  }

	
		
	public static void Contract(String CandidateId) throws InterruptedException {
		    //String CandidateId ="";
			System.out.println("Contract method is called.");
		
			   // Find the search element and submit button
		    WebElement searchElement = driver.findElement(By.id("searchBar"));
		    WebElement searchclick = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div"));

		 	   
		     
			   searchElement.sendKeys(CandidateId);
			   Thread.sleep(2000);
			   searchclick.click();
			  
			 //div[contains(text(),'No records found!!')]
			   WebElement CheckingIDS = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']"));
			
				log.info(CandidateId);
				 WebDriverWait wait = new WebDriverWait(driver, 10);

			    // Check if CheckingIDS is displayed and act accordingly
		        if (CheckingIDS.isDisplayed()) {
		            // Try to click on the "VERIFY" button
		            WebElement verifyButton = null;
		            if (!driver.findElements(By.xpath("//button[text()='VERIFY']")).isEmpty()) {
		                verifyButton = driver.findElement(By.xpath("//button[text()='VERIFY']"));
		                //verifyButton.click();
		            } else if (!driver.findElements(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[3]/mat-tab-group/div/mat-tab-body[3]/div/div[1]/div[2]/div[2]/div[1]/div/span/div[1]/div[7]/button")).isEmpty()) {
		                verifyButton = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[3]/mat-tab-group/div/mat-tab-body[3]/div/div[1]/div[2]/div[2]/div[1]/div/span/div[1]/div[7]/button"));
		            }

		            // Perform the action based on the presence of verifyButton
		            if (verifyButton != null) {
		                verifyButton.click();
		                log.info("Button clicked.");
		            } else {
		                // If neither "VERIFY" button nor verify2 is found, handle other actions (e.g., clicking on "OK")
		                WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		                snap.click();
		                log.info("OK button clicked.");
		                WebElement Internal = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'Internal')]"));
						   Thread.sleep(2000);
						   Internal.click();
										   
					   Internal(CandidateId);
			       
		            }
		        } else {
		            // If CheckingIDS is not displayed, handle other actions (e.g., clicking on "OK")
		            WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		            snap.click();
		            log.info("OK button clicked.");
		            WebElement Internal = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'Internal')]"));
					   Thread.sleep(2000);
					   Internal.click();
									   
				   Internal(CandidateId);
		       
		        }
		
		}
  
		public static void Internal(String CandidateId) throws InterruptedException {
		    //String CandidateId ="";
			System.out.println("Contract method is called.");
		
			   // Find the search element and submit button
		    WebElement searchElement = driver.findElement(By.id("searchBar"));
		    WebElement searchclick = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div"));

		 	   
		     
			   searchElement.sendKeys(CandidateId);
			   Thread.sleep(2000);
			   searchclick.click();
			  
			 //div[contains(text(),'No records found!!')]
			   WebElement CheckingIDS = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']"));
			
			   
//			   WebElement CheckingID = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']"));
//				  
//			   	
//			   CheckingID.getText();
//			    String check =CheckingID.getText();//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']
//			   String numbersOnly = check.replaceAll("[^0-9]", "");
//		
//			   log.info(numbersOnly);
			log.info(CandidateId);
			 
			 // Check if the CheckingIDS element is displayed
	        if (CheckingIDS.isDisplayed()) {
	            // Try to click on the "VERIFY" button
	            try {
	                WebElement verify1 = driver.findElement(By.xpath("//button[text()='VERIFY']"));
	                verify1.click();
	                log.info("VERIFY button clicked");
	               //calling Internal method 
	                InternalDoc();
	            
	            } catch (org.openqa.selenium.NoSuchElementException e) {
	                // If the "VERIFY" button is not found, try clicking on verify2
	                try {
	                    WebElement verify2 = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[3]/mat-tab-group/div/mat-tab-body[3]/div/div[1]/div[2]/div[2]/div[1]/div/span/div[1]/div[7]/button"));
	                    verify2.click();
	                    log.info("verify2 clicked");
	                    //calling Internal method 
		                InternalDoc();
		            
	                   
	                } catch (org.openqa.selenium.NoSuchElementException ex) {
	                    // If both "VERIFY" and verify2 are not found, click on the "Internal" label element
	                    
	                	WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
						 
						 snap.click();
					  log.info("verify clicked");
					   
					   WebElement Campus = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'Campus')]"));
				   Thread.sleep(2000);
				   Campus.click();
								   
			   Campus(CandidateId);
	                }
	            }
	        } else {
	            // If the CheckingIDS element is not displayed, click on the "OK" button
	            WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	            snap.click();
	            log.info("OK button clicked");
	            WebElement Campus = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'Campus')]"));
				   Thread.sleep(2000);
				   Campus.click();
								   
				   Campus(CandidateId);
	       
	        
	        }	
		
		}

		public static void Campus(String CandidateId) throws InterruptedException {
		    //String CandidateId ="";
			System.out.println("Contract method is called.");
		
			   // Find the search element and submit button
		    WebElement searchElement = driver.findElement(By.id("searchBar"));
		    WebElement searchclick = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div"));

		 	   
		     
			   searchElement.sendKeys(CandidateId);
			   Thread.sleep(2000);
			   searchclick.click();
			  
			 //div[contains(text(),'No records found!!')]
			   WebElement CheckingIDS = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']"));
			
			   
//			   WebElement CheckingID = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']"));
//				  
//			   	
//			   CheckingID.getText();
//			    String check =CheckingID.getText();//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']
//			   String numbersOnly = check.replaceAll("[^0-9]", "");
//		
//			   log.info(numbersOnly);
			log.info(CandidateId);
			 
			 // Check if the CheckingIDS element is displayed
	        if (CheckingIDS.isDisplayed()) {
	            // Try to click on the "VERIFY" button
	            try {
	                WebElement verify1 = driver.findElement(By.xpath("//button[text()='VERIFY']"));
	                verify1.click();
	                log.info("VERIFY button clicked");
	            } catch (org.openqa.selenium.NoSuchElementException e) {
	                // If the "VERIFY" button is not found, try clicking on verify2
	                try {
	                    WebElement verify2 = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[3]/mat-tab-group/div/mat-tab-body[3]/div/div[1]/div[2]/div[2]/div[1]/div/span/div[1]/div[7]/button"));
	                    verify2.click();
	                    log.info("verify2 clicked");
	                } catch (org.openqa.selenium.NoSuchElementException ex) {
	                    // If both "VERIFY" and verify2 are not found, click on the "Internal" label element
	                    
	                	WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
						 
						 snap.click();
					  log.info("verify clicked");
					   
					   WebElement GSH = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'GSH')]"));
				   Thread.sleep(2000);
				   GSH.click();
								   
				   GSH(CandidateId);
	                }
	            }
	        } else {
	            // If the CheckingIDS element is not displayed, click on the "OK" button
	            WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	            snap.click();
	            log.info("OK button clicked");
	            WebElement GSH = driver.findElement(By.xpath("//label[@class='pull-left text-capitalize font12 mt2' and contains(text(),'GSH')]"));
				   Thread.sleep(2000);
				   GSH.click();
								   
				   GSH(CandidateId);
	       
	        
	        }	
		
		}

		public static void GSH(String CandidateId) throws InterruptedException {
		    //String CandidateId ="";
			System.out.println("Contract method is called.");
		
			   // Find the search element and submit button
		    WebElement searchElement = driver.findElement(By.id("searchBar"));
		    WebElement searchclick = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[1]/div/div"));

		 	   
		     
			   searchElement.sendKeys(CandidateId);
			   Thread.sleep(2000);
			   searchclick.click();
			  
			 //div[contains(text(),'No records found!!')]
			   WebElement CheckingIDS = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']"));
			
			   
//			   WebElement CheckingID = driver.findElement(By.xpath("//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']"));
//				  
//			   	
//			   CheckingID.getText();
//			    String check =CheckingID.getText();//div[@class='col-xs-12 candidate_info_content ng-star-inserted']/span/div/div/div/span[@class='col-xs-12 no_pad ng-star-inserted']
//			   String numbersOnly = check.replaceAll("[^0-9]", "");
//		
//			   log.info(numbersOnly);
			log.info(CandidateId);
			 
			 // Check if the CheckingIDS element is displayed
	        if (CheckingIDS.isDisplayed()) {
	            // Try to click on the "VERIFY" button
	            try {
	                WebElement verify1 = driver.findElement(By.xpath("//button[text()='VERIFY']"));
	                verify1.click();
	                log.info("VERIFY button clicked");
	            } catch (org.openqa.selenium.NoSuchElementException e) {
	                // If the "VERIFY" button is not found, try clicking on verify2
	                try {
	                    WebElement verify2 = driver.findElement(By.xpath("/html/body/app-root/div/va-page/div[2]/div[2]/div[3]/mat-tab-group/div/mat-tab-body[3]/div/div[1]/div[2]/div[2]/div[1]/div/span/div[1]/div[7]/button"));
	                    verify2.click();
	                    log.info("verify2 clicked");
	                } catch (org.openqa.selenium.NoSuchElementException ex) {
	                    // If both "VERIFY" and verify2 are not found, click on the "Internal" label element
	                    
	                	WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
						 
						 snap.click();
					  log.info("verify clicked");
					  log.info("Id not found");
					
	                }
	            }
	        } else {
	            // If the CheckingIDS element is not displayed, click on the "OK" button
	            WebElement snap = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	            snap.click();
	            log.info("Id not found 1");
	          
	        
	        }	
		
		}	
		
		public static void InternalDoc() throws InterruptedException {
			
//			getting candidate details
		    //WebElement details =driver.findElement(By.xpath("//*[@id=\"rightBorderDiv\"]/div[5]/div/span/span"));
		    WebElement details =driver.findElement(By.xpath("//span[@class='cursor call_mail_txt pull-right clr_blue']"));
		    WebElement details1 =driver.findElement(By.xpath("//span[@class='ng-star-inserted' and contains(text(),'Employee details')]"));
		    if(details.isDisplayed()) {
		    	JavascriptExecutor js5 = (JavascriptExecutor) driver;
		    	js5.executeScript("arguments[0].click();",details);
		    	Thread.sleep(2000);
		    	
		    }else {
		    	JavascriptExecutor js5 = (JavascriptExecutor) driver;
		    	js5.executeScript("arguments[0].click();",details1);
		    	Thread.sleep(2000);
		    	
		    }
		    
			Thread.sleep(2000);//html/body/div[2]/div[2]/div/mat-dialog-container/confirm/div/div/div[2]
			WebElement detailstext = driver.findElement(By.xpath("//div[@class='modal-body modal_scroll']"));
			Thread.sleep(2000);
			detailstext.getText();									
			
			  
			//getting data to a string 
			String tabledata = detailstext.getText();
			log.info(tabledata);
			Thread.sleep(2000);

			//closing the table box
			WebElement Close = driver.findElement(By.xpath("//button[@class='close']"));
			Thread.sleep(2000);
			 Close.click(); 
			
			//downloading documents for the candidates
		    WebElement consent =driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[1]/div/span"));
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView(true)",consent);
			Thread.sleep(2000);
			log.info("consent");
			//clicking on consent 
			

		     
		//consent download
				WebElement consent2 =driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[2]/div/div[1]/div/div[2]/div/span/span"));
				JavascriptExecutor js5 = (JavascriptExecutor) driver;
				js5.executeScript("arguments[0].click();",consent2);
				Thread.sleep(2000);
				log.info("consent click download");
		     
		//Download all documents
				WebElement AllDoc = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[4]/div/span[1]"));
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("arguments[0].scrollIntoView(true)",AllDoc);
				Thread.sleep(2000);
					log.info("All download");
					
					//clicking downlaod doc
					JavascriptExecutor js7 = (JavascriptExecutor) driver;
					js7.executeScript("arguments[0].click();",AllDoc);

		////////////////////////////////////////////
			
					//Resume Validation
					WebElement  resume = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[1]/div[2]/div[1]"));
					JavascriptExecutor js8 = (JavascriptExecutor) driver;
					js8.executeScript("arguments[0].scrollIntoView(true)",resume);
					Thread.sleep(1000);
					
					//clicking resume doc
					WebElement  resume0 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[5]/div[1]/div[2]/div[2]/span/span/div/span[1]/img"));
					JavascriptExecutor js9 = (JavascriptExecutor) driver;
					js9.executeScript("arguments[0].click();",resume0);
					Thread.sleep(1000);
					
					
					//clicking resume download
					WebElement Resume1 = driver.findElement(By.xpath("/html/body/app-root/div/detailview-page/div[6]/div[3]/div[1]/div/div[4]/div/span[1]"));
					JavascriptExecutor js10 = (JavascriptExecutor) driver;
					js10.executeScript("arguments[0].click();",Resume1);
					Thread.sleep(1000);

		////////////////////////////////////////////
			
		}
	
		
} 
   
		

	
	
	
	
	
	
	

