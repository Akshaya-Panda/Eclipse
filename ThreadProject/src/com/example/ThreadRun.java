package com.example;

public class ThreadRun extends Thread {
	//public static ThreadRun t1;
	//public static ThreadRun t2;
	
	public static void main(String[] args) throws Exception {
		// t1=new ThreadRun();//new born
		 //t2=new ThreadRun();
		ThreadRun rn1=new ThreadRun();
		Thread t1=new Thread(rn1);
		Thread t2=new Thread(rn1);
		
		 t1.start();
		
		 t2.start();
		// System.out.println("Thread1 is  "+t1.isInterrupted());
		
		
	}
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
//			if(i==3)
//			{
//				t1.interrupt();
//			}
			try {
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				//t1.stop();
				
			}
		}
	}
}
