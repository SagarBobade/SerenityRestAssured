package testcases;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

	
	@BeforeClass
	public static void inIt() {
		
		RestAssured.baseURI= "https://reqres.in";
		RestAssured.basePath= "/api/users?page=2";
	}
}
