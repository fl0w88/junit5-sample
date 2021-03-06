/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;


import org.junit.jupiter.api.*;

@Tag("fast")
public class FirstTest {

    // we define a variable ( or an object) of the type Calculator
    Calculator myCalculator;

    // before we start, we must initialize our Calculator
    @BeforeEach
    public void init() {
        // this is how we 'create' a new Calculator
        myCalculator = new Calculator();
    }

    @Test
    @DisplayName("My 1st JUnit 5 test! 😎 - Calculator - Addition Test")
    void test1() {
        Assertions.assertEquals(9, myCalculator.add(3, 3, 3));
    }

    @Test
    @DisplayName("My 2nd JUnit 5 test! 😎 - Calculator - Multiplication Test")
    void test2() {
        Assertions.assertEquals(40, myCalculator.multiply(2, 5, 4));
    }

    @Test
    @DisplayName("My 3rd JUnit 5 test! 😎 - Calculator - Subtraction Test")
    void test3() {
        Assertions.assertEquals(886, myCalculator.subtract(890, 4));
    }

    @Test
    @DisplayName("My 4th JUnit 5 test! 😎 - Calculator - Division Test")
    void test4() {
        Assertions.assertEquals(5, myCalculator.divide(100, 4, 5));
    }

    @Test
    @DisplayName("Calculator - Invalid Parameter Test")
    void negativeTest1() {
        boolean exceptionOccurred = false;
        try {
            myCalculator.subtract(8);
            System.out.println("Ich werde bei einem Fehler NICHT ausgeführt.");
        } catch (Exception e) {
            System.out.println("Ich habe einen Fehler aufgefangen.");
            exceptionOccurred = true;
        }
        Assertions.assertTrue(exceptionOccurred);
    }

    @Test
    @DisplayName("Calculator - Division By 0 Test")
    void negativeTest2() {
        boolean exceptionOccurred = false;
        try {
            myCalculator.divide(8, 0);
        } catch (Exception e) {
            exceptionOccurred = true;
        }
        Assertions.assertTrue(exceptionOccurred);
    }

    @Test
    @DisplayName("Calculator - Check Author Test")
    void authorCheckTest() {
        Assertions.assertNotNull(myCalculator.authorName);
        Assertions.assertEquals("John Doe", myCalculator.authorName);
    }


    @Test
    void test123() {
        // leer
    }

}
