package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of re usable methods related to excel file
 * @author Chaitra M
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet and return the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param celNo
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName, int rowNum, int celNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNo).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * This method will write data into Excel Sheet 
	 * @param sheet
	 * @param rowNum
	 * @param celNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheet, int rowNum, int celNum, String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(rowNum).createCell(celNum).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();		
	}
	
	
	/**
	 * This method will read multiple Data from excel file for the sheet provided
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++) // navigate thru Rows 3 - 0 1
		{
			for(int j=0;j<lastCel;j++)
			{                        //1 - 0, 2 - 0
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
