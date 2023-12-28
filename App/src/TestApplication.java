import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApplication {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl="jdbc:mysql://localhost:3306/knowit";
			Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
			System.out.println("Connection Established succesfully");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Not Registered");
		}
		catch(SQLException e)
		{
			System.out.println("Connection failed ");
		}
	}
 dss
}
