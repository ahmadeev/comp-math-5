package org.example;

public class Test {
    public static double getLagrangePolynomialSum(double variableX, double[] x, double[] y) {
        double result = 0;
        for(int i = 0; i < x.length; i++) {
            result += y[i] * getLagrangePolynomial(x, variableX, i);
        }
        return result;
    }

    /**  Метод для вычисления многочлена Лагранжа.
     * x -- массив значений координаты x из таблицы,
     * variableX -- точка, в которой нужно вычислить значение многочлена Лагранжа,
     * pointNumber -- позиция слагаемого в многочлене Лагранжа
     */
    public static double getLagrangePolynomial(double[] x, double variableX, int pointNumber) {
        int size = x.length;

        double result = 1;
        for(int i = 0; i < size; i++) {
            if (i != pointNumber) {
                result *= (variableX - x[i]) / (x[pointNumber] - x[i]);
            }
        }
        return result;
    }
}
