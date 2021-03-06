package go.euro.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
public class ReadJsonFromUrl {
	
	private static String ApiURL="http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public static String ReadJson(String City) throws Exception {
	    BufferedReader reader = null;
	    try {
	    	String PrepareUrl= ApiURL+URLEncoder.encode(City,"UTF-8").replace("+", "%20");
	    	System.out.println("requesting URL:  " + PrepareUrl);	
	        URL url = new URL(PrepareUrl);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
	        return buffer.toString();
	    }
	    finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
