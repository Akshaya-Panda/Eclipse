package com.example;

public class ThreadDemo extends Thread {
	public static void main(String[] args) {
		ThreadDemo t1=new ThreadDemo();
		t1.start();
		
		
	}
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}