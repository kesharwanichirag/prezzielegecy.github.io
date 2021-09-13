package utils;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;

public class ReCaptcha{
	public static boolean checkRecaptcha(String captchaResponse)throws IOException{
		
		String captchaURL = "https://www.google.com/recaptcha/api/siteverify";
		String parameters ="secret=6LfostcZAAAAAIR8QuXF41Oqnnl86Nsn8T37w49N"+"&response="+captchaResponse;

		URL url = new URL(captchaURL+"?"+parameters);

		HttpURLConnection httpURLconnection = (HttpURLConnection)url.openConnection();
		
		httpURLconnection.setRequestMethod("POST");
		httpURLconnection.setDoOutput(true);
	
		DataOutputStream dos = new DataOutputStream(httpURLconnection.getOutputStream());

		dos.flush();
		dos.close();

		InputStream inputStream;

		int statusCode = httpURLconnection.getResponseCode();
		
		if(statusCode!= HttpURLConnection.HTTP_OK){
			inputStream = httpURLconnection.getErrorStream();
		}else{
			inputStream = httpURLconnection.getInputStream();
		}

		JsonReader jsonReader = Json.createReader(inputStream);
		
		JsonObject jsonObject = jsonReader.readObject();
		
		boolean flag = jsonObject.getBoolean("success");

		return flag;
	}
}