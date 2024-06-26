package vtiger.Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String val = pUtil.readDataFromPropertyFile("browser");
		System.out.println(val);
		
		String un = pUtil.readDataFromPropertyFile("username");
		System.out.println(un);
		
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println(data);
		
		eUtil.writeDataIntoExcel("TrialNow", 5, 3, "HarryPotter");
		System.out.println("Data Added");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
	}

}
