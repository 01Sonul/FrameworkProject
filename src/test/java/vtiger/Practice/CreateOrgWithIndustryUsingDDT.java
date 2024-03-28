package vtiger.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDDT {

	public static void main(String[] args) throws Throwable {
		
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		WebDriver driver = null;	//to avoid cte we'll set the driver val to null
		
		//Step1: Read all the data required
		
		/*Read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/*Read data from Excel file*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organizations");
		String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random; 		//coz org names cannot take duplicates thats why random class is being used here
		String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
		
		//Step2: Launch the browser 	-	//Run Time Polymerphism(driver is getting initiallized based on the runtime data from the property file)
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//Step2: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step3: Navigate to Orgs link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4: Click on create Org look up img
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step5: Create Org with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step6: Select 'Chemicals' in industry dropdown
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(dropDown);
		sel.selectByValue(INDUSTRY);
		
		//Step7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if((orgHeader).contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(orgHeader);			
		}
		else {
			System.out.println("FAIL");
		}
		
		//Step9: Logout of App
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step10: Close the browser
		driver.quit();
		   
	}

}
