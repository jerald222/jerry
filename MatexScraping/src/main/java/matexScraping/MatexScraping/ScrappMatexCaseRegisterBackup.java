package matexScraping.MatexScraping;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Assertions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ScrappMatexCaseRegisterBackup {

//		String filePath="/home/admin/Documents/2032454/";
		String filePath="C:\\Users\\Public\\Documents\\Matex\\";
		
		String Pingurl="http://192.168.0.206:8080/scrap/api/pdf/ping";
		//String Pingurl="http://192.168.15.78:8888/Scrap/api/pdf/ping";
		public static boolean pingURL(String url, int timeout) {
		    url = url.replaceFirst("^https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
		    System.out.println("Pingurl "+url);
		    try {
		        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		        connection.setConnectTimeout(timeout);
		        connection.setReadTimeout(timeout);
		        connection.setRequestMethod("HEAD");
		        int responseCode = connection.getResponseCode();
		        System.out.println("Response Code "+responseCode);
		        return (200 <= responseCode && responseCode <= 399);
		    } catch (IOException exception) {
		        return false;
		    }
		}
		
		
		
		  public String sendBgvFile(String FileName) throws IOException{
		    	
			  
			  String url="http://192.168.0.206:8080/scrap/api/pdf/ocrcaseregister";
			  //String url="http://192.168.15.78:8888/Scrap/api/pdf/ocrcaseregister";
				 
			  String caseRegisteredId="";
			  RestAssured.baseURI =url;// "http://192.168.0.206:9093/Scrap/api/pdf/ocrcaseregister";
		    	//Post
		    	
		       boolean hostEnabled=pingURL(Pingurl,10000);//http://192.168.0.206:9093/Scrap/api/pdf/ocrcaseregister
		       if(hostEnabled)
		       {
		       System.out.println("Host is Enabled ");
		       System.out.println("Bgf Document File Name "+FileName);
		    	File bgfDocument = new File(filePath+FileName);
		    	  System.out.println("*****"+bgfDocument);
		    	  Response response = given()
		    			  .multiPart(bgfDocument)
		                 // .header("Content-type", "mu")
		                 // .and()
		                 // .body(requestBody)
		                  .when()
		                  .post()
		                  .then()
		                  .extract().response();
		    	  Assertions.assertEquals(200, response.statusCode());
		    	 System.out.println(response.statusCode());
		    	
		    	 String caseRegsiteredResponse=response.getBody().toString();
		    	 System.out.println(caseRegsiteredResponse);
		    	
		    	  //ResponseBody body = response.getBody();
		    	  JsonPath jsonPathEvaluator = response.jsonPath();
		    	  System.out.println(jsonPathEvaluator.toString());
		    	  caseRegisteredId = jsonPathEvaluator.getString("id");
		    	  
		    	  System.out.println("Response Body is: " +  caseRegisteredId);
		    	 
			       
		       }
		       else
		       {
		    	   System.out.println("HOst is  not Enabled cannot send documents ");
		       
		       }
		    	
		    	
				return caseRegisteredId;
		    }

		public void sendCaseUploadDocument(String caseRegistrationId,String name,String check_name) {
			// TODO Auto-generated method stub
			boolean hostEnabled=pingURL(Pingurl,1000);
	    	
			if(hostEnabled)
			{
				System.out.println("Host is Enabled");
			
				
				RestAssured.baseURI = "http://192.168.0.206:8080/master/api/casedocuments/"+caseRegistrationId+"/upload/"+check_name;
				//RestAssured.baseURI = "http://192.168.15.78:9091/CaseDocuments/"+caseRegistrationId+"/upload/"+check_name;
				
				
				File checkDocuments = new File(filePath+name);
	  	   
	    	System.out.println("*****"+checkDocuments);
	  	     Response response = given()
	  			  .multiPart(checkDocuments)
	               // .header("Content-type", "mu")
	               // .and()
	               // .body(requestBody)
	                .when()
	                .post()
	                .then()
	                .extract().response();
	  	  Assertions.assertEquals(200, response.statusCode());
	  	 System.out.println(response.statusCode());
	  	 System.out.println(response.getBody());
	  	 
			}
	  	 //System.out.println("Response Body is: " +  caseRegistrationId);
			}
	  	  //ResponseBody body = response.getBody();
	  	  //JsonPath jsonPathEvaluator = response.jsonPath();
	  	  //caseRegisteredId = jsonPathEvaluator.getString("id");
	  	  //System.out.println("Response Body is: " + caseRegisteredId);
			//return caseRegisteredId;
		
			
		}

	

