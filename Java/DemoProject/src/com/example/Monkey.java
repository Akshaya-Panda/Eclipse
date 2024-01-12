package com.example;

 interface Animal {
	public abstract void eat();
	public void run();
	

}

 class Tiger implements Animal
{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eats only non veg");
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runs fast");
		
	}
}
	
	public class Monkey extends Tiger  implements Animal
	{

		@Override
		public void eat() {
			super.eat();
			System.out.println("hii");
			
		}

		@Override
		public void run() {
			super.run();
			// TODO Auto-generated method stub
			System.out.println("bye");
			
		}
		
		public static void main(String[] args) {
			Monkey m=new Monkey();
			m.eat();
			m.run();
		}
		
	}
	
	
	

