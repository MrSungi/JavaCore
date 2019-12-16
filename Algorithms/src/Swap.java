public class Swap {
    public static void main(String[] args) {
        int a = 5, b = 10, temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Swap");

        temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int x = 3, y = 6;

        System.out.println("*******************************");

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("Swap without temporary");

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("x = " + x);
        System.out.println("y = " + y);




    }
}
