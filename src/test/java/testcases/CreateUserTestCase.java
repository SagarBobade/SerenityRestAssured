package testcases;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import steps.TestSteps;
import utilities.ExcelReader_my;



@Narrative(text={"In order to Run Parameterized test",
				"As a Serenity Runner",
				"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "4")
public class CreateUserTestCase extends BaseTest{

	
	private String requestURL;
	private String requestBody;
	private String responseCode;
	private String method;
	
	public CreateUserTestCase(String requestURL, String requestBody, String responseCode, String method) {
		System.out.println("in constructor");
		this.requestURL = requestURL;
		this.requestBody = requestBody;
		this.responseCode = responseCode;
		this.method = method;
		
	}
	
	@TestData
	public static Collection<Object[]> testData() {
	
		Object[][] data = new Object[1][4];
//		 data[0][0] = "a";
//		  data[0][1] = "b";
//		  data[0][2] = "c";
//		  data[0][3] = "d";
//		  
//			return Arrays.asList(data);
     	 Object[][] data2 = new Object[1][4];
		 data2 = ExcelReader_my.testData();
     	 System.out.println("sagar");
		 return Arrays.asList(data2);
	}
	

	@Steps
	TestSteps api;
	
	@Title("Executing Login Test")
	@Test
	public void loginTest() throws Exception {
		
//		System.out.println("sag");
//		System.out.println(requestURL+"\n"+requestBody+"\n"+responseCode+"\n"+method);
		api.sendPostRequestForUsers(requestURL, requestBody, responseCode, method);
	}

	
	
}
