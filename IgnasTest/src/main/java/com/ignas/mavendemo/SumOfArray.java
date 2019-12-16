package com.ignas.mavendemo;

public class SumOfArray {

    public static void main(String[] args) {
        int[] arr = {10,1,2,3,0};
        System.out.println("Sum:" + sumOfArray(arr));
    }

    public static int sumOfArray(int[] arr) {
        int sum = arr[0];
        for(int i = 1; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}