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

public class ExcelReader_my {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
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
			int rowCount = sheet.getPhysicalNumberOfRows();
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
	
	//public static Collection<Object[]> testData() {
	public static Object[][] testData() {
		ExcelReader_my excel = new ExcelReader_my(".//src//test//resources//testdata//data.xlsx");
		
		Object[][] data = new Object[excel.getRowCount("LoginTest")-4][excel.getColumnCount("LoginTest")];
		int i = 0, j = 0;

		int rows = excel.getRowCount("LoginTest");		
		int cols = excel.getColumnCount("LoginTest");
		sheet = workbook.getSheet("LoginTest");
		
		System.out.println(rows+" : "+cols);
		for (i = 1; i < rows; i++) {
			for (j = 0; j <cols; j++) {
				
				if(!isRowEmpty(sheet.getRow(i))) {
					System.out.println("now in row "+ i);
				data[i-1][j] = excel.getCellData("LoginTest", i, j);
				
				System.out.println(i+":"+j+" "+data[i-1][j]+data[i-1][j].getClass().getSimpleName());
				
				}
			}
		}
System.out.println("bobade");
	//	return Arrays.asList(data);
	return data;

		
		
//		Object[][] data = new Object[1][4];
//		 data[0][0] = "a";
//		  data[0][1] = "b";
//		  data[0][2] = "c";
//		  data[0][3] = "d";
//			return data;
		  
//			return Arrays.asList(data);
	}

	private static boolean isRowEmpty(Row row) {
		if (row == null) {
		return true;
		}
		if (row.getLastCellNum() <= 0) {
		return true;
		}
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
		Cell cell = row.getCell(c);
		if (cell != null && cell.getCellType() != CellType.BLANK)
		return false;
		}
		return true;
		}
}
