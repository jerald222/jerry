package matexScraping.MatexScraping;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UpdatePropertiesGenpact {
	 public static void main(String string) {
	        // Specify the path to your properties file
		  Genpact_UPDATE(string);
	    }	
	
	public static void Genpact_UPDATE(String string) {
			// TODO Auto-generated method stub
			String filePath = "Overall.properties";

     try (FileInputStream input = new FileInputStream(filePath)) {
         Properties properties = new Properties();
         properties.load(input);

         // Update the HCL_Excel property
         properties.setProperty("Genpact_Excel", string);

         // Save the updated properties to the file
         try (FileOutputStream output = new FileOutputStream(filePath)) {
             properties.store(output, null);
         }

         System.out.println("Genpact_Excel updated successfully.");

     } catch (IOException e) {
         e.printStackTrace();
     }
		}
}
