package MatexScraping.MatexScraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	  // Set the path to your chromedriver executable
//      System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
      System.setProperty("webdriver.chrome.driver", "/home/admin/eclipse-workspace/selinum_export/chromedriver");
		
      
      // Initialize ChromeDriver
      WebDriver driver = new ChromeDriver();

      // Open Google homepage
      driver.get("https://www.google.com");

      // Find the search box by name attribute
      WebElement searchBox = driver.findElement(By.name("q"));

      // Enter your search query
      searchBox.sendKeys("Selenium WebDriver");

      // Submit the form
      searchBox.submit();

      // Wait for a few seconds to see the search results (you might want to replace this with proper waits)
      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // Print the titles of the search results
      driver.findElements(By.cssSelector("h3")).forEach(result -> System.out.println(result.getText()));

      // Close the browser
      driver.quit();
        System.out.println( "Hello World!" );
    }
}
