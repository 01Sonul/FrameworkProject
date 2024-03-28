package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of Generic/reusable Methods related to property file
 * @author HP
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read the data from property file & return the value to caller
	 * @param PropertyFilekey
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String PropertyFilekey) throws Throwable {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String val = p.getProperty(PropertyFilekey);
		return val;
	}
}
