package CallableStatements;
import java.sql.Connection;

import java.sql.CallableStatement;

import java.sql.DriverManager;
import java.sql.Types;

public class EmpDisplay {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/knowit";
		Connection con=DriverManager.getConnection(jdbcurl,"root","sumit");
		System.out.println("Connection Established !!!");
		
		CallableStatement cs=con.prepareCall("{call dispEmp(?)}");
		cs.registerOutParameter(1, Types.INTEGER);
//		cs.registerOutParameter(2, Types.VARCHAR);
//		cs.registerOutParameter(3, Types.VARCHAR);
//		cs.registerOutParameter(4, Types.DECIMAL);
		
		cs.execute();
		int eno=cs.getInt(1);
		String ename=cs.getNString(2);
		String job=cs.getString(3);
		Float sal=cs.getFloat(4);
		
		System.out.print("EmpNo    : "+eno+"\t");
		System.out.print("Name     : "+ename+"\t");
		System.out.print("Job Role : "+"\t");
		System.out.print("Salary   : "+sal+"\t\n");
	}

}
