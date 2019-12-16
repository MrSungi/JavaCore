package com.ignas.mavendemo;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class CustomerNameFilterTest {

   CustomerNameFilter filter;

    @Test
    public void filter_NamesLongerThanFiveCharacters_filteredArray(){
        //given
        String[] Names = {"Ignas", "Mindaugas", "Elvyra", "Petras", "Jonas"};
        //when
        String[] fNames = filter.filterNames(Names);

        //then

        assertThat("Elvyra", isIn(fNames));
        
    }
}
