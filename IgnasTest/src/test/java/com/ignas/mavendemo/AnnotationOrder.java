package com.ignas.mavendemo;

import org.junit.*;

public class AnnotationOrder {

    @BeforeClass
    public static void bc(){
        System.out.println("@BeforeClass");
    }

    @Before
    public void b1(){
        System.out.println("@Before");
    }

    @Test
    public void t1(){
        System.out.println("@Test1");
    }

    @Test
    public void t2(){
        System.out.println("@Test2");
    }

    @Test
    public void t3(){
        System.out.println("@Test3");
    }

    @After
    public void a1(){
        System.out.println("@After");
    }

    @AfterClass
    public static void ac(){
        System.out.println("@AfterClass");
    }

}
