package com.example;
import java.util.Scanner;
public class RepeatedCharacters {

	public static void main(String[] args) {
		int count[]=new int[256];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String: ");
		String str=sc.nextLine();
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
		char ch[] = new char[str.length()];
		for(int i=0;i<str.length();i++)
		{
		    ch[i]= str.charAt(i);
			int flag=0;
			for(int j =0;j<=i;j++)
			{
				if(str.charAt(i)==ch[j])
					flag++;
			}
			
		
		if(flag==1)
			System.out.println("Number of occurences of "+str.charAt(i)+" is"+count[str.charAt(i)]);
		sc.close();
		}
	}
}
