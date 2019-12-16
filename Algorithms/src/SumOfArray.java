import java.util.Scanner;
public class SumOfArray {
    public static void main(String[] args) {
        //A program to find sum of all Array numbers

        int[] Arr = new int[10];
        Array(Arr);
        System.out.println("Sum of Array is: " + SumArray(Arr));

    }

//////////////Enter elements for Array////////////////
    public static int[] Array(int[]Arr){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 Array elements: ");
        for(int k = 0; k < 10; k++){
            Arr[k] = in.nextInt();
        }
        in.close();
        return Arr;
    }


/////////////Sum of All Array numbers/////////////////
    public static int SumArray(int[]Arr){
        int sum = 0;
        int len = Arr.length;
        for(int i = 0;i < len; i++){
            sum += Arr[i];
        }
        return sum;
    }
}


