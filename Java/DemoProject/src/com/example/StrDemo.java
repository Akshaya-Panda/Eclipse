package com.example;

public class StrDemo {
	public static void main(String[] args) {
		String str1="Welcome";
		String str2=new String("Welcome");
		String str3=new String("Welcome");
		String str4=str2;
		String str5="A";
	    str1.concat("Java Programming");
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1==str2);
		System.out.println(str2==str3);
		System.out.println(str4==str1);
		System.out.println(str5.hashCode());
		System.out.println(str1.toUpperCase());
		System.out.println(str1);
		System.out.println(str1.charAt(0));
		System.out.println(str1.replace('c', 'x'));
		System.out.println(str1.length());
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3,6));
		System.out.println(str1.substring(str1.length()-1));
		StringBuffer sb=new StringBuffer(str1);
		sb.append(" to java").append("programming");
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb);
		
		StringBuilder sb1=new StringBuilder(str1);
		sb.append(" to java").append("programming");
		System.out.println(sb1);
		System.out.println(sb1.reverse());
		System.out.println(sb1);
		
		String s=sb.reverse().toString();
		System.out.println(s);
		String s1=String.valueOf(sb.reverse());
		System.out.println(s1);
		
		
	}

}
