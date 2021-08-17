package testcases;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

	
	@BeforeClass
	public static void inIt() {
		
		System.out.println("In before class tag in Base Test");
		RestAssured.baseURI= "https://reqres.in";
		//RestAssured.basePath= "";
	}
}
