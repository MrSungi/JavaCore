import java.util.Scanner;

public class BasicEx11_20 {
    public static void main(String[] args) {
        System.out.println("======================11.==================");

        Scanner in = new Scanner(System.in);
        System.out.print("Input circle radius: ");
        double r = in.nextDouble();

        System.out.println("Circle Perimeter is = " + (2 * Math.PI * r));
        System.out.println("Circle Area is = " + (Math.PI * r * r));

        System.out.println("======================12.===================");
        double average;

        System.out.print("Input first number: ");
        double n1 = in.nextDouble();

        System.out.print("Input first number: ");
        double n2 = in.nextDouble();

        System.out.print("Input first number: ");
        double n3 = in.nextDouble();

        System.out.println("Average of these three numbers is = " + ((n1 + n2 + n3)/3));

        System.out.println("=====================13.===================");
        System.out.print("Input rectangle Width: ");
        double width = in.nextDouble();
        System.out.print("Input rectangle Height: ");
        double height = in.nextDouble();

        System.out.println("Area is " + width + " * " + height + " = " + width*height);
        System.out.println("Perimeter is 2 " + " * (" + width + " + " + height + ") = " + (2*(width+height)));

        System.out.println("======================14.====================");
        System.out.println("* * * * * * ==========================================");
        System.out.println(" * * * * *  ==========================================");
        System.out.println("* * * * * * ==========================================");
        System.out.println(" * * * * *  ==========================================");
        System.out.println("* * * * * * ==========================================");
        System.out.println(" * * * * *  ==========================================");
        System.out.println("* * * * * * ==========================================");
        System.out.println(" * * * * *  ==========================================");
        System.out.println("* * * * * * ==========================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println("======================================================");

        System.out.println("\n ===========================15.========================");
        System.out.print("input first number a: ");
        int a = in.nextInt();
        System.out.print("input second number b: ");
        int b = in.nextInt();

        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.println("Numbers after swaping: a = " + a + ", b = " + b);

        System.out.println("====================16=============================");
        System.out.println(" +''''''+ ");
        System.out.println("[| o  o |]");
        System.out.println(" |  ^   | ");
        System.out.println(" | '-'  | ");
        System.out.println(" +------+ ");

        System.out.println("===================17.============================");
        long binary1, binary2;
        int i = 0, remainder = 0;
        int[] sum = new int[20];

        System.out.print("Input first binary number: ");
        binary1 = in.nextLong();
        System.out.print("Input second binary number: ");
        binary2 = in.nextLong();

        while (binary1 != 0 || binary2 != 0)
        {
            sum[i++] = (int)((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        System.out.print("Sum of two binary numbers: ");
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
        System.out.print("\n");

        System.out.println("======================18.=========================");
        Scanner test= new Scanner(System.in);
        String bn1, bn2;

        System.out.println("Enter The First Binary No: ");
        bn1 = test.nextLine();

        System.out.println("Enter The Second Binary No: ");
        bn2 = test.nextLine();

        int nr1 =Integer.parseInt(bn1, 2);
        int nr2 =Integer.parseInt(bn2, 2);
        int nr3 = nr1 * nr2;

        System.out.println("The Addition Of 2 Binary No is : " + Integer.toBinaryString(nr3));

        System.out.println("===========================19.=====================");
        int dec_num, rem, quot, k=1, j;
        int bin_num[] = new int[100];
        Scanner scan = new Scanner(System.in);

        System.out.print("Input a Decimal Number : ");
        dec_num = scan.nextInt();

        quot = dec_num;

        while(quot != 0)
        {
            bin_num[k++] = quot%2;
            quot = quot/2;
        }

        System.out.print("Binary number is: ");
        for(j=k-1; j>0; j--)
        {
            System.out.print(bin_num[j]);
        }
        System.out.print("\n");

        System.out.println("=========================20.===================");
        int deci_num, rema;
        String hexdec_num="";

        /* hexadecimal number digits */

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        Scanner inte = new Scanner(System.in);

        System.out.print("Input a decimal number: ");
        deci_num = inte.nextInt();

        while(deci_num>0)
        {
            rema = deci_num%16;
            hexdec_num = hex[rema] + hexdec_num;
            deci_num = deci_num/16;
        }
        System.out.print("Hexadecimal number is : "+hexdec_num+"\n");

    }//psvm
}//class
