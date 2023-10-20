package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Date;
import java.util.Scanner;

public class MkBank 
{
	public static void main(String[] args) 
	{
       Scanner sc = new Scanner(System.in);
       try(sc;)
       {
    	   try
    	   {
    		   Connection con = DriverManager.getConnection
                              ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
    		   //Select Query
    		   PreparedStatement pstmt1 = con.prepareStatement
    				                          ("select*from mkBank where AccNo=?");
    		   //Update Query
    		   PreparedStatement pstmt2 = con.prepareStatement
    			("update mkBank set set amt=amt+?,DepositDate+=?,depositedamount+=? where AccNo=?");
				/*
				 * //Date PreparedStatement pstmt3 = con.prepareStatement
				 * ("update mkBank  where AccNo=?"); //DipositedAmount PreparedStatement pstmt4
				 * = con.prepareStatement ("update mkbank set  where");
				 */
    		   con.setAutoCommit(false);
    		   Savepoint sp = con.setSavepoint();
    		   System.out.println("Enter HomeAccount No ::");
    		   Long hAccNo = sc.nextLong();
    		   pstmt1.setLong(1, hAccNo);
    		   ResultSet rs1 = pstmt1.executeQuery();
    		   if(rs1.next())
    		   {
    			   Float amount = rs1.getFloat(3);
    			   System.out.println("Enter bAccNo :: ");
    			   Long bAccNo = sc.nextLong();
    			   pstmt1.setLong(1, bAccNo);
    			   ResultSet rs2 = pstmt1.executeQuery();
    			   if(rs2.next())
    			   {
    				   System.out.println("Enter the Amount to be Transfer :: ");
    				   Float amt = sc.nextFloat();
    				   if(amt<=amount)
    				   {
    					   pstmt2.setFloat(1,-amt);
    					   pstmt2.setDate(2,(java.sql.Date) new Date());
    					   pstmt2.setFloat(3,amt);
    					   pstmt2.setLong(4,hAccNo);
                           int i = pstmt2.executeUpdate();
                           
                           pstmt2.setFloat(1,amt);
                           pstmt2.setDate(2,(java.sql.Date) new Date());
    					   pstmt2.setFloat(3,amt);
                           pstmt2.setLong(4,bAccNo);
                           int j = pstmt2.executeUpdate();
                           
                           if(i==1 && j==1)
                           {
                        	   System.out.println("Transaction Successfull.....");
                        	   con.commit();
                           }//if
                           else
                           {
                        	   System.out.println("Transaction Failed .....");
                        	   con.rollback(sp);
                           }//else
    				   }//if
    				   else
    				   {
    					   System.out.println("Insufficient Amount.....");
    				   }//else
    			   }//if
    			   else
    			   {
    				   System.out.println("Invalid bAccNo.....");
    			   }//else
    		   }//if
    		   else
    		   {
    			   System.out.println("Invalid AccNo....");
    		   }//else
    	   }//try
    	   catch(SQLException se)
    	   {
    		   se.printStackTrace();
    	   }//catch
       }//resource
	}//main
}//class