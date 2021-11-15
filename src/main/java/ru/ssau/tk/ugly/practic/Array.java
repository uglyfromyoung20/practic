package ru.ssau.tk.ugly.practic;

public class Array {
    public double[] createArrayWithDim(int dim) {
        return new double[dim];
    }
    public double[] getArraysOfOnes(int dim) {
        double[] array = new double[dim];
        for (int i = 0; i < array.length; i++) {
            if ((i == 0) || (i == array.length - 1)) {
                array[i] = 2;
            } else
                array[i] = 1;
        }
        return array;
    }
    public double[] getArrays(int dim) {
        double[] array = new double[dim];
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * i + 1;
        }
        return array;
    }
    public double[] getArray(int dim) {
        double[] array = new double[dim];
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * i + 1;
        }
        return array;
    }
        public double[] Decreasing(int dim) {
            double[] array = new double[dim];
            for (int i = 0; i < array.length; i++) {
                array[i] = (dim - i) * 2;
            }
            return array;
        }
    public double[] Fibonacci(int n) {
        double[] array = new double[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }
    public double[] Square(int dim) {
        double[] array = new double[dim];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
        return array;
    }
    }


