package matexScraping.MatexScraping;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MCA_ID_check {
	  static String Download_Path="/home/admin/Documents/TCS_Experienced_Professionals";
	  @BeforeTest
public static void main() throws IOException {
	 FileInputStream fis= new FileInputStream("Overall.properties");
     Properties p = new Properties();
     p.load(fis);
     String Executables = p.getProperty("driver_Execeutables");
     String Chrome_path = p.getProperty("Chrome_path");
     ChromeOptions options = new ChromeOptions();
     HashMap<String, Object> chromePrefs = new HashMap<>();
     options.setExperimentalOption("prefs", chromePrefs);
     options.addArguments("--remote-allow-origins=*"); 
	    chromePrefs.put("download.default_directory", Download_Path);
	     String url = p.getProperty("MCA_URL");
		
	     
}
	  @Test
	     private static void Excel_Read() throws IOException, AWTException, InterruptedException {
		        System.out.println("##### Entering Excel_Read() method.!! #####");
	     }  
}
