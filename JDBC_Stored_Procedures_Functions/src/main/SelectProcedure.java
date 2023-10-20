package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class SelectProcedure 
{
	public static void main(String[] args)
	{
      Scanner sc = new Scanner(System.in);
      try(sc;)
      {
    	  try
    	  {
    		  System.out.println("Enter Employee Id :: ");
    		  String eid = sc.nextLine();
    		  
    		  Connection con = DriverManager.getConnection
    				           ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
    		  CallableStatement cs = con.prepareCall
    				               ("call pro_emp52_select(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		  cs.setString(1, eid);
    		  cs.registerOutParameter(2,Types.VARCHAR);
    		  cs.registerOutParameter(3,Types.VARCHAR);
    		  cs.registerOutParameter(4,Types.VARCHAR);
    		  cs.registerOutParameter(5,Types.VARCHAR);
    		  cs.registerOutParameter(6,Types.VARCHAR);
    		  cs.registerOutParameter(7,Types.INTEGER);
    		  cs.registerOutParameter(8,Types.VARCHAR);
    		  cs.registerOutParameter(9,Types.BIGINT);
    		  cs.registerOutParameter(10,Types.FLOAT);
    		  cs.registerOutParameter(11,Types.FLOAT);
    		  cs.registerOutParameter(12,Types.FLOAT);
    		  cs.registerOutParameter(13,Types.FLOAT);
    		  
    		  cs.execute();
    		  
    		  System.out.println("EID :: "+eid);
    		  System.out.println("Ename :: "+cs.getString(2));
    		  System.out.println("Desg :: "+cs.getString(3));
    		  System.out.println("Hno :: "+cs.getString(4));
    		  System.out.println("sName :: "+cs.getString(5));
    		  System.out.println("City :: "+cs.getString(6));
    		  System.out.println("Pioncode :: "+cs.getInt(7));
    		  System.out.println("Mid :: "+cs.getString(8));
    		  System.out.println("Phno :: "+cs.getLong(9));
    		  System.out.println("Bsal :: "+cs.getDouble(10));
    		  System.out.println("Hra :: "+cs.getDouble(11));
    		  System.out.println("DA :: "+cs.getDouble(12));
    		  System.out.println("Total Sal :: "+cs.getDouble(13));
    	  }//try
    	  catch(SQLException se)
    	  {
    		  se.printStackTrace();
    	  }//catch
      }//resource
	}//main
}//class