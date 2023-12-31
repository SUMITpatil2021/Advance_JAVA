package PrepareStmnt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpProjection {

	public static void main(String[] args)throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/knowit";
		Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
		System.out.println("Connection Established !!!");
		PreparedStatement p =con.prepareStatement("select * from emp where empno = ?");
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter Employee No : ");
		int empno=Integer.parseInt(br.readLine());
		
		p.setInt(1, empno);
		
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.print("Empno : "+rs.getInt(1)+" \t ");
			System.out.print("Employee Name: "+rs.getString(2)+" \t ");
			System.out.print("Job Role : "+rs.getString(3)+" \t ");
			System.out.print("Salary : "+rs.getFloat(6)+"  \n");
		}
		
		rs.close();
		br.close();
		p.close();
		con.close();
		

	}

}
