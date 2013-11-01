package com.di.world.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RestServices {
	private DefaultHttpClient client;
	
	public RestServices() {
		//client = new DefaultHttpClient();
	}
	
	public String get(String url) throws Exception {
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");
 
		try {
			client = new DefaultHttpClient();
			HttpResponse response = client.execute(getRequest);
	 
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
			return new String(EntityUtils.toString(response.getEntity()));
		} finally {
			client.getConnectionManager().shutdown();
		}
		
	}
	
	

}
