package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtensions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtensions.class)
public class CalculatorTest {
    private BasicOperations basic;
    private ExpertOperations expertOperations;
    private static final Logger LOGGER = LogManager.getLogger(CalculatorTest.class);

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTest() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        System.out.println("\nBefore Each");
        basic = new Basic();
        expertOperations=new Expert();
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each\n");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumberGivenOperand0(int a, int b) {
        //GIVEN

        //WHEN
        long result = basic.add(a, b);
        //THEN
        System.out.println(result);

    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(2, 0));
        argumentsList.add(Arguments.of(0, 2));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {
        //GIVEN

        //WHEN
        long result = basic.add(-2, -4);
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddBigNumbers() {
        //GIVEN

        //WHEN
        long result = basic.add(Integer.MAX_VALUE, 1);
        //THEN
        System.out.println(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1, int a2, int a3) {
        //GIVEN

        //WHEN
        long result = basic.add(a1, a2, a3);
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAddNoOperands() {
        //GIVEN

        //WHEN
        long result = basic.add();
        //THEN
        System.out.println(result);
    }

    @Test
    public void shouldAdd1Operands() {
        //GIVEN

        //WHEN
        long result = basic.add(167);
        //THEN
        System.out.println(result);
    }
    //MULTIPLY


    @Tag("smoke")
    @Test
    public void shouldMultiplyWithNegativeNumbers() {
        //GIVEN

        //WHEN
        long result = basic.multiply(-2, -4);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldMultiplyWithGiven0Number() {
        //GIVEN

        //WHEN
        long result = basic.multiply(0, 12);
        //THEN
        LOGGER.info(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldMultiplyMoreThan2Operands(int a1, int a2, int a3) {
        //GIVEN

        //WHEN
        long result = basic.multiply(a1, a2, a3);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldMultiplyNoOperands() {
        //GIVEN

        //WHEN
        long result = basic.multiply();
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldMultiply1Operands() {
        //GIVEN

        //WHEN
        long result = basic.multiply(2);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldMultiplyBigNumbers() {
        //GIVEN

        //WHEN
        long result = basic.multiply(Integer.MAX_VALUE, 1);
        //THEN
        LOGGER.info(result);
    }
    //POW
    @Tag("smoke")
    @Test
    public void shouldUsePowWithExponentNegativeNumbers() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(2, -4);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldUsePowWith0Exponent() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(2, 0);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldUsePowWith0Base() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(0,2);
        //THEN
        LOGGER.info(result);
    }
    //FACTORIAL
    @Tag("smoke")
    @Test
    public void shouldFactorialWith0() {
        //GIVEN

        //WHEN
        double result = expertOperations.factorial(0);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldFactorialWithNegative() {
        //GIVEN

        //WHEN
        double result = expertOperations.factorial(-1);
        //THEN
        LOGGER.info(result);
    }
    @Test
    public void shouldFactorialWithPositive() {
        //GIVEN

        //WHEN
        double result = expertOperations.factorial(2);
        //THEN
        LOGGER.info(result);
    }
}
