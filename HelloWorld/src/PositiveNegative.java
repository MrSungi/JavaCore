import java.util.Scanner;
public class PositiveNegative {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        int input = in.nextInt();

        if (input > 0){
            System.out.println("Number is positive: " + input);
        }
        else if (input < 0){
            System.out.println("Numbet is negative: " + input);
        }
        else{
            System.out.println("Number is zero");
        }
    }//psvm
}//class
