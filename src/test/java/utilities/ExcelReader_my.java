package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
//		row = sheet.getRow(0);
//		// finding columname
//		for (int i = 0; i < row.getLastCellNum(); i++) {
//			if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
//				colNum = i;
//			}
//		}

		// System.out.println("cell value is "+ sheet.getRow(1).getCell(0).toString());
		cellData = sheet.getRow(rowNum).getCell(columnNum).toString();
		return cellData;
	}

}
