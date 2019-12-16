import java.util.Scanner;
public class Primes {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Starting number: ");
        int start = scan.nextInt();

        System.out.println("Enter Ending number: ");
        int end = scan.nextInt();
        System.out.println("Primes from " + start + " to " + end);



        int count=0;

        for(int i = start; i<= end; i++){
            for(int x = 2; x<i; x++){

                if (i % x == 0){
                    break;
                }

                if(x+1 == i){
                    System.out.println(i);
                    count++;
                }
            }
        }
        System.out.println("There are " + (count) + " Primes!"); //add 1 for "2"... even prime

        scan.close();

    }
}
