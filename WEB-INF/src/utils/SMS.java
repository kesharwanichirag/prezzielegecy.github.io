package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
 
public class SMS{
	public static String sendSms(String mobile, String msg){
		try {
			// Construct data
			String apiKey = "apikey=" + "5iohOZXZyr0-hhhZnrETxxiQwOzSNGQvV36XQWszV4";
			//+oUnVLg+e74-MnT2GE5E4dUbfObrDNH2ktoWLDwe3P
			String message = "&message=" + msg;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" +mobile;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}