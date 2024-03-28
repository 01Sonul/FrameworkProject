package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		
		
		//Step1: Open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step3: Navigate to required row
		Row rw = sh.getRow(4);
		
		//Step3: Navigate to required cell
		Cell cl = rw.getCell(3);
		
		//Step3: Read the data inside the cell
		String data = cl.getStringCellValue();
		System.out.println(data);
		
		//Step3: Close the WorkBook
		wb.close();

	}

}
