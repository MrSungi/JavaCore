package Collections.Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Queuex {

    public static void main(String[] args) {
        Queue<String> q =new LinkedList<>();
        q.add("Mr.1");
        q.add("Mr.2");
        q.add("Miss 3");
        q.add("Miss 4");
        q.add("Mr. 5");
        q.add("Mrs. 55");
        q.add("Mrs. 66");
        q.add("Mr. 6");
        //q.offer(object); is used as a safer way of adding elements in case full capcity has already been reached
        System.out.println(q);
        System.out.println(q.size());
        System.out.println("=====================0");

        System.out.println("head: " + q.peek());
        System.out.println("Tail: " + ((LinkedList<String>) q).peekLast());
        System.out.println("=====================1");

        q.poll();//will return null if there are no elements, but no error
        q.remove();//can give error if no elements
        System.out.println("After 2 removals: " + q);

        String wasRemoved = ((LinkedList<String>) q).remove(4);
        System.out.println("removed at index 4: " + wasRemoved);
        System.out.println(q);

        for(String s: q){
            System.out.println(s);
        }

    }
}
