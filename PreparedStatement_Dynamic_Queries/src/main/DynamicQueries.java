package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicQueries {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "username", "password");
			/*PreparedStatement pstmt = con.prepareStatement("insert into Statement values(?,?)");
			System.out.println("Enter Sno :: ");
			pstmt.setInt(1, new Integer(Integer.parseInt(sc.nextLine())));
			System.out.println("Enter the Value for Method :: ");
			pstmt.setString(2, new String(sc.nextLine()));
			pstmt.executeUpdate();
			System.out.println("One Record Inserted Successfully.....");*/
			PreparedStatement pstmt2 = con.prepareStatement("Select ename,job from emp where empno=?");
			System.out.println("Select *from emp where sno =___");
			pstmt2.setInt(1, new Integer(sc.nextInt()));
			ResultSet rs = pstmt2.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.println(rs.getString("job"));
			} //while
		} //if 
		catch (SQLException e) {
			e.printStackTrace();
		} //catch
		sc.close();
	}//main
}//class