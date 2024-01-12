package com.comviva.ui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.comviva.bean.EmployeeBean;
import com.comviva.dao.EmployeeDao;


public class Main {
public static void main(String[] args) throws SQLException {
   int eid=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID"));
   // String ename=JOptionPane.showInputDialog("Enter Employee Name");
    //int esal=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Salary"));
   EmployeeBean eb=new EmployeeBean();
   eb.setEid(eid);
    //eb.setEname(ename);
    //eb.setEsal(esal);
    //EmployeeDao.addEmployee(eb);
    //JOptionPane.showMessageDialog(null, EmployeeDao.retrieveEmployee(eb)+" record inserted successfully...");
//EmployeeDao.deleteEmployee(eb);   
//    System.out.println(EmployeeDao.retrieveEmployee(eb));
	
//	ResultSet r=EmployeeDao.selectAll();    
//	String str="";
//	try
//	{
//	while(r.next())
//	{
//	str+=r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+"\n";   
//	}
//	}
//	catch(SQLException sql)
//	{
//	    
//	}
//	JOptionPane.showMessageDialog(null, str);

	//JOptionPane.showMessageDialog(null, EmployeeDao.retrieveEmployee(eid)+" record inserted successfully...");
	
	ResultSet r=EmployeeDao.retrieveEmployee(eb);    
	String str="";
	
	
	if(r.next())
	{
	str+=r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+"\n";   
	}
	
	JOptionPane.showMessageDialog(null,str);

}

}

