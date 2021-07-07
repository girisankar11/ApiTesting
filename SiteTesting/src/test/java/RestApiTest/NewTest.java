package RestApiTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {

	@Test
	public void postMethod() throws IOException {
		
		URL url = new URL("https://reqres.in/api/users/114");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");
		
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		
		String jsonBody=  "{\n"
				+ "    \"name\": \"karthi\",\n"
				+ "    \"job\": \"Teamleader\"\n"
				+ "}";
		
		byte[] inputJsonBody = jsonBody.getBytes();
		
		OutputStream outputStream =connection.getOutputStream();
		outputStream.write(inputJsonBody);
		
		
		
		int statusCode =connection.getResponseCode();
		String message =connection.getResponseMessage();
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		
		StringBuffer buffer = new StringBuffer();
		while((line=bufferedReader.readLine())!=null) {
			
			buffer.append(line);
		}
		System.out.println(statusCode);
		System.out.println(message);
		System.out.println(buffer);
			
	}
	
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		/*URL url = new URL("	https://reqres.in/api/users?page=2");
		HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int statusCode = connection.getResponseCode();
		System.out.println("The StatusCode is "+ statusCode);

		String responseMessage = connection.getResponseMessage();
        System.out.println("Message is "+ responseMessage);
        
        InputStream inputsteam = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputsteam);
        
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer buffer = new StringBuffer();
        while((line =bufferedReader.readLine())!=null) {
        	buffer.append(line);
        }
        System.out.println(buffer); */
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@AfterSuite
	public void afterSuite() throws IOException {
		NewTest postTest = new NewTest();
		
		postTest.postMethod();
		
		
		
	}

}
