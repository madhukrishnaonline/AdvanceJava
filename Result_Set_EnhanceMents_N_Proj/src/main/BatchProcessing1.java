package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessing1 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "java17", "java17");
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into test values(6,'f')");
			stmt.addBatch("Delete from statement");
			stmt.executeBatch();
			System.out.println("Updates are Excecuted...");
		} //try
		catch (Exception e)
		{
			e.printStackTrace();
		} //catch
	}//main
}//class