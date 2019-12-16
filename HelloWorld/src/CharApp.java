public class CharApp {

    public static void main(String[] args) {

        char c = 'a';
        System.out.println(c);

        System.out.println('\n');
        c = '8';
        System.out.println(c);

        System.out.println("Hey \t wasssup");

        System.out.println("==========================================");

        char c1 = '\u004E';
        char c2 = '\u005D';
        char c3 = (char)165; //casting
        char c4 = 78;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        System.out.println("==========================================");

        int o, h, b;

        o = 020;
        h = 0xAB56;
        b = 0b1001;

        System.out.print(o + " | " + h + " | " + b);








    }//psvm
}//class
