package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertProcedure 
{
	public static void main(String[] args)
	{
       Scanner sc = new Scanner(System.in);
       try(sc;)
       {
    	   try
    	   {
    		   System.out.println("Enter Employee ID :: ");
    		   String eid = sc.nextLine();
    		   System.out.println("Enter Employee Name :: ");
    		   String ename = sc.nextLine();
    		   System.out.println("Enter Employee Desg :: ");
    		   String edesg = sc.nextLine();
    		   System.out.println("Enter hNo :: ");
    		   String hNo = sc.nextLine();
    		   System.out.println("Enter sName :: ");
    		   String sName = sc.nextLine();
    		   System.out.println("Enter city :: ");
    		   String city = sc.nextLine();
    		   System.out.println("Enter Pincode :: ");
    		   Integer pin = Integer.parseInt(sc.nextLine());
    		   System.out.println("Enter mail Id ::");
    		   String mid = sc.nextLine();
    		   System.out.println("Enter Phone :: ");
    		   Long phno = sc.nextLong();
    		   System.out.println("Enter Basic Sal :; ");
    		   Double sal = sc.nextDouble();
				/*
				 * System.out.println("Enter House rent Allowances :: "); Double hra =
				 * sc.nextDouble(); System.out.println("Enter Daily Allowance :: "); Double da =
				 * sc.nextDouble();
				 */
    		   /*System.out.println("Enter Total Sal :: ");
    		   Double totSal = sc.nextDouble();*/
    		   Double hra = sal*0.4;
    		   Double da = sal*0.3;
    		   Double totSal = sal*12;
    		   //DB Connection
    		   Connection con = DriverManager.getConnection
    				                  ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
    		   //Procedure
    		   CallableStatement cs = con.prepareCall
    				                   ("call pro_emp52(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		   cs.setString(1,eid);
    		   cs.setString(2,ename);
    		   cs.setString(3,edesg);
    		   cs.setString(4,hNo);
    		   cs.setString(5,sName);
    		   cs.setString(6,city);
    		   cs.setInt(7,pin);
    		   cs.setString(8,mid);
    		   cs.setLong(9,phno);
    		   cs.setDouble(10,sal);
    		   cs.setDouble(11,hra);
    		   cs.setDouble(12,da);
    		   cs.setDouble(13,totSal);
    		   
    		   cs.execute();
    		   System.out.println("Procedure Executed Successfully.....");
    		   System.out.println("Employee Data Updated....");
    	   }//try
    	   catch(SQLException se)
    	   {
    		   se.printStackTrace();
    	   }//catch
       }//resource
	}//main
}//class