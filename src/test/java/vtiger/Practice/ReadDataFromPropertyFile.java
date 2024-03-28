package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		
		//Step 1: Open the document in Java readable format from java.io package
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Object of properties class from java.util package
		Properties p = new Properties();
		
		//Step 3: Load the doc into properties class
		p.load(fis);
		
		//Step 4: Provide the key & read the value
		String BROWSER = p.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME = p.getProperty("username"); 
		System.out.println(USERNAME);
		
		System.out.println("hi");
	}

}
