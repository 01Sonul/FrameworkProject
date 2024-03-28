package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@Test
	public void test() {
		System.out.println("TEST");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AFTER CLASS");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BEFORE METHOD");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AFTER METHOD");
	}
	
	
	
}
