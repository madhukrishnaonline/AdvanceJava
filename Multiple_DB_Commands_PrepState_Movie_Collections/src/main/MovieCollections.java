package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class MovieCollections
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
				   //insert operation
				   PreparedStatement pstmt1 = con.prepareStatement
						     ("insert into  values(?,?,?,?,?,?,?)");
				   //select operation
				   PreparedStatement pstmt2 = con.prepareStatement("select*from movieCollections");
				   //selectBy Movie name
				   PreparedStatement pstmt3 = con.prepareStatement
						              ("select*from moviecollections where movie=?");
				   //Update Record
				   PreparedStatement pstmt4 = con.prepareStatement
						  ("update moviecollections set rating=?,boxoffice=boxoffice+? where movie=?");
				   //delete Record
				   PreparedStatement pstmt5 = con.prepareStatement
						              ("delete from moviecollections where movie=?");
				   while(true)
				   {
					   System.out.println("*****Select the Operation***** ");
					   System.out.println
					   ("\t1.Insert Record \n\t2.View Data\n\t3.SelectByMovieName\n\t4.Update record(rating,boxoffice)"
					   		+ "\n\t5.delete record\n\t6.Terminate Operation");
					   switch(Integer.parseInt(sc.nextLine()))
					   {
					   case 1:
						   System.out.println("Enter Movie Name :: ");
						   String mv = sc.nextLine();
						   System.out.println("Enter Actor's Name :: ");
						   String actor = sc.nextLine();
						   System.out.println("Enter Actress Name :: ");
						   String actress = sc.nextLine();
						   System.out.println("Enter Director's Name :: ");
						   String director = sc.nextLine();
						   System.out.println("Enter the Genere :: ");
						   String gener = sc.nextLine();
						   System.out.println("Enter Rating :: ");
						   String rating = sc.nextLine();
						   System.out.println("Enter BoxOffice Collections :: ");
						   Long collection = Long.parseLong(sc.nextLine());
						   //setting Data Setter Methods
						   pstmt1.setString(1, mv);
						   pstmt1.setString(2, actor);
						   pstmt1.setString(3, actress);
						   pstmt1.setString(4, director);
						   pstmt1.setString(5, gener);
						   pstmt1.setString(6, rating);
						   pstmt1.setLong(7,collection);
						   
						   int k = pstmt1.executeUpdate();
						   if(k==1)
						   {
							   System.out.println("One Record Inserted Successfully....");
						   }
						   break;
					   case 2:
						   ResultSet rs = pstmt2.executeQuery();
						   ResultSetMetaData rsmd = rs.getMetaData();
						   System.out.println("*****Movie Collections*****");
							   int n = rsmd.getColumnCount();
							   for(int i=1;i<=n;i++)
							   {
								   System.out.print(rsmd.getColumnName(i)+"        \t");
							   }//for
							   System.out.println(" \n");
							   while(rs.next())
							   {
								   System.out.println
								   (rs.getString("movie")+"\t "+rs.getString("Actor")+"\t"+rs.getString("actress")
								   +"\t"+rs.getString("director")+" \t"+rs.getString("gener")+"      \t"+rs.getString("rating")
								   +"      \t"+rs.getLong("Boxoffice"));
							   }//while
								/*
								 * }//if else { System.out.println("\nNo Movies Available...."); }//else
								 */			
							   break;
					   case 3:
						   System.out.println("Enter Movie Name :: ");
						   String movie1 = sc.nextLine();
						   pstmt3.setString(1, movie1);
						   ResultSet rs1 = pstmt3.executeQuery();
						   if(rs1.next())
						   {
							   System.out.println
							   (rs1.getString("movie")+"\t "+rs1.getString("Actor")+"\t"+rs1.getString("actress")
							   +"\t"+rs1.getString("director")+" \t"+rs1.getString("gener")+"\t"+rs1.getString("rating")
							   +"\t"+rs1.getLong("Boxoffice"));
						   }
						   else
						   {
							   System.out.println("Movie Not Found....");
						   }
						   break;
					   case 4:
						   System.out.println("Enter the Movie Name :: ");
						   String movie = sc.nextLine();
						   pstmt3.setString(1, movie);
						   ResultSet rs2 = pstmt3.executeQuery();
						   if(rs2.next())
						   {
							   System.out.println("Old Rating :: "+rs2.getString("rating"));
							   System.out.println("Enter new Rating :: ");
							   String rating2 = sc.nextLine();
							   System.out.println("Old Collections :: "+rs2.getLong("boxoffice"));
							   System.out.println("Enter new Collections :: ");
							   Long boxoffice = Long.parseLong(sc.nextLine());
							   
							   pstmt4.setString(1, rating2);
							   pstmt4.setLong(2, boxoffice);
							   pstmt4.setString(3, movie);
							   
							   int k2 = pstmt4.executeUpdate();
							   if(k2>0)
							   {
								   System.out.println("One Record Updated");
							   }
						   }
						   else
						   {
							   System.out.println("Movie Not Found....");
						   }
						   break;
					   case 5:
						   System.out.println("Enter Movie Name :: ");
						   String movie2 = sc.nextLine();
						   pstmt3.setString(1, movie2);
						   ResultSet rs3 = pstmt3.executeQuery();
						   if(rs3.next())
						   {
							   pstmt5.setString(1, movie2);
							   int d = pstmt5.executeUpdate();
							   if(d>0)
							   {
								   System.out.println("One Record Deleted...");
							   }
						   }
						   else
						   {
							   System.out.println("No Results Found....");
						   }
						   break;
					   case 6:
						   System.out.println("Operations Terminated....");
						   System.exit(0);
						   break;
					   default:
						   System.out.println("Invalid Option.....");
						   break;
					   }//switch
				   }//while
			   }//try
			   catch(SQLException se)
			   {
				   se.printStackTrace();
			   }//catch
		   }//try-resource
	}//main
}//class