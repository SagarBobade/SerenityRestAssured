package steps;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class API {

	private Response response;
	private JSONObject object;

	@Step("Send get request")
	public void sendGetRequest() {

		response = SerenityRest.given().when().get();
		
		response.prettyPrint();
		
	}

	
	@Step("Send post request for request body: {0}")
	public void sendPostRequest(String requestBody, String responseCode) throws Exception {
		
		object = new JSONObject(requestBody);  	
		System.out.println("in post");
		response = SerenityRest.given().contentType(ContentType.JSON).body(object.toString()).log().all().post();
		response.prettyPrint();
	}

	@Step("Send put request with updated body: {0}")
	public void sendPutRequest(String requestBody, String responseCode) throws Exception {
		object = new JSONObject(requestBody);  	
		System.out.println("in put");
		System.out.println(requestBody);
		response = SerenityRest.given().contentType(ContentType.JSON).body(object.toString()).log().all().put();
		System.out.println(response.getStatusCode());
	}
	
	@Step("Send delete request to delete: {0}")
	public void sendDeleteRequest(String id) {

		response = SerenityRest.given().when().delete(id);
		
		System.out.println("Status Code: " + response.getStatusCode());
	}

	
	@Step("Validate response code with expected")
	public void validateResponseCode(String responseCode) {
		System.out.println("heyya"+responseCode+" : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), (int)Math.round(Float.parseFloat(responseCode)));
	}

	
	@Step("Validate response body with expected key:{0}, value:{1}")
	public void validateResponseBody(String expected) {

		System.out.println("hey ya"+expected);
		response.then().assertThat().extract().path("name", expected);
	}
	
}
