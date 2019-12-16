import java.util.Scanner;
public class Weekday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Number: ");
        int input = in.nextInt();
        int day;

        if (input > 0){
            day = input % 7;
            switch (day){
                case 1 : System.out.println("It's Monday"); break;
                case 2 : System.out.println("It's Tuesday"); break;
                case 3 : System.out.println("It's Wednesday"); break;
                case 4 : System.out.println("It's Thursday"); break;
                case 5 : System.out.println("It's Friday"); break;
                case 6 : System.out.println("It's Saturday"); break;
                case 0 : System.out.println("It's Sunday"); break;
            }
        }
        else{
            System.out.println("Number is Invalid");
        }
    }
}
