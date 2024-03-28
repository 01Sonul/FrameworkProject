package practice;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncryptDecrypt {

	public static void main(String[] args) {
		
		String encryptedUsername = new String(Base64.getEncoder().encode("admin".getBytes()));
		String encryptedPassword = new String(Base64.getEncoder().encode("admin".getBytes()));
		
		System.out.println(encryptedUsername);
		System.out.println(encryptedPassword);
		
		String decryptedUsername = new String(Base64.getDecoder().decode(encryptedUsername.getBytes()));
		String decryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword.getBytes()));
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(decryptedUsername);
		driver.findElement(By.name("user_password")).sendKeys(decryptedPassword);
		driver.findElement(By.id("submitButton")).click();

		driver.quit();
		
	}
}
