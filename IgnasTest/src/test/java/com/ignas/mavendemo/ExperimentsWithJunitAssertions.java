package com.ignas.mavendemo;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ExperimentsWithJunitAssertions {

    @Test
    public void testAssertArrayEqualsAssertion(){
        int[] a1 = {4, 5};
        int[] a2 = {4, 5};

        // assertArrayEquals(a1, a2);
        assertArrayEquals(a1, a2);
    }

    class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }

    @Test
    public void testAssertNullAssertion(){

        Person p1 = null;
        Person p2 = new Person("Mindaugas");

        assertNull(p1);
        // assertNull(p2);
    }

}