package com.example.springcalculator.component;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import static org.junit.Assert.*;

@SpringBootTest
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private DollarCalculator dollarCalculator;

    @Test
    public void dollarCalculatorTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();

        int sum = dollarCalculator.sum(10, 10);
        int minus = dollarCalculator.minus(10, 10);
        assertEquals(60000, sum);
        assertEquals(0, minus);
    }
}
