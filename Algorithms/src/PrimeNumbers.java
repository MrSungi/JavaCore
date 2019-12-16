import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
    //A program to find Prime number, even numbers and firs even number


        int[]Arr = new int[10];
        Array(Arr);
        EvenNum(Arr);
        FirstEvenNum(Arr);
        PrimeNumbers(Arr);
    }

    public static void EvenNum(int[]Arr){
        for(int i =0;i<Arr.length;i++){
            if (Arr[i]%2 == 0){
                System.out.println("Even number: " + Arr[i]);
            }
        }
}
    public static void FirstEvenNum(int[]Arr){
        for(int i =0;i<Arr.length;i++){
            if (Arr[i]%2 == 0){
                System.out.println("First Even number: " + Arr[i]);
                break;
            }
        }
    }

    public static void PrimeNumbers(int[]Arr){
        for(int i =0;i<Arr.length;i++){
            if ((Arr[i] % 2 != 0) && (Arr[i] % 3 != 0) && (Arr[i] % 5 != 0)) {
                System.out.println("Prime number: " + Arr[i]);
            }
            else if ((Arr[i]==2) || (Arr[i]==3) || (Arr[i]==5)) {
                System.out.println("Prime number: " + Arr[i]);
            }
            }
        }


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

}
