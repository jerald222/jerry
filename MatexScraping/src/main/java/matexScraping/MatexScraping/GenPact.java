package matexScraping.MatexScraping;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

public class GenPact {
static WebDriver driver;
static	Logger log =Logger.getLogger(GenPact.class);
private static String desired_filepath ="/home/admin";
//	public static void main(String []args) throws FindFailed, InterruptedException, IOException {
public static void main(String []args) throws  InterruptedException, IOException {
	
		GenPact_id(args);
		genpact1(args);
	}
	
	public static void GenPact_id(String[] args ) throws InterruptedException, IOException {
		
		String userID ="";// 2531691
		if (args[0] != "") {
		userID = args[0];
	}

		String password ="Matrix@2023";// 2531691
		if (args[1] != "") {
			password = args[1]; 
		}
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("profile.default_content_settings.popups", 0);
		hm.put("download.default_directory",desired_filepath  );
		// hm.put("download.default_directory",desired_filepath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", hm);
		options.setCapability("disable-dev-shm-usage", true);
		options.addArguments("--remote-allow-origins=*"); 
		//options.addArguments("--user-data-dir=/path/to/custom/directory");
//														/home/admin/eclipse-workspace/selinum_export/chromedriver

		System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
		// get url for Tech_mahindra
			// get url for tcs
			log.info("*****************************************************URL*************************");
			driver.get("http://genpact.tydy.co/app/bgv/#/employee");
			

//username for genpact
			
	driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div[1]/div[1]/div[2]/div[1]/input")).sendKeys(userID);
	Thread.sleep(2000);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
	// password for capgemini
	driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div[1]/div[1]/div[2]/div[2]/input")).sendKeys(password);

	//Clicked to submit button
	driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/div[1]/div[2]/button")).click();
	Thread.sleep(1000);
	}
	
	
	
	
	public static void genpact1(String[] args ) throws InterruptedException, IOException {
			
		 // Set the maximum time to wait for the element (in seconds)
        int maxWaitTimeInSeconds = 10;
Thread.sleep(10000);
     
		//Dropdown
			WebElement drop = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[2]/ng-select/div"));
			   // Wait until the element is visible
			 waitForElementVisibility(driver, drop, maxWaitTimeInSeconds);
 
	        drop.click();
			
			Thread.sleep(2000);
			
			//dropdown select
			driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[2]")).click();
			Thread.sleep(2000);
			
			
			WebElement ID = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[1]/input"));
	
			String CandidateId ="6970366";
			if (args[0]!= "") {
			CandidateId = args[0];
			
			}
			
			
		try {
		//applying  candidate id 
				if (!CandidateId.isEmpty()&& !(CandidateId==null)) {
		    ID.sendKeys(CandidateId);
		    Thread.sleep(2000);
		} else if(CandidateId == null || CandidateId.isEmpty()){
		    // Check if ID is null
	 log.info("Closing the browser when values are not found");
	 driver.quit();
		}
		}catch(Exception e) {
			log.info(" catch Exception candidate's id not found so browser closed" );
			driver.quit();

		}
	
		WebElement PROGRESS = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[2]/ng-select/div"));

		Thread.sleep(4000);
		System.out.println("click icon ");
		
		//click for the veiwdetails button	
		WebElement PROGRESS1 = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[2]/ng-select/div"));
		try {
		if (PROGRESS.isDisplayed()) {
			WebElement ViewDot = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[2]/div/div/div/table/tbody/tr/td[6]/div/div[1]/img"));
			
			ViewDot.click();
			Thread.sleep(2000);
			WebElement ViewDetail = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]"));
			
			ViewDetail.click();
			Thread.sleep(5000);
			
			log.info("view link is visible ");
			
		}else{
			log.info("browser not replicable , so restarted to scrap the candidates");
	
		WebElement No_case	= driver.findElement(By.xpath("//div[class=(class=\"emptyStates__title font-18 font-medium\") and text()='No Cases']"));
		if (No_case.isDisplayed()) {;
		log.info("no case found for the "+CandidateId+" so skipped to next ID ");
		}else {
			
		}
		
		}
		}catch(Exception T1){
			log.info("website error , So Relogging  is done");
		}
		try {
			// verifying the candidate
			WebElement verify = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div/div[2]/div/div/div/div[9]/div[2]"));
			
		   // Scroll the element into view
	        scrollIntoView(driver, verify);
			
	        verify.getText();
			 String Ver = verify.getText();
		System.out.println(Ver);
	log.info(Ver);
	
	if(Ver.equals(CandidateId)) {
			log.info("Values are equals so data will scrap for the " +CandidateId);
//		//getting band details 
//		WebElement Band = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div/div[2]/div[8]/div/div[2]"));
//		String Bandvalue = Band.getText();
//		System.out.println("Band value is =" +Bandvalue);
//		log.info(Bandvalue);
//		
//		// getting Sdo value 
//		WebElement SDO = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div/div[2]/div[11]/div/div[2]"));
//		String SDOvalue = SDO.getText();
//		System.out.println("SDO value is =" +SDOvalue);
//		log.info(SDOvalue);
//	
//		WebElement CandidateName = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div/div/div[1]"));
//		String Candidatevalue = CandidateName.getText();
//		System.out.println("SDO value is =" +Candidatevalue);
//		log.info(Candidatevalue);
//		Thread.sleep(3000);
//		
		//click for the view From button
			WebElement ViewFrom = driver.findElement(By.xpath("//div[@class='btn btn__primary btn__compact u-min-width-125' and contains (text(),' View Form ')]"));
		   
			 // Scroll the element into view
	        scrollIntoView(driver, ViewFrom);
			
	      
			
			ViewFrom.click();
			Thread.sleep(2000);
			
			
			WebElement Download = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]"));
					//driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[2]/div/div[3]"));
//			scrollIntoView(driver, Download);
			Download.click();						///html/body/app-root/div/app-employee-detail/div[1]/div[2]/div/div[3]/span	
			Thread.sleep(2000);						///html/body/app-root/div/app-employee-detail/div[1]/div[2]/div/div[3]
			
//			String parentWindow = driver.getWindowHandle(); // Store the parent window handle
//			Set<String> windows = driver.getWindowHandles();
//			for (String window : windows) {
//			    if (!window.equals(parentWindow)) {
//			        driver.switchTo().window(window);
//			        break;
//			 
//			    }
//			}
//			
//			
//			WebElement buttonInNewWindow = driver.findElement(By.xpath("/html/body/button"));
////			File_mover();
//			System.out.println("file moved ");
//			buttonInNewWindow.click();
//			//Moving file 
//		
//			Thread.sleep(2000);
////			System.out.println("outer window pdf clicked ");
//			Thread.sleep(2000);
//			driver.close();
//			//Switch back to parent window
//			Thread.sleep(2000);
//			driver.switchTo().window(parentWindow);
//			
			
			//navigating back
		WebElement Back = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[1]/div/div/div"));
			Back .click();
			Thread.sleep(5000);
			log.info("Back button clicked");
					
			//click for the viewDocuments	
			WebElement ViewDocuments = driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div[2]"));
			log.info("Viewbutton clicked");
		    waitForElementVisibility(driver, ViewDocuments, maxWaitTimeInSeconds);
			ViewDocuments.click();
			System.out.println("pdf clicked");
			Thread.sleep(3000);
			   // Wait for the download to complete (you can implement a proper wait here)
	        // For simplicity, we'll use a thread sleep, but you should use WebDriverWait in a real scenario
	        try {
	            Thread.sleep(5000); // Wait for 5 seconds (adjust as needed)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	     	//looping for the div element
			//WebElement div_table = driver.findElement(By.cssSelector(""));
		  				 
	             

//	            }catch(Exception r5) {
//	            	log.info("closing the driver");
//	            	
//	            	
//	            	driver.close();
//	            }
	        
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
					
								  
					Thread.sleep(2000);
				}
				else {
					//driver.findElement(By.xpath("/html/body/app-root/div/app-employee-detail/div[1]/div[1]/div[1]/div/div/div/svg")).click();
					Thread.sleep(2000);
					System.out.println("2nd window");
				}
				
						WebElement opennewWindow1 = driver.findElement(By.cssSelector("span.u-margin-right-vsmall"));
				Thread.sleep(2000);										
					opennewWindow1.click();									
						System.out.println("clicked for the new window");
			opennewWindow1.getText();
//			String name = opennewWindow1.getText();
			log.info("click the download link");
			Thread.sleep(2000);

			// Get the window handles
				Set<String> windowHandles = driver.getWindowHandles();
				System.out.println("window handles ");
				
				// Check if there is more than one window handle
				if (windowHandles.size() > 1) {
				    // The element clicked opened a new tab
				    // Perform actions in the new tab
				 	Thread.sleep(1000);	
				 	log.info("check for the screenshot");
				 	
					//String parentWindow = driver.getWindowHandle(); // Store the parent window handle
					Set<String> windows1 = driver.getWindowHandles();
					for (String window : windows1) {
						Thread.sleep(2000);	
//
						  System.out.println("jjjjjjjjjjjj@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
						     
//					      Screen  screen  = new Screen();
							 System.out.println("699999999868978@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

////						 Pattern image1 = new Pattern ("C:/Users/Public/Documents/image1.png");
//							 System.out.println(image1.isValid());
//							
//							 if (image1.isValid()) {
//													 screen.wait(image1,2000);
//						      screen.click(image1);
//						      System.out.println("check@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//							   
//							
//				
////						      Pattern image2 = new Pattern("/home/admin/Pictures/image2.png"); 
//								 Pattern image2 = new Pattern ("C:/Users/Public/Documents/image3.png");
//
//						      screen.wait(image2,2000);
//						      screen.click(image2);
//					   
//						      System.out.println("clicked the images");
//						   }  else  {
//						    	  System.out.println("printing screenshot");
//						    	  File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//						          // Specify the destination where you want to save the screenshot
//						          File destinationFile = new File("C:/Users/Public/Documents/screenshot.png"); // Specify your desired file path and name
//
//						          // Use FileUtils.copyFile to save the screenshot file to the specified destination
//						          try {
//						              FileUtils.copyFile(sourceFile, destinationFile);
//						              System.out.println("Screenshot file saved successfully.");
//						          } catch (IOException e) {
//						              System.out.println("Failed to save screenshot: " + e.getMessage());
//						          }
//	  }  	  
//						      

						
						
						
//						// Create a Robot instance
////				        Robot robot = new Robot();
//				        log.info("Robot class Started");
////				       
////				        File sourceFile = ( (TakesScreenshot) robot).getScreenshotAs(OutputType.FILE);
//////						 
////				    	// Specify the destination where you want to save the screenshot
////						File destinationFile = new File("C:/Users/Public/Documents/"); // Replace with your desired file path and name
////					
////						// Use FileUtils.copyFile to save the screenshot file to the specified destination
////						try {
////						FileUtils.copyFile(sourceFile, destinationFile);
////						log.info("log check 4");
////					 	
////						 System.out.println("Screenshot file saved successfully .");
////						 log.info("log check 5");
////						 	
////						
////					 } catch (IOException e) {
////		            System.out.println("Failed to save court screenshot: " + e.getMessage());
////		        
////			 
////			 }
////				
//						System.out.println("clicking  images and  hs a time limit");
//						Thread.sleep(1200);
////&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//						 System.out.println("jjjjjjjjjjjj@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		     
//				Screen  screen  = new Screen();
//				 System.out.println("699999999868978@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//
////				 Pattern image1 = new Pattern("/home/admin/Pictures/image1.png"); 
//				 Pattern image1 = new Pattern ("C:/Users/Public/Documents/image1.png");
//			   
//										 screen.wait(image1,2000);
//			      screen.click(image1);
//			      System.out.println("check@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//				   
//				
//	
////			      Pattern image2 = new Pattern("/home/admin/Pictures/image2.png"); 
//					 Pattern image2 = new Pattern ("C:/Users/Public/Documents/image3.png");
//
//			      screen.wait(image2,2000);
//			      screen.click(image2);
//		   
//			      System.out.println("clicked the images");
//
//				 
//					   
								String parentWindow = driver.getWindowHandle(); // Store the parent window handle
								Set<String> windows = driver.getWindowHandles();
									driver.switchTo().window(parentWindow);
								
							 
							 
							 log.info("Robot class Stops");
				        
						
				  	if (!window.equals(parentWindow)) {
				  		log.info("log check 6");
					 	    
					    	driver.switchTo().window(window);
					    	log.info("log check 7");
						 	
					    	driver.close();
					    	log.info("log check 8");
						 	
					    	break;
					 
					    }
					}
//					
//					Thread.sleep(2000);
				    // Switch back to the original tab
				   driver.switchTo().window(windowHandles.iterator().next());
				   JavascriptExecutor js1 = (JavascriptExecutor) driver;
					js1.executeScript("window.scrollBy(0,65)");
				}else {
					System.out.println("Take screen shot");
				}
	       	}

	    	//clicking for the cases for other id scraping
	    	WebElement  casesLINK =driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/div[2]/div/span"));
	    	casesLINK.click();
	       	    	System.out.println("scraping for other id's");

}else if(!Ver.equals(CandidateId)) {
	// Click to another candidate to scrap
	WebElement  casesLINK =driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/div[2]/div/span"));
	casesLINK.click();
	System.out.println("scraping for other id's");
Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		 System.out.println("2");
		   
		 log.info("id  found so scrapped for the candiate");	
 }
	
}catch (Exception e2) {
System.out.println("id not found fo ID "+CandidateId +"so skipped to another id");
log.info("id not found fo ID "+CandidateId +"so skipped to another id");	
//Click to another candidate to scrap

WebElement  casesLINK =driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/div[2]/div/span"));
casesLINK.click();
driver.findElement(By.xpath("/html/body/app-root/div/app-employee-list/div[1]/div/div[1]/div[1]/input")).clear();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		 log.info("when id not equals to candidate id clicks urn");
}	
}

    private static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    private static void waitForElementVisibility(WebDriver driver, WebElement element, int maxWaitTimeInSeconds) {
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, maxWaitTimeInSeconds);
        wait.until((WebDriver k)->ExpectedConditions.visibilityOf(element).apply(k));
    }	

}





