package edu.cmu.andrew.ruiw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SendTextMessage {
	  
	    private String XML;

	    public void sendText(String phoneNum, String text) throws UnsupportedEncodingException {
	         String textURL = java.net.URLEncoder.encode(text, "UTF-8");
	         String response = "";
	        try {
	            // Create a URL for the desired page            
	            URL url = new URL("https://rest.nexmo.com/sms/xml?api_key=bc5c5e08&api_secret=3774e6cc&from=12013514304&to=1"+phoneNum+"&text="+textURL);
	            // Create an HttpURLConnection.  This is useful for setting headers.
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
	            // Read all the text returned by the server
	            BufferedReader in = new BufferedReader
	                    (new InputStreamReader(connection.getInputStream(), "UTF-8"));
	            String str;
	            while ((str = in.readLine()) != null) {
	                // str is one line of text readLine() strips newline characters
	                response += str;
	              
	            }
	            in.close();
	        } catch (IOException e) {
	            // Do something reasonable.  This is left for students to do.
	        }
	        
	  
	        
	
	      //  System.err.println(startfarm+" "+endfarm);
	        // only start looking after the quote before http
	      
	       XML = response; 
	       //pictureURL = response.substring(startfarm, endfarm+1);
	        // +1 to include the quote
	    }
	    
	    public String getXML(){
	    	return XML;
	    }
}
