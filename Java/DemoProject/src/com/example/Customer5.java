package com.example;
interface Vegfood{
	void curdrice();
	void tomatorice();
	void dal();
	void curry();
}

interface Nonvegfood{
	void chicken();
	void mutton();
	void fish();
}


abstract class Hotel  implements Vegfood,Nonvegfood{
	
	 public void curdrice()
	 {
		 System.out.println("Curdrice");
	 }
	 
	 public void tomatorice()
	 {
		 System.out.println("tomatorice");
	 }
	 
	 public void dal()
	 {
		 System.out.println("dal");
	 }
	 public void curry()
	 {
		 System.out.println("Curry");
	 }
	 
	 public void chicken()
	 {
		 System.out.println("Chicken");
	 }
	 public void mutton()
	 {
		 System.out.println("mutton");
	 }
	 public void fish()
	 {
		 System.out.println("fish");
	 }
	 
	 public int billdetails(int amount)
	 {
		 return amount;
	 }

}

public class Customer5 extends Hotel
{
	void customermsg()
	{
		System.out.println("The food  was good");
	}
	
	public static void main(String[] args) {
		Vegfood vf =new Customer5();
		vf.curdrice();
		vf.curry();
		vf.dal();
		vf.tomatorice();
		
		Nonvegfood nvf =new Customer5();
		nvf.chicken();
		nvf.mutton();
		nvf.fish();
	
		Hotel h =new Customer5();
		h.curdrice();
		h.curry();
		h.dal();
		h.tomatorice();
		h.chicken();
		h.mutton();
		h.fish();
		h.billdetails(3000000);
		
		Customer5 c =new Customer5();
		c.curdrice();
		c.curry();
		c.dal();
		c.tomatorice();
		c.chicken();
		c.mutton();
		c.fish();
		c.billdetails(3000000);
		c.customermsg();
	
	}
}
