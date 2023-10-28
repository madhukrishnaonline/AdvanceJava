package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user", "password");
			Statement stmt = con.createStatement();
			//stmt.execute("Create table Statement(sno int,name varchar2(20))");
			//stmt.execute("truncate table statement");
			//stmt.execute("flashback table statemtnt to before drop");
			//System.out.println("Table truncated Successfully.....");
			//stmt.executeUpdate("insert into statement(sno,method)values(2,'executeQuery')");
			//System.out.println("Record Inserted Succesfuuly....");
			//stmt.executeUpdate("alter table Statement add Constructors varchar2(20)");
			//System.out.println("Table Altered...");
			//stmt.executeUpdate("update statement set method='execute' where sno=1");
			//System.out.println("Record Updated Successfully....");
			ResultSet rs = stmt.executeQuery("Select*from Statement");
			ResultSetMetaData rsm = rs.getMetaData();
			int cc = rsm.getColumnCount();
			for (int i = 1; i <= cc; i++) {
				System.out.print(rsm.getColumnName(i) + "\t");
			} //for
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t");
				System.out.println(rs.getString(2) + "\n\t");
			} //while
		} //try 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} //catch 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //catch
	}//main
}//class