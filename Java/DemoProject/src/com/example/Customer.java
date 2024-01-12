package com.example;


class  Bank1  {
	double balance=0.0;
	private double amount=0;
	
	void deposit(double amount)
	{
		double newbalance=balance+amount;
		balance=newbalance;
		System.out.println("Money deposited successfully, the amount deposited is "+balance);
	}
	
	void setAmount(double amount)
	{
		this.amount=amount;
	}
	
	double checkBalance()
	{
		return amount;
	}
}
	public class Customer extends Bank1
	{
		void withdraw(double amount)
		 { 
		  if( balance<5000)
		  { 
		   System.out.println("Insufficient Funds...Withdraw canot be sucessfull"); 
		  }

		  if(balance-amount<=0)
		  {
		   System.out.println("Please deposit some money in the account because withdraw is not possible");
		  }
	
		else {
		   double newbalance = balance -amount;
		   balance=newbalance;
		   System.out.println("Withdraw Sucessfull");
		   if(balance<5000)
		    System.out.println("Insufficient Funds...Withdraw canot be sucessfull");
		  }
		 
		 }
		
		void check_Balance()
		{
			  System.out.println("Balance is: " + balance);
			}
		
		
		void change_pin()
		{
			System.out.println("u have changed ur pin : ");
			
			System.out.println("your pin is "+ this.hashCode());
		}
		
		public static void main(String[] args) {
			Customer c=new Customer();
			c.deposit(45000.0);
			c.check_Balance();
			//c.withdraw(10000.0);
			c.check_Balance();
			c.change_pin();
			
		}

}

