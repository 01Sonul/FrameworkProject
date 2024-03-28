package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic/reusable Methods related to excel file
 * @author HP
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet & return data to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheet, int rowNum, int cellNum, String value) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheet).createRow(rowNum).createCell(cellNum).setCellValue(value);;
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();

	}
	
	/**
	 * This method will read multiple data from excel for the sheet provider 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException{
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++) {		//navigate through rows
			
			for(int j=0; j<lastCell; j++) {
				
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
