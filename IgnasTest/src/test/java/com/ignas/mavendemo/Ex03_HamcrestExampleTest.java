package com.ignas.mavendemo;
import org.hamcrest.collection.IsIn;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Ex03_HamcrestExampleTest {
    @Test
    public void justForFun(){
        int out = Ex03_HamcrestExample.random();
        assertThat(out, anyOf(is(0), is(1), is(2)));
    }

    @Test
    public void testWAllOf(){
        String out = "Achilles is powerful";
        assertThat(out, allOf(startsWith("Achi"), endsWith("ul"), containsString("Achilles")));
    }

    @Test
    public void givenValueAndArray_whenValueFoundInArray_thenCorrect() {
        String[] array = new String[] { "collections", "beans", "text", "number" };
        assertThat("beans", isIn(array));
    }




}//class