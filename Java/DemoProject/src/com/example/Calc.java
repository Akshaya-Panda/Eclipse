package com.example;

public class Calc {
public static void add(int x,int y)
{
    System.out.println("The addition of "+x+" and "+y+" is "+(x+y));
}
public void sub(int x,int y)
{
    System.out.println("The subtraction of "+x+" and "+y+" is "+(x-y));
}
public int mul(int x,int y)
{
    return(x*y);
}
public static void main(String[] args) {
    Calc c=new Calc();
    Calc.add(22, 5);
    c.sub(33,7);
    int mul=c.mul(33,3);
    System.out.println(mul);
}
}