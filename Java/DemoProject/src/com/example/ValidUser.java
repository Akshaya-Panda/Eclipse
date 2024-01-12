package com.example;

import javax.swing.JOptionPane;
public class ValidUser {
	public static void main(String[] args) {
		//JButton jb=new JButton("Click me");
		String n1=JOptionPane.showInputDialog("Enter a name ");
		
		
		String n2=JOptionPane.showInputDialog("Enter password ");
		//int a =Integer.parseInt(n1);
		//int b =Integer.parseInt(n2);
		if(n1.equalsIgnoreCase("Akshaya") && n2.equals("password"))
		{
			JOptionPane.showMessageDialog(null,"Congratulations!!! Login Succesful");
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Invalid User");
		}
		
	}
	

}

