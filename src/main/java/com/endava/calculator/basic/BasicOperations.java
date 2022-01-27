package com.endava.calculator.basic;

public interface BasicOperations {
    long add(int... no);
    long add(long... no);
    double add(double... no);

    int substract(int... no);
    long substract(long... no);
    double substract(double... no);

    long multiply(int... no);
    long multiply(long... no);
    double multiply(double... no);

    double divide (int... no);
    double divide (long... no);
    double divide (double... no);
}
