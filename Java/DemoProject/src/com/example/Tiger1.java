package com.example;

public class Tiger1 {

//    @Override
//    public void eat() {
//    System.out.println("Eats Insects"); 
//    }
//
//    @Override
//    public void fly() {
//        System.out.println("Flies Fast");
//    }
//public static void main(String[] args) {
//Bird b=new Tiger1();
//b.eat();
//b.fly();
//    Animal1 a=()->{System.out.println("Eats Only Non Veg");};
//a.eat();
//a.walk();
//Animal1.run();
public void tigereat()
{
	System.out.println("Tiger eats only Non veg");
	}
public static void main(String[] args) {
	Tiger1 t =new Tiger1();
	Animal1 a = t::tigereat;
	a.eat();

}
}



