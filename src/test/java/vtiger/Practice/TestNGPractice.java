package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(priority= 0, invocationCount = 1)
	public void createCustomer() {
		System.out.println("created");
	}
	
	@Test(priority= 1, dependsOnMethods = "createCustomer")
	public void modifyCustomer() {
		System.out.println("modified");
	}
	
	@Test(enabled = false)
	public void deleteCustomer() {
		System.out.println("deleted");
	}

}
