package com.vir.verifier;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;



public class Verifier {
	public static boolean verifyToken(String token) throws IOException
	{
		
		try {
			URL url = new URL("https://oauth2.googleapis.com/tokeninfo?id_token=" + token);
//			res.setContentLength(token.length());
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			long len = token.length();
			con.setFixedLengthStreamingMode(len + 50);
//			con.setHeader("Content-Length", "0"); 
//			DataOutputStream out = new DataOutputStream(con.getOutputStream());
//	        out.write(body);
//	        out.close();
			int responseCode = con.getResponseCode();
			System.out.println(responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     JSONObject myResponse = new JSONObject(response.toString());
		     
		     int exp = Integer.parseInt(myResponse.getString("exp"));
		     System.out.println("***" + exp);
		     int currentTime = (int) (new Date().getTime()/1000);
		     if((exp <= currentTime) && (myResponse.getString("email_verified") == "true"))
		     {
		    	 return true;
		     }
		     
		     
		     
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

}
