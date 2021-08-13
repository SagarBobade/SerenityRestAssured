package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import steps.TestSteps;
import utilities.ExcelReader_my;

@Narrative(text={"In order to Run Parameterized test",
		"As a Serenity Runner",
		"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
public class CreateUserTestCase extends BaseTest {

	@Steps
	TestSteps api;

	private String name;
	private String job;

	public CreateUserTestCase(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@TestData
	public static Collection<Object[]> testData() {
		
		 return ExcelReader_my.testData();
	}

	
	@Title("Executing Test")
	@Test
	public void temp() {
		
		api.sendPostRequestForUsers(name, job);
	}
}
