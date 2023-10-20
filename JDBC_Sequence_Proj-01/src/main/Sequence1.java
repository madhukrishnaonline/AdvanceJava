package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Sequence1 extends Exception
{
	public Sequence1(String msg)
	{
		super(msg);
	}
	@SuppressWarnings("removal")
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
       try 
       {
    	   //int count=0;
    	 while(true)
    	 {
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
        Statement stmt = con.createStatement();
        System.out.println("Enter Name :: ");
        String name = new String(sc.nextLine());
        System.out.println("Enter the Salary :: ");
        Integer sal = new Integer(Integer.parseInt(sc.nextLine()));
        stmt.execute("insert into test10 values(sq10.nextval"+","+"'"+name+"'"+","+sal+" )");
		System.out.println("Record Inserted Successfully....");
		}//while
	  } //try
       catch (SQLException e) 
       {
		e.printStackTrace();
	   }//catch
       catch(Exception sq1)
       {
    	   System.out.println("Enter Integer Values Only...");
       }//catch
       sc.close();
	}//main
}//Class