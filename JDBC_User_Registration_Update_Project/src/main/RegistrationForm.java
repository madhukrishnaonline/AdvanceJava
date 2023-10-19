package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class RegistrationForm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "username",
						"password");
				//Registration Process || inserting users records
				PreparedStatement pstmt1 = con.prepareStatement("insert into UserRegistration values(?,?,?,?,?,?)");
				//Login Process || select Query
				PreparedStatement pstmt2 = con
						.prepareStatement("select*from userregistration where uname=? and pword=?");
				//Filtering Query
				PreparedStatement pstmt3 = con.prepareStatement("select*from userregistration where pword=?");
				//Edit Address || Updating Profile
				PreparedStatement pstmt4 = con.prepareStatement("update userregistration set addr=? where pword=?");
				//Edit mailId || Updating Profile
				PreparedStatement pstmt5 = con.prepareStatement("update userregistration set mail=? where pword=?");
				//Edit Phone || Updating Profile
				PreparedStatement pstmt6 = con.prepareStatement("update userregistration set phone=? where pword=?");
				while (true) {
					System.out.println("=====Register or Login=====");
					System.out.println("1.Register\n2.Login\n3.Exit");
					switch (Integer.parseInt(sc.nextLine())) {
					case 1:
						System.out.println("*****User Registration*****");
						System.out.println("Enter UserName :: ");
						String uname = sc.nextLine();
						System.out.println("Enter Password :; ");
						String pword = sc.nextLine();
						System.out.println("Enter FullName :: ");
						String fname = sc.nextLine();
						System.out.println("Enter Address :; ");
						String addr = sc.nextLine();
						System.out.println("Enter MailId :: ");
						String mail = sc.nextLine();
						if (mail.endsWith("@gmail.com")) {
							System.out.println("Enter PhoneNo :: ");
							String phone = sc.nextLine();
							int len = phone.length();
							if (len == 10) {
								pstmt1.setString(1, uname);
								pstmt1.setString(2, pword);
								pstmt1.setString(3, fname);
								pstmt1.setString(4, addr);
								pstmt1.setString(5, mail);
								pstmt1.setString(6, phone);

								int k = pstmt1.executeUpdate();
								if (k > 0) {
									System.out.println("Registration Successfull....");
								} //if
							} //if
							else {
								System.out.println("Invalid Mobile No....");
							} //else
						} //if
						else {
							System.out.println("Invalid Email");
						} //else
						break;
					case 2:
						System.out.println("*****User Login*****");
						System.out.println("Enter UserName :: ");
						String uname2 = sc.nextLine();
						System.out.println("Enter Password :: ");
						String pword2 = sc.nextLine();
						pstmt2.setString(1, uname2);
						pstmt2.setString(2, pword2);
						ResultSet rs = pstmt2.executeQuery();
						if (rs.next()) {
							System.out.println("Login Successfull......");
							System.out.println("1.View Profile\n2.Update Profile\n3.View Details\n4.LogOut");
							switch (Integer.parseInt(sc.nextLine())) {
							case 1:
								System.out.println("Welcome " + rs.getString("uname"));
								continue;
							case 2:
								System.out.println("Select the Detauls to Update :: ");
								System.out.println("1.Address\n2.MailId\n3.Phone No\n4.Exit");
								switch (Integer.parseInt(sc.nextLine())) {
								case 1:
									System.out.println("Enter Password :: ");
									String pword3 = sc.nextLine();
									pstmt3.setString(1, pword3);
									ResultSet rs2 = pstmt3.executeQuery();
									if (rs2.next()) {
										System.out.println("Old Address :: " + rs2.getString("addr"));
										System.out.println("Enter new Address :: ");
										String addr2 = sc.nextLine();
										pstmt4.setString(1, addr2);
										pstmt4.setString(2, pword3);
										int n = pstmt4.executeUpdate();
										if (n > 0) {
											System.out.println("Address Updated Successfully....");
										} //if
									} //if
									else {
										System.out.println("Invalid Password....");
									} //else
									continue;
								case 2:
									System.out.println("Enter Password :: ");
									String pword4 = sc.nextLine();
									pstmt3.setString(1, pword4);
									ResultSet rs3 = pstmt3.executeQuery();
									if (rs3.next()) {
										System.out.println("Old mailId :: " + rs3.getString("mail"));
										System.out.println("Enter New MailId :; ");
										String mail2 = sc.nextLine();
										pstmt5.setString(1, mail2);
										int m = pstmt5.executeUpdate();
										if (m > 0) {
											System.out.println("MailId Updated Successfully....");
										} //if
									} //if
									else {
										System.out.println("Invalid Password.....");
									} //else
									continue;
								case 3:
									System.out.println("Enter Password :: ");
									String pword5 = sc.nextLine();
									pstmt3.setString(1, pword5);
									ResultSet rs4 = pstmt3.executeQuery();
									if (rs4.next()) {
										System.out.println("Old Phone No. :: " + rs4.getString("phone"));
										System.out.println("Enter New Phone No. :; ");
										String phone = sc.nextLine();
										pstmt6.setString(1, phone);
										int m = pstmt6.executeUpdate();
										if (m > 0) {
											System.out.println("Phone No. Updated Successfully....");
										} //if
									} //if
									else {
										System.out.println("Invalid Password.....");
									} //else
									continue;
								case 5:
									System.exit(0);
									break;
								default:
									System.out.println("Something Went Wrong....");
								}//inner switch2
								break;
							case 3:
								System.out.println("Enter Password :: ");
								String pword6 = sc.nextLine();
								pstmt3.setString(1, pword6);
								ResultSet rs5 = pstmt3.executeQuery();
								ResultSetMetaData rsmd = rs5.getMetaData();
								int s = rsmd.getColumnCount();
								for (int i = 1; i <= s; i++) {
									System.out.print(rsmd.getColumnName(i) + "            \t");
								} //for
								System.out.println(" ");
								while (rs5.next()) {
									System.out.println(rs5.getString("uname") + "\t" + rs5.getString("pword") + "\t"
											+ rs5.getString("fullname") + "\t" + rs5.getString("addr") + "\t"
											+ rs5.getString("mail") + "\t" + rs5.getString("phone"));
								} //while
								continue;
							case 4:
								System.out.println("User Logged Out....");
								System.exit(0);
								break;
							default:
								System.out.println("Something Went Wrong....");
								continue;
							}//inner switch1
						} //if
						else {
							System.out.println("Invalid Username/password....");
						} //else
						break;
					case 3:
						System.out.println("Program Terminated");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice");
					}//Outer switch
				} //while
			} //try
			catch (SQLIntegrityConstraintViolationException icve) {
				System.out.println("Data Already Available.... or\n Duplicate Data not Allowed....");
			} catch (SQLException sql) {
				sql.printStackTrace();
			} //catch
		} //resource
	}//main
}//class