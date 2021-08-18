package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.thucydides.junit.annotations.TestData;

public class ExcelReader_my {

	public String path; 
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public XSSFCell cell = null;
	private static int kk = 0;

	public ExcelReader_my(String path) {
		this.path = path;

		try {
			fis = new FileInputStream(path);

			workbook = new XSSFWorkbook(fis);

		//	fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);

		if (index == -1) {

			return 0;
		} else {
			int rowCount = sheet.getPhysicalNumberOfRows();

			return rowCount + 1;
		}
	}

	public int getColumnCount(String sheetName) {
		int colCount = 0;
		colCount = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		return colCount;
	}

	public String getCellData(String sheetName, int rowNum, int columnNum) {
		String cellData = null;

		sheet = workbook.getSheet(sheetName);

		cellData = sheet.getRow(rowNum).getCell(columnNum).toString();

		return cellData;
	}

	// public static Collection<Object[]> testData() {
	public static Object[][] testData(String sheetName) {
		ExcelReader_my excel = new ExcelReader_my(".//src//test//resources//testdata//data.xlsx");
		sheet = workbook.getSheet(sheetName);
		// Object[][] data = new Object[excel.getRowCount(sheetName) -
		// 5][excel.getColumnCount(sheetName)];
		System.out.println("in test data fun: "+sheetName);
		kk = getFilledRows(sheet.getSheetName());
		System.out.println("initially kk is: " + kk);
		Object[][] data = new Object[kk-1][excel.getColumnCount(sheetName)];
		int i = 0, j = 0;

		int rows = kk;
		int cols = excel.getColumnCount(sheetName);
		sheet = workbook.getSheet(sheetName);

		System.out.println(sheetName + rows + " : " + cols);
		for (i = 1; i < rows; i++) {
			for (j = 0; j < cols; j++) {

				if (!isRowEmpty(sheet.getRow(i))) {

					data[i - 1][j] = excel.getCellData(sheetName, i, j);
					System.out.println(i + ":" + j + " " + data[i - 1][j] + data[i - 1][j]);
				//	System.out.println(i + ":" + j + " " + data[i - 1][j] + data[i - 1][j].getClass().getSimpleName());
				}
			}
		}
		System.out.println("bobade");
		
		// return Arrays.asList(data);
		return data;
	}

	public static int getFilledRows(String sheet2) {
		int i = 0;
		System.out.println("in fun2");
		XSSFSheet currentSheet = workbook.getSheet(sheet2);
		System.out.println("a bc");
		try {
		while (currentSheet.getRow(i).getCell(i).getCellType() != CellType.BLANK) {
			i++;
			System.out.println("in while");
		}
		}catch(Exception e) {
			System.out.println("i is: " + i);			
		}
		return i;
	}

	private static boolean isRowEmpty(Row row) {

		if (row == null) {
			return true;
		}
		if (row.getLastCellNum() <= 0) {
			return true;
		}
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			kk++;
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != CellType.BLANK)
				return false;
		}
		System.out.println("rows are: " + kk);
		return true;
	}

}
