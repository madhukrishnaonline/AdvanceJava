package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPooling 
{
	String DBUrl,user,pword;
   public ConnectionPooling(String DBUrl, String user, String pword)
   {
	   this.DBUrl = DBUrl;
	   this.user = user;
	   this.pword = pword;
   }//constructor
   public Vector<Connection> v = new Vector<Connection>();
   public void createConnections()
   {
	   try
	   {
		   while(v.size()<5)
		   {
			   System.out.println("Connection is not full...");
		      Connection con = DriverManager.getConnection(DBUrl,user,pword);
		      v.add(con);
		      System.out.println(con);
		   }//while
		   if(v.size()==5)
		   {
			   System.out.println("Conection is full.....");
		   }//if
	   }//try
	   catch(SQLException se)
	   {
		   se.printStackTrace();
	   }//catch
   }//method
   public Connection userConnections()
   {
	   Connection con = v.elementAt(0);
	   v.removeElementAt(0);
	   return con;
   }//method
   public void returnConnections(Connection con)
   {
	   v.addElement(con);
	   System.out.println("Connections Added back to pool....");
   }
}//class