package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSet1 
{
  public static void main(String[] args) 
  {
	try (WebRowSet wrs = new OracleWebRowSet()) {
		wrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		wrs.setUsername("username");
		wrs.setPassword("password");
		wrs.setCommand("select*from table order by sno");
		wrs.execute();
		FileOutputStream fos = new FileOutputStream("table.xml");
		wrs.writeXml(fos);
	}//catch 
	catch (SQLException e) {
		e.printStackTrace();
	}//catch
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}//catch
	catch (IOException e) {
		e.printStackTrace();
	}//catch
  }//main
}//class