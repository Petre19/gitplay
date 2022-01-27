package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {
    public static void main(String[] args) {
        BasicOperations basic = new Basic(3);
        System.out.println("add " +basic.add(1,2,5,10,11));
        System.out.println("substract " +basic.substract(2,-3,10,-10,15));
        System.out.println("Multiply " +basic.multiply(2,6));
        System.out.println("Divide " +basic.divide(101,31));
        System.out.println("Divide " +basic.divide(15,3));
        System.out.println("Multiply " +basic.multiply(3.5,2.3));
        ExpertOperations expert=new Expert(3);
        System.out.println("pow " +expert.pow(4,-1));
        System.out.println("sqrt " +expert.sqrt(-5));
        System.out.println("factorial " +expert.factorial(5));
        System.out.println("sqrtMultiple " +expert.sqrtMultiple(27,3));
        System.out.println(expert.calculate("(1-2+(-9-1))"));

    }
}
