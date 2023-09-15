package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: navigate to Sheet
		Sheet sh = wb.createSheet("Trial");
		
		//Step 4: navigate to Row //QCO-SOEAJD-M2-Shobha
		Row rw = sh.createRow(2);
		
		//Step 5: create a cell
		Cell cl = rw.createCell(3);
		
		//Step 6: provide Data to be written
		cl.setCellValue("SELENIUM");
		
		//Step 7: open document in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: write the data
		wb.write(fos);
		System.out.println("Data added successfully");
		
		//Step 9: close 
		wb.close();
		
	}

}
