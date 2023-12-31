import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Projection {

	public static void main(String[] args) throws Exception
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl="jdbc:mysql://localhost:3306/knowit";
			Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
			System.out.println("Connection Established !!!");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp ");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t \n");				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			
			
		
	}

}
