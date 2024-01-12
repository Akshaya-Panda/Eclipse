package com.comviva.dao;
import java.sql.*;

import com.comviva.bean.EmployeeBean;
public class EmployeeDao {
	public static Connection con=getInstance();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Connection getInstance()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin12");
			System.out.println("Connected successfully...");
	    }
	    catch(ClassNotFoundException cnf)
	    {
	        System.out.println(cnf);
	    }
	    catch(SQLException sql)
	    {
	        System.out.println(sql);
	    }
	    return con;
	}

	public static int addEmployee(EmployeeBean eb)
	{
	int i=0;    

	    try
	    {
	    ps=con.prepareStatement("insert into emp222 values(?,?,?)");
	    ps.setInt(1,eb.getEid());
	    ps.setString(2, eb.getEname());
	    ps.setInt(3, eb.getEsal());
	    
	     i=ps.executeUpdate();
	    }
	    catch(SQLException sql)
	    {
	        
	    }
	    return i;
	}
	

public static int updateEmployee(EmployeeBean eb)
{
int i=0;    

    try
    {
    ps=con.prepareStatement("update emp222 set salary=? where name=?");
    //ps.setInt(1,eb.getEid());
    ps.setString(2, eb.getEname());
    ps.setInt(1, eb.getEsal());
    
     i=ps.executeUpdate();
    }
    catch(SQLException sql)
    {
        
    }
    return i;
}


public static int deleteEmployee(EmployeeBean eb)
{
int i=0;    

    try
    {
    ps=con.prepareStatement("delete from emp222 where salary=?");
   // ps.setInt(1,eb.getEid());
   // ps.setString(2, eb.getEname());
    ps.setInt(1, eb.getEsal());
    
     i=ps.executeUpdate();
    }
    catch(SQLException sql)
    {
        
    }
    return i;
}

public static ResultSet retrieveEmployee(EmployeeBean eb)
{
//String i="";    

    try
    {
//    ps=con.prepareStatement("select * from emp222 where salary=?");
////    ps.setInt(1,eb.getEid());
////    ps.setString(2, eb.getEname());
    ps=con.prepareStatement("select * from emp222 where id=?");
    ps.setInt(1, eb.getEid());
    rs=ps.executeQuery();
//    if(rs.next())
//    {
//        i+=rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3);
//    }
    }
    catch(SQLException sql)
    {
        
    }
    return rs;
}

public static ResultSet selectAll()
{
    try
    {
        ps=con.prepareStatement("select * from emp222");
        rs=ps.executeQuery();
    }
    catch(SQLException sql)
    {
        
    }
    return rs;
}


}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class CreateTable {
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/rentaldb";
//        String user = "root";
//        String password = "password";
//
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            String createTableSql = "CREATE TABLE IF NOT EXISTS rental ( " +
//                    "rental_id INT PRIMARY KEY, " +
//                    "rental_customerid INT, " +
//                    "rental_staffid INT, " +
//                    "rental_rentaldate DATE NOT NULL, " +
//                    "rental_returneddate DATE, " +
//                    "rental_pricecode INT, " +
//                    "FOREIGN KEY (rental_customerid) REFERENCES customer(customer_id), " +
//                    "FOREIGN KEY (rental_staffid) REFERENCES staff(staff_id), " +
//                    "FOREIGN KEY (rental_pricecode) REFERENCES price(price_code) " +
//                    ")";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
//            preparedStatement.execute();
//            System.out.println("Table created successfully.");
//        } catch (SQLException e) {
//            System.out.println("Error occurred while creating the table: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}





