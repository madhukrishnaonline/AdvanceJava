package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetenhance {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "username",
					"password");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("Select *from emp");
			rs.absolute(4);
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getInt(4) + "\t");
			System.out.print(rs.getDate(5) + "\t");
			System.out.print(rs.getInt(6) + "\t");
			System.out.print(rs.getInt(7) + "\t");
			System.out.print(rs.getInt(8));
		} //try
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //catch
	}//main
}//class