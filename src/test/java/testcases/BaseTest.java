package testcases;

import io.restassured.RestAssured;

public class BaseTest {


	protected String requestURL;
	protected String requestBody;
	protected String responseCode;
	protected String method;
	
	public BaseTest(String requestURL, String requestBody, String responseCode, String method) {
		this.requestURL = requestURL;
		this.requestBody = requestBody;
		this.responseCode = responseCode;
		this.method = method;
		
		RestAssured.baseURI= "https://reqres.in";
		
	}
	
//	
//	@BeforeClass
//	public static void inIt() {
//		
//		System.out.println("In before class tag in Base Test");
//		RestAssured.baseURI= "https://reqres.in";
//		//RestAssured.basePath= "";
//	}
}
