package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public TestConnection() {
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/knowit";
		Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
		System.out.println("Connection Established !!!");
	}

}
