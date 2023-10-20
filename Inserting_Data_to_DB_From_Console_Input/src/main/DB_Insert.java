package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB_Insert 
{
	public static void main(String[] args) 
	{
      Scanner sc = new Scanner(System.in);
    	  try
    	  {  
    		  Connection con = DriverManager.getConnection
    				  ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
    		  Statement stmt = con.createStatement();
    		  
    		  System.out.println("Enter Employee Id ::");
    		  String empId = sc.nextLine();
    		  System.out.println("Enter Employee Name ::");
    		  String empName = sc.nextLine();
    		  System.out.println("Enter Employee Designation :: ");
    		  String desg = sc.nextLine();
    		  System.out.println("Enter Employee sal :: ");
    		  int sal = sc.nextInt();
    		  
    		  int k = stmt.executeUpdate
    				("insert into employee values('"+empId+"','"+empName+"','"+desg+"',"+sal+")");
    		  if(k==1)
    		  {
    			  System.out.println("One Record Inserted Successfully....");
    		  }//if
    		  con.close();
    	  }//try
    	  catch(InputMismatchException ime)
    	  {
    		  System.out.println("Enter integer Values only...");
    	  }//catch
    	  catch(SQLIntegrityConstraintViolationException sicve)
    	  {
    		  System.out.println("Data Already Available...\n or Duplicates Not Allowed....");
    	  }
    	  catch(SQLException cnfe)
    	  {
    		  cnfe.printStackTrace();
    	  }
    	  sc.close();
	}//main
}//class