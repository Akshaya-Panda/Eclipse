package com.example;

public class Dog {
	int legs=4;//Instance variable
	void eat()//Instance method	
	{
		System.out.println("Eats Bones");
	}
	public class Cat{
		
	}
	
public static void main(String[] args) {
	Dog d =new Dog();
	d.eat();
	System.out.println("Dog has "+ d.legs +" legs");
}
}
