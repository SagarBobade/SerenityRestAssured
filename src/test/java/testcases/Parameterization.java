package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import utilities.ExcelReader_my;

@Narrative(text = { "In order to Run Parameterized test", "As a Serenity Runner",
		"We need to Integrate Excel Reading" })
@RunWith(SerenityParameterizedRunner.class)
//@Concurrent(threads = "4")
public class Parameterization {

	private String username;
	private String password;

	public Parameterization(String username, String password) {

		System.out.println("In constructor");
		this.username = username;
		this.password = password;

	}

	@TestData
	public static Collection<Object[]> testData() {
		Object[][] data = new Object[8][2];
		ExcelReader_my excel = new ExcelReader_my(".//src//test//resources//testdata//data.xlsx");
		System.out.println(excel.getRowCount("LoginTest") +" :: "+ excel.getColumnCount("LoginTest"));
		
		
		//Object[][] data = new Object[excel.getRowCount("LoginTest")][excel.getColumnCount("LoginTest")];
		int i = 0, j = 0;
//
		int rows = excel.getRowCount("LoginTest");
//		System.out.println("Rows: "+rows);

		for (i = 0; i < rows; i++) {
			for (j = 0; j < excel.getColumnCount("LoginTest"); j++) {
				//System.out.println(i+" X "+j);
				data[i][j] = excel.getCellData("LoginTest", i, j);
				System.out.println(i+":"+j+" "+data[i][j]);
			}
		}

//		data[0][0] = "a";
//		data[0][1] = "b";
//		data[1][0] = "c";
//		data[1][1] = "d";

		return Arrays.asList(data);
	}

	@Title("Executing Login Test")
	@Test
	public void loginTest() {

		System.out.println("-----START------");
		System.out.println(username);
		System.out.println(password);
		System.out.println("----next iteration----");
	}

}
