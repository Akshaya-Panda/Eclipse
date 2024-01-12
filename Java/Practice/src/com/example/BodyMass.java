package com.example;

import java.util.Scanner;

import com.example.bean.BodyMassBean;


public class BodyMass {
public static void main(String[] args) {
	BodyMassBean b =new BodyMassBean();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your height: ");
	b.setHeight(sc.nextDouble());
	System.out.println("Enter your weight: ");
	b.setWeight(sc.nextDouble());
	System.out.println("BMI is "+(b.getWeight()/(b.getHeight()*b.getHeight())) );
	
	
}
}
