package Pkg222;

import Pkg111.MyClass1;

public class SubClass2 extends MyClass1 {

    public static void main(String[] args) {
      SubClass2 obj = new SubClass2();
        System.out.println("Different Package SUB-CLASS");
        //System.out.println(obj.x_pvt);
        //System.out.println(obj.x_dft);
        System.out.println(obj.x_ptd);
        System.out.println(obj.x_pub);


    }
}
