import java.util.Scanner;

public class BasicEx32_40 {
    public static void main(String[] args) {

        System.out.println("=====================31.==================");
        Scanner in = new Scanner(System.in);
        System.out.println("Input Data:");
        System.out.print("Input first integer: ");
        int int1 = in.nextInt();

        System.out.print("Input second integer: ");
        int int2 = in.nextInt();

        if (int1 == int2){
            System.out.println(int1 + " == " + int2);
        }
        else{
            System.out.println(int1 + " != " + int2);
        }

        if (int1 > int2){
            System.out.println(int1 + " > " + int2);
        }
        else{
            System.out.println(int1 + " < " + int2);
        }

        if (int1 >= int2){
            System.out.println(int1 + " >= " + int2);
        }
        else{
            System.out.println(int1 + " <= " + int2);
        }


    }//psvm
}//class
