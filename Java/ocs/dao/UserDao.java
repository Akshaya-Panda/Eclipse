package com.comviva.ocs.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comviva.ocs.bean.AppointmentBean;
import com.comviva.ocs.bean.CredentialsBean;
import com.comviva.ocs.bean.PatientBean;
import com.comviva.ocs.bean.UserBean;

public class UserDao{
	
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
	public static int AddUser(UserBean db)
	{
		int i=0;
		try
		{
			System.out.println(db.getUserID());
			ps=con.prepareStatement("insert into ocs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,db.getUserID());
			ps.setString(2,db.getFirstName());
			ps.setString(3,db.getLastName());
			ps.setString(4,db.getDateOfBirth());
			ps.setString(5,db.getGender());
			ps.setString(6,db.getStreet());
			ps.setString(7,db.getLocation());
			ps.setString(8,db.getCity());
			ps.setString(9,db.getState());
			ps.setString(10,db.getPincode());
			ps.setString(11,db.getMobileNumber());
			ps.setString(12,db.getEmailID());
			i= ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	
	public static int UpdateUser(UserBean sb)
	{
		int i=0;
		try
		{
			System.out.println(sb);
			ps=con.prepareStatement("update ocs_tbl_user_profile set FIRSTNAME=?,LASTNAME=?,DOB=?,GENDER=?,STREET=?,LOCATION=?,CITY=?,STATE=?,PINCODE=?,MOBILENO=?,EMAILID=? where USERID =?");
			ps.setString(12,sb.getUserID());
			ps.setString(1,sb.getFirstName());
			ps.setString(2,sb.getLastName());
			ps.setString(3,sb.getDateOfBirth());
			ps.setString(4,sb.getGender());
			ps.setString(5,sb.getStreet());
			ps.setString(6,sb.getLocation());
			ps.setString(7,sb.getCity());
			ps.setString(8,sb.getState());
			ps.setString(9,sb.getPincode());
			ps.setString(10,sb.getMobileNumber());
			ps.setString(11,sb.getEmailID());
			i=ps.executeUpdate();
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static int DeleteUser(UserBean pb)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("delete from ocs_tbl_user_profile where userID=?");
			ps.setString(1,pb.getUserID());
			i=ps.executeUpdate();
			System.out.println(pb.getUserID());
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static UserBean ShowUser(String pb)
	{	UserBean ub = new UserBean();
		try
		{
			ps=con.prepareStatement("select * from ocs_tbl_user_profile where userID=?");
			ps.setString(1,pb);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				ub.setUserID(rs.getString(1));
				ub.setFirstName(rs.getString(2));
				ub.setLastName(rs.getString(3));
				ub.setDateOfBirth(rs.getString(4));
				ub.setGender(rs.getString(5));
				ub.setStreet(rs.getString(6));
				ub.setLocation(rs.getString(7));
				ub.setCity(rs.getString(8));
				ub.setState(rs.getString(9));
				ub.setPincode(rs.getString(10));
				ub.setMobileNumber(rs.getString(11));
				ub.setEmailID(rs.getString(12));	
			}
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return ub;
	}

	public static int loginUser(CredentialsBean lu) {
		int i=0;
		try
		{
			ps=con.prepareStatement("select * from ocs_tbl_user_credentials where userid=? AND password=? AND usertype=?");
			ps.setString(1,lu.getUserid());
			ps.setString(2,lu.getPassword());
			ps.setString(3,lu.getUsertype());
			rs=ps.executeQuery();
			
	        if(rs.next()) {

	              i=1; 
	        }
			//System.out.println(pb.getUserID());
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	public static int registerUser(CredentialsBean ru) {
		int i=0;
		try
		{
			ps=con.prepareStatement("insert into ocs_tbl_user_credentials values(?,?,?)");
			ps.setString(1,ru.getUserid());
			ps.setString(2,ru.getPassword());
			ps.setString(3,ru.getUsertype());
			i= ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	public static String appointmentDoc(AppointmentBean ab) {
		// TODO Auto-generated method stub
		String i=ab.getAppointmentID();
		try
		{
			ps=con.prepareStatement("insert into ocs_tbl_appointments values(?,?,?,?,?)");
			ps.setString(1,ab.getAppointmentID());
			ps.setString(2,ab.getDoctorID());
			ps.setString(3,ab.getPatientID());
			ps.setString(4,ab.getAppointmentDate());
			ps.setString(5,ab.getAppointmentTime());
			ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	
	
	
	

}
