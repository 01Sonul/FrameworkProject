package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustry {
	
	public static void main(String[]args) throws InterruptedException {
		
		Random ranVal = new Random();
		int random = ranVal.nextInt(1000);
		
		//Step1: Launch Browser
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3: Navigate to Orgs link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4: Click on create Org look up img
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step5: Create Org with mandatory information
		String OrgName = "Infosys" + random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//Step6: Select 'Chemicals' in industry dropdown
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(dropDown);
		sel.selectByValue("Chemicals");
		
		//Step7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step8: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if((orgHeader).contains(OrgName)) {
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
