//package testcases;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import net.serenitybdd.junit.runners.SerenityRunner;
//import net.thucydides.core.annotations.Steps;
//import net.thucydides.core.annotations.Title;
//import steps.TestSteps;
//
// 
//@RunWith(SerenityRunner.class)
//public class DeleteUserTestCase extends BaseTest {
//
//	@Steps
//	TestSteps api;
//	
//	@Title("Deleting user")
//	@Test
//	public void deleteUser() {
//		
//		api.sendDeleteRequestForUsers("2");
//		api.validateResponseCode(204);
//	}
//	
//	
//}