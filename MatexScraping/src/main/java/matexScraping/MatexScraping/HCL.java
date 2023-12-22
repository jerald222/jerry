package matexScraping.MatexScraping;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HCL {


		static	Logger log =Logger.getLogger(HCL.class);
		static WebDriver driver;
		private static String desired_filepath = "/home/admin/Documents/HCL";
//		private static String desired_filepath = "C:\\Users\\Public\\Documents\\Matex";
		
		static ChromeOptions options = new ChromeOptions();
		 static HashMap<String, Object> hm = new HashMap<String, Object>();
		
		
		public static void main(String[] args ) throws InterruptedException, IOException {
			
			//	String[] args = {"userID","password","CandidateId" };	
				
			HCL_id(args);
			
			HCL1(args);
			
			}

		public static void HCL_id(String[] args ) throws InterruptedException, IOException {
			
			String userID ="TPA090";// 2531691
				if (args[0] != "") {
				userID = args[0];
			}

				String password ="hcl@123";// 2531691
				if (args[2] != "") {
					password = args[2]; 
				}
				
				String CaseRegistrationId = "";
//				HashMap<String, Object> hm = new HashMap<String, Object>();
//				hm.put("profile.default_content_settings.popups", 0);
//				hm.put("download.default_directory", desired_filepath);
//				// hm.put("download.default_directory",desired_filepath);

//				options = new ChromeOptions();
				options.setExperimentalOption("prefs", hm);
				options.setCapability("disable-dev-shm-usage", true);
				options.addArguments("--remote-allow-origins=*"); 
				//options.addArguments("--headless");
				////////////////////////////////////////
			System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");

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
							driver.get("https://wf6.myhcl.com/SmartVerifyRevamptpa/vendor/tpLogin.aspx");
							//username for  hcl
							driver.findElement(By.id("ctl00_ContentPlaceHolder1_txttpaUserId")).sendKeys(userID);
							Thread.sleep(2000);
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
							//Password for the hcl	
							driver.findElement(By.id("ctl00_ContentPlaceHolder1_txttpaPassword")).sendKeys(password);
							Thread.sleep(2000);
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
							
						
					//Clicked to submit
					driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
					Thread.sleep(1000);
		
					// submitted my initiator and vendor view details
					driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdSummary_ctl02_lnkViewdetail")).click();	
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
					
		}
		

		public static void HCL1(String[] args ) throws InterruptedException, IOException {
						
				
				//Second method for the capegemini for scraping and screenshots
				String value ="";// 2531691
				if (args[0] != "") {
					value = args[0]; //7276924
				}
		
				String desired_filepath1 = "/home/admin/Documents/HCL"+value;
				
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("profile.default_content_settings.popups", 0);
				hm.put("download.default_directory", desired_filepath1);
			
				
				
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
					
					
					
					//applying the BGV ID for the candidate
			WebElement candidate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
			log.info("value  are been checked for confirmation");
			try {	
				if (!value.isEmpty()) {
					System.out.println("Entring the valus for the candidate");
					candidate.sendKeys(value);
				Thread.sleep(2000);
				}else if(value.isEmpty()) {
				log.info("candidate's id not found so browser closed" );
				driver.quit();
				
				}
				
			}catch( Exception e) {
				log.info(" catch Exception candidate's id not found so browser closed" );
				driver.quit();

			}
				  
			    //applying search for the candidate
				WebElement search = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSearch"));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				JavascriptExecutor executor77 = (JavascriptExecutor) driver;
				executor77.executeScript("arguments[0].click();",search );
				
				
				
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				Thread.sleep(10000);
			 try {
		
			//Verifying the candidate								//*[@id="ctl00_ContentPlaceHolder1_grdTPAView"]/tbody/tr[2]/td[1]
				WebElement verify = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_grdTPAView\"]/tbody/tr[2]/td[1]"));
				String verifytext =verify.getText();
				log.info(verifytext);
				
				if(verifytext.equals(value)) {
		log.info(value);
					Thread.sleep(8000);
			 WebElement name = driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[2]"));
				String nametxt = name.getText();
				log.info("candidate name =" +nametxt );
			
			 WebElement Id = driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[2]/table/tbody/tr/td/table/tbody/tr[7]/td/div/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td[1]"));
					String IDtxt = Id.getText();
					log.info("candidate Id =" +IDtxt );
			
					//clicking on the joining form for the  candidate 
			log.info("clicking the joining form");
					WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdTPAView_ctl02_lnkJoiningForm"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
			  // Get the window handles
	        String mainWindow = driver.getWindowHandle();
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Iterate through each window handle
	        for (String handle : windowHandles) {
	            if (!handle.equals(mainWindow)) {
	                driver.switchTo().window(handle);

	                 // Find and interact with the element in the new window
	    			System.out.println("123");
	    			@SuppressWarnings("deprecation")
					WebDriverWait wait = new WebDriverWait(driver, 60);
	 
	    			
	    			By elementLocator = (By.xpath("//*[@id=\"PreviewForm\"]/div[2]/a[1]"));
	    			
	    			 WebElement elementInNewWindow = wait.until((WebDriver k) -> ExpectedConditions.visibilityOfElementLocated(elementLocator).apply(k));

	    				
	    				JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    				js1.executeScript("arguments[0].scrollIntoView(true)",elementInNewWindow);
	    				Thread.sleep(2000);
	    				
	    				
	    				
	    				
	    				//By elementLocator1 = (By.xpath("//div/a[@class=]'list_icon' and contains (text(),'Download')"));
	    				By download = (By.xpath("//div/a[@class='list_icon' and contains(text(),'Download')]"));
	    	    		
	    			//webElement download = driver.findElement(By.xpath("//div/a[@class='list_icon' and contains(text(),'Download')]"));
	     				WebElement elementInNewWindow1 = wait.until((WebDriver l) -> ExpectedConditions.visibilityOfElementLocated(download).apply(l));
	    				Thread.sleep(2000);
	    				elementInNewWindow1.click();
	    				log.info("document downloaded");
						
	    				log.info("joining form downloaded for the candidate :" +nametxt);
	    				Thread.sleep(10000);
	    				driver.close();
	    				 System.out.println("closed window for downloadedpage 1");
	    				
	    				// Check if a new window2 opens
	                Set<String> newWindowHandles = driver.getWindowHandles();
	                if (newWindowHandles.size() > 1) {
	                    
	                	// There is a new window2
	                    for (String newHandle : newWindowHandles) {
	                        if (!newHandle.equals(mainWindow) && !newHandle.equals(handle)) {
	                            driver.switchTo().window(newHandle);

	                            // Close the browser if window2 opens
	                            driver.close();
	                            System.out.println("closed window for downloadedpage 2 (redirect)");
	                         
	                           
	                        }
	                    }
	                }
	            	Thread.sleep(2000);
	                // Switch back to the main window
	                driver.switchTo().window(mainWindow);

	                break;
	            }
	        }

	   
			//editing and updating of the candidate
				 Thread.sleep(5000);
				 driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdTPAView_ctl02_lnkUpload")).click();
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
				//Second new window 
					// Store the main window handle
					// Get the window handles
					Set<String> windowHandles1 = driver.getWindowHandles();
					System.out.println("second new window");
					// Switch to the new window
					for (String handle : windowHandles1) {
					    if (!handle.equals(mainWindow)) {
					        driver.switchTo().window(handle);
					        break;
					    }
					}
					// Find and interact with the element in the new window
					Thread.sleep(1000);	
					WebDriverWait wait = new WebDriverWait(driver, 60);
					WebElement InSecondWindow =driver.findElement(By.xpath("//*[@id=\"btnDownload\"]"));
					
						WebElement Package_name = driver.findElement(By.xpath("//*[@id=\"global-centrecontent\"]/table/tbody/tr[1]/td/table/tbody/tr[4]/td[1]"));
						String Package = Package_name.getText();
						log.info(Package);
					

						WebElement Package_name1 = driver.findElement(By.xpath("//*[@id=\"lblPkgname\"]"));
						String Package1 = Package_name1.getText();
						log.info( Package  = Package1);
					
					
					By elementInSecondWindow =(By.xpath("//*[@id=\"btnDownload\"]"));
								JavascriptExecutor js2 = (JavascriptExecutor) driver;
							js2.executeScript("arguments[0].scrollIntoView(true)",InSecondWindow);
							Thread.sleep(2000);
							log.info("joining form downloaded for the candidate :" +nametxt);
							WebElement elementInNewWindow2 = wait.until((WebDriver h) -> ExpectedConditions.visibilityOfElementLocated( elementInSecondWindow).apply(h));
							
							Thread.sleep(2000);
						
						
						
							elementInNewWindow2.click();
							Thread.sleep(6000);
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

							 driver.close();
					
						// Optionally, switch back to the main window
					driver.switchTo().window(mainWindow);

							
					//clearing the search field to generate another candiate id 
					//clearing the BGV ID for the candidate

					try {
						// Try to find and click the first element
						WebElement ResumeElement = driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdTPAView_ctl02_lnkResume"));
						JavascriptExecutor js12 = (JavascriptExecutor) driver;
						js12.executeScript("arguments[0].click();",ResumeElement);
					
						Thread.sleep(2000);
					
						log.info("Resume downloaded for the candidate :" +nametxt);
						
						WebElement secondElement = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
						secondElement.clear();
						log.info("cleared the search field");
						Thread.sleep(4000);
					
								} catch (NoSuchElementException e1) {
							// First element not found, click the second element instead
						WebElement secondElement = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
						secondElement.clear();
						log.info("cleared the search field in catch");
						Thread.sleep(2000);
						//candidate clear
						WebElement clear1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
						clear1.clear();
					
								
								}
				}else if (!verifytext.equals(value)) {
					System.out.println("id not found so skipped to another id");
					log.info("id not found so skipped to another id");	
					// Click to another candidate to scrap
					
					log.info("candidate not found , so cleared the ");
					WebElement clear1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
					clear1.clear();
				
				}
			 }catch(Exception e2){
					//candidate clear
					WebElement clear1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTransferEmpCode"));
//					clear1.clear();
					System.out.println("cleared field 2");
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
					
				//applying search for the candidate
				  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//WebElement element = driver.findElement(By.id("elementId"));
					//element.click();
				  System.out.println("applying search");
				  	Thread.sleep(2000);
					WebElement search1 = driver.findElement(By.xpath("//input[@type='submit' and @value='Search']"));
					JavascriptExecutor js12 = (JavascriptExecutor) driver;
					js12.executeScript("arguments[0].click();",search1);
					
					Thread.sleep(10000);
					try {
					WebElement ttt = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_tblTPAGridView\"]/tbody/tr[2]/td"));
//					WebElement xxx = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_UpdatePanel3\"]"));
				       
					
					if (ttt.isDisplayed()) {
			        	System.out.println("Id's displayed");
			        }else {
			        	System.out.println("Time scheduler is been activated");
						time_Scheduler();
						
			        }
					}catch(Exception e9){
						System.out.println("Time scheduler is been activated");
						time_Scheduler();
						
					}
			 
			 
			 }
			
		
		}
	public static void time_Scheduler() {

		 // Set a timeout duration (in seconds) for the browser to automatically close
	    int timeoutDuration = 200; // 5 minutes (300 seconds)

	    // Create a ScheduledExecutorService to schedule the browser close task
	    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.schedule(() -> {
	        System.out.println("Closing the browser due to timeout...");
	        driver.quit();
	        executorService.shutdownNow();
	    }, timeoutDuration, TimeUnit.SECONDS);

	    try {
	        Thread.sleep(TimeUnit.SECONDS.toMillis(timeoutDuration));
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }	



	}
	}
	
	

