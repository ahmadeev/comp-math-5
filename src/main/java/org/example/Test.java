package org.example;

public class Test {
    public static void getResult(double variableX, double[] x, double[] y) {

        double result = 0;

        for(int i = 0; i < x.length; i++) {

            result += y[i] * getLValue(x, variableX, i);

        }
        System.out.println(result);

    }

    public static double getLValue(double[] x, double variableX, int pointNumber) {
        int size = x.length;

        double result = 1;
        for(int i = 0; i < size; i++) {
            if (i == pointNumber) {
                continue;
            } else {
                result *= (variableX - x[i]) / (x[pointNumber] - x[i]);
            }
        }
        return result;
    }
}
