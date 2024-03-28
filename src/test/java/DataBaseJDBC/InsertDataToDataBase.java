package DataBaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
																//go to google search for mysql url(universal)
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/christ_info", "root", "root");		//table url, un, pwd
		Statement state = connection.createStatement();
		
		String query = "insert into students_of_christ(first_name, last_name, address)values('Sanghamitra','Jena','Banglore')";
		int result = state.executeUpdate(query);
		
		if(result==1) {
			System.out.println("data updated");
		}
		else {
			System.out.println("data not updated");
		}
			
	}

}
