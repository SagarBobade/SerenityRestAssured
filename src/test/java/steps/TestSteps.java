package steps;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TestSteps {

	private Response response;

	@Step("Send get request")
	public void sendGetRequest() {

		response = SerenityRest.given().when().get();
		
		response.prettyPrint();
		
		response.then().statusCode(200); 

		response.then().body("total", Matchers.equalTo(12));
	}

	
	@Step("Send post request for request body: {0}, and expected response code: {1}")
	public void sendPostRequest(String requestBody, String responseCode) throws Exception {
		
		JSONObject object = new JSONObject(requestBody);  	
		System.out.println("in post");
		response = SerenityRest.given().contentType(ContentType.JSON).body(object.toString()).log().all().post();

		response.prettyPrint();
	}

	
	@Step("Send delete request to delete: {0}")
	public void sendDeleteRequest(String id) {

		response = SerenityRest.given().when().delete(id);
		
		System.out.println("Status Code: " + response.getStatusCode());
	}

	
	@Step("Validate response code with expected")
	public void validateResponseCode(String responseCode) {
		Assert.assertEquals(response.getStatusCode(), (int)Math.round(Float.parseFloat(responseCode)));
	}

	
	@Step("Validate response body with expected key:{0}, value:{1}")
	public void validateResponseBody(String key, String value) {

		response.then().body(key, Matchers.equalTo(Integer.parseInt(value)));
	}
	
}
