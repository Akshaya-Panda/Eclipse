package com.example;

public class User {
	public int display(int a)
	{
		return a*a;
		
	}
		public static int disp(int a , int b)
		{
			return a*a*a;
		}
	
	public static void main(String[] args) {
//		Calc1 c=(x)->{return(x*x);};
//		System.out.println(c.square(10));
		User u=new User();
		Calc1 c=u::display;
	//	Calc1 c1=User::disp;
		//System.out.println(c1.square1(5,4));
		System.out.println(c.square(3));
	}
	
}
