package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NivaBupa {

	static	Logger log =Logger.getLogger(NivaBupa.class);
	static WebDriver driver;
//	private static String desired_filepath = "/home/admin/Documents/Nivabupa";
	private static String desired_filepath = "C:\\Users\\Public\\Documents\\Matex";
	
	public static void main(String[] args ) throws InterruptedException, IOException {
		
		//	String[] args = {"userID","password","CandidateId" };	
			
		NivaBupa_id(args);
		
		NivaBupa_download(args);
		
		}

public static void NivaBupa_id(String[] args ) throws InterruptedException, IOException {
		
		String userID ="ebgc_maxbupa@matrixbsindia.com";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

			String password ="1234567890";// 2531691
			if (args[1] != "") {
				password = args[1]; 
			}
			
			System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
			
			String CaseRegistrationId = "";
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("profile.default_content_settings.popups", 0);
			hm.put("download.default_directory", desired_filepath);
			hm.put("download.prompt_for_download", false);
		    
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", hm);
			options.setCapability("disable-dev-shm-usage", true);
			options.addArguments("--remote-allow-origins=*"); 
			// Configure Chrome to automatically download files to the specified directory
	       options.addArguments("download.default_directory=" + desired_filepath);
	       options.addArguments("download.prompt_for_download=false");
	       options.addArguments("disable-popup-blocking");

	       log.info("*******URL*******");
	     //Chrome driver 
//			System.setProperty("webdriver.gecko.driver","/home/admin/eclipse-workspace/selinum_export/geckodriver");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");

	       driver = new ChromeDriver(options);
	       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	       driver.manage().window().maximize();
	       driver.manage().deleteAllCookies();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));


			// get url for MAXBUPa
			log.info("*****************************************************URL*************************");
			driver.get("https://disha.darwinbox.in/onboarding/bgv/");
						
			
			// username for capegemini
				driver.findElement(By.id("BgvLogin_username")).sendKeys(userID);
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				// password for capgemini
				driver.findElement(By.id("BgvLogin_password")).sendKeys(password);
			
				//Clicked to send OTP button
				driver.findElement(By.id("login-submit")).click();
				Thread.sleep(1000);
	
	       
			

}


