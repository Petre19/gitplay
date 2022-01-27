package com.endava.calculator.basic;

public class Basic implements BasicOperations {
    protected int decimals;
    public Basic() {
        decimals=10;
    }
    public Basic(int decimals) {
        this.decimals=decimals;
    }
    @Override
    public long add(int... no) {
        long sum=0;
        for(int element:no){
             sum+=element;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        long sum=0;
        for(long element:no){
            sum+=element;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum=0;
        for(double element:no){
            sum+=element;
        }
        return sum;
    }

    @Override
    public int substract(int... no) {
        int result =no[0];
        for(int element=1;element<no.length;element++){
            result-=no[element];
        }
        return result;
    }

    @Override
    public long substract(long... no){
        long result =no[0];
        for(int element=1;element<no.length;element++){
            result-=no[element];
        }
        return result;
    }

    @Override
    public double substract(double... no){
        double result =no[0];
        for(int element=1;element<no.length;element++){
            result-=no[element];
        }
        return result;
    }

    @Override
    public long multiply(int... no) {
        int result =1;
        for(int element:no){
            result*=element;
        }
        return result;
    }

    @Override
    public long multiply(long... no) {
        long result=1;
        for(long element:no){
            result*=element;
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result =1;
        for(double element:no){
            result*=element;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result =no[0];
        for(int element=1;element<no.length;element++){
            result/=no[element];
        }
        //DecimalFormat numberFormat = new DecimalFormat("#.00");

        return formatNumber(result);
    }

    @Override
    public double divide(long... no) {
        double result =no[0];
        for(int element=1;element<no.length;element++){
            result/=no[element];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result =no[0];
        for(int element=1;element<no.length;element++){
            result/=no[element];
        }

        return formatNumber(result);
    }
    protected double formatNumber(double result){
        String s=String.format("%."+decimals+"f",result);
        return Double.parseDouble(s);
    }
}
