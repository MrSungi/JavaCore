package Pkg111;

public class MyClass1 {

     private int x_pvt = 0;
     int x_dft = 1;
     protected int x_ptd = 2;
     public int x_pub = 3;


     public static void main(String[] args) {
          MyClass1 obj = new MyClass1();
          System.out.println("SAME CLASS");
          System.out.println(obj.x_pvt);
          System.out.println(obj.x_dft);
          System.out.println(obj.x_ptd);
          System.out.println(obj.x_pub);

     }

}
