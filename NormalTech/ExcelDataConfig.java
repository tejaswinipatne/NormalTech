package Create_Campaign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.xslf.usermodel.XSLFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataConfig {
	//org.apache.poi.xssf.usermodel.XSSFWorkbook wb;
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataConfig(String excelpath) {

		try {
			File src = new File(excelpath);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
	public String getData(int sheetnumber, int row, int col) {

		sheet1 = wb.getSheetAt(sheetnumber);

		String data = sheet1.getRow(row).getCell(col).getStringCellValue();

		return data;

	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;

	}
	
	
	
//	public int getcolcount(int sheetIndex) {
//		int col = wb.getSheetAt(sheetIndex).getDefaultColumnWidth();
//		col = col + 1;
//		return col;
//
//	}
	

}
