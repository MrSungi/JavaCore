package Collections.Collections;

//import android.view.ContextThemeWrapper;

import java.util.Stack;

public class Stackx {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(23);
        s.push(18);
        s.push(21);
        s.push(11);
        s.push(47);
        s.push(34);
        System.out.println(s);
        System.out.println(s.size());
        System.out.println("Top Most is: " + s.peek());
        System.out.println("=====================0");

        Integer popVal = s.pop();
        System.out.println("popped value: " + popVal);
        System.out.println(s);
        System.out.println(s.size());
        System.out.println("Top Most is: " + s.peek());
        System.out.println("=====================1");


        Integer position = s.search(99);
        boolean contains = s.contains(99);
        System.out.println("for values NOT present: "+ contains +"|" + position);
        position = s.search(18);//position from top
        contains = s.contains(18);
        System.out.println("for values present: "+ contains +"|" + position);
        System.out.println("=====================2");

          for (Integer item: s) {
            System.out.println(item);
          }

        System.out.println("=====================3");
        System.out.println(s.empty());
        s.clear();
        System.out.println(s.empty());
    }
}
