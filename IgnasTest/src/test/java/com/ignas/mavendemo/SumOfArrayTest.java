package com.ignas.mavendemo;

import org.junit.Test;

public class SumOfArrayTest {

    @Test
    public void Test() {
        //given
        int[] arr = {2, 5, 4, 6, 3};

        //when
        int sum = SumOfArray.sumOfArray(arr);

        //then
        assert sum == 20;
    }

    @Test
    public void Test2(){
        //given
        int[] arr = {-1, -5, -6, - 4};

        //when
        int sum = SumOfArray.sumOfArray(arr);

        //then
        assert sum == -16;

    }

    @Test
    public void Test3(){
        //given
        int[] arr = {};

        //when
        int sum = SumOfArray.sumOfArray(arr);

        //then
        assert sum == 0;
    }



}