public static void NivaBupa_download(String[] args ) throws InterruptedException, IOException {
	
	String desired_filepath = "/home/admin/Documents/capegemini";
		 //Second method for the genpact for scraping and screenshots
			String CandidateId ="";// 2531691
			if (args[0] != "") {
				CandidateId = args[0]; //7276924
		}
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		      //waiting for the page to load
		       Thread.sleep(5000);
		       
		//candidate id searching
		
		   	WebElement Candidate =driver.findElement(By.id("candidate_search"));
		
try {
			 if(!(CandidateId== null ||CandidateId.isEmpty() )) {
				 
				 Candidate.sendKeys(CandidateId);
				 Thread.sleep(2000);
				 
			} else if((CandidateId== null ||CandidateId.isEmpty() )) {
			  	log.info("candidate's id not found so browser closed" );
				driver.quit();
			
			}
				
}catch(Exception e) {
	log.info(" catch Exception candidate's id not found so browser closed" );
	driver.quit();
			}    
		       
System.out.println("Clicking on submit");
Thread.sleep(5000);
// -----submit button----//

try {

WebElement element4 = driver.findElement(By.xpath("//*[@id=\"center_stage\"]/section/div[2]/div[1]/div/div/div/ul/li"));
if(element4.isDisplayed()) {	
	
	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	executor3.executeScript("arguments[0].click();", element4);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	

try {
	// verifying the candidate
	
WebElement CanID =  driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tbody/tr/td[1]"));
 String Value = CanID.getText();
 log.info(Value);
 
 
 if(!Value.equals(CandidateId)) {
	 log.info("checking whether the id is equal or not");
		// Get the handle of the current window
        String parentWindowHandle = driver.getWindowHandle();

		
		//clicking candidate's hyperlink
		//WebElement Hyperlink = driver.findElement(By.xpath(""));
		Thread.sleep(3000);
		WebElement Hyperlink = driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tbody/tr/td[1]/a[2]"));
		
		int attempts = 0;
	        while (attempts < 3) {  // Retry a maximum of 3 times
	            try {
	            	Hyperlink.click();
	                break;  // Exit the loop if the click succeeds
	            } catch (StaleElementReferenceException e) {
	            	Hyperlink.click();
	            
	            	System.out.println("the candidate name = "+ Hyperlink);
	            }// Element reference is stale, wait and retry
	          
	        }  	
	        
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   	 Hyperlink.getText();
		   	String Name =  Hyperlink.getText();
		   	System.out.println("the candidate name" +Name);
		   	log.info(Name);
		    // Get the handles of all open windows
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Switch to the new window
	        for (String handle : windowHandles) {
	            if (!handle.equals(parentWindowHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        // Perform actions in the new window
	        // Locate and click on the element in the new window
	        WebElement elementInNewWindow = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div"));
	        Thread.sleep(2000);
	        elementInNewWindow.click();

	        
	        //Dropdown for the filled form on boarding
	        WebElement Dropdown1 = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div/ul/li[1]/a"));
	        Thread.sleep(2000);
	        Dropdown1.click();
	       
	     

	        // Locate and click on the element in the new window
	        WebElement elementInNewWindow1 = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div"));
	        Thread.sleep(2000);
	        elementInNewWindow1.click();

	        //Dropdown for the files to download for the candidate
	        WebElement Dropdown2 = driver.findElement(By.xpath("//*[@id=\"bulk_attachment\"]"));
	         Dropdown2.click();
	         Thread.sleep(2000);
	       
	       //Sending Downloaded document through Api for case registration
	         
	         
	         
	         
	         driver.close();
	        Thread.sleep(2000);
	        
	        // Switch back to the parent window
	        driver.switchTo().window(parentWindowHandle);
	        Thread.sleep(2000);
	      //clearing id searching
			
	        //WebElement search1 = driver.findElement(By.id("candidate_search"));
			//search1.clear();
		    
	        Candidate.clear();
	       Thread.sleep(2000);
			
	      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
	      Sear.click();
	     
	        Thread.sleep(5000);
			
 }else if(Value.equals(CandidateId)) {
		   
	        Candidate.clear();
		       Thread.sleep(2000);
				
		      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
		      Sear.click();
		     
		        Thread.sleep(5000);
 }	
 }catch(Exception e2) {
	   Candidate.clear();
       Thread.sleep(2000);
		
      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
      Sear.click();
     
        Thread.sleep(5000);
 
 }
	
	
	
}else if(!element4.isDisplayed()){
		log.info("candidate id  for " +CandidateId+ "is not found , so skipped for other canddiate ");
		 Candidate.clear();
	       Thread.sleep(2000);
			
	      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
	      Sear.click();
	     
}
}catch(Exception e2) {
	   Candidate.clear();
       Thread.sleep(2000);
		
      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
      Sear.click();
     
        Thread.sleep(5000);
	
	//wait for the page load
}	
		       
	

//try {
//	// verifying the candidate
//	
//WebElement CanID =  driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tbody/tr/td[1]"));
// String Value = CanID.getText();
// log.info(Value);
// 
// 
// if(!Value.equals(CandidateId)) {
//	 log.info("checking whether the id is equal or not");
//		// Get the handle of the current window
//        String parentWindowHandle = driver.getWindowHandle();
//
//		
//		//clicking candidate's hyperlink
//		//WebElement Hyperlink = driver.findElement(By.xpath(""));
//		Thread.sleep(3000);
//		WebElement Hyperlink = driver.findElement(By.xpath("//*[@id=\"employee_list\"]/tbody/tr/td[1]/a[2]"));
//		
//		int attempts = 0;
//	        while (attempts < 3) {  // Retry a maximum of 3 times
//	            try {
//	            	Hyperlink.click();
//	                break;  // Exit the loop if the click succeeds
//	            } catch (StaleElementReferenceException e) {
//	            	Hyperlink.click();
//	            
//	            	System.out.println("the candidate name = "+ Hyperlink);
//	            }// Element reference is stale, wait and retry
//	          
//	        }  	
//	        
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		   	 Hyperlink.getText();
//		   	String Name =  Hyperlink.getText();
//		   	System.out.println("the candidate name" +Name);
//		   	log.info(Name);
//		    // Get the handles of all open windows
//	        Set<String> windowHandles = driver.getWindowHandles();
//
//	        // Switch to the new window
//	        for (String handle : windowHandles) {
//	            if (!handle.equals(parentWindowHandle)) {
//	                driver.switchTo().window(handle);
//	                break;
//	            }
//	        }
//
//	        // Perform actions in the new window
//	        // Locate and click on the element in the new window
//	        WebElement elementInNewWindow = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div"));
//	        Thread.sleep(2000);
//	        elementInNewWindow.click();
//
//	        
//	        //Dropdown for the filled form on boarding
//	        WebElement Dropdown1 = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div/ul/li[1]/a"));
//	        Thread.sleep(2000);
//	        Dropdown1.click();
//	       
//	     
//
//	        // Locate and click on the element in the new window
//	        WebElement elementInNewWindow1 = driver.findElement(By.xpath("//*[@id=\"bulk_actions_dev\"]/div"));
//	        Thread.sleep(2000);
//	        elementInNewWindow1.click();
//
//	        //Dropdown for the files to download for the candidate
//	        WebElement Dropdown2 = driver.findElement(By.xpath("//*[@id=\"bulk_attachment\"]"));
//	         Dropdown2.click();
//	         Thread.sleep(2000);
//	       
//	       //Sending Downloaded document through Api for case registration
//	         
//	         
//	         
//	         
//	         driver.close();
//	        Thread.sleep(2000);
//	        
//	        // Switch back to the parent window
//	        driver.switchTo().window(parentWindowHandle);
//	        Thread.sleep(2000);
//	      //clearing id searching
//			
//	        //WebElement search1 = driver.findElement(By.id("candidate_search"));
//			//search1.clear();
//		    
//	        Candidate.clear();
//	       Thread.sleep(2000);
//			
//	      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
//	      Sear.click();
//	     
//	        Thread.sleep(5000);
//			
// }else if(Value.equals(CandidateId)) {
//		   
//	        Candidate.clear();
//		       Thread.sleep(2000);
//				
//		      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
//		      Sear.click();
//		     
//		        Thread.sleep(5000);
// }	
// }catch(Exception e2) {
//	   Candidate.clear();
//       Thread.sleep(2000);
//		
//      WebElement Sear =driver.findElement(By.xpath("//*[@id=\"search_selected\"]/button"));
//      Sear.click();
//     
//        Thread.sleep(5000);
// 
// }
		        
		        
 }
 }




		
	