package ObjetRelationMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class EmpOnDept {

	public static void main(String[] args)throws Exception
	{
	Class.forName("Driver.mysql.cj.jdbc.DriverManager");
	String jdbcurl="jdbc:mysql://localhost:3306/knowit";
	Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
	System.out.println("Connection Established Successfully !!!");
	PreparedStatement ps=con.prepareStatement(jdbcurl);
	ResultSet rs=ps.executeQuery();
	
	Set<Emp>emps=new HashSet();
	while(rs.next())
	{
		Emp e=new Emp();
		e.setEmpno(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setSal(rs.getFloat(3));
		
		emps.add(e);

		
	}
			

	}

}
