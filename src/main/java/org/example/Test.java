package org.example;

import java.util.Arrays;

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

    public static double getNewtonPolynomial(double variableX, double[] x, double[] y) {
        int size = x.length;

        //  массив неразделенных сумм (по количеству узлов)
        double[][] array = new double[size][];

        //  создание и заполнение первого уровня значениями из таблицы
        array[0] = new double[size];
        for(int i = 0; i < size; i++) {
            array[0][i] = y[i];
        }

        //  создание остальных уровней
        for(int i = 1; i < size; i++) {
            array[i] = new double[size - i];
        }

        //  заполнение остальных уровней
        for(int i = 1; i < size; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = (array[i-1][j+1] - array[i-1][j]) / (x[i+j] - x[j]);
            }
        }

        System.out.println();

        for(int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println();

        //  вычисление значения полинома в точке
        double result = 0;
        for(int i = 0; i < size; i++) {
            result += array[i][0] * getMultipleForNewtonPolynomial(i, variableX, x);
        }
        return result;
    }

    /** Вычисление в многочлене Ньютона множителей, содержащих переменную x.
     * position -- позиция слагаемого в многочлене,
     * variableX -- значение переменной x,
     * x -- массив значений координаты x из таблицы.
     */
    public static double getMultipleForNewtonPolynomial(int position, double variableX, double[] x) {
        double result = 1;
        for(int i = 0; i < position; i++) {
            result *= variableX - x[position - 1];
        }
        return result;
    }
}
