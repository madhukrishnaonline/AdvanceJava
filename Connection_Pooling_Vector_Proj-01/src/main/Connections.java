package main;

import java.sql.Connection;

import test.ConnectionPooling;

public class Connections 
{
	public static void main(String[] args)
	{
        ConnectionPooling cp = new ConnectionPooling
        		               ("jdbc:oracle:thin:@localhost:1521:orcl","username","password");
        cp.createConnections();
        System.out.println("*******User-1*******");
        Connection cn1 = cp.userConnections();
        System.out.println("User-1 at Con "+cn1);
        System.out.println("Size :: "+cp.v.size());
        System.out.println("*******User-2*******");
        Connection cn2 = cp.userConnections();
        System.out.println("User-2 at Con "+cn2);
        System.out.println("Size :: "+cp.v.size());
        cp.returnConnections(cn1);
        System.out.println("Size of Pool "+cp.v.size());
        cp.returnConnections(cn2);
        System.out.println("Size of Pool "+cp.v.size());
        System.out.println("=====Display Connections=====");
        cp.v.forEach(k->
 	    {
 		   System.out.println(k);
 	    });
	}//main
}//class