package Collections.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mapsx {
    public static void main(String[] args) {
        Map m =new HashMap();
        //Adding elements to map
        m.put(1,"Yo");
        m.put(5,"Man");
        m.put(2,"AAA");
        m.put(6,"XYZZ");
        m.put("Yohan",66);
        m.put("str",19);
        m.put(6,"abcde");//wont be added
        m.put("Yohan", 55);//wont be added
        System.out.println(m);
        System.out.println("====================1");

        Map<String,Integer> student = new HashMap<>();
        student.put("Yohan",66);
        student.put("Mr.A",89);
        student.put("BBB",27);
        student.put("xyz",19);
        System.out.println(student);
        System.out.println("====================2");

        int val1 = student.get("Mr.A");
        System.out.println(val1);
        System.out.println(student.get("Mr.BBB"));

        //int val2 = student.get("Mr.BBB");//error
        //System.out.println(val2);

        System.out.println(student.size());
        student.put("New", 99);
        student.put("More New", 100);
        student.put("Final New", 999);
        System.out.println(student);
        System.out.println(student.size());
        System.out.println("====================3");

        student.remove("More New");
        System.out.println(student);
        System.out.println(student.size());
        System.out.println("====================4");

        System.out.println(student.containsKey("BBB"));
        System.out.println(student.containsValue(35));
        System.out.println("====================5");

        Map<Integer, String> customer = new HashMap<>();
        if(customer==null){
            System.out.println("NO CUSTOMERS....");
        }
        else {
            System.out.println("Yes! Customers are there!");
        }

        if(customer.isEmpty()){
            System.out.println("NO CUSTOMERS.... from isEmpty()");
        }
        System.out.println("====================6");

        System.out.println(student);
        student.replace("Final New", 1000);
        System.out.println(student);
        //student.clear();//clears the entire map
        System.out.println("====================7");
        //https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map

        Set set = student.entrySet();//Converting to Set
        Iterator i = set.iterator();//get iterator from set

        while(i.hasNext()){
            Map.Entry entry=(Map.Entry)i.next();//get each "element" or "entry"  from the iterator
            System.out.println(entry.getKey() + " | " +entry.getValue());
        }

    }
}
