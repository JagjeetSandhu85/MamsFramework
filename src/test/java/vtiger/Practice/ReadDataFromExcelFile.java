package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	
	public static void main(String[] args) throws Throwable {
		
		//Step1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step 4: Navigate to required row
		Row rw = sh.getRow(4);
		
		//Step 5: Navigate to required cell
		Cell cl = rw.getCell(3);
		
		//Step 6: read the data inside the cell
		String data = cl.getStringCellValue();
		System.out.println(data);
		
		//Step 7: close the workbook
		wb.close();
		
	}

}
