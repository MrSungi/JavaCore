package com.ignas.mavendemo;

public class Calculator {
    public int add(int a, int b) {


        if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE ){
            throw new ArithmeticException("Can't add two MAX_VALUES");
        }

        if(a == Integer.MAX_VALUE && b > 0 ){
            throw new ArithmeticException("Can't add possitive numbers to int.MAX_VALUE");
        }


        return a + b;
    }
////////////////////////////////////////////////////////////////////////////////
    public int divide(int a, int b) {

        if(a == 0 || b == 0) {
            throw new ArithmeticException("Division by zero is not possible");
        }
        return a / b;
    }


///////////////////////////////////////////////////////////////////////////////////
    public int minus(int a, int b) {

        if(a == Integer.MIN_VALUE && b > 0){
            throw new ArithmeticException("Can't subtract a positive number from int.MIN_VALUE");
        }

        if(Integer.valueOf(a) == null || Integer.valueOf(b) == null){
            throw new NullPointerException("no initialization of number");
        }

        return a - b;
    }

}
