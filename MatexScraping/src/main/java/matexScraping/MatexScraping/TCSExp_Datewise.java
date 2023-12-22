package matexScraping.MatexScraping;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TCSExp_Datewise {

		
		static	Logger log =Logger.getLogger(TCSExp_Datewise.class);
				static WebDriver driver;

		     	//private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
				private static String desired_filepath = "/home/admin/Documents/2032454";

				public static void main(String[] args ) throws InterruptedException, IOException {
			
				//	String[] args = {"userID","password","CandidateId" };	
					
					captcha1(args);
				
					sample(args);
				
				}
			
				public static void captcha1(String[] args) throws InterruptedException, IOException {
					
					String userID ="ishwarya.s@matrixbsindia.com";// 2531691
						if (args[0] != "") {
						userID = args[0];
					}

					String password ="Aug@2023 ";// 2531691
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
					driver = new ChromeDriver(options);
					
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
			   			
						Thread.sleep(20000);

						
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
				public static  void sample(String[] args) throws InterruptedException, IOException {
					String desired_filepath = "/home/admin/Documents/2032454";
			
					 SimpleDateFormat dateFormat;
					 dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					 String Datewise ="";// 2531691
					if (args[0] != "") {
						Datewise = args[0];
					}
				
					String Datewise1 ="";// 2531691
					if (args[1] != "") {
						Datewise1 = args[1];
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
				//System.out.println("//****************************Mtd started to download files ");
				
		// ------------------BGC TYPE----------------------//
						// agencySearchViewForm:checksDatatable:0:j_idt144
						driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt105_label")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(2000);
						System.out.println("//****************************experience type ");
							
						// ========experience=======//
						driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt105_panel\"]/div/ul/li[6]"))
								.click();
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
					
		// String for getting date form the scrapping application	
						
						//+++++++++++++++++++++Datewise_click++++++++++++++++++++//
						
						WebElement Dateapply =driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:fromDate_input"));
						Dateapply.sendKeys(Datewise);
						 Thread.sleep(2000);

						 if (Datewise.isEmpty()) {
						
							 driver.close();
						} else {
					
							 WebElement Dateapply1 =driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:toDate_input"));
								Dateapply1.sendKeys(Datewise1);
								 Thread.sleep(2000);
//		 				
								 if (Datewise1.isEmpty()) {
									 driver.close();
								 }else {
									 // -----submit button----//
										WebElement element4 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
										JavascriptExecutor executor3 = (JavascriptExecutor) driver;
										executor3.executeScript("arguments[0].click();", element4);
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500)); 
								 }
							   }
						
							
						 //+++++++++++++++++++++Datewise_click done++++++++++++++++++++//
						
						 	//##################### Finding table row and data and sending employee id #######################//
						  
						//listing the No:Rows in the first table
							List<WebElement> tabelrow = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
					        // Get the number of rows in the outer table						
					        System.out.println( tabelrow.size()-1);
						    Thread.sleep(1000);
						   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						  
						     try {
								
						    	//Looping for the downloading of the documents for the required table
									for (int j = 0; j < tabelrow.size() - 1; j++) {
						
						Thread.sleep(1000);				
					    // WebElement id = driver.findElement(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr>td"));
					 	WebElement id = driver.findElement(By.id("agencySearchViewForm:checksDatatable:"+j+":applicantEmployeeID"));
						 String Employee_id = id.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
						 System.out.println("Candidate id ="  +Employee_id);
						 Thread.sleep(1000);
						log.info("Applicant id for scrapping is  ="+ Employee_id);
									
						
					// -----------applicant id-----//
					WebElement Candidate =driver.findElement(By.id("agencySearchViewForm:j_idt58"));
					 Candidate.sendKeys(Employee_id);
					 Thread.sleep(1000);

					 if (Employee_id.isEmpty()) {
					
						 driver.close();
					} else {
					    System.out.println("Clicking on submit");
					  
					 // -----submit button----//
						WebElement element5 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
						JavascriptExecutor executor4 = (JavascriptExecutor) driver;
						executor4.executeScript("arguments[0].click();", element5);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					}
						
				
				 		Thread.sleep(1000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					
					System.out.println("//*****submiting id");
					
						// ===========scroll========//
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("window.scrollBy(0,1000)");
						Thread.sleep(1000);
						log.info("//****************************Downloading required files");
						
						System.out.println("//****************************Downloading required files");
						
						// ------bgc form download------//
						driver.findElement(By.linkText("BGC Form")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						
						// driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:checksDatatable:0:j_idt144\"]")).click();

						Thread.sleep(1000);

						// -------bgc-----popupdownload-----//
						driver.findElement(By.linkText("View BGC Form")).click();
						// driver.findElement(By.xpath("//*[@id=\"bgcFormDownload:j_idt150_content\"]/a")).click();
						Thread.sleep(1000);
						// driver.close();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						//log.info("***********Bgc Form downloaded for"+CandidateId);
						
						// --------bgc close-----//
						driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
						// *[@id="bgcAgencyFormDialog"]/div[1]/a/span
						// driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
						Thread.sleep(1000);
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
						
						
						// -------bgc-----popup resume download-----//
						// driver.findElement(By.cssSelector("#agencySearchViewForm\\:checksDatatable_data
						// > tr:nth-child(3) > td:nth-child(10) > a:nth-child(2)")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						driver.findElement(By.linkText("Resume")).click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					//	log.info("********************Resume  downloaded for "+CandidateId);
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
							scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
						}

						// -----------------bgc initiated documents-----------//
						driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:checksDatatable:0:actionRequired\"]")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						
						
						// ----------adhaar download link-------//
						driver.findElement(By.linkText("1 Document(s) Uploaded")).click();
						Thread.sleep(1000);
						// ========downloading aadhar========//
						driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:0:fileNameLink\"]")).click();
						Thread.sleep(1000); // *[@id="documentDialogForm:j_idt148:0:fileNameLink"]
						// *[@id="documentDialogForm:j_idt148:0:fileNameLink"]

					//	log.info("****************Aadhaar downloaded for "+CandidateId);
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocraadhar = new ScrappMatexCaseRegisterBackup();
							scrapocraadhar.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"ID");
						}

						// cancel button
						driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt157\"]/span")).click();
						Thread.sleep(1000);

						// ----------address download link-------//
						driver.findElement(
								By.xpath("//*[@id=\"agencyCandDocListForm:tabPanel:uploadedDocsDataTable:2:fileUploadedCount\"]"))
								
						.click();

						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						// ----download of address proof----//
						driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:0:fileNameLink\"]")).click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						//log.info("***********Address downloaded for "+CandidateId);
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocraddress = new ScrappMatexCaseRegisterBackup();
							scrapocraddress.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Address");
						}

						// -----ok button----//
						driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")).click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						// ===========scroll========//
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						js2.executeScript("window.scrollBy(0,1000)");
						Thread.sleep(1000);

						// =========pan details======//
						driver.findElement(
								By.xpath("//*[@id=\"agencyCandDocListForm:tabPanel:uploadedDocsDataTable:18:fileUploadedCount\"]"))
								.click();
						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

						// =====downloading pan====//
						driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:0:fileNameLink\"]")).click();

						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						//log.info("*****************pan downloaded for "+CandidateId);
						
						fileName = null;

						fileName = findUsingIOApi(filePath);
						if (fileName != null && CaseRegistrationId != "") {
							ScrappMatexCaseRegisterBackup scrapocrpan = new ScrappMatexCaseRegisterBackup();
							scrapocrpan.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"ID");
						
						
						}

						// ---cancel button----//
						driver.findElement(By.id("documentDialogForm:j_idt155")).click();
						Thread.sleep(1000);
						System.out.println("downloaded successfully");
						Thread.sleep(1000);
						//driver.close();
					       
						//Downloading details for the rest of the id's(Home button)
						driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/div[2]/table/tbody/tr/td[1]/div/a")).click();

						Thread.sleep(1000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						// ------------------Notifications-------------------//
						driver.findElement(
								By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"))
								.click();
						
						// driver.findElement(By.linkText("263")).click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(1000);
						 
						 WebElement Dateapply2 =driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:fromDate_input"));
						Dateapply2.sendKeys(Datewise);
						 Thread.sleep(1000);

						 if (Datewise.isEmpty()) {
						
							 driver.close();
						} else {
					
							 WebElement Dateapply1 =driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:toDate_input"));
								Dateapply1.sendKeys(Datewise1);
								 Thread.sleep(2000);

								 if (Datewise1.isEmpty()) {
									 driver.close();
								 }else {
									
									// ------------------BGC TYPE----------------------//
										// agencySearchViewForm:checksDatatable:0:j_idt144
										driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt105_label")).click();
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
										Thread.sleep(2000);
									
									 
									 
									 //relation specfic  element click
										 driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt105_panel\"]/div/ul/li[6]")).click();
									 Thread.sleep(2000);
									 // -----submit button----//
										WebElement element4 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
										JavascriptExecutor executor3 = (JavascriptExecutor) driver;
										executor3.executeScript("arguments[0].click();", element4);
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500)); 
								 }
							   }
				 
									}
							}catch (Exception e){
				    System.out.println("employee id is not found");	
				    log.info("employee id is not found");    
				    driver.close();
				    }    
				
						  	
							 	
				}	
				
				public static void close() throws InterruptedException {
					Thread.sleep(3000);
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

