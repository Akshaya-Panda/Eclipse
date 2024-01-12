package com.example;
import javax.swing.*;
public class First {
	public static void main(String[] args) {
		//JButton jb=new JButton("Click me");
		int n1=Integer.parseInt(JOptionPane.showInputDialog("Enter a number "));
		int n2=Integer.parseInt(JOptionPane.showInputDialog("Enter another number "));
		//int a =Integer.parseInt(n1);
		//int b =Integer.parseInt(n2);
		JOptionPane.showMessageDialog(null,"The addition of  "+n1+" and "+n2+" is "+(n1+n2));
	}
	

}
