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
import utilities.ExcelReader;

@Narrative(text={"In order to Run Parameterized test",
		"As a Serenity Runner",
		"We need to Integrate Excel Reading"})
@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(".//src//test//resources//testdata//users.xlsx")
public class Testt {

//	@Steps
//	TestSteps api;

	 private String name;
	 private String job;
//	private String cellData;

	public Testt(String name, String job) {
		this.name = name;
		this.job = job;
	}

//	public Testt(String cellData) {
//		this.cellData = cellData;
//	}

	@TestData
	public static Collection<Object[]> testData() {

		ExcelReader excel = new ExcelReader(".//src//test//resources//testdata//users.xlsx");

		String sheetName = "users";
		int rows = excel.getRowCount(sheetName);
//		System.out.println(rows);
		String cellData = excel.getCellData("users", "name", 2);
		System.out.println("okkk");
	//	System.out.println(cellData);
		
		Object[][] data = new Object[1][1];
		
//		data[0][0] = excel.getCellData(sheetName, 0, 2); 
//		  data[0][1] = excel.getCellData(sheetName, 1, 2);
//		  
//		  
//		  
//		  data[1][0] = excel.getCellData(sheetName, 0, 3); 
//		  data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		data[0][0] = "a";
		data[0][1] = "b";
//		data[1][0] = "c";
//		data[1][1] = "d";
								
		 
		 return Arrays.asList(data);
		//return cellData;
	}

	@Title("Executing Test")
	@Test
	public void temp() {
		// here i should consume testdata
		System.out.println("In Temp method.....");
		System.out.println(name);
		System.out.println(job);
		
	}
}
