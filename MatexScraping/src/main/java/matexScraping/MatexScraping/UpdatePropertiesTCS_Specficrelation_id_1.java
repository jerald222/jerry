package matexScraping.MatexScraping;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UpdatePropertiesTCS_Specficrelation_id_1 {
	public static void main(String string) {
        // Specify the path to your properties file
		Tcs_Specficrelation_UPDATE(string);
    }	

public static void Tcs_Specficrelation_UPDATE(String string) {
		// TODO Auto-generated method stub
		String filePath = "Overall.properties";

try (FileInputStream input = new FileInputStream(filePath)) {
  Properties properties = new Properties();
  properties.load(input);

  // Update the HCL_Excel property
  properties.setProperty("TCS_SpecficRelation_Excel", string);

  // Save the updated properties to the file
  try (FileOutputStream output = new FileOutputStream(filePath)) {
      properties.store(output, null);
  }

  System.out.println("TCS_SpecficRelation_Excel updated successfully.");

} catch (IOException e) {
  e.printStackTrace();
}
	}
}
