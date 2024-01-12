package com.comviva.ocs.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.comviva.ocs.bean.DoctorBean;
import com.comviva.ocs.service.Administrator;

public class DoctorDao {
	
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
	
	public static int AddDoc(DoctorBean db)
	{
		int i=0;
		try
		{
			System.out.println(db.getDoctorName());
			ps=con.prepareStatement("insert into ocs_tbl_doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,db.getDoctorID());
			ps.setString(2,db.getDoctorName());
			ps.setString(3,db.getDateOfBirth());
			ps.setString(4,db.getDateOfJoining());
			ps.setString(5,db.getGender());
			ps.setString(6,db.getQualification());
			ps.setString(7,db.getSpecialization());
			ps.setString(8,db.getYearOfExperience());
			ps.setString(9,db.getStreet());
			ps.setString(10,db.getLocation());
			ps.setString(11,db.getCity());
			ps.setString(12,db.getState());
			ps.setString(13,db.getPincode());
			ps.setString(14,db.getContactNumber());
			ps.setString(15,db.getEmailID());
			i= ps.executeUpdate();
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	

	public static int UpdateDoc(DoctorBean db) {
		int i=0;
		try
		{
			ps=con.prepareStatement("update ocs_tbl_doctor set doctorName=?,gender=? where doctorID=?");
			
			ps.setString(1, db.getDoctorName());
			ps.setString(2, db.getGender());
			ps.setString(3,db.getDoctorID());
			i= ps.executeUpdate();
			System.out.println(db.getDoctorID()+" "+db.getDoctorName()+" "+db.getGender());
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}
		return i;
	}
	
	public static int DeleteDoc(DoctorBean db)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("delete from ocs_tbl_doctor where doctorID=?");
			ps.setString(1,db.getDoctorID());
			i=ps.executeUpdate();
			System.out.println(db.getDoctorID());
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static ArrayList<DoctorBean> selectAll(){
		
		ArrayList<DoctorBean> al=new ArrayList<DoctorBean>();
	    try
	    {
	        ps=con.prepareStatement("select * from ocs_tbl_doctor");
	        rs=ps.executeQuery();
	        ArrayList<String> a=new ArrayList<>();
	        ArrayList<String> b=new ArrayList<>();
	        ArrayList<String> c=new ArrayList<>();
	        ArrayList<String> d=new ArrayList<>();
	        
	        while(rs.next())
	        {	
	        	String doctorId = rs.getString("doctorID");
                String doctorName = rs.getString("doctorName");
                String specilization= rs.getString("specialization");
                String yoe= rs.getString("yearsofexperience");
                //String contactNumber= rs.getString("contactNumber");
//                System.out.println(doctorId + "\t\t" + doctorName + "\t\t" + gender);
//                JOptionPane.showMessageDialog(null, doctorId);
//                JOptionPane.showMessageDialog(null, doctorName);
//                JOptionPane.showMessageDialog(null, gender);
                
                
                a.add(doctorId);
                b.add(doctorName);
                c.add(specilization);
                d.add(yoe);
                
	        }
	        
//	        Object[][] rows = {
//	        		{a.get(0),b.get(0),c.get(0)},
//	        	    {a.get(1),b.get(1),c.get(1)}
//	        	};
//	        Object[] cols = {
//	        	    "id","name","gender"
//	        	};
	        
	        JTable table = new JTable();
	        DefaultTableModel dtm=new DefaultTableModel(0,0);
	        
	        String header[] = new String[] {"ID", "Doctor Name", "Specilization","Year of Experience"};
	        dtm.setColumnIdentifiers(header);
	        table.setModel(dtm);
	        
	        for(int i=0; i<a.size(); i++) {
	        	dtm.addRow(new Object[] {a.get(i), b.get(i), c.get(i),d.get(i)});
	        }
	        
	        JOptionPane.showMessageDialog(null, new JScrollPane(table));
	        
	    }
	    catch(SQLException sql)
	    {
	     System.out.println(sql);   
	    }
	    return al;
	}
	
	public static ArrayList<DoctorBean> selectAllslot(String id){
		
		ArrayList<DoctorBean> al=new ArrayList<DoctorBean>();
	    try
	    {
	    	ps=con.prepareStatement("SELECT * FROM ocs_tbl_doctor doc LEFT JOIN ocs_tbl_leave lev ON doc.DOCTORID = lev.DOCTORID WHERE SPECIALIZATION LIKE (SELECT AILMENT_TYPE FROM ocs_tbl_patient WHERE PATIENTID = ?) AND IF(LEAVEFROM IS NULL,TRUE,(SELECT APPOINTMENT_DATE FROM ocs_tbl_patient WHERE PATIENTID = ? ) NOT BETWEEN LEAVEFROM AND LEAVETO)");
//	        ps=con.prepareStatement("select * from ocs.ocs_tbl_doctor where specialization=(select ailment_type from ocs.ocs_tbl_patient where patientid=?)");
	        ps.setString(1,id);
	        ps.setString(2,id);
	        rs=ps.executeQuery();
	        ArrayList<String> a=new ArrayList<>();
	        ArrayList<String> b=new ArrayList<>();
	        ArrayList<String> c=new ArrayList<>();
	        ArrayList<String> d=new ArrayList<>();
	        while(rs.next())
	        {
	        	String doctorId = rs.getString("doctorID");
                String doctorName = rs.getString("doctorName");
                String specialization= rs.getString("specialization");
           System.out.println(doctorId + "\t\t" + doctorName + "\t\t" + specialization+"\t\t");
//                JOptionPane.showMessageDialog(null,doctorId);
//                JOptionPane.showMessageDialog(null,doctorName);
//                JOptionPane.showMessageDialog(null,gender);
           a.add(doctorId);
           b.add(doctorName);
           c.add(specialization);  
                
	        }
	        JTable table = new JTable();
	        DefaultTableModel dtm=new DefaultTableModel(0,0);
	        
	        String header[] = new String[] {"ID", "Name", "specialization"};
	        dtm.setColumnIdentifiers(header);
	        table.setModel(dtm);
	        
	        for(int i=0; i<a.size(); i++) {
	        	dtm.addRow(new Object[] {a.get(i), b.get(i), c.get(i)});
	        }
	        
	        JOptionPane.showMessageDialog(null, new JScrollPane(table));
	        
	    }
	    catch(SQLException sql)
	    {
	     System.out.println(sql);   
	    }
	    return al;
	    
	}
}
