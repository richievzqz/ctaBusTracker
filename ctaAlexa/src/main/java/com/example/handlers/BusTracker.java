package com.example.handlers;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BusTracker {
	private static final String baseUrl = "http://www.ctabustracker.com/bustime/api/v1/";
	private String key = "";
	public BusTracker (String k) {
		key = k;
	}
	    public String demo() {
	        // Current official CTA time.
	    	String sampleRoute = "&rt=53A&stpid=4716";
	        String url = baseUrl + "getpredictions?key=" + key + sampleRoute;
	        return makeRequest(url);
	    }
	    private String makeRequest(String stringUrl) {
	        String response = null;
	        try {
	            URL url = new URL(stringUrl);
	            URLConnection conn = url.openConnection();
	            conn.setDoInput(true);
	            BufferedReader in =
	                new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String chunk = null;
	            while ((chunk = in.readLine()) != null) response += chunk;
	            in.close();
	        }
	        catch(Exception e) { throw new RuntimeException("Arrrg! " + e); }
	        return report(stringUrl, response);
	    }
	    private String report(String url, String xml) {
	    	int firstIndex = xml.indexOf("</prdtm>");
	    	String fTimeH = xml.substring(firstIndex - 5, firstIndex -3);
	    	String fTimeM = xml.substring(firstIndex -2, firstIndex);
	    	int firstBH = Integer.parseInt(fTimeH);
	    	if (firstBH > 12)
	    		firstBH = firstBH - 12;
	    	if (firstBH == 0)
	    		firstBH = 12;
	    	//String msg = url + "\n" + xml;
	    	return ("The next bus arrives at " + firstBH + ":" + fTimeM);
	        
	    }
}