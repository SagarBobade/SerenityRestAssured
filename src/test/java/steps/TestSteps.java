package steps;

import java.util.HashMap;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TestSteps {

	private Response response;

	@Step("Send get request for users list")
	public void sendGetRequestForUsers() {

		response = SerenityRest.given().when().get();
		response.prettyPrint();
		response.then().statusCode(200);

		response.then().body("total", Matchers.equalTo(12));
	}

	@Step("Send post request for user creation with name:{0}, job:{1}")
	public void sendPostRequestForUsers(String name, String job) {

		//System.out.println(name + " "+ job);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("job", job);

		Response response = SerenityRest.given().contentType(ContentType.JSON).body("").log().all().post();

		response.prettyPrint();
		System.out.println("Status Code: " + response.getStatusCode());
	}

	@Step("Send delete request for user deletion with id:{0}")
	public void sendDeleteRequestForUsers(String id) {

		response = SerenityRest.given().when().delete(id);
		System.out.println("Status Code: " + response.getStatusCode());
	}

	@Step("Validate response code with expected:{0}")
	public void validateResponseCode(int expectedStatusCode) {

		System.out.println("Status Code: " + response.then().statusCode(expectedStatusCode));
	}

	@Step("Validate response body with expected key:{0}, value:{1}")
	public void validateResponseBody(String key, String value) {

		response.then().body(key, Matchers.equalTo(Integer.parseInt(value)));
	}
	
	
	
	
	
	
	
}
