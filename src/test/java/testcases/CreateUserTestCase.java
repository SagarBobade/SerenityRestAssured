package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import steps.TestSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("/home/sagarb/eclipse-workspace/SerenityRestAssured/src/test/java/testdata/users.csv")
public class CreateUserTestCase extends BaseTest {
	
	@Steps
	TestSteps api;
	
	private String name;
	private String job;
	

	public void setName(String name) {
		this.name = name;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Title("Creating user")
	@Test
	public void deleteUser() {
		
		api.sendPostRequestForUsers(name, job);
		//api.validateResponseCode(201);
	}

}
