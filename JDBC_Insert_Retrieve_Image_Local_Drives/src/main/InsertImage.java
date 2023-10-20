package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertImage 
{
	@SuppressWarnings("removal")
	public static void main(String[] args) throws FileNotFoundException
	{
       Scanner sc = new Scanner(System.in);
       try(sc;)
       {
    	   try
    	   {
    		   Connection con = DriverManager.getConnection
    				                 ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
    		   PreparedStatement pstmt = con.prepareStatement
    				                             ("insert into shootpics2022 values(?,?,?)");
    		   while(true)
    		   {
    			   System.out.println("Enter the Id :: ");
        		   pstmt.setInt(1,new Integer(Integer.parseInt(sc.nextLine())));
        		   
        		   System.out.println("Enter the title :: ");
        		   pstmt.setString(2,new String(sc.nextLine()));
        		   
        		   System.out.println("Enter the FileName|Path(source) :: ");
        		   File f = new File(new String(sc.nextLine()));
        		   
        		   FileInputStream fis = new FileInputStream(f);
        		   pstmt.setBinaryStream(3,fis,f.length());
        		   int k = pstmt.executeUpdate();
        		   if(k>0)
        		   {
        			   System.out.println("Image Inserted Successfully....");
        		   }
    		   }//while
    	   }//try
    	   catch(SQLException | IOException se)
    	   {
    		   se.printStackTrace();
    	   }//catch
       }//resource
	}//main
}//class