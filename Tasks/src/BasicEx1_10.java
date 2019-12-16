import java.util.Scanner;

public class BasicEx1_10 {
    public static void main(String[] args) {
        System.out.println("=============1.===================");
        System.out.println("Hello");
        System.out.println("Ignas Sungaila");

        System.out.println("=============2.===================");
        int x = 74, y = 36, z;
        z = x + y;
        System.out.println(z);

        System.out.println("=============3.===================");
        int q = 50, w = 3, e;
        e = q/w;
        System.out.println(e);

        System.out.println("============4.====================");
        System.out.println(-5 + 8 * 6);
        System.out.println((55 + 9) % 9);
        System.out.println(20 + (-3)*5/8);
        System.out.println(5 + 15/3 *2 - 8 % 3);

        System.out.println("============5.====================");
        Scanner num = new Scanner(System.in);
        System.out.print("Input first number: ");
        int numb1 = num.nextInt();

        System.out.print("Input second number: ");
        int numb2 = num.nextInt();

        System.out.println(numb1 + " x " + numb2 + " = " + numb1 * numb2);

        System.out.println("=============6.=====================");
        System.out.print("Input first number: ");
        int num1 = num.nextInt();

        System.out.print("Input second number: ");
        int num2 = num.nextInt();

        System.out.println(num1 + " + " + num2 +  " = " +  (num1 + num2));
        System.out.println(num1 + " - " + num2 +  " = " +  (num1 - num2));
        System.out.println(num1 + " * " + num2 +  " = " +  (num1 * num2));
        System.out.println(num1 + " / " + num2 +  " = " +  (num1 / num2));
        System.out.println(num1 + " mod " + num2 +  " = " +  (num1 % num2));

        System.out.println("====================7.======================");
        System.out.println("Input a number: ");
        int number = num.nextInt();
        int i;
        for(i = 1; i < 11; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        }

        System.out.println("===================8.=======================");
        System.out.println("   J    a   V     V  a");
        System.out.println("   J   a a   V   V  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");

        System.out.println("====================9.======================");
        double sum;
        sum = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
        System.out.println(sum);

        System.out.println("====================10.======================");
        double form;
        form = 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
        System.out.println(form);



    }//psvm
}//class
