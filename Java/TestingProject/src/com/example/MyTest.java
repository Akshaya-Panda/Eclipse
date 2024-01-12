package com.example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class MyTest {
    @BeforeClass
    public static void before()
    {
        System.out.println("Before Test1");
    }
@Test
public void test1()
{
    Assert.assertEquals(33, Calc.add(22, 11));
}

@Test
public void test2()
{

    Calc c=new Calc();
    Assert.assertEquals(15, c.sub(27,12));
}
@AfterClass
public static void after()
{
    System.out.println("After Test2");
    
}
}