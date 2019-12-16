public class Fibonacci {
    public static void main(String[] args) {

        int a, b;

       a = 0;
       b = 1;

        for(int i=0; i<=10; i++){

            System.out.print(a+b + ", ");
            b = a + b;
            a = b - a;

        }

        System.out.println("\n===================================================");

        int x = 1;

        for(int i = 0; i<=10; i++){

            System.out.println(x);
            x = x + 1;


        }
    }//psvm
}//class
