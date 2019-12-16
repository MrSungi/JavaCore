package com.ignas.mavendemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockitoTest {

    // Real object to be spied on!
    Calculator calc;

    @Before
    public void setup(){
        calc = new Calculator();
    }

    // MOCKING - creating objects that have no implementation
    @Test
    public void add_mockTest(){
        // given
       Calculator mockCalculator = mock(Calculator.class);

        // when
        when(mockCalculator.add(1, 3))
                .thenReturn(123);

        // then
        // simple verify
        System.out.println(mockCalculator.add(1, 3));
        verify(mockCalculator).add(anyInt(), anyInt());

        // other verification modes:
        // times(3)

        // never()
        // System.out.println(mockCalculator.divide(3, 6));
        // verify(mockCalculator, never()).divide(anyInt(), anyInt());

        // atLeast()

        // atMost()
        // System.out.println(mockCalculator.add(555, 6));
        verify(mockCalculator, atMost(1))
                .add(anyInt(), anyInt());

        // atLeastOnce()
        verify(mockCalculator, atLeastOnce()).add(anyInt(), anyInt());

    }

    // SPYING - calling and inspecting real objects and their methods
    @Test
    public void add_spyTest() {
        // given
        // Ex02_Calculator calculator = new Ex02_Calculator();
        Calculator spyCalculator = spy(calc);
        // when ... we see that even in a scenario where we are simply spying on a real object,
        // we can still tell what it should return - force it to return the value we want!
        when(spyCalculator.add(eq(4), eq(6))).thenReturn(55);

        // then
        System.out.println(spyCalculator.add(4,6));

        // verify - with a spy we can check that the real method was called and how many times that happened!
        verify(spyCalculator, times(1)).add(anyInt(), anyInt());
    }
}