package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import steps.API;
import utilities.ExcelReader_my;

@Narrative(text = { "In order to Run Parameterized test", "As a Serenity Runner",
		"We need to Integrate Excel Reading" })
@RunWith(SerenityParameterizedRunner.class)
public class CreateUserTestCase extends BaseTest {

	public CreateUserTestCase(String requestURL, String requestBody, String responseCode, String method) {
		super(requestURL, requestBody, responseCode, method);
	} 

	@TestData
	public static Collection<Object[]> testData() {
		
		ExcelReader_my excel = new ExcelReader_my();
		int rows = excel.getFilledRows("CreateUserTest");
		Object[][] data2 = new Object[1][rows];
		data2 = excel.testData("CreateUserTest");
		return Arrays.asList(data2);	
	}

	@Steps
	API api;

	@Title("Executing Create User Test")
	@Test
	public void createUserTestCase() throws Exception {	
		RestAssured.basePath = requestURL;
		api.sendPostRequest(requestBody, responseCode);
		api.validateResponseCode(responseCode);
	}

}
