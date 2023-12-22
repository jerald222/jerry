package matexScraping.MatexScraping;

import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.StandardCopyOption;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.apache.log4j.Logger;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Font;
	import org.apache.poi.ss.usermodel.HorizontalAlignment;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.ElementClickInterceptedException;
	import org.openqa.selenium.ElementNotInteractableException;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

	public class TCS_Experience_id_1 {
		static	Logger log =Logger.getLogger(TCS_Experience_id_1.class);
		static WebDriver driver;
	    static String Download_Path="/home/admin/Documents/TCS_Experienced_Professionals";
	    static Workbook workbookOutput = new XSSFWorkbook();
	    static Sheet sheetOutput = workbookOutput.createSheet("TCS_Experience_logsheet");
	    static String excelOutput = "/home/admin/Documents/TCS_Experience_Statusbook.xlsx";
	    @BeforeTest
		 public static void Open_Browser() throws IOException, InterruptedException, AWTException {
	        FileInputStream fis= new FileInputStream("Overall.properties");
	        Properties p = new Properties();
	        p.load(fis);
	        String Executables = p.getProperty("driver_Execeutables");
	        String Chrome_path = p.getProperty("Chrome_path");
	        String username= p.getProperty("TCS_username");
	        String password= p.getProperty("TCS_password");
	        System.setProperty(Executables, Chrome_path);
	        ChromeOptions options = new ChromeOptions();
	        HashMap<String, Object> chromePrefs = new HashMap<>();
	        options.setExperimentalOption("prefs", chromePrefs);
	        options.addArguments("--remote-allow-origins=*"); 
		    chromePrefs.put("download.default_directory", Download_Path);

	        // Initialize the Chrome WebDriver with the specified options
	        options.setCapability("acceptSslCerts", true); // Accept SSL certificates
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        driver.manage().deleteAllCookies();
	        String url = p.getProperty("TCS_URL");
	        driver.get(url);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement login_username = driver.findElement(By.xpath("//input[@id='loginForm:j_idt21']"));
	        login_username.sendKeys(username);
	        WebElement login_password = driver.findElement(By.xpath("//input[@id='loginForm:j_idt26']"));
	        login_password.sendKeys(password);
	        Thread.sleep(10000);
	        WebElement login_button = driver.findElement(By.xpath("//input[@id='loginForm:addNewMiddle2']"));
	        login_button.click();
	        WebElement BGC_docs = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a"));
	        BGC_docs.click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        WebElement Adv_filters = driver.findElement(By.xpath("//a[text()='Advanced Filters :']"));
	        Adv_filters.click();
	        WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
	        BGC_type.click();
	        WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
	        Exp_professional.click();
//	        WebElement Relation_specific = driver.findElement(By.xpath("//li[text()='Relationship Specific BGC']"));
//	        Relation_specific.click();
	     
	        
	        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	        Excel_Read();
	    }
	    @Test(priority = 1)
	    private static void Excel_Read() throws IOException, AWTException, InterruptedException {
	        System.out.println("##### Entering Excel_Read() method.!! #####");
	        try {
	            //Opening Excel sheet
	            FileInputStream fis= new FileInputStream("Overall.properties");
	            Properties p = new Properties();
	            p.load(fis);
	            System.out.println("Loaded");
	            String Inputexcel = p.getProperty("TCS_Experienced_Excel");
	            FileInputStream inputStream= new FileInputStream(Inputexcel);
	            XSSFWorkbook workbook =new  XSSFWorkbook(inputStream);
	            Sheet sheetInput = workbook.getSheetAt(0);
	            int columnIndex = 0;
	            System.out.println("Column index =0");
	             CellStyle headerStyle = workbookOutput.createCellStyle();
	                Font headerFont = workbookOutput.createFont();
	                headerFont.setBold(true);
	                headerStyle.setFont(headerFont);
	                headerStyle.setAlignment(HorizontalAlignment.CENTER);

	                //Write to new Excel Sheet
	                logAndWriteToExcel(sheetOutput, "Applicant-ID", 0, 0 , headerStyle);
	                logAndWriteToExcel(sheetOutput, "Employee-ID", 0, 1 , headerStyle);
	                logAndWriteToExcel(sheetOutput, "Ref-no", 0, 2 , headerStyle);
	                logAndWriteToExcel(sheetOutput, "Status", 0, 3 , headerStyle);
	                logAndWriteToExcel(sheetOutput, "Remarks", 0, 4 , headerStyle);

	            for (int i = 1; i <=sheetInput.getLastRowNum(); i++) {
	                System.out.println("Entering 1st for loop");
	                Row row = sheetInput.getRow(i);
	                CellStyle dataStyle = workbookOutput.createCellStyle();
	                dataStyle.setAlignment(HorizontalAlignment.CENTER);
	                if (row == null) {
	                    System.out.println("Row " + i + " is empty.");
	                    logAndWriteToExcel(sheetOutput, "Fail", i, 3 , dataStyle);
	                    logAndWriteToExcel(sheetOutput, "No ID found", i, 4 , dataStyle);
	                    continue;
	                }
	                Cell cell = row.getCell(columnIndex);
	                Cell cell2 = row.getCell(columnIndex+1);
	                System.out.println("completed Column index.");
	                List<Integer> columnValues = new ArrayList<Integer>();
	                List<Integer> columnValues1 = new ArrayList<Integer>();
	                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
	                    double data = cell.getNumericCellValue();
	                    String id = String.valueOf((int) data);
	                    logAndWriteToExcel(sheetOutput, id, i, 0 , dataStyle);
	                    columnValues.add((int) data);
	                } else {
	                    // Add a placeholder value (e.g., null) to indicate that the cell is empty
	                    columnValues.add(null);
	                }

	                if (cell2 != null && cell2.getCellType() ==  CellType.NUMERIC) {
	                    double data1 = cell2.getNumericCellValue();
	                    String id1 = String.valueOf((int) data1);
	                    logAndWriteToExcel(sheetOutput, id1, i, 1 , dataStyle);
	                    columnValues1.add((int) data1);
	                } else {
	                    // Add a placeholder value (e.g., null) to indicate that the cell is empty
	                    columnValues1.add(null);
	                }


	                for (int a = 0; a < columnValues.size() && a < columnValues1.size(); a++) {
	                    ID_input(columnValues.get(a) != null ? columnValues.get(a).toString() : null,
	                            columnValues1.get(a) != null ? columnValues1.get(a).toString() : null, i, sheetInput, dataStyle);
	                }

	            }

	            afterTest();
	        }catch(NullPointerException n) {
	        	n.getMessage();
	        }
	    }

	    private static void logAndWriteToExcel(Sheet sheet, String message, int i, int columnIndex, CellStyle style) {
	        // Create a new row or get the existing row
	        Row row = sheet.getRow(i);
	        if (row == null) {
	            row = sheet.createRow(i);
	        }

	        // Create a new cell in the specified column
	        Cell cell = row.createCell(columnIndex);

	        // Set the cell value to the log message
	        cell.setCellValue(message);
	        cell.setCellStyle(style);
	        sheet.autoSizeColumn(columnIndex);
	    }
    private static void ID_input(String id , String id1 ,int i, Sheet sheetInput , CellStyle dataStyle ) throws InterruptedException, AWTException, IOException {
	        System.out.println("##### Entering ID_input(String id) method.!! #####");

	        WebElement emp_ID1 = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt49']"));
	        WebElement app_ID1 = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt58']"));
	        emp_ID1.clear();
	        app_ID1.clear();
	        try {
	            if((id!=null) && (id1!=null)) {
	                System.out.println("Both id and id1 are present");
	                WebElement app_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt58']"));
	                app_ID.clear();
	                app_ID.sendKeys(id);
	                Thread.sleep(1000);
	                WebElement emp_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt49']"));
	                emp_ID.clear();
	                emp_ID.sendKeys(id1);
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	                Robot r= new Robot();
	                Thread.sleep(2000);
	                r.keyPress(KeyEvent.VK_PAGE_DOWN);
	                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	                Thread.sleep(3000);
	            }
	            else if(id1 == null) {
	                System.out.println("Employee ID is not present");
	                WebElement app_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt58']"));
	                app_ID.clear();
	                app_ID.sendKeys(id);
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	                Robot r= new Robot();
	                Thread.sleep(2000);
	                r.keyPress(KeyEvent.VK_PAGE_DOWN);
	                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	                Thread.sleep(3000);
	            }

	            else if(id == null){
	                System.out.println("Applicant ID is not present");
	                WebElement emp_ID = driver.findElement(By.xpath("//input[@id='agencySearchViewForm:j_idt49']"));
	                emp_ID.clear();
	                emp_ID.sendKeys(id1);
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	                Robot r= new Robot();
	                Thread.sleep(2000);
	                r.keyPress(KeyEvent.VK_PAGE_DOWN);
	                r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	                Thread.sleep(3000);
	            }
	            Downloads(id , id1, i, sheetInput, dataStyle);
	        }catch(Exception e) {
	            logAndWriteToExcel(sheetOutput, "No such ID", i, 4 , dataStyle);
	            logAndWriteToExcel(sheetOutput, "Fail", i, 3 , dataStyle);

	            System.out.println("NoSuchElementException occurred: " + e.getMessage());
	            System.out.println("Skipping to the next ID.");
	        }
	       
	    }
	    private static void Downloads(String id, String id1 ,int i, Sheet sheetInput , CellStyle dataStyle) throws InterruptedException, AWTException, IOException {
	        System.out.println("##### Entering ID_Downloads(String id) method.!! #####");
	        try {
	            WebElement employee_id = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:employeeID']"));
	            WebElement applicant_id = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:applicantEmployeeID']"));
	            System.out.println(applicant_id+"######");
	            if(applicant_id.isDisplayed() || employee_id.isDisplayed()) {
	                System.out.println("If Applicant ID and Employee ID is a match");
	                String BGC_Type = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:bgcType']")).getText();
	                System.out.println("BGC_Type is =====>>>>"+BGC_Type);
	                String Region = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:candidateRegion']")).getText();
	                System.out.println("Region is =====>>>>"+Region);

	                WebElement BGC_Form = driver.findElement(By.xpath("//a[text()='BGC Form']"));
	                BGC_Form.click();
	                Thread.sleep(2000);
	                driver.findElement(By.xpath("//a[text()='View BGC Form']")).click();
	                Thread.sleep(2000);
	                if(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).isDisplayed()) {
	                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
	                }
	                Thread.sleep(2000);
	                WebElement resume = driver.findElement(By.xpath("//a[text()='Resume']"));
	                resume.click();
	                Thread.sleep(2000);
	                WebElement Action_req = driver.findElement(By.xpath("//a[@id='agencySearchViewForm:checksDatatable:0:actionRequired']"));
	               log.info("$%%$%$%$%$%%%%%%%%%%%%%^^^^^^^^^^^^^^^@$$$$$$$$$$$$$");
	                Action_req.click();
	                Thread.sleep(3000);
	                log.info("bdjkgfkhgbfkgkdfhjertretaslsdghjersldfjerald");
	 	  
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
					    log.info(tabelrow.size()+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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
			            		 log.info(innerRows.size()+"****************************************");
									try {
			            		// ===========scroll========//
								   log.info("scroll 22222");
			            		   WebElement downloadLinks = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt148:"+ l +":fileNameLink\"]"));
			            		   JavascriptExecutor js3 = (JavascriptExecutor) driver;
			            		   Thread.sleep(500);
			            		   js3.executeScript("arguments[0].scrollIntoView(true)",downloadLinks);
			            			 Thread.sleep(500);
				            	    downloadLinks.click();
			            	  
			            	   }catch(Exception e) {
			            		   WebElement OK = null;
			            	        try {
			            	        	// ===========scroll========//
//					    				JavascriptExecutor js11 = (JavascriptExecutor) driver;
//					    				js11.executeScript("window.scrollBy(0,20)");
					    				log.info("scroll 33333");
			            	        	
			            	        	OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
			            	        } catch (NoSuchElementException ignored) {
			            	            // If OK button is not found, you can handle the exception here or perform necessary actions
			            	        }
//			            	       
			            	        System.out.println("Clicked OK for exception");
			            	   }
			            	     }
			       			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Set a shorter implicit wait
			       			WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
						   WebDriverWait wait = new WebDriverWait(driver, 3);
