package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdateDelete 
{
  public static void main(String[] args) 
  {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("select sno,method from statement");
		//rs.absolute(4);
		rs.moveToInsertRow();
		rs.updateInt(1,4);
		rs.updateString(2,"createStatement");
		rs.insertRow();
		/*rs.updateString(2,"createStatement");
		rs.updateRow();
		rs.deleteRow();*/
		System.out.println("one row inserted Successfully....");
	}//catch 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}//catch 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	}//catch
  }//main
}//class