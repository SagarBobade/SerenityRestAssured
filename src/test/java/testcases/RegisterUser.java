package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import steps.TestSteps;
import utilities.ExcelReader_my;

@Narrative(text={"In order to Run Parameterized test",
		"As a Serenity Runner",
		"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)

public class RegisterUser extends BaseTest {

	private String requestURL;
	private String requestBody;
	private String responseCode;
	private String method;
	
	public RegisterUser(String requestURL, String requestBody, String responseCode, String method) {
		this.requestURL = requestURL;
		this.requestBody = requestBody;
		this.responseCode = responseCode;
		this.method = method;
		
	}
	
	
	@TestData
	public static Collection<Object[]> TestData() {
		
		Object[][] data = new Object[1][4];
//		 data[0][0] = "a";
//		  data[0][1] = "b";
//		  data[0][2] = "c";
//		  data[0][3] = "d";
//		  
//			return Arrays.asList(data);
    	 Object[][] data2 = new Object[1][4];
		 data2 = ExcelReader_my.testData("RegisterUserTest");
    	System.out.println("after regi user get data");
		 return Arrays.asList(data2);	
	}
	
	@Steps
	TestSteps api;
	
	@Title("Executing Login Test")
	@Test
	public void loginTest() throws Exception {
		
		System.out.println("sasg "+requestURL);
//		System.out.println(requestURL+"\n"+requestBody+"\n"+responseCode+"\n"+method);
		RestAssured.basePath = requestURL;
	api.sendPostRequestForUsers(requestBody, responseCode);
	api.validateResponseCode(200);
	}
	
}
