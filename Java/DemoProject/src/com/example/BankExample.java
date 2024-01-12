package com.example;
public class BankExample {
int amount=2000;

void withdraw(int amount)
{
    if(this.amount>=amount)
    {
        System.out.println(amount+" withdrawn successfully...");
        this.amount-=amount;
    }
    else
    {
        System.out.println("Insufficient amount");
    }
}
void balance()
{
    System.out.println("Account Balance is "+amount);
   
}

void deposit(int amount)
{
	this.amount+=amount;
	System.out.println("Amount deposited is "+amount);
}
public static void main(String[] args) {
    BankExample b=new BankExample();
    b.deposit(400);
    b.balance();
    b.withdraw(500);
    b.balance();
    b.deposit(400);
    b.balance();
    
}
}