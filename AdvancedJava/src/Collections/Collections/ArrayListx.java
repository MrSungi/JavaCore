
package Collections.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListx {

    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();
        letters.add("AA");
        letters.add("BB");
        letters.add("CC");
        letters.add("DD");
        letters.add("EE");
        letters.add("FF");
        System.out.println(letters);
        System.out.println("===================");

        letters.add(1,"A1");
        System.out.println(letters);
        System.out.println("===================");

        String str0, str6;
        str0 = letters.get(0);
        str6 = letters.get(6);
        System.out.println(str0 +" | " + str6);
        System.out.println("===================");

        int size = letters.size();
        System.out.println("ArrayList size: " + size);
        System.out.println("===================");

        letters.remove(5);
        size = letters.size();
        System.out.println(letters);
        System.out.println("After Removal size: " + size);
        System.out.println("===================");

        letters.remove("A1");
        size = letters.size();
        System.out.println(letters);
        System.out.println("After Removal size: " + size);
        System.out.println("===================");

        System.out.println("Index of CC: " + letters.indexOf("CC"));
        letters.add("A1");
        letters.add("CC");
        System.out.println(letters);
        System.out.println("Last Index of CC: " + letters.lastIndexOf("CC"));
        System.out.println("===================");

        boolean contains = letters.contains("XX");
        int index = letters.indexOf("XX");
        System.out.println("from .contains: " + contains);
        System.out.println("from .indexOf: " + index);
        System.out.println("===================");

        Iterator<String> i = letters.iterator();
        while (i.hasNext()){
            System.out.println("*** " + i.next());
        }
        System.out.println("===================");

        for(String s : letters){
            System.out.println(s);
        }
        System.out.println("===================");

        Collections.sort(letters,Collections.reverseOrder());
        System.out.println(letters);
        Collections.sort(letters);
        System.out.println(letters);
        System.out.println("===================");

        letters.clear();
        System.out.println(letters);












    }

}
