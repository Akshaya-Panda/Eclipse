package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTesting {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	
	//Instantiate a chromedriver class
	
	WebDriver driver=new ChromeDriver();
	
	//Launch Website
	
	driver.navigate().to("http://172.19.5.55:4200/");
	
	//Maximize the browser
	
	driver.manage().window().maximize();
	
	 driver.findElement(By.name("eid")).sendKeys("akshay@gmail.com");

     driver.findElement(By.xpath("/html/body/app-root/app-first/div/form/input[2]")).sendKeys("ishanth");
     driver.findElement(By.name("password")).sendKeys("123");
     driver.findElement(By.name("email")).sendKeys("akshay@gmail.com");
     driver.findElement(By.name("city")).sendKeys("Bangalore");
     driver.findElement(By.xpath("/html/body/app-root/app-first/div/form/button")).click();
	
	
	
	
	
	//driver.close();
	
	
	
	
}
}
