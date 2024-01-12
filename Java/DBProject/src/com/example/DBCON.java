package com.example;
import java.sql.*;

public class DBCON {
public static void main(String[] args) throws Exception {
	String url="jdbc:mysql://localhost:3306/demo";
	String username="root";
	String password="admin12";
	Class.forName( "com.mysql.cj.jdbc.Driver"); //Registering and loading database driver
	Connection con = DriverManager.getConnection(url, username, password);
	System.out.println("connection established");
	Statement st = con.createStatement(); //Initialize the statement
    //st.execute("create table emp222(id int,name varchar(20),salary int)");
//    st.executeUpdate("insert into emp222 values(101,'Arjun',34000)");
//    st.executeUpdate("insert into emp222 values(102,'Kavin',36000)");
//    st.executeUpdate("insert into emp222 values(103,'Mukund',37000)");
    ResultSet rs= st.executeQuery("select id,salary from emp222");
    ResultSetMetaData rsMetaData = rs.getMetaData();
    DatabaseMetaData dbmd=con.getMetaData();
    System.out.println(dbmd.getDatabaseProductName());
    System.out.println(dbmd.getDatabaseMajorVersion());
    System.out.println(dbmd.getDatabaseMinorVersion());
    System.out.println(dbmd.getUserName());
    System.out.println(dbmd.getURL());
    System.out.println(dbmd.getDriverName());
    int count = rsMetaData.getColumnCount();
    for(int j=1;j<=count;j++)
	{
	System.out.print(rsMetaData.getColumnName(j)+" ");
	}
    System.out.println();
    while(rs.next())
    {
    		for(int j=1;j<=count;j++)
    		{
    	
    		System.out.print(rs.getString(j)+" ");
    		
    }
    		System.out.println();
    		}
}


}
