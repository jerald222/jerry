package matexScraping.MatexScraping;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCScampusTrianee_id {
	
		
		static	Logger log =Logger.getLogger(TCScampusTrianee_id.class);
				static WebDriver driver;

		     	//private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
				private static String desired_filepath = "/home/admin/Documents/2032454";

				public static void main(String[] args ) throws InterruptedException, IOException {
			
				//	String[] args = {"userID","password","CandidateId" };	
					
					TcsCTcaptcha1(args);
				
					TcsCTsample(args);
				
				}
			
				public static void TcsCTcaptcha1(String[] args) throws InterruptedException, IOException {
					
					String userID ="ishwarya.s@matrixbsindia.com";// 2531691
						if (args[0] != "") {
						userID = args[0];
					}

					String password ="Aug@2023";// 2531691
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
					System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
					 //System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
					log.info("********************************************chromedriver*************************");
					driver			   = new ChromeDriver(options);
					
					// get url for tcs
					log.info("*****************************************************URL*************************");
					driver.get("https://gbis.tcsapps.com/agency/");
					
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					Thread.sleep(5000);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

					// username
					// driver.findElement(By.id("loginForm:j_idt21")).sendKeys("ishwarya.s@matrixbsindia.com");
					// Thread.sleep(1000);

					// password
					// driver.findElement(By.id("loginForm:j_idt26")).sendKeys("Jan@2023");
					// NAVIGATING TO CAPTCH TEXT BOX
					try {
						driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
					} catch (Exception e) {
					
						e.printStackTrace();
					}
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				
					WebElement element = driver.findElement(By.name("loginForm:addNewRight2"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					Thread.sleep(1000);
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/div/div/div[3]/a")).click();
					Thread.sleep(1000);
					
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// username
					driver.findElement(By.id("loginForm:j_idt21")).sendKeys(userID);
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// password
					driver.findElement(By.id("loginForm:j_idt26")).sendKeys(password);
				
					//log.info(CandidateId );
					System.out.println(password);
					
					// NAVIGATING TO CAPTCH TEXT BOX
					Thread.sleep(2000);
					driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
		        	String captchatext = "";
		               
					log.info("====bypassing the captcha=========");
					
					//====bypassing the captcha=========//
					/*
					//captcha username			
					String dbcusrname ="jerald.berchmans@likemindtech.com";
					//captcha password
					String dbcpsswd ="1222K3806@jb";
					
					System.out.println(args.length);
				        Client client;
				        // using http API
				
				        if(args.length == 3){
				            client = (Client)(new HttpClient(dbcusrname, dbcpsswd));
				        }else if(args.length == 2){
				            client = (Client)(new HttpClient(args[0]));
				        }else{
				            System.out.println("Wrong number of arguments");
				            System.out.println("You must use username/password combination");
				            System.out.println("Or API key");
				            return;
				        }
					
				        client.isVerbose = true;
		*/
				    /* 
					try {
				            try {
				                System.out.println("Your balance is " + client.getBalance() + " US cents");
				            } catch (IOException e) {
				                System.out.println("Failed fetching balance: "+ e.toString() );
				                return;
				            }

				            WebElement element12 = driver.findElement(By.cssSelector("#captchaImg"));
				            //driver.findElement(By.cssSelector("#captchaImg"));
						    Thread.sleep(2000);

						    // Take a screenshot
						    File srcFile = element12.getScreenshotAs(OutputType.FILE);
						    FileUtils.copyFile(srcFile, new File("/home/admin/Documents/captcha.png"));

						//====================================================//
				          /*  //getting captcha 
				            // Download the image
				   		 //By imageLocator = By.cssSelector("#captchaImg");
				   	      String imageSrc = driver.findElement(By.cssSelector("#captchaImg")).getAttribute("src");
				   	    //String imageSrc = driver.findElement(By.cssSelector("#captchaImg")).getAttribute("scr");
				   	      
				   	      URL imageUrl = new URL(imageSrc);
				   	     
				   	      FileUtils.copyURLToFile(imageUrl, new File("/home/admin/Documents/cha.jpg"));
				   		
				   	     Thread.sleep(2000);
				   	//=================================================//
				            
				        	String imageFilePath = "/home/admin/Documents/captcha.png";
				        	  Captcha captcha = null;
				            try {
				                // Upload a CAPTCHA and poll for its status with 120 seconds timeout.
				                // Put you CAPTCHA image file name, file object, input stream, or
				                // vector of bytes, and optional solving timeout (in seconds) here.
				                System.out.println(args);
				            	if (args.length == 3){
				                    //captcha = client.decode(args[2], 120);
				                    captcha = client.decode(imageFilePath,120);
				                }else if (args.length == 2){
				                    captcha = client.decode(args[1], 120);
				                }else{
				                    System.out.println("Failed uploading CAPTCHA - args");
				                    return;    
				                }
				                
				            } catch (IOException e) {
				                System.out.println("Failed uploading CAPTCHA");
				                return;
				            }
				            if (null != captcha) {
				                System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);
				                System.out.println(captcha.text);

				            	 captchatext = (captcha.text);
			       
				        	// NAVIGATING TO CAPTCHA TEXT BOX
				            	 driver.findElement(By.id("loginForm:captcha")).clear();
				            	 Thread.sleep(2000);	
			    			
				            	 driver.findElement(By.id("loginForm:captcha")).sendKeys(captchatext);
					    			
			    				Thread.sleep(2000);
					
					// driver.findElement(By.id("loginForm:addNewRight2")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// driver.findElement(By.className("buttonMiddleSection
					// disableOnClick")).click();
					//login button*****************************
					WebElement element3 = driver.findElement(By.name("loginForm:addNewRight2"));
					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", element3);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// ------------------Notifications-------------------//
					WebElement sap =   driver.findElement(
							By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"));
						sap.click();
					// driver.findElement(By.linkText("263")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// -----------------Advanced filters-----------//
					driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/h3[1]/a")).click();
					//	/html/body/div[1]/div[2]/form/div[2]/h3[1]/a
					//	/html/body/div[1]/div[2]/form/div[2]/h3[1]/span
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					Thread.sleep(4000);
				            } 
				            else {
				               System.out.println("Failed solving CAPTCHA");
				            }
				        } catch (com.DeathByCaptcha.Exception e) {
				            System.out.println(e);

							Thread.sleep(3000);
				        }
		*/

					// NAVIGATING TO CAPTCHA TEXT BOX
			       	 driver.findElement(By.id("loginForm:captcha")).clear();
			       	 Thread.sleep(2000);	
					
			       	 driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
			   			
						Thread.sleep(12000);

						
			// driver.findElement(By.id("loginForm:addNewRight2")).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			//login button click*****************************
			WebElement element3 = driver.findElement(By.name("loginForm:addNewRight2"));
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element3);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			// ------------------Notifications no of request-------------------//
			WebElement sap = driver.findElement(By.xpath("//*[@id=\"agencyHomeForm:fyaFyiTable_data\"]/tr[1]/td[2]/a"));sap.click();
//				/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));


						// -----------------Advanced filters-----------//
					
				WebElement filter =	driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/h3[1]/a"));
					
				if (filter.isDisplayed() && filter.isEnabled()) {
				    filter.click();
				    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				} else {
				    System.out.println("Advanced Filter element is not displayed or enabled so clicked Dropdown.");
				    driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt105_label")).click();
					
				
				
				}	
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						Thread.sleep(1000);	

					
					}

				
		       
				//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
				@SuppressWarnings("unlikely-arg-type")
				public static  void TcsCTsample(String[] args) throws InterruptedException, IOException {
					String desired_filepath = "/home/admin/Documents/2032454";
			
					System.out.println("Candidate Id===========" + args[0]);

				String CandidateId ="";// 2531691
				if (args[0] != "") {
					CandidateId = args[0];
				}
						
				String CaseRegistrationId = "";
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("profile.default_content_settings.popups", 0);
				hm.put("download.default_directory", desired_filepath);
				// hm.put("download.default_directory",desired_filepath);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", hm);
				options.setCapability("disable-dev-shm-usage", true);
				
				
							
				log.info("//****************************Mtd started to download files ");
				

				//*******************************FYA/FYI Type*******************************************//
					driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt112_label")).click();
					
				//**********************select from the list option***********//
					driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt112_panel\"]/div/ul/li[1]")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					Thread.sleep(2000);
					System.out.println("//****************************select from the list type  ");
				

						// ------------------BGC TYPE----------------------//
						// agencySearchViewForm:checksDatatable:0:j_idt144
						driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt105_label")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(2000);
						System.out.println("//****************************campus trainee type ");
							
						// ========Campus trainee type=======//
						driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt105_panel\"]/div/ul/li[5]"))
								.click();   //*[@id="agencySearchViewForm:advanceSearchPanel:j_idt105_panel"]/div/ul/li[3]
						Thread.sleep(4000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						System.out.println("//****************************submitting dropdown ");
							
						// ------------------submit button---------//
						WebElement element2 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
						JavascriptExecutor executor2 = (JavascriptExecutor) driver;
						executor2.executeScript("arguments[0].click();", element2);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						System.out.println("//****************************scrolling");
							
						// ===========scroll========//
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollBy(0,1000)");
						Thread.sleep(2000);

						System.out.println("//****************************applying id");
					log.info("Applicant id for scrapping is  ="+CandidateId );
						
						// -----------employee id-----//
					WebElement Candidate =driver.findElement(By.id("agencySearchViewForm:j_idt58"));
					 Candidate.sendKeys(CandidateId);
					 Thread.sleep(2000);

					 if (CandidateId.isEmpty()) {
					
						 driver.close();
					} else {
					    System.out.println("Clicking on submit");
					  
					 // -----submit button----//
						WebElement element4 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
						JavascriptExecutor executor3 = (JavascriptExecutor) driver;
						executor3.executeScript("arguments[0].click();", element4);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					}

					//listing the No:Rows in the first table
						List<WebElement> tabelrowdate = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
				        // Get the number of rows in the outer table						
				        System.out.println( tabelrowdate.size()-1);
					    Thread.sleep(1000);
					   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					   	int count = tabelrowdate.size() - 1;
					   	String countString = String.valueOf(count);
					   	System.out.println(countString);
				try {
				
					if(countString != null) {
						}
						for(int i =0; i< tabelrowdate.size() -1; i++) {
							
				 		Thread.sleep(2000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						System.out.println("//*****submiting id");
				
						// ===========scroll========//
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("window.scrollBy(0,1000)");
						Thread.sleep(1000);

					//BGC initiated Document download//
					
							driver.findElement(By.linkText("BGC Initiated and Documents Sent to Vendor")).click();
					
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						//driver.findElement(By.xpath("//*[@id=\"agencyWorkflowForm\"]/table[1]/tbody/tr/td[1]/input")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(2000);
						
						
						//listing the No:Rows in the first table
						List<WebElement> tabelrow = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
				        // Get the number of rows in the outer table						
				        System.out.println( tabelrow.size()-1);
					    Thread.sleep(1000);
					   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					   	try {
					
					   		//Looping for the downloading of the documents for the required table
						for (int j = 0; j < tabelrow.size() - 1; j++) {
						    
							//XpathElement for looping to download the entire documents in the required table   
							  driver.findElement(By.xpath("//*[@id=\"agencyCandDocListForm:tabPanel:uploadedDocsDataTable:" + j + ":fileUploadedCount\"]")).click();
						    System.out.println("xpath has been clicked");
						    Thread.sleep(1000);
						   
		    				//downlaoding of all documents in the inner table
			                // Loop through each cell in the current row
						    WebElement innerTable1  = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148\"]/div/table"));         
					         // Find all the rows in the inner table 
				             List<WebElement> innerRows = innerTable1.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
				            System.out.println("Inner row  size "  + innerRows.size() );													
				           
				            	for (int l = 0; l < innerRows.size(); l++) {
				            	   try {
				            		   WebElement downloadLinks = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
					            	    WebDriverWait wait = new WebDriverWait(driver, 1);
					            	    downloadLinks.click();
				            	  
				            	   }catch(Exception e) {
				            		   WebElement OK = null;
				            	        try {
				            	            OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
				            	        } catch (NoSuchElementException ignored) {
				            	            // If OK button is not found, you can handle the exception here or perform necessary actions
				            	        }
				            	        if (OK != null) {
				            	            WebDriverWait wait1 = new WebDriverWait(driver, 1);
//				            	            OK = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
				            	            OK.click();
				            	        }
				            	        System.out.println("Clicked OK for exception");
				            		
				            	   }
				            	
				            }
				       													
				            	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Set a shorter implicit wait

				            	
				            	WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
							   WebDriverWait wait = new WebDriverWait(driver, 3);
//								  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
								   System.out.println("clicked ok when document is downloaded " );
									OK.click();
							    Thread.sleep(2000);
							
						}
					
						}catch (StaleElementReferenceException e) {
							 System.out.println("Element has faced some problems" +  e);
						     
						}
					   
						}
				}catch (Exception e){
				    System.out.println("employee id is not found");	
				        
				}
					 
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		         Thread.sleep(2000);
					System.out.println("Document downloaded for the employee " + CandidateId );
					//driver.close();
			
					
					//Downloading details for the rest of the id's(Home button)
					driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/div[2]/table/tbody/tr/td[1]/div/a")).click();

					Thread.sleep(4000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					// ------------------Notifications-------------------//

					driver.findElement(
							By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"))
							.click();
					// driver.findElement(By.linkText("263")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					
				
						
						// --------getting file name---------//
						String filePath = desired_filepath;
						// String filePath="/home/admin/Documents/2032454/";

						File fileName = findUsingIOApi(filePath);

						System.out.println(fileName);
						if (fileName != null) {
							ScrappMatexCaseRegisterBackup scrapocr = new ScrappMatexCaseRegisterBackup();
							CaseRegistrationId = scrapocr.sendBgvFile(fileName.getName());
						}
						
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
							scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
						}
						
					
						
						
						
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
							scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
						}

						
						
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocraadhar = new ScrappMatexCaseRegisterBackup();
							scrapocraadhar.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"ID");
						}

						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocraddress = new ScrappMatexCaseRegisterBackup();
							scrapocraddress.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Address");
						}

						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocrpan = new ScrappMatexCaseRegisterBackup();
							scrapocrpan.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"ID");
						}
				}	


					public static void close() throws InterruptedException {
					Thread.sleep(1000);
					driver.close();
				}
				
				public static File findUsingIOApi(String sdir) {
					File dir = new File(sdir);
					if (dir.isDirectory()) {
						Optional<File> opFile = Arrays.stream(dir.listFiles(File::isFile))
								.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

						if (opFile.isPresent()) {
							return opFile.get();
						}
					}

						return null;
				}


		}
