package com.ignas.mavendemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTrialTest {

    @Test // simplest possible use of AssertJ
    public void testSimpleFluentAssertion(){
        String text = "abc";
        assertThat(text).isEqualTo("abc");
    }

    @Test // collection assertions
    public void testMultipleConditionsFluentAssertion(){
        String[] stringArray = {"abc", "cde", "efg"};

        assertThat(stringArray)
                .hasSize(3)
                .contains("cde")
                .doesNotContain("xyz");
    }

    @Test
    public void testObjectWDescription(){
        String[] stringArray = {"abc", "cde", "efg"};

        // as() is used to describe the test and will be shown before the error message
        assertThat(stringArray[0].length())
                .as("Testing %s's length", stringArray[0])
                .isEqualTo(3);
    }

    // TODO :: Object assertions


    @Test // exception assertions
    public void testExceptionsWAssertJ(){
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).hasMessage("boom!");

        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("String one", "String two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                // .hasMessageContaining("Index 2 out of bounds for length 2");
                .hasMessageContaining("Index: 2, Size: 2");

        // .hasMessage("Index: %s, Size: %s", 2, 2)
        // .hasMessageStartingWith("Index: 2")
        // .hasMessageContaining("2")
        // .hasMessageEndingWith("Size: 2")
        // .hasMessageMatching("Index: \\d+, Size: \\d+")
        // .hasCauseInstanceOf(IOException.class)
        // .hasStackTraceContaining("java.io.IOException");
    }



    // TODO :: Conditions
}