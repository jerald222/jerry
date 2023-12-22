package matexScraping.MatexScraping;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

public class Tcs_Canididate {
	
static	Logger log =Logger.getLogger(Tcs_Canididate.class);
		static WebDriver driver;

     	//private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
		//private  String desired_filepath = "/home/admin/Documents/";
		
		
		
		public static void main(String[] args ) throws InterruptedException, IOException {
	
		//	String[] args = {"userID","password","CandidateId" };	
			
			      
			
			captcha1(args);
		
			sample(args);
		
		}
	
		public static void captcha1(String[] args) throws InterruptedException, IOException {
//			String desired_filepath = "C:\\Users\\Public\\Documents\\Matex";
		
			String desired_filepath = "/home/admin/Documents/";
			
			
			String userID ="ishwarya.s@matrixbsindia.com";// 2531691
				if (args[0] != "") {
				userID = args[0];
			}

			String password ="Oct@2023";// 2531691
			if (args[1] != "") {
				password = args[1]; 
			}
			
			
		
			String CaseRegistrationId = "";
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("profile.default_content_settings.popups", 0);
		hm.put("download.default_directory", desired_filepath);
			
		
		
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", hm);
			options.setCapability("disable-dev-shm-usage", true);
			options.addArguments("--remote-allow-origins=*"); 
			
//			
			System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
//			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\chromedriver.exe");

			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
				driver = new ChromeDriver(options);
			
			// get url for tcs
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
               
			
			//====bypassing the captcha=========//
			
//			//captcha username			
//			String dbcusrname ="jerald.berchmans@likemindtech.com";
//			//captcha password
//			String dbcpsswd ="1222K3806@jb";
//			
//			System.out.println(args.length);
//		        Client client;
//		        // using http API
//		
//		        if(args.length == 3){
//		            client = (Client)(new HttpClient(dbcusrname, dbcpsswd));
//		        }else if(args.length == 2){
//		            client = (Client)(new HttpClient(args[0]));
//		        }else{
//		            System.out.println("Wrong number of arguments");
//		            System.out.println("You must use username/password combination");
//		            System.out.println("Or API key");
//		            return;
//		        }
//			
//		        client.isVerbose = true;
//
//		     
//			try {
//		            try {
//		                System.out.println("Your balance is " + client.getBalance() + " US cents");
//		            } catch (IOException e) {
//		                System.out.println("Failed fetching balance: "+ e.toString() );
//		                return;
//		            }
//
//		            WebElement element12 = driver.findElement(By.cssSelector("#captchaImg"));
//		            //driver.findElement(By.cssSelector("#captchaImg"));
//				    Thread.sleep(2000);
//
//				    // Take a screenshot
//				    File srcFile = element12.getScreenshotAs(OutputType.FILE);
//				    FileUtils.copyFile(srcFile, new File("/home/admin/Documents/captcha.png"));
//
//				//====================================================//
//		          /*  //getting captcha 
//		            // Download the image
//		   		 //By imageLocator = By.cssSelector("#captchaImg");
//		   	      String imageSrc = driver.findElement(By.cssSelector("#captchaImg")).getAttribute("src");
//		   	    //String imageSrc = driver.findElement(By.cssSelector("#captchaImg")).getAttribute("scr");
//		   	      
//		   	      URL imageUrl = new URL(imageSrc);
//		   	     
//		   	      FileUtils.copyURLToFile(imageUrl, new File("/home/admin/Documents/cha.jpg"));
//		   		
//		   	     Thread.sleep(2000);
//		   	*/
//		   	
//		   	//=================================================//
//		            
//		        	String imageFilePath = "/home/admin/Documents/captcha.png";
//		        	  Captcha captcha = null;
//		            try {
//		                // Upload a CAPTCHA and poll for its status with 120 seconds timeout.
//		                // Put you CAPTCHA image file name, file object, input stream, or
//		                // vector of bytes, and optional solving timeout (in seconds) here.
//		                System.out.println(args);
//		            	if (args.length == 3){
//		                    //captcha = client.decode(args[2], 120);
//		                    captcha = client.decode(imageFilePath,120);
//		                }else if (args.length == 2){
//		                    captcha = client.decode(args[1], 120);
//		                }else{
//		                    System.out.println("Failed uploading CAPTCHA - args");
//		                    return;    
//		                }
//		                
//		            } catch (IOException e) {
//		                System.out.println("Failed uploading CAPTCHA");
//		                return;
//		            }
//		            if (null != captcha) {
//		                System.out.println("CAPTCHA " + captcha.id + " solved: " + captcha.text);
//		                System.out.println(captcha.text);
//
//		            	 captchatext = (captcha.text);
//	       
//		        	// NAVIGATING TO CAPTCHA TEXT BOX
//		            	 driver.findElement(By.id("loginForm:captcha")).clear();
//		            	 Thread.sleep(2000);	
//	    			
//		            	 driver.findElement(By.id("loginForm:captcha")).sendKeys(captchatext);
//			    			
//	    				Thread.sleep(10000);
//			
//			// driver.findElement(By.id("loginForm:addNewRight2")).click();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//			// driver.findElement(By.className("buttonMiddleSection
//			// disableOnClick")).click();
//			//login button*****************************
//			WebElement element3 = driver.findElement(By.name("loginForm:addNewRight2"));
//			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
//			executor1.executeScript("arguments[0].click();", element3);
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//			// ------------------Notifications-------------------//
//			WebElement sap =   driver.findElement(
//					By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"));
//				sap.click();
//			// driver.findElement(By.linkText("263")).click();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//			// -----------------Advanced filters-----------//
//			driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/h3[1]/a")).click();
//			//	/html/body/div[1]/div[2]/form/div[2]/h3[1]/a
//			//	/html/body/div[1]/div[2]/form/div[2]/h3[1]/span
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//			Thread.sleep(4000);
//		            } 
//		            else {
//		               System.out.println("Failed solving CAPTCHA");
//		            }
//		        } catch (com.DeathByCaptcha.Exception e) {
//		            System.out.println(e);
//
//					Thread.sleep(3000);
//		        }
//
//
//			
//	       	 driver.findElement(By.id("loginForm:captcha")).sendKeys("/");
//	      // NAVIGATING TO CAPTCHA TEXT BOX
	       	 driver.findElement(By.id("loginForm:captcha")).clear();
	       	 Thread.sleep(2000);	
				
				Thread.sleep(15000);

				
	// driver.findElement(By.id("loginForm:addNewRight2")).click();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	//login button click*****************************
	WebElement element3 = driver.findElement(By.name("loginForm:addNewRight2"));
	JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	executor1.executeScript("arguments[0].click();", element3);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

	// ------------------Notifications no of request-------------------//
	WebElement sap = driver.findElement(By.xpath("//*[@id=\"agencyHomeForm:fyaFyiTable_data\"]/tr[1]/td[2]/a"));
	sap.click();
//		/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a
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
			
			System.out.println("Candidate Id===========" + args[0]);

		String CandidateId ="";// 2531691
		if (args[2] != "") {
			CandidateId = args[2];
		}
		String desired_filepath = "/home/admin/Documents/"+CandidateId;
		
		String ApplicantId ="";// 2531691
		if (args[0] != "") {
			ApplicantId = args[0];
		}

		
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("profile.default_content_settings.popups", 0);
	hm.put("download.default_directory", desired_filepath);
		
	
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", hm);

		
		String CaseRegistrationId = "";

					
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
				Thread.sleep(2000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				System.out.println("//****************************submitting dropdown ");
					
				// ------------------submit button---------//
				WebElement element2 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
				JavascriptExecutor executor2 = (JavascriptExecutor) driver;
				executor2.executeScript("arguments[0].click();", element2);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				System.out.println("//****************************scrolling");
					
				
				System.out.println("//****************************applying id");
			log.info("Applicant id for scrapping is  = "+CandidateId );
				
				// -----------applicant id-----//
			WebElement Candidate =driver.findElement(By.id("agencySearchViewForm:j_idt58"));
				
			try {
				log.info("candidate's id  appliying to the field  " );
				
				if (!CandidateId.isEmpty()) {
					Candidate.sendKeys(CandidateId);
					WebElement Applicant =driver.findElement(By.id("agencySearchViewForm:j_idt49"));
					//*[@id="agencySearchViewForm:j_idt58"]
					Applicant.sendKeys(ApplicantId); 
					log.info("candidate's id  appliying to the field  " );
					// WebElement Applicant =driver.findElement(By.id("agencySearchViewForm:j_idt49"));
					 Thread.sleep(2000);
					
					
				} else if(CandidateId.isEmpty()) {
				   System.out.println("candidate's id not found so browser closed");
					log.info("candidate's id not found so browser closed" );
					driver.quit();
				}
			}catch(Exception e1) {
				
				log.info(" catch Exception candidate's id not found so browser closed" );
				driver.quit();

			}
			
			System.out.println("Clicking on submit");
			  
			 // -----submit button----//
				WebElement element4 = driver.findElement(By.name("agencySearchViewForm:addNewMiddleSubmit"));
				JavascriptExecutor executor3 = (JavascriptExecutor) driver;
				executor3.executeScript("arguments[0].click();", element4);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		 		Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
			System.out.println("//*****submiting id");
			
				// ===========scroll========//
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(2000);
			
				try {
				WebElement id1 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:applicantEmployeeID"));
//				WebElement Applican = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:employeeID"));
				String CandidateId1 = id1.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
				
//				String EmployeeID = Applican.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
				//log.info(CandidateId1+"********");
					//log.info(CandidateId+"********");//
					//log.info(EmployeeID+"********");//
					log.info(CandidateId1.trim().equalsIgnoreCase(CandidateId.trim())  + "****************==+++++=====" + CandidateId1 + "====" +  CandidateId);
				
					if(CandidateId1.trim().equals(CandidateId.trim())) {
					

					WebElement id = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:candidateName"));
					String Candidatename = id.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID

				// *[@id="agencySearchViewForm:checksDatatable:0:accountType"]
				WebElement id2 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:accountType"));
				String Accountname = id2.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID

				WebElement id3 = driver
						.findElement(By.id("agencySearchViewForm:checksDatatable:0:candidateRegion"));
				String candidateregion = id3.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID

				WebElement id4 = driver
						.findElement(By.id("agencySearchViewForm:checksDatatable:0:bgcType"));
				String BGCType = id4.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID

				
				System.out.println("Candidate name =" + Candidatename + "Candidate id =" + CandidateId + " Account Name ="
						+ Accountname + " candidateRegion =" + candidateregion+   "BGC_type =" +BGCType );

				log.info("Candidate name =" + Candidatename + "Candidate id =" + CandidateId + " Account Name ="
						+ Accountname + " candidateRegion =" + candidateregion+   "BGC_type =" +BGCType+   "Candidateid =" +CandidateId1);

				Thread.sleep(1000);
				log.info("Applicant id for scrapping is  =" + CandidateId);

				
				
				
				System.out.println("//****************************Downloading required files");
				
				// ------bgc form download------//
				driver.findElement(By.linkText("BGC Form")).click();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				
				// driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:checksDatatable:0:j_idt144\"]")).click();

				Thread.sleep(2000);

				// -------bgc-----popupdownload-----//
				driver.findElement(By.linkText("View BGC Form")).click();
				// driver.findElement(By.xpath("//*[@id=\"bgcFormDownload:j_idt150_content\"]/a")).click();
				Thread.sleep(2000);
				// driver.close();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
				log.info("***********Bgc Form downloaded for"+CandidateId);
				
				// --------bgc close-----//
				driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
				// *[@id="bgcAgencyFormDialog"]/div[1]/a/span
				// driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
				Thread.sleep(3000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				// --------getting file name---------//
				//String filePath = Candidatepath;
				 String filePath="/home/admin/Documents/11111/"+CandidateId;

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
				;
				Thread.sleep(10000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				log.info("********************Resume  downloaded for "+CandidateId);
				
				fileName = null;

				fileName = findUsingIOApi(filePath);
				if (fileName != null && CaseRegistrationId != "") {
					ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
					scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
				}
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
			  log.info(tabelrow.size());
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
		            		// ===========scroll========//

		            			log.info("scroll 22222");
		            		   WebElement downloadLinks = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
		            		   JavascriptExecutor js3 = (JavascriptExecutor) driver;
		            			js3.executeScript("arguments[0].scrollIntoView(true)",downloadLinks);
		            			
			            	    downloadLinks.click();
		            	  
		            	   }catch(Exception e) {
		            		   WebElement OK = null;
		            	        try {
		            	        	// ===========scroll========//
//				    				JavascriptExecutor js11 = (JavascriptExecutor) driver;
//				    				js11.executeScript("window.scrollBy(0,20)");
				    				log.info("scroll 33333");
		            	        	
		            	        	OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
		            	        } catch (NoSuchElementException ignored) {
		            	            // If OK button is not found, you can handle the exception here or perform necessary actions
		            	        }
//		            	        if (OK != null) {
//		            	            WebDriverWait wait1 = new WebDriverWait(driver, 1);
//		            	            OK = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
//		            	            OK.click();
//		            	        }
		            	        System.out.println("Clicked OK for exception");
		            		
		            	   }
		            	
		            }
		       													
		            	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Set a shorter implicit wait

		            	
		            	WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
					   WebDriverWait wait = new WebDriverWait(driver, 3);
//						  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
						   System.out.println("clicked ok when document is downloaded " );
						   
						   OK.click();
					    Thread.sleep(6000);
					
				}
			
				}catch (StaleElementReferenceException e) {
					 System.out.println("Element has faced some problems" +  e);
				     
				}
					
		            
		            
		            Thread.sleep(1000);
				System.out.println("downloaded successfully");
				Thread.sleep(1000);
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
					}	
				
//				}else if(EmployeeID.trim().equals(ApplicantId.trim())) {
//
//					WebElement id = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:candidateName"));
//					String Candidatename = id.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
//
//				// *[@id="agencySearchViewForm:checksDatatable:0:accountType"]
//				WebElement id2 = driver.findElement(By.id("agencySearchViewForm:checksDatatable:0:accountType"));
//				String Accountname = id2.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
//
//				WebElement id3 = driver
//						.findElement(By.id("agencySearchViewForm:checksDatatable:0:candidateRegion"));
//				String candidateregion = id3.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
//
//				WebElement id4 = driver
//						.findElement(By.id("agencySearchViewForm:checksDatatable:0:bgcType"));
//				String BGCType = id4.getText(); // agencySearchViewForm:checksDatatable:0:applicantEmployeeID
//
//				
//				System.out.println("Candidate name =" + Candidatename + "Candidate id =" + CandidateId + " Account Name ="
//						+ Accountname + " candidateRegion =" + candidateregion+   "BGC_type =" +BGCType );
//
//				log.info("Candidate name =" + Candidatename + "Candidate id =" + CandidateId + " Account Name ="
//						+ Accountname + " candidateRegion =" + candidateregion+   "BGC_type =" +BGCType+   "Candidateid =" +CandidateId1);
//
//				Thread.sleep(1000);
//				log.info("Applicant id for scrapping is  =" + CandidateId);
//
//				
//				
//				
//				System.out.println("//****************************Downloading required files");
//				
//				// ------bgc form download------//
//				driver.findElement(By.linkText("BGC Form")).click();
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//				
//				// driver.findElement(By.xpath("//*[@id=\"agencySearchViewForm:checksDatatable:0:j_idt144\"]")).click();
//
//				Thread.sleep(2000);
//
//				// -------bgc-----popupdownload-----//
//				driver.findElement(By.linkText("View BGC Form")).click();
//				// driver.findElement(By.xpath("//*[@id=\"bgcFormDownload:j_idt150_content\"]/a")).click();
//				Thread.sleep(2000);
//				// driver.close();
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//				log.info("***********Bgc Form downloaded for"+CandidateId);
//				
//				// --------bgc close-----//
//				driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
//				// *[@id="bgcAgencyFormDialog"]/div[1]/a/span
//				// driver.findElement(By.xpath("//*[@id=\"bgcAgencyFormDialog\"]/div[1]/a/span")).click();
//				Thread.sleep(3000);
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//				// --------getting file name---------//
//				//String filePath = Candidatepath;
//				 String filePath="/home/admin/Documents/11111/"+CandidateId;
//
//				File fileName = findUsingIOApi(filePath);
//
//				System.out.println(fileName);
//				if (fileName != null) {
//					ScrappMatexCaseRegisterBackup scrapocr = new ScrappMatexCaseRegisterBackup();
//					CaseRegistrationId = scrapocr.sendBgvFile(fileName.getName());
//				}
//				
//				if (fileName != null && CaseRegistrationId != "") {
//					ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
//					scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
//				}
//				
//				
//				// -------bgc-----popup resume download-----//
//				// driver.findElement(By.cssSelector("#agencySearchViewForm\\:checksDatatable_data
//				// > tr:nth-child(3) > td:nth-child(10) > a:nth-child(2)")).click();
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//				driver.findElement(By.linkText("Resume")).click();
//				Thread.sleep(10000);
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//
//				log.info("********************Resume  downloaded for "+CandidateId);
//				
//				fileName = null;
//
//				fileName = findUsingIOApi(filePath);
//				if (fileName != null && CaseRegistrationId != "") {
//					ScrappMatexCaseRegisterBackup scrapocrUploadDoc = new ScrappMatexCaseRegisterBackup();
//					scrapocrUploadDoc.sendCaseUploadDocument(CaseRegistrationId, fileName.getName(),"Personal");
//				}
//				//BGC initiated Document download//
//				
//				driver.findElement(By.linkText("BGC Initiated and Documents Sent to Vendor")).click();
//		
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//			//driver.findElement(By.xpath("//*[@id=\"agencyWorkflowForm\"]/table[1]/tbody/tr/td[1]/input")).click();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//			Thread.sleep(2000);
//		
//				
//				//listing the No:Rows in the first table
//				List<WebElement> tabelrow = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
//		        // Get the number of rows in the outer table						
//		        System.out.println( tabelrow.size()-1);
//			  log.info(tabelrow.size());
//		        Thread.sleep(1000);
//			   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			
//			  	try {
//					
//			   		//Looping for the downloading of the documents for the required table
//				for (int j = 0; j < tabelrow.size() - 1; j++) {
//				    
//					//XpathElement for looping to download the entire documents in the required table   
//					  driver.findElement(By.xpath("//*[@id=\"agencyCandDocListForm:tabPanel:uploadedDocsDataTable:" + j + ":fileUploadedCount\"]")).click();
//				    System.out.println("xpath has been clicked");
//				    Thread.sleep(1000);
//				   
//    				//downlaoding of all documents in the inner table
//	                // Loop through each cell in the current row
//				    WebElement innerTable1  = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148\"]/div/table"));         
//			         // Find all the rows in the inner table 
//		             List<WebElement> innerRows = innerTable1.findElements(By.cssSelector("div.ui-datatable-tablewrapper>table>tbody>tr"));
//		            System.out.println("Inner row  size "  + innerRows.size() );													
//		           
//		            	for (int l = 0; l < innerRows.size(); l++) {
//		    				
//		            		try {
//		            		// ===========scroll========//
//
//		            			log.info("scroll 22222");
//		            		   WebElement downloadLinks = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
//		            		   JavascriptExecutor js3 = (JavascriptExecutor) driver;
//		            			js3.executeScript("arguments[0].scrollIntoView(true)",downloadLinks);
//			            	   
//			            	    downloadLinks.click();
//		            	  
//		            	   }catch(Exception e) {
//		            		   WebElement OK = null;
//		            	        try {
//		            	        	// ===========scroll========//
////				    				JavascriptExecutor js11 = (JavascriptExecutor) driver;
////				    				js11.executeScript("window.scrollBy(0,20)");
//				    				log.info("scroll 33333");
//		            	        	
//		            	        	OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
//		            	        } catch (NoSuchElementException ignored) {
//		            	            // If OK button is not found, you can handle the exception here or perform necessary actions
//		            	        }
////		            	        if (OK != null) {
////		            	            WebDriverWait wait1 = new WebDriverWait(driver, 1);
////		            	            OK = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
////		            	            OK.click();
////		            	        }
//		            	        System.out.println("Clicked OK for exception");
//		            		
//		            	   }
//		            	
//		            }
//		       													
//		            	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Set a shorter implicit wait
//
//		            	
//		            	WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
//					   WebDriverWait wait = new WebDriverWait(driver, 3);
////						  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
//						   System.out.println("clicked ok when document is downloaded " );
//							OK.click();
//					    Thread.sleep(2000);
//					
//				}
//			
//				}catch (StaleElementReferenceException e) {
//					 System.out.println("Element has faced some problems" +  e);
//				     
//				}
//					
//		            
//		            
//		            Thread.sleep(1000);
//				System.out.println("downloaded successfully");
//				Thread.sleep(1000);
//				//Downloading details for the rest of the id's(Home button)
//				driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div/div[2]/table/tbody/tr/td[1]/div/a")).click();
//
//				Thread.sleep(1000);
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//				// ------------------Notifications-------------------//
//
//				driver.findElement(
//						By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"))
//						.click();
//				// driver.findElement(By.linkText("263")).click();
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
//				
//				
//				}
				else if(!CandidateId1.equals(CandidateId)) {
					// Click to another candidate to scrap
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
			   
						 log.info("id  found so scrapped for the candiate");	
				   }
				
			       
				}catch (Exception e2) {
					System.out.println("id not found fo ID "+CandidateId +"so skipped to another id");
					log.info("id not found fo ID "+CandidateId +"so skipped to another id");	
					// Click to another candidate to scrap


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
			
				}
            
         
		
            }
			
		
		
		  public static void moveFile(String sourceFilePath, String targetFolderPath) {
		        Path sourcePath = Paths.get(sourceFilePath);
		        Path targetPath = Paths.get(targetFolderPath).resolve(sourcePath.getFileName());

		        try {
		            Files.move(sourcePath, targetPath);
		            System.out.println("File moved successfully.");
		        } catch (IOException e) {
		            e.printStackTrace();
		            System.out.println("Error moving file.");
		        }
		    }
		
		
		/*	 String logFilePath = "log4j.log";
			        String excelFilePath = "log4j.xlsx";

			        try {
			            // Create a new Excel workbook
			            Workbook workbook = new XSSFWorkbook();
			            Sheet sheet = workbook.createSheet("Log Entries");

			            // Read the Log4j log file
			            BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
			            String line;
			            int rowIdx = 0;

			            // Write headers to Excel
			            Row headerRow = sheet.createRow(rowIdx++);
			            headerRow.createCell(0).setCellValue("Timestamp");
			            headerRow.createCell(1).setCellValue("Log Level");
			            headerRow.createCell(2).setCellValue("Logger Name");
			            headerRow.createCell(3).setCellValue("Log Message");

			            // Parse log entries and write to Excel
			            while ((line = reader.readLine()) != null) {
			                // Assuming the log entry format is: [timestamp] [log level] [logger name] - [log message]
			                String[] entryParts = line.split(" - ", 2);
			                if (entryParts.length == 2) {
			                    String[] logParts = entryParts[0].split(" ", 3);
			                    if (logParts.length == 3) {
			                        String timestamp = logParts[0].replace("[", "").replace("]", "");
			                        String logLevel = logParts[1].replace("[", "").replace("]", "");
			                        String loggerName = logParts[2].replace("[", "").replace("]", "");
			                        String logMessage = entryParts[1];

			                        Row row = sheet.createRow(rowIdx++);
			                        row.createCell(0).setCellValue(timestamp);
			                        row.createCell(1).setCellValue(logLevel);
			                        row.createCell(2).setCellValue(loggerName);
			                        row.createCell(3).setCellValue(logMessage);
			                    }
			                }
			            }

			            reader.close();

			            // Auto-size columns for better visibility
			            for (int i = 0; i < 4; i++) {
			                sheet.autoSizeColumn(i);
			            }

			            // Save the Excel file
			            FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
			            workbook.write(fileOutputStream);
			            workbook.close();
			            fileOutputStream.close();

			            System.out.println("Log4j logs converted to Excel successfully.");

			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
				*/
			
		
		public static void close() throws InterruptedException {
			Thread.sleep(1000);
			//driver.close();
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


