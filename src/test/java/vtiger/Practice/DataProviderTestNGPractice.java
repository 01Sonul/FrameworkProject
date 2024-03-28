package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNGPractice {

	@Test(dataProvider = "getData")
	public void addProductToCart(String name, String model, int price) {
		
		System.out.println(name + " - " + model + " - " + price);
	}
	
	@DataProvider
	public Object[][] getData(){
									//4 sets of data with 3 fields
		Object[][] data  = new Object[4][3]; 	//[row][col]
		
		data[0][0] = "Samsung";			//just storing data
		data[0][1] = "A80";
		data[0][2] = 12000;
		
		data[1][0] = "Vivo";
		data[1][1] = "V21";
		data[1][2] = 8000;
		
		data[2][0] = "Iphone";
		data[2][1] = "15";
		data[2][2] = 80000;
		
		data[3][0] = "Oppo";
		data[3][1] = "A80";
		data[3][2] = 15000;
		
		return data;
	}
	
	
	@Test(dataProvider = "getInfo")
	public void addProductToCart2(String name, String model) {
		
		System.out.println(name + " - " + model);
	}
	
	@DataProvider
	public Object[][] getInfo(){
		
	Object[][] data  = new Object[2][2]; 	//[row][col]
		
		data[0][0] = "Nokia";			//just storing data
		data[0][1] = "550";
		
		data[1][0] = "Blueberry";
		data[1][1] = "M30";
		
		return data;
	}
	
}
