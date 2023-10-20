package main;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CashedRowSet1 {
	public static void main(String[] args) 
	{
		try (CachedRowSet crs = new OracleCachedRowSet()) {
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("username");
			crs.setPassword("password");
			crs.setCommand("Select*from test");
			crs.execute();
			while (crs.next()) 
			{
				System.out.print(crs.getInt(1) + "\t");
				System.out.println(crs.getString(2));
			} //while
		} //try
		catch (SQLException e) 
		{
			e.printStackTrace();
		} //catch
	}//main
}//class