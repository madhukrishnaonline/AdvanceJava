package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrieveImage 
{
	@SuppressWarnings("removal")
	public static void main(String[] args)
	{
		 Scanner sc = new Scanner(System.in);
	       try(sc;)
	       {
	         try
	         {
	        	 Connection con = DriverManager.getConnection
		                             ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
                 PreparedStatement pstmt = con.prepareStatement
                		                      ("select*from shootpics where sno=?");
                 System.out.println("Enter the Id :: ");
                 pstmt.setInt(1,new Integer(Integer.parseInt(sc.nextLine())));
                 ResultSet rs = pstmt.executeQuery();
                 if(rs.next())
                 {
                	 Blob b = rs.getBlob(2);
                	 byte[] by = b.getBytes(1,(int)b.length());
                	 System.out.println("Enter FileName|Path(Destination) :: ");
                	 FileOutputStream fos = new FileOutputStream(new String(sc.nextLine()));
                	 fos.write(by);
                	 System.out.println("Image Retrieved Successfully....");
                 }//if
                 else
                 {
                	 System.out.println("Invalid Id :: ");
                 }
	         }//try
	         catch(SQLException se)
	         {
	        	 se.printStackTrace();
	         }//catch
             catch (FileNotFoundException e) 
	         {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }//resource
	}//main
}//class