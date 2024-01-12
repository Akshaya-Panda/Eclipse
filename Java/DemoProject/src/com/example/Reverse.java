package com.example;
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string you want to reverse: ");
		String str=sc.nextLine();
		String str1="";
		for(int i=0;i<str.length();i++)
		{
			str1=str.charAt(i)+str1;
	
		}
		System.out.println("The reversed string is "+str1);
		sc.close();
		
	}
}
