package com.ignas.mavendemo;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setUp(){
        System.out.println("setUp()");
        calc = new Calculator();
    }

    @After
    public void tearDown(){
        System.out.println("tearDown()");
        calc = null;
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_twoPositiveIntegers_correctPositiveSum() {
        // given
        int firstNum = 1;
        int secondNum = 2;

        // when
        int result = calc.add(firstNum, secondNum);

        // then
        assertEquals("Variables are equal? ", 3, result);
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_givenTwoNegativeIntegers_correctNegativeSum(){
        // given, when
        int result = calc.add(-1, -2);

        // then
        // assert result == -3;
        assertEquals(-3, result);
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_givenOneNegativeOnePossitive_correctSum(){
        // given
        int firstNum = -1;
        int secondNum = 2;

        // when
        int result = calc.add(firstNum, secondNum);

        // then
        // assert result == 1;
        assertEquals(1, result);
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_integerMaxAndZero_outputsIntegerMax(){
        // given
        int firstNum = Integer.MAX_VALUE;
        int secondNum = 0;

        // when
        int result = calc.add(firstNum, secondNum);

        // then
        assert result == firstNum;
    }

    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_integerMinAndZero_outputsIntegerMin() {
        // given
        int firstNum = Integer.MIN_VALUE;
        int secondNum = 0;

        // when
        int result = calc.add(firstNum, secondNum);

        // then
        assert result == firstNum;
    }

    @Test
    public void minus_integerMinAndZero_outputsIntegerMin(){


        //given
        int firstNum = Integer.MIN_VALUE;
        int secondNum = 0;

        //when
        int result = calc.minus(firstNum, secondNum);

        //then
        assertEquals("Variables are nor equal.. ", firstNum, result);

    }

    @Test
    public void minus_integerMaxAndZero_outputsIntegerMax(){


        //given
        int firstNum = Integer.MAX_VALUE;
        int secondNum = 0;

        //when
        int result = calc.minus(firstNum, secondNum);

        //then
        assertEquals("Variables are nor equal.. ", firstNum, result);

    }

    @Test
    public void minus_twoPositiveIntegers_outputsCorrectSubtraction(){


        //given
        int firstNum = 5;
        int secondNum = 4;

        //when
        int result = calc.minus(firstNum, secondNum);

        //then
        assertEquals("Variables are nor equal.. ", 1, result);

    }

    @Test
    public void minus_twoNegativeIntegers_outputsCorrectSubtraction(){


        //given
        int firstNum = -5;
        int secondNum = -4;

        //when
        int result = calc.minus(firstNum, secondNum);

        //then
        assertEquals("Variables are nor equal.. ", -1, result);

    }


    @Test
    public void minus_twoZeros_outputsCorrectSubtraction(){


        //given
        int firstNum = 0;
        int secondNum = 0;

        //when
        int result = calc.minus(firstNum, secondNum);

        //then
        assertEquals("Variables are nor equal.. ", 0, result);

    }

    /*
     *  NEGATIVE PATH
     */
    // @Ignore
    // then
    @Test(expected = ArithmeticException.class)
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_integerMaxPlusIntegerMax_raisesException(){
        // given
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        // when
        int result = calc.add(firstNum, secondNum);
    }

    // Testing for exceptions using a different methodology
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    // @Ignore
    @Test
    // [the name of the tested method]_[expected input / tested state]_[expected behavior]
    public void add_integerMaxPlus1_raisesException(){
        // then
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Can't add possitive numbers to int.MAX_VALUE");

        // given
        int firstNum = Integer.MAX_VALUE;
        int secondNum = 1;

        // when
        int result = calc.add(firstNum, secondNum);

        // TASK : : change the order of then and when - observe what happens!
    }
///////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(expected = ArithmeticException.class)

    public void subtract_integerMinMinusPositive_raisesException(){
        //given
        int firstNum = Integer.MIN_VALUE;
        int secondNum = 1;

        //when

        int result = calc.minus(firstNum, secondNum);

    }
//////////////////////////////////////////////////////////////////////////////////////////////

    // @Rule
    // public ExpectedException expectedException2 = ExpectedException.none();

   @Test

    public void divide_divisionByZero_raisesException(){

        //then
        expectedException.expect(ArithmeticException.class);
       expectedException.expectMessage("Division by zero is not possible");

       //given
       int firstNum = 5;
       int secondNum = 0;


       //when
       int result = calc.divide(firstNum, secondNum);


   }

   @Ignore
   @Test(expected = NullPointerException.class)

    public void subtract_SubtractionFromNull_raisesException(){
        //given
       int firstNum = 4;
       Integer secondNum = null;

       //when
        int result = calc.minus(firstNum,secondNum);

   }



}//main class
