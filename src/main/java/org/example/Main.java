package org.example;

import static org.example.Test.getLagrangePolynomialSum;

public class Main {
    public static void main(String[] args) {

//        double[] x = {0.1, 0.2, 0.3, 0.4, 0.5};   //  x = 0.35
//        double[] y = {1.25, 2.38, 3.79, 5.44, 7.14};

        double[] x = {100, 121, 144};   //  x = 105
        double[] y = {10, 11, 12};

        System.out.println(getLagrangePolynomialSum(105, x, y));

    }
}