package vtiger.Practice;

import java.io.FileInputStream;
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

		
		//Step1: Open the doc in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Navigate to Sheet
		Sheet sh = wb.createSheet("Trail");
		
		//Step4: Navigate to Row
		Row rw = sh.createRow(4);
		
		//Step5: Create a cell
		Cell cl = rw.createCell(5);
		
		//Step6: Provide data to be written
		cl.setCellValue("Selenium");
		
		//Step7: Open the doc in java writable format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step8:Write the data
		wb.write(fos);
		System.out.println("Data added successfully");
		//Step9:close the workbook
		wb.close();
		

	}

}
