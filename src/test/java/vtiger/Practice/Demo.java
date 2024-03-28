package vtiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	 public static void main(String[] args) {
		
		//only if webdriver manager is used to download driver executables
		//WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		GenericMethodPractice.add(20,50);
		
		
		driver.quit();
	}

}
