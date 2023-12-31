import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Update {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/knowit";
		Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
		System.out.println("Connection Established !!!");
		Statement stmt=con.createStatement();
		
		//Update query 
		int n=stmt.executeUpdate("update emp set sal=50000 where Empno=5");
		System.out.println(n+" Record  updated Succefully ");
		
		// all objects  must have to be close 
		stmt.close();
		con.close();
		
	}

}
