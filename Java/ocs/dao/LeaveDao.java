package com.comviva.ocs.dao;

import java.sql.*;

import java.util.*;

import com.comviva.ocs.bean.LeaveBean;

public class LeaveDao {
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
	public static int unavailableDoc(LeaveBean lb)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("insert into ocs_tbl_leave values(?,?,?,?,?,?)");
			ps.setString(1,lb.getLeaveID());
			ps.setString(2,lb.getDoctorID());
			ps.setString(3,lb.getLeaveFrom());
			ps.setString(4,lb.getLeaveTo());
			ps.setString(5,lb.getReason());
			ps.setInt(6,lb.getStatus());
			i= ps.executeUpdate();
			//System.out.println(lb.getLeaveID());
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
}
