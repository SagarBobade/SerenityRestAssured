package rough;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap; // import the HashMap class

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstTest {
	
	
	@BeforeClass
	public static void inIt() {
		
		RestAssured.baseURI= "https://reqres.in";
		RestAssured.basePath= "/api/users?page=2";
	}
	
	@Ignore
	@Title("Sending get request")
	@Test
	public void getRequest() {
		
		Response response = SerenityRest.given().when().get();
		response.prettyPrint();
		response.then().statusCode(200);
		//OR System.out.println(response.statusCode());
		//OR System.out.println(response.getStatusCode());
		
	
	}

	@Ignore
	@Title("Sending post request")
	@Test
	public void postRequest() {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("name", "sagar");
		map.put("job", "leader");
		
		Response response = SerenityRest.given()
				.contentType(ContentType.JSON)
				.body("").log().all().post();
		
		response.prettyPrint();
		System.out.println("Status Code: "+response.getStatusCode());
	
	}
	
	@Title("Sending delete request")
	@Test
	public void deleteRequest() {
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("name", "sagar");
//		map.put("job", "leader");
		
		Response response = SerenityRest.given().when().delete("2");
		
		response.prettyPrint();
		System.out.println("Status Code: "+response.getStatusCode());
	
	}
	
}
