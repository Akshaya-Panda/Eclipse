package com.example;

interface Loan
{
	void intrestRate(int amount);
	
	}

class ICICIBANK implements Loan
{

	@Override
	public void intrestRate(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Amount ");
		
	}
	}

class SBIBANK implements Loan
{

	@Override
	public void intrestRate(int amount) {
		// TODO Auto-generated method stub
		
		
	}
	}
class Customer2 extends ICICIBANK
{
	
	
	}
public class Customer1 extends SBIBANK {
	public static void main(String[] args) {
		
	
	Loan b=new Customer1();
	b.intrestRate(200);

}
}
