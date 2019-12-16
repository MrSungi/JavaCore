import java.util.Scanner;
public class minOfArray {
    public static void main(String[] args) {
        //A program to find a minimum number of an Array


        int[] Arr = new int[10];
        Array(Arr);
        System.out.println("Minimum number of Array is: " + minArray(Arr));
        System.out.println("Maximum number of Array is: " + maxArray(Arr));

    }//psvm


    /////////////Enter elements for Array ///////////////////
    public static int[] Array(int[]Arr){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 Array elements: ");
        for(int k = 0; k < 10; k++){
            Arr[k] = in.nextInt();
        }
        in.close();
        return Arr;
    }

    /////////////minimum number of an Array/////////////////////
    public static int minArray(int[]Arr){
        int min = Arr[0];
        int len = Arr.length;
        for (int i = 1; i<len;i++){
            if (min > Arr[i] ){
                min = Arr[i];
            }
        }
        return min;
    }

    /////////////maximum number of an Array////////////////////
    public static int maxArray(int[]Arr){
        int max = Arr[0];
        int len = Arr.length;
        for (int i = 1; i<len;i++){
            if (max < Arr[i] ){
                max = Arr[i];
            }
        }
        return max;
    }

}//class
