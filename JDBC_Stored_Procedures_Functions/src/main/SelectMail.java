package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class SelectMail 
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        try(sc;)
        {
        	try
        	{
        		System.out.println("Enter Employee ID ::");
        		String eid = sc.nextLine();
        		Connection con = DriverManager.getConnection
        				          ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
        		CallableStatement cs = con.prepareCall("{call ?:=FUN_EMP52(?)}");
        		
        		cs.registerOutParameter(1,Types.VARCHAR);
        		cs.setString(2,eid);
        		cs.execute();
        		System.out.println("EID :: "+eid);
        		System.out.println("Mail :: "+cs.getString(1));
        	}//try
        	catch(SQLException se)
        	{
        		se.printStackTrace();
        	}
        }//resource
	}//main
}//class