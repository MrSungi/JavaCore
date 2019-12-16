import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;

public class StringsSix {

    public static void main(String[] args) {


        String str = "today we make our programming logic stronger!";

        System.out.println(str.replace('o', 'X'));
        System.out.println(str);

        System.out.println("==============");

        String s = "hello How are you?";
        System.out.println(s.substring(6));
        System.out.println(s.substring(6, 12)); // substring(includes, excludes)

        System.out.println("==============");

        String Order_Num = "23-A33/yohan";
        int position = Order_Num.indexOf('/');
        String name = Order_Num.substring(++position);//... solve?

        System.out.println("Name: " + name);
        //power guns:      Tx-Ray-750, Tx-Ray-300
        //client history   yw/45/87/34/91

        String Order_Num1 = "Tx-Ray-750";
        int positionx = Order_Num1.lastIndexOf('-');
        String namex = Order_Num1.substring(++positionx);//... solve?
        System.out.println(namex);

        System.out.println("--------------------------------------------------");

        String gun = "Tx-Ray-300";
        String[] arr = gun.split("-");
        System.out.println(arr[2]);

        String bill = "yw/45/87/34/91";
        String[] arr1 = bill.split("/");
        System.out.println(arr1[(arr1.length-1)]);






    }
}
