package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
		
		//1. GET Method without Headers:
		public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
			
			CloseableHttpClient httpClient = HttpClients.createDefault(); //create a http client
			HttpGet httpGet = new HttpGet(url); //http get request
			CloseableHttpResponse closeableHttpresponse = httpClient.execute(httpGet); //hit the GET URL
			
			return closeableHttpresponse;
			
		}
	
	    //2. GET Method with Headers:
		public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
			
			CloseableHttpClient httpClient = HttpClients.createDefault(); //create a http client
			HttpGet httpGet = new HttpGet(url); //http get request
			
			//for iterating through the hash map
			for(Map.Entry<String,String> entry : headerMap.entrySet()){
				httpGet.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closeableHttpresponse = httpClient.execute(httpGet); //hit the GET URL
			return closeableHttpresponse;
			
		}
		
		//3/ POST Method:
		public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
			
			CloseableHttpClient httpClient = HttpClients.createDefault(); //create a http client
			HttpPost httpPost = new HttpPost(url);//http post request
			httpPost.setEntity(new StringEntity(entityString));//for payload
			
			//for headers
			for(Map.Entry<String,String> entry : headerMap.entrySet()){
				httpPost.addHeader(entry.getKey(), entry.getValue());
			}
			
			CloseableHttpResponse closeableHttpresponse = httpClient.execute(httpPost); //hit the GET URL
			return closeableHttpresponse;
		}
		
		

}
