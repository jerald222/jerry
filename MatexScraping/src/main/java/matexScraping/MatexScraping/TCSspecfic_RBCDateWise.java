package matexScraping.MatexScraping;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCSspecfic_RBCDateWise {
		 
		static	Logger log =Logger.getLogger(TCSspecfic_RBCDateWise.class);
			
				
				static WebDriver driver;
				
				

			private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
//				private static String desired_filepath = "/home/admin/Documents/2032454";

				
				public static void main(String[]args) throws InterruptedException, IOException, AWTException {
					captchaRBCDateWise(args);
					
					RelationRBCDateWise(args);
				
					
				}
			
				public static void captchaRBCDateWise (String[] args) throws InterruptedException, IOException, AWTException {
				
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
					hm.put("download.prompt_for_download", false);
					hm.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
					  
					hm.put("download.default_directory", desired_filepath);
					// hm.put("download.default_directory",desired_filepath);

					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", hm);
					options.setCapability("disable-dev-shm-usage", true);
					options.addArguments("--safebrowsing-disable-download-protection"); // disable safe browsing download protection
					options.addArguments("--remote-allow-origins=*");
//					System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
					 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
					log.info("************************chromedriver*************************");
					driver = new ChromeDriver(options);
					log.info("************************chromedriver*************************");
					
					// WebDriverManager.chromedriver().setup();
					driver.get("https://gbis.tcsapps.com/agency/");
					log.info("***************************URL*************************");
					
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
						System.out.println("");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Thread.sleep(12000);
					// driver.findElement(By.id("loginForm:addNewRight2")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// driver.findElement(By.className("buttonMiddleSection
					// disableOnClick")).click();

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
					System.out.println(password);
					/////////////////////////////////////////////$$%%%%%%%%%$$$$########################################
					/////////////////////////////////////////////$$$$$$$$$$$$$$$########################################
					// NAVIGATING TO CAPTCH TEXT BOX
					/*Thread.sleep(2000);
					
						driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
					
						// TODO Auto-generated catch block

		            	String captchatext = "";
		               
					
					//====bypassing the captcha=========//
					
					String dbcusrname ="jerald.berchmans@likemindtech.com";
					//String dbcusrname ="praveenkumar@likemindtech.com";
					
					
					String dbcpsswd ="1222K3806@jb";
					 
					
					
					System.out.println(args.length);
				        Client client;
				        // using http API
				
				        if(args.length == 4){
				            client = (Client)(new HttpClient(dbcusrname, dbcpsswd));
				        }else if(args.length == 3){
				            client = (Client)(new HttpClient(args[0]));
				        }else{
				            System.out.println("Wrong number of arguments");
				            System.out.println("You must use username/password combination");
				            System.out.println("Or API key");
				            return;
				        }
					
				        client.isVerbose = true;

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
				   		
				   	     */
				   	//=================================================//
				            
				              		
				        /*	
				        	String imageFilePath = "/home/admin/Documents/captcha.png";
				        	  Captcha captcha = null;
				            try {
				                // Upload a CAPTCHA and poll for its status with 120 seconds timeout.
				                // Put you CAPTCHA image file name, file object, input stream, or
				                // vector of bytes, and optional solving timeout (in seconds) here.
				                System.out.println(args);
				            	if (args.length == 4){
				                    //captcha = client.decode(args[2], 120);
				                    captcha = client.decode(imageFilePath,120);
				                }else if (args.length == 3){
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
				                
				             
				          */   
				          
				        
				        	// NAVIGATING TO CAPTCHA TEXT BOX
					try {
						driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
						Thread.sleep(12000);	
		    			
					} catch (Exception e) {
						System.out.println("");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				         
					//login button click*****************************
					WebElement element3 = driver.findElement(By.name("loginForm:addNewRight2"));
					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", element3);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// ------------------Notifications no of request-------------------//
					WebElement sap = driver.findElement(By.xpath("//*[@id=\"agencyHomeForm:fyaFyiTable_data\"]/tr[1]/td[2]/a"));sap.click();
//						/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a
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
					
				//********************************************************************//
				   //###################################################################*//
					//SECOND STEP FOR DOWNLOADING THE FILES OF THE  RRELATION SPECFIC CANDIDATES
					
					public static  void RelationRBCDateWise (String[] args) throws InterruptedException, IOException {
						String desired_filepath = "/home/admin/Documents/2032454";
				
						System.out.println("Candidate Id===========" + args[0]);
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
						
					
					// ------------------BGC TYPE----------------------//
					// agencySearchViewForm:checksDatatable:0:j_idt144
					driver.findElement(By.id("agencySearchViewForm:advanceSearchPanel:j_idt105_label")).click();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
						Thread.sleep(2000);
				
					
					// ========Relation specfic=======//
					driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt105_panel\"]/div/ul/li[7]")).click();					
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// ------------------submit button---------//
					WebElement element2 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
					JavascriptExecutor executor2 = (JavascriptExecutor) driver;
					executor2.executeScript("arguments[0].click();", element2);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

					// ===========scroll========//
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,1000)");
					Thread.sleep(1000);

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
						
						Thread.sleep(1000);				
					    // WebElement id = driver.findElement(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr>td"));
					 
						WebElement id = driver.findElement(By.id("agencySearchViewForm:checksDatatable:"+i+":candidateName"));
						 String Candidatename = id.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
					
						
						 WebElement id1 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:"+i+":employeeID"));
						 String CandidateId = id1.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
						
						 //*[@id="agencySearchViewForm:checksDatatable:0:accountType"]
						 WebElement id2 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:"+ i +":accountType"));
						 String Accountname = id2.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
						
						 WebElement id3 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:"+i+":candidateRegion"));
						 String candidateregion = id3.getText(); //agencySearchViewForm:checksDatatable:0:applicantEmployeeID
						
						 System.out.println("Candidate name =" +Candidatename +"Candidate id =" +CandidateId +" Account Name =" +Accountname+" candidateRegion =" +candidateregion);
						 
						 log.info("Candidate name =" +Candidatename +"Candidate id =" +CandidateId +" Account Name =" +Accountname+" candidateRegion =" +candidateregion);
							
						 Thread.sleep(1000);
						log.info("Applicant id for scrapping is  ="+CandidateId);
					
						
						// -----------Employee id-----//
					WebElement Candidate =driver.findElement(By.id("agencySearchViewForm:j_idt49"));
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
					Thread.sleep(1000);
					
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
					    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					    Thread.sleep(1000);
					 
					    //downlaoding of all documents in the inner table
		                // Loop through each cell in the current row
					    WebElement innerTable1  = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148\"]/div/table"));         
				         // Find all the rows in the inner table
			             List<WebElement> innerRows = innerTable1.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
			            //int rowCount = innerRows.size();
			            System.out.println("Inner row  size "  + innerRows.size() );													
				   try {
			            //looping for the inner table 
					     for (int l = 0; l < innerRows.size(); l++) {
		          
					    	    WebElement Doc = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
								JavascriptExecutor Downloadclick = (JavascriptExecutor) driver;
								Downloadclick.executeScript("arguments[0].click();", Doc);
								Thread.sleep(1000);
								System.out.println("clickedugyigy");
								
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
								Thread.sleep(1000);
					 /*  WebElement downloadLink = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
		                 
		                 WebDriverWait wait = new WebDriverWait(driver, 10);
		                 downloadLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]")));
		                 downloadLink.click();												   // documentDialogForm:j_idt148:"+ 1 +":fileNameLink
		                 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
		               	*/
		               	System.out.println("Document downloading for Row =  "+ j +" in "+l+ " Document is downloaded");
					     System.out.println("wating to download the document ");
					//     Thread.sleep(2000);
					    }
					  
					     }catch (StaleElementReferenceException e){
					    	 System.out.println("Element has faced some problems" +  e);
						     
					     }
				   														
					    WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
					    WebDriverWait wait = new WebDriverWait(driver, 10);
//						   OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
//						  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
						   OK.click();		  	    
					    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			            Thread.sleep(2000);
					}
					}catch (StaleElementReferenceException e) {
						 System.out.println("Element has faced some problems" +  e);
					     
					}
					
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
								
								 
								 
								 //specfic relation element click
									 driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:advanceSearchPanel:j_idt105_panel\"]/div/ul/li[7]")).click();
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
					        
					}
					
					}
	}
	

