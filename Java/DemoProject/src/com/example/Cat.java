package com.example;

public class Cat {
	int a,b;
	Cat()
	{
		//this(22,33);
		System.out.println("Cat");
	}
	Cat(int a , int b)
	{	
		this.a=a;
		this.b=b;
		//this("Akshaya");
		System.out.println(this.a+this.b);
	}
	Cat(String name)
	{
		System.out.println(name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cat(22,33);
		//new Cat("Akshaya");
		

	}

}
