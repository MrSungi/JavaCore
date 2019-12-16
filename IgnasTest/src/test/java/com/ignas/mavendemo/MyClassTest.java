package com.ignas.mavendemo;

import org.junit.Test;

public class MyClassTest {
    // public static void main(String[] args) {
    //    String input = "Hello World";
    //    String result = MyClass.myMethod(input);
    //
    //    if (input.equals(result))
    //        System.out.println("SUCCESS");
    //    else
    //        System.out.println("FAILURE");
    // }

    @Test
    public void simpleTest(){
        //given
        String input = "Hello World";

        //when
        String result = MyClass.myMethod(input);

        //then
        assert  result.equals(input);

        //teardowon (not needed in this case, but needed in general)
        input = null;
    }

    @Test
    public void simpleFailingTest2(){
        //given
        String input = "Hello World";

        //when
        String result = MyClass.myMethod(input);

        //then
        assert  result.equals(input + "A");

        //teardowon (not needed in this case, but needed in general)
        input = null;
    }


}
