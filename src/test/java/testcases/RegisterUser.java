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
	
	public RegisterUser(String requestURL, String requestBody, String responseCode, String method) {
		super(requestURL, requestBody, responseCode, method);
	}

	@TestData
	public static Collection<Object[]> TestData() {
		
		ExcelReader_my excel = new ExcelReader_my(".//src//test//resources//testdata//data.xlsx");
		int rows = excel.getFilledRows("RegisterUserTest");
		Object[][] data2 = new Object[1][rows];
		data2 = excel.testData("RegisterUserTest");
		return Arrays.asList(data2);	
	}
	
	@Steps
	TestSteps api;
	
	@Title("Executing registration Test")
	@Test
	public void loginTest() throws Exception {
    
	RestAssured.basePath = requestURL;
	api.sendPostRequestForUsers(requestBody, responseCode);
	api.validateResponseCode(200);
	}
	
}
