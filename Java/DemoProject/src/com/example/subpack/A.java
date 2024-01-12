package com.example.subpack;

import com.example.Calc;

public class A {
public static void main(String[] args) {
    Calc c=new Calc();
    Calc.add(11,10);
    c.sub(33,5);
    System.out.println(c.mul(22, 2));
}
}