//							  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
							   System.out.println("clicked ok when document is downloaded " );
							   Thread.sleep(500);
							   OK.click();
						    Thread.sleep(1000);
						}
					}catch (StaleElementReferenceException e) {
						 System.out.println("Element has faced some problems" +  e);
					} 
				     System.out.println("Outer first for  loop");
		                create_Folder( id ,  id1 ,  i, sheetInput, dataStyle);
		            }
	        			}catch(StaleElementReferenceException e) {
	            System.out.println("Entering CATCH  ###");
	            String employee_id = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:employeeID']")).getText();
	            if(id1.equals(employee_id)) {
	                System.out.println("If Employee ID is a match");
	                String BGC_Type = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:bgcType']")).getText();
	                System.out.println(BGC_Type);
	                String Region = driver.findElement(By.xpath("//label[@id='agencySearchViewForm:checksDatatable:0:candidateRegion']")).getText();
	                System.out.println(Region);
	                WebElement BGC_Form = driver.findElement(By.xpath("//a[text()='BGC Form']"));
	                BGC_Form.click();
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//a[text()='View BGC Form']")).click();
	                Thread.sleep(2000);
	                if(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).isDisplayed()) {
	                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
	                }
	                Thread.sleep(2000);
	                WebElement resume = driver.findElement(By.xpath("//a[text()='Resume']"));
	                resume.click();
	                Thread.sleep(2000);
	                WebElement Action_req = driver.findElement(By.xpath("//a[@id='agencySearchViewForm:checksDatatable:0:actionRequired']"));
	                Action_req.click();
	                Thread.sleep(3000);
	                log.info("bdjkgfkhgbfkgkdfhjertretaslsdghjersldfjerald");
	      	 	  
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
					    JavascriptExecutor js = (JavascriptExecutor)driver;
	                       js.executeScript("window.scrollBy(0,40)");
	            		
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
			            		   JavascriptExecutor js1 = (JavascriptExecutor)driver;
			                       js1.executeScript("window.scrollBy(0,30)");
			            		   js3.executeScript("arguments[0].scrollIntoView(true)",downloadLinks);
				            	   Thread.sleep(500);
				            	    downloadLinks.click();
			            		   }catch(Exception e1) {
			            		   WebElement OK = null;
			            	        try {
			            	        	// ===========scroll========//
//					    				JavascriptExecutor js11 = (JavascriptExecutor) driver;
//					    				js11.executeScript("window.scrollBy(0,20)");
					    				log.info("scroll 33333");
			            	        	
			            	        	OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
			            	        } catch (NoSuchElementException ignored) {
			            	            // If OK button is not found, you can handle the exception here or perform necessary actions
			            	        }
			            	        System.out.println("Clicked OK for exception");
			            		   }
			             }
			       			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // Set a shorter implicit wait
			            	WebElement OK = driver.findElement(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span"));
						   WebDriverWait wait = new WebDriverWait(driver, 3);
//							  OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"documentDialogForm:j_idt155\"]/span")));
							   System.out.println("clicked ok when document is downloaded " );
						   Thread.sleep(500);
						   OK.click();
						    Thread.sleep(1000);
					}
						}catch (StaleElementReferenceException e2) {
						 System.out.println("Element has faced some problems" +  e);
					     
					}  
                    System.out.println("Outer first for  loop");
               create_Folder( id ,  id1 ,  i, sheetInput , dataStyle);
           }
       }catch(ElementNotInteractableException e) {
           System.out.println("Returning to previous method from e catch..!!");
       }
   }
	                
	        

	    private static void create_Folder(String id , String id1 ,int i, Sheet sheetInput, CellStyle dataStyle) throws InterruptedException, AWTException, IOException {
	        System.out.println("Entering Folder creation");
	        log.info("Printed Log");
	        //Applicant ID will enter here..
	        if(id!=null) {
	            System.out.println("Creating subfolder on Applicant id");

	            String base_path = Download_Path;
	            String subfolder_path ="";
	            subfolder_path = base_path + File.separator +id;
	            File subfolder = new File(subfolder_path);
	            if (!subfolder.exists() && subfolder.mkdirs()) {
	                System.out.println("Subfolder created: " + subfolder_path);
	            } else if (subfolder.exists()) {
	                System.out.println("Subfolder already exists: " + subfolder_path);
	            } else {
	                System.err.println("Failed to create subfolder: " + subfolder_path);
	            }
	            File download_folder = new File(Download_Path);
	            File[] files = download_folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    String fileName = file.getName();
	                    System.out.println(fileName);
	                    if (!subfolder.exists()) {
	                        subfolder.mkdirs();
	                        System.out.println("Directory is created");
	                    }
	                    if (file.isFile()) {      //This method will move only files not the directory which is present in default download path
	                        try {
	                            System.out.println("#############  Entering TRY  ##############");
	                            Path source = file.toPath();
	                            Path destination = new File(subfolder, file.getName()).toPath();
	                            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
	                           
	                            System.out.println("File moved successfully for ID: " + id);
	                        } catch (IOException e) {
	                            e.printStackTrace();

	                        }
	                    }
	                    if(subfolder.exists()) {
	                            logAndWriteToExcel(sheetOutput, "Pass", i, 3, dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Scrapped successfully", i, 4, dataStyle);
	                        }
	                    else {
	                            logAndWriteToExcel(sheetOutput, "Fail", i, 3, dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Not scrapped", i, 4, dataStyle);
	                    }
	                }
	            }
	            Robot r= new Robot();
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            Thread.sleep(4000);
	            driver.findElement(By.xpath("//a[text()='Home']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
	            Thread.sleep(2000);
	            WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
	            BGC_type.click();
	            Thread.sleep(2000);
	            WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
	            Exp_professional.click();
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	        }

	        //Employee ID will enter here..
	        else if(id1!=null){
	            System.out.println("Creating subfolder on Employee id");
	            String base_path = Download_Path;
	            String subfolder_path ="";
	            subfolder_path = base_path + File.separator +id1;
	            File subfolder = new File(subfolder_path);
	            if (!subfolder.exists() && subfolder.mkdirs()) {
	                System.out.println("Subfolder created: " + subfolder_path);
	            } else if (subfolder.exists()) {
	                System.out.println("Subfolder already exists: " + subfolder_path);
	            } else {
	                System.err.println("Failed to create subfolder: " + subfolder_path);
	            }
	            File download_folder = new File(Download_Path);
	            File[] files = download_folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    String fileName = file.getName();
	                    System.out.println(fileName);
	                    if (!subfolder.exists()) {
	                        subfolder.mkdirs();
	                        System.out.println("Directory is created");
	                    }
	                    if (file.isFile()) {      //This method will move only files not the directory which is present in default download path
	                        try {
	                            System.out.println("#############  Entering TRY  ##############");
	                            Path source = file.toPath();
	                            Path destination = new File(subfolder, file.getName()).toPath();
	                            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
	                            
	                            System.out.println("File moved successfully for ID: " + id1);
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    if(subfolder.exists()) {
	                            logAndWriteToExcel(sheetOutput, "Pass", i , 3, dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Scrapped successfully",i, 4, dataStyle);
	                        }
	                    else {
	                            logAndWriteToExcel(sheetOutput, "Fail", i , 3, dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Not scrapped", i, 4, dataStyle);
	                    }
	                }
	            }
	            Robot r= new Robot();
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            Thread.sleep(4000);
	            driver.findElement(By.xpath("//a[text()='Home']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
	            Thread.sleep(2000);
	            WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
	            BGC_type.click();
	            Thread.sleep(2000);
	            WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
	            Exp_professional.click();
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	        }

	        //Since both the values are present, Applicant id will work in default
	        else {
	            System.out.println("Creating subfolder on Applicant id by default");
	            String base_path = Download_Path;
	            String subfolder_path ="";
	            subfolder_path = base_path + File.separator +id;
	            File subfolder = new File(subfolder_path);
	            if (!subfolder.exists() && subfolder.mkdirs()) {
	                System.out.println("Subfolder created: " + subfolder_path);
	            } else if (subfolder.exists()) {
	                System.out.println("Subfolder already exists: " + subfolder_path);
	            } else {
	                System.err.println("Failed to create subfolder: " + subfolder_path);
	            }
	            File download_folder = new File(Download_Path);
	            File[] files = download_folder.listFiles();
	            if (files != null) {
	                for (File file : files) {
	                    String fileName = file.getName();
	                    System.out.println("fileName is =======>>>>>>"+fileName);
	                    if (!subfolder.exists()) {
	                        subfolder.mkdirs();
	                        System.out.println("Directory is created");
	                    }
	                    if (file.isFile()) {      //This method will move only files not the directory which is present in default download path
	                        try {
	                            System.out.println("#############  Entering TRY  ##############");
	                            Path source = file.toPath();
	                            Path destination = new File(subfolder, file.getName()).toPath();
	                            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
	                           
	                            System.out.println("File moved successfully for ID: " + id);
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    if(subfolder.exists()) {
	                            logAndWriteToExcel(sheetOutput, "Pass", i, 3, dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Scrapped successfully", i, 4,dataStyle);
	                        }
	                    else {
	                            logAndWriteToExcel(sheetOutput, "Fail", i, 3 ,dataStyle);
	                            logAndWriteToExcel(sheetOutput, "Not scrapped", i , 4 , dataStyle);
	                    }
	                }
	            }

	            Robot r= new Robot();
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            r.keyPress(KeyEvent.VK_PAGE_UP);
	            r.keyRelease(KeyEvent.VK_PAGE_UP);
	            Thread.sleep(4000);
	            driver.findElement(By.xpath("//a[text()='Home']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table[3]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/a")).click();
	            Thread.sleep(2000);
	            WebElement BGC_type = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/label"));
	            BGC_type.click();
	            Thread.sleep(2000);
	            WebElement Exp_professional = driver.findElement(By.xpath("//li[text()='Experience Professional']"));
	            Exp_professional.click();
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	            }
	        }


	    @AfterTest
	    public static void afterTest() {
	        try (FileOutputStream fileOut = new FileOutputStream(excelOutput)) {
	            workbookOutput.write(fileOut);
	        } catch (IOException e) {
	            System.out.println("Error writing to output file: " + e.getMessage());
	            e.printStackTrace();
	        }
	        System.out.println("After Test, Closing Browser");
	        driver.close();
	    }

	}
	
	

