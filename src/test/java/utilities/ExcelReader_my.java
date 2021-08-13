package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.thucydides.junit.annotations.TestData;

public class ExcelReader_my {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelReader_my(String path) {
		this.path = path;

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			int rowCount = sheet.getLastRowNum();
			return rowCount+1;
		}
	}

	public int getColumnCount(String sheetName) {
		int colCount = 0;
		colCount = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		return colCount;
	}

	public String getCellData(String sheetName, int rowNum, int columnNum) {
		String cellData = null;
		int colNum = -1;

		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		cellData = sheet.getRow(rowNum).getCell(columnNum).toString();
		return cellData;
	}
	
	public static Collection<Object[]> testData() {
		ExcelReader_my excel = new ExcelReader_my(".//src//test//resources//testdata//data.xlsx");
		
		Object[][] data = new Object[excel.getRowCount("LoginTest")-1][excel.getColumnCount("LoginTest")];
		int i = 0, j = 0;

		int rows = excel.getRowCount("LoginTest");		
		int cols = excel.getColumnCount("LoginTest");

		for (i = 1; i < rows; i++) {
			for (j = 0; j <cols; j++) {
				data[i-1][j] = excel.getCellData("LoginTest", i, j);
				System.out.println(i+":"+j+" "+data[i-1][j]);
			}
		}

		return Arrays.asList(data);
	}


}
