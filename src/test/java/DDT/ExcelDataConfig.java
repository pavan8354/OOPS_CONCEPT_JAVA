package DDT;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String excelpath) {
		
		File src = new File(excelpath);
		try {
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
		
		public String getData(int sheetNumber , int row , int column) {			
			sheet1 = wb.getSheetAt(0);		
			String data = sheet1.getRow(row).getCell(column).getStringCellValue();		
			return data;	
		}
		
		public int getrowcount(int sheetIndex)		
		{		
			int row = wb.getSheetAt(sheetIndex).getLastRowNum();
			row = row+1;
			return row;		
	}
		
}
