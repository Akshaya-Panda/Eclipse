package com.example;

interface Product
{
	int watch_price=10000;
	int mobile_price=20000;
	void display();
	}
 class Flipkart implements Product
 {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("The products available in flipkart are "+ Product.watch_price +"and "+ Product.mobile_price);
		
	}
	 
 }
 
 class Amazon implements Product
 {

	@Override
	public void display() {
		
		// TODO Auto-generated method stub
		System.out.println("The products available in Amazon are "+ Product.watch_price +"and "+ Product.mobile_price);
		
	}
	 
	
 }
 
 class Customer4 extends Flipkart
 {
	 void purchase()
	 {
		 super.display();
		 System.out.println("purchased both the products from flipkart");
	 }
 }
 
 
public class Customer3 extends Amazon {
	 void purchase()
	 {
		 super.display();
		 System.out.println("purchased both the products from Amazon");
	 }
	public static void main(String[] args) {
		Product p=new Customer3();
		p.display();
		
		
	}

}
