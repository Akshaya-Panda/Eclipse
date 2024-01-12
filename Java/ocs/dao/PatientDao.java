package com.comviva.ocs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comviva.ocs.bean.PatientBean;;

public class PatientDao {
	
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
	public static int AddPatient(PatientBean db)
	{
		int i=0;
		try
		{
			System.out.println(db.getPatientID());
			ps=con.prepareStatement("insert into ocs_tbl_patient values(?,?,?,?,?,?)");
			ps.setString(1,db.getPatientID());
			ps.setString(2,db.getUserID());
			ps.setString(3,db.getAppointmentDate());
			ps.setString(4,db.getAilementType());
			ps.setString(5,db.getAilementDetails());
			ps.setString(6,db.getDiagnosisHistory());
			
			i= ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	
	public static int UpdatePatient(PatientBean db)
	{
		int i=0;
		try
		{
			System.out.println(db.getPatientID());
			ps=con.prepareStatement("update ocs_tbl_patient set APPOINTMENT_DATE=?,AILMENT_TYPE=?,AILMENT_DETAILS=?,DIAGNOSIS_HISTORY=? where PATIENTID=?");
			ps.setString(5,db.getPatientID());
			ps.setString(1,db.getAppointmentDate());
			ps.setString(2,db.getAilementType());
			ps.setString(3,db.getAilementDetails());
			ps.setString(4,db.getDiagnosisHistory());
			
			i= ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	public static int DeletePatient(PatientBean pb)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("delete from ocs_tbl_patient where patientID=?");
			ps.setString(1,pb.getPatientID());
			i=ps.executeUpdate();
			System.out.println(pb.getPatientID());
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static PatientBean ShowPatient(String pb)
	{	PatientBean ub = new PatientBean();
		try
		{
			ps=con.prepareStatement("select * from ocs_tbl_patient where patientID=?");
			ps.setString(1,pb);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				ub.setPatientID(rs.getString(1));
				ub.setUserID(rs.getString(2));
				ub.setAppointmentDate(rs.getString(3));	
				ub.setAilementType(rs.getString(4));
				ub.setAilementDetails(rs.getString(5));
				ub.setDiagnosisHistory(rs.getString(1));
			}
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return ub;
	}
//	public static String selectAllslot(PatientBean sb1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
