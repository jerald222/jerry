package matexScraping.MatexScraping;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.DeathByCaptcha.Captcha;
import com.DeathByCaptcha.Client;
import com.DeathByCaptcha.HttpClient;

public class Indusind {

	static	Logger log =Logger.getLogger(Indusind.class);
	static WebDriver driver;

// 	private static String desired_filepath ="C:\\Users\\Public\\Documents\\Matex\\";
	private static String desired_filepath = "/home/admin/Documents/Indusind";

	public static void main(String[] args ) throws InterruptedException, IOException {

	//	String[] args = {"userID","password","CandidateId" };	
		
		Indusind1(args);
	
		Indusind2(args);
	
	}

	public static void Indusind1(String[] args) throws InterruptedException, IOException {
		
		String userID ="Matrix5";// 2531691
			if (args[0] != "") {
			userID = args[0];
		}

		String password ="Matrix5@123";// 2531691
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
//		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\chromedriver.exe");
			driver = new ChromeDriver(options);
		
		// get url for tcs
		driver.get("https://onboarding.indusind.com");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

	
	
		// username
		driver.findElement(By.id("txtLoginID")).sendKeys(userID);
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

		// password
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	
		// NAVIGATING TO CAPTCH TEXT BOX
			String captchatext = "";
     
		
	//====bypassing the captcha=========//
			
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

		     
			try {
		            try {
		                System.out.println("Your balance is " + client.getBalance() + " US cents");
		            } catch (IOException e) {
		                System.out.println("Failed fetching balance: "+ e.toString() );
		                return;
		            }
		        	//=================================================//
		 		   
		            WebElement element12 = driver.findElement(By.cssSelector("#trCaptchaImage > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > div > img"));
		            //driver.findElement(By.cssSelector("#captchaImg"));
				    Thread.sleep(2000);

				    // Take a screenshot
				    File srcFile1 = element12.getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(srcFile1, new File("/home/admin/Documents/captcha.png"));

				    Thread.sleep(2000);
				    log.info("sending captcha image");
		            
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
	       
		        				Thread.sleep(2000);
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			//Applying value  to the text field as captcha
			WebElement Text = driver.findElement(By.id("txtinput"));
			Text.sendKeys(captchatext);
			Thread.sleep(2000);
			
			//login button*****************************
			WebElement element3 = driver.findElement(By.name("btnLogin"));
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", element3);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			
			WebElement frame =driver.findElement(By.name("btnResetSession"));
			
			if (frame.isDisplayed()) {
				frame.click();
				Thread.sleep(1000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			}else {
				// clicking for the Bgv Document button
				WebElement BGV =driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/nav/ul/li[2]/a"));
				BGV.click();
				Thread.sleep(1000);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

				
			}
			
			
			
			Thread.sleep(2000);
		            } 
		            else {
		               System.out.println("Failed solving CAPTCHA");
		            }
		        } catch (com.DeathByCaptcha.Exception e) {
		            System.out.println(e);
		    		Thread.sleep(3000);
		        }
	
	}	
			//SECOND STEP FOR DOWNLOADING THE FILES OF THE EXPERIENCED CANDIDATES
			public static  void Indusind2(String[] args) throws InterruptedException, IOException {
				String desired_filepath = "/home/admin/Documents/2032454";
		
				//System.out.println("Candidate Id===========" + args[0]);

			String CandidateId ="";// 2531691
			if (args[0] != "") {
				CandidateId = args[0];
			}
			
			// clicking for the Bgv Document button
			WebElement BGV =driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/nav/ul/li[2]/a"));
			BGV.click();
			Thread.sleep(1000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));

			
			// Applying text for the text field
			WebElement seek = driver.findElement(By.id("TXTECN"));

			try {
			    if (seek.isDisplayed()) {
			        seek.sendKeys(CandidateId);
			        // You can remove the pageLoadTimeout line as it seems unnecessary in this context
			    } else {
			        System.out.println("Text field not found. Closing the browser.");
			        driver.quit(); // Use quit() to close the browser and end the WebDriver session
			    }
			} catch (Exception e) {
			    System.out.println("Error occurred while interacting with the text field. Closing the browser.");
			    driver.quit(); // Use quit() to close the browser and end the WebDriver session
			}

			
			// clicking for the Search button
			WebElement Search =driver.findElement(By.name("BTN_Search"));
			Search.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
			//clicking for the Download all button
			WebElement Downlaod =driver.findElement(By.name("btnDownLoadZip"));
			Downlaod.click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			
			
			}
	
	}

	