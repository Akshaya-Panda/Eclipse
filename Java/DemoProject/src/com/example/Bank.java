package com.example;

public class Bank {
	static int amount=2000;
	public static void main(String[] args) {
		Bank b1=new Bank();
		Bank b2=new Bank();
		b1.amount+=3000;
		System.out.println("Fisrt object "+b1.amount);
		System.out.println("Second object "+b2.amount);
		System.out.println("Class level "+Bank.amount);
	}

}
	