package ApiTest.SiteTesting;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnirestException
    {
        
    	
    	HttpResponse<JsonNode> jsonResponse = Unirest.get("https://reqres.in/api/users?page=2").asJson();
    	
    	System.out.println(jsonResponse.getStatus());
    	System.out.println(jsonResponse.getStatusText());
    	System.out.println(jsonResponse.getBody());
    	
    	
    	
    	
    	
    	
    }
}
