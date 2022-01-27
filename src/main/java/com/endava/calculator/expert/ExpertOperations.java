package com.endava.calculator.expert;

import com.endava.calculator.basic.BasicOperations;

public interface ExpertOperations extends BasicOperations {
    double pow(int base, int exponent);
    double sqrt(int number);
    long sqrtMultiple(long number, double exp);
    long fac(int n);
    long factorial(int n);
    double calculate(String s);
}
