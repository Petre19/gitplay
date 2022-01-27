package com.endava.calculator.expert;

import com.endava.calculator.basic.Basic;

public class Expert extends Basic implements ExpertOperations {
    private String[] operators = {"+", "-", "%", "/", "*","^"};

    public Expert() {
        decimals = 10;
    }

    public Expert(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public double pow(int base, int exponent) {
        double result = 1;
        for (int element = 1; element <= Math.abs(exponent); element++) {
            result *= base;
        }
        if (exponent > 0) {
            return formatNumber(result);
        } else {
            return formatNumber(1 / result);
        }
    }

    @Override
    public double sqrt(int number) {
        number = Math.abs(number);
        return formatNumber(Math.sqrt(number));

    }

    public long sqrtMultiple(long number, double exp) {
        number = Math.abs(number);
        return Math.round(Math.pow(number, (1 / exp)));
    }

    @Override
    public long fac(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public long factorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return factorial(n - 1) * n;
        } else {
            throw new IllegalArgumentException("You can not calculate factorial from negative number");
        }
    }

    @Override
    public double calculate(String s) {

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            if (s.contains("(")) {
                int startIndex = s.lastIndexOf("(");
                int endIndex = s.indexOf(")",startIndex);
                String left = s.substring(0, startIndex);
                String right = s.substring(endIndex + 1);
                String center = s.substring(startIndex + 1, endIndex);
                double result = calculate(center);
                return calculate(left + result + right);
            } else {
                for (String o : operators) {
                    int index = s.lastIndexOf(o);
                    if (index == -1) {
                        continue;
                    }
                    String leftSide=s.substring(0,index);
                    if(index!=0&&(leftSide.trim().charAt(leftSide.trim().length()-1)=='+'||leftSide.trim().charAt(leftSide.trim().length()-1)=='-'||
                            leftSide.trim().charAt(leftSide.trim().length()-1)=='*'||leftSide.trim().charAt(leftSide.trim().length()-1)=='/')){
                        continue;
                    }
                    double leftOp = index == 0 ? 0.0 : calculate(leftSide);
                    double rightOp = calculate(s.substring(index + 1));

                    switch (o) {
                        case "+":
                            return add(leftOp, rightOp);
                        case "-":
                            return substract(leftOp, rightOp);
                        case "*":
                            return multiply(leftOp, rightOp);
                        case "/":
                            return divide(leftOp, rightOp);
                        case "%":
                            return leftOp % rightOp;
                        case "^":
                            return pow((int) leftOp, (int) rightOp);
                        default:
                            throw new IllegalArgumentException("invalid operator " + o);
                    }
                }
                throw new RuntimeException("Operator field needs to have a value");
            }
        }

    }

}
