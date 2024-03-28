package DataBaseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/christ_info", "root", "root");		//table url, un, pwd
		Statement state = connection.createStatement();
		String query = "Select * from students_of_christ";
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		connection.close();
		
	}

}
