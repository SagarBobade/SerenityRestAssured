package testcases;

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
import utilities.ExcelReader;

@Narrative(text={"In order to Run Parameterized test",
		"As a Serenity Runner",
		"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(".//src//test//resources//testdata//users.xlsx")
public class CreateUserTestCase extends BaseTest {

	@Steps
	TestSteps api;

	// private String name;
	// private String job;
	private int rows;

//	public CreateUserTestCase(String name, String job) {
//		this.name = name;
//		this.job = job;
//	}

	public CreateUserTestCase(int rows) {
		this.rows = rows;
	}

	@TestData
	public static int testData() {

		ExcelReader excel = new ExcelReader(".//src//test//resources//testdata//users.xlsx");

		String sheetName = "users";
		int rows = excel.getRowCount(sheetName);
		System.out.println(rows);
		String cellData = excel.getCellData("users", "name", "2");
		System.out.println("okkk");
		System.out.println(cellData);
		return rows;
	}

	@Title("Executing Test")
	@Test
	public void temp() {
		// here i should consume testdata
		System.out.println("Hi.....");
		System.out.println(rows);
	}
}
