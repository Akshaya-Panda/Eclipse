package com.comviva.ocs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ocsDao {
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Connection getCon()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ocs","root","RaMa#210289");
//		System.out.println("Database Connected");
	}catch(ClassNotFoundException cnf) {
		System.out.println(cnf);
	}
	catch(SQLException sql) {
		System.out.println(sql);
	}
		
		return con;
}

	public static void main(String[] args) {
		System.out.println("connected");

	}

}
