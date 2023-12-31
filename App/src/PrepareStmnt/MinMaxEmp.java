package PrepareStmnt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MinMaxEmp {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/knowit";
		Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
		System.out.println("Connection Established Successfully !!!");
		PreparedStatement ps=con.prepareStatement("select * from emp where sal between ? and ?");
		BufferedReader br=new BufferedReader(new InputStreamReader  (System.in));
		System.out.print("Enter Min salary : \n");
		Float minSal=Float.parseFloat(br.readLine());
		ps.setFloat(1,minSal);
		System.out.print("Enter Max salary : \n");
		Float maxSal=Float.parseFloat(br.readLine());
		ps.setFloat(2, maxSal);
		
		ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				System.out.print("Empno   : "+rs.getInt(1)+"\t");
				System.out.print("Ename   : "+rs.getString(2)+"\t");
				System.out.print("Salary  : "+rs.getFloat(6)+"\n");
			}
		
		rs.close();
		br.close();
		ps.close();
		con.close();
		
		
		

	}

}
