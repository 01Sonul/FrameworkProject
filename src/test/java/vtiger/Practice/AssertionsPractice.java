package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void test() {
		
		System.out.println("Hi started");
		Assert.assertEquals("a", "b");
		
		System.out.println("Hello Im here");	
		
	}
	
	@Test
	public void test2() {
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		sa.assertEquals(1,2);
		System.out.println("Step 2");	
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		sa.assertAll();
		
	}

}
