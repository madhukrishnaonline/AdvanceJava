package main;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JDBCRowSet1 
{
	public static void main(String[] args)
	{
		try
		{
          JdbcRowSet jrs = new OracleJDBCRowSet();
          jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
          jrs.setUsername("username");
          jrs.setPassword("password");
          //System.out.println("Connection Established Successfully....");
          jrs.setCommand("select*from table");
          jrs.execute();
          while(jrs.next())
          {
        	  System.out.print(jrs.getInt("sno")+"\t");
        	  System.out.println(jrs.getString("name"));
          }//while
          jrs.close();
		}//try
		catch(SQLException e)
		{
			e.printStackTrace();
		}//catch
	}//main
}//class