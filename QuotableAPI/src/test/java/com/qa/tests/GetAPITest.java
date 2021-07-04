package com.qa.tests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetAPITest extends TestBase{
	
	//applicable to all the methods
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	String pageURL;
	String pageparam;
	String tagURL;
	String authorURL;
	String tagparam;
	String authorparam;
	String tagname1;
	String tagname2;
	String authorname1;
	String authorname2;
	RestClient restClient;
	CloseableHttpResponse closeableHttpresponse;
	
	@BeforeMethod
	public void setup(){
		
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		pageparam = prop.getProperty("pageparam");
		tagparam = prop.getProperty("tagparam");
		authorparam = prop.getProperty("authorparam");
		tagname1 = prop.getProperty("tagname1");
		tagname2 = prop.getProperty("tagname2");
		authorname1 = prop.getProperty("author1");
		authorname2 = prop.getProperty("author2");
		
		
		url = serviceUrl + apiUrl;
	}
	
	@Test(priority = 1)
	public void getPages() throws ClientProtocolException, IOException {
		//for 5 pages
	    for(int i=1; i<=5; i++) {
	    	
	    	pageURL = url+pageparam+"="+i;
		
		restClient = new RestClient();
		closeableHttpresponse = restClient.get(pageURL);

		//a. Status Code:
		int statusCode = closeableHttpresponse.getStatusLine().getStatusCode(); // to get the status code of the http call
		System.out.println("Status Code----->" +statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");
		
		//b. JSON String:
		String responseString = EntityUtils.toString(closeableHttpresponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString); // to convert the string response into json object
		System.out.println("Response JSON from API----->" +responseJson);
		
	    }
	}
	    
	    
	    @Test(priority = 2)
		public void getTags1() throws ClientProtocolException, IOException {
		  
		    tagURL = url+tagparam+"="+tagname1+"%7C"+"tagname2";
			
			restClient = new RestClient();
			closeableHttpresponse = restClient.get(tagURL);

			//a. Status Code:
			int statusCode = closeableHttpresponse.getStatusLine().getStatusCode(); // to get the status code of the http call
			System.out.println("Status Code----->" +statusCode);
			
			Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");
			
			//b. JSON String:
			String responseString = EntityUtils.toString(closeableHttpresponse.getEntity(), "UTF-8");
			
			JSONObject responseJson = new JSONObject(responseString); // to convert the string response into json object
			System.out.println("Response JSON from API----->" +responseJson);
			
		    
		
	}
	    
	    @Test(priority = 3)
		public void getTags2() throws ClientProtocolException, IOException {
		  
		    tagURL = url+tagparam+"="+tagname1+","+"tagname2";
			
			restClient = new RestClient();
			closeableHttpresponse = restClient.get(tagURL);

			//a. Status Code:
			int statusCode = closeableHttpresponse.getStatusLine().getStatusCode(); // to get the status code of the http call
			System.out.println("Status Code----->" +statusCode);
			
			Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");
			
			//b. JSON String:
			String responseString = EntityUtils.toString(closeableHttpresponse.getEntity(), "UTF-8");
			
			JSONObject responseJson = new JSONObject(responseString); // to convert the string response into json object
			System.out.println("Response JSON from API----->" +responseJson);
			
		    
		
	}
	    
	    @Test(priority = 4)
		public void getAuthor() throws ClientProtocolException, IOException {
		  
		    authorURL = url+authorparam+"="+authorname1;
			
			restClient = new RestClient();
			closeableHttpresponse = restClient.get(authorURL);

			//a. Status Code:
			int statusCode = closeableHttpresponse.getStatusLine().getStatusCode(); // to get the status code of the http call
			System.out.println("Status Code----->" +statusCode);
			
			Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status Code is not 200");
			
			//b. JSON String:
			String responseString = EntityUtils.toString(closeableHttpresponse.getEntity(), "UTF-8");
			
			JSONObject responseJson = new JSONObject(responseString); // to convert the string response into json object
			System.out.println("Response JSON from API----->" +responseJson);
			
		    
		
	}
	    
	 
			
		    
		
	
}


