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
    public double[] getArrayOfPositivePrimes(double number) {
        int numberOfPositivePrimes = 0;
        for (int i = 2; i <= number; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if ((i % j) != 0) {
                    continue;
                }
                isSimple = false;
            }
            if (isSimple) numberOfPositivePrimes++;
        }
        double[] array = new double[numberOfPositivePrimes];
        int index = 0;
        for (int i = 2; i <= number; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j != 0) {
                    continue;
                }
                isSimple = false;
            }
            if (isSimple) array[index++] = i;
        }
        return array;
    }
    public double[] getSymmetricalArray(int dimension) {
        double[] array = new double[dimension];
        int index;
        if (dimension % 2 != 0) {
            index = (dimension / 2) + 1;
        } else {
            index = dimension / 2;
        }
        for (int i = 1; i <= index; i++) {
            array[i - 1] = i;
            array[dimension - i] = i;
        }
        return array;
    }
    public void getArrayOfElementsWithOppositeSigns(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= (-1);
        }
    }
    public boolean isNumberInTheArray(double[] array, double number) {
        boolean result = false;
        for (double x : array) {
            if (x == number) {
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean isNullInTheArray(Integer[] array) {
        boolean result = false;
        for (Integer x : array) {
            if (x == null) {
                result = true;
                break;
            }
        }
        return result;
    }
    public int getNumberOfEvenNumbersInArray(double[] array) {
        int numberOfEvenNumbers = 0;
        for (double element : array) {
            if (element % 2 == 0) {
                numberOfEvenNumbers++;
            }
        }
        return numberOfEvenNumbers;
    }
    public double getMaximalElementInArray(double[] array) {
        double maxElement = array[0];
        for (double v : array) {
            if (maxElement < v) {
                maxElement = v;
            }
        }
        return maxElement;
    }
    public boolean whoHasTheMostDivisible(double[] array) {
        int divisibleByFirstElement = 0, divisibleByLastElement = 0;
        for (double v : array) {
            if (v % array[0] == 0) {
                divisibleByFirstElement++;
            }
            if (v % array[array.length - 1] == 0) {
                divisibleByLastElement++;
            }
        }
        return divisibleByFirstElement > divisibleByLastElement;
    }
    public double theNumberThatRepeats(double[] array) {
        double[] duplicateNumbers = new double[1];
        double[] numberOfRepetitions = new double[1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] == array[j]) {
                    if (i > getIndexOfDuplicateNumber(array[i], array)) {
                        continue;
                    } else if (isInTheArrayOfDuplicateNumbers(array[i], duplicateNumbers)) {
                        numberOfRepetitions[getIndexOfDuplicateNumber(array[i], duplicateNumbers)]++;
                    } else { //не содержится
                        double[] newDuplicateNumbers = new double[duplicateNumbers.length + 1];
                        double[] newNumberOfRepetitions = new double[numberOfRepetitions.length + 1];
                        System.arraycopy(duplicateNumbers, 0, newDuplicateNumbers, 0, duplicateNumbers.length);
                        System.arraycopy(numberOfRepetitions, 0, newNumberOfRepetitions, 0, numberOfRepetitions.length);
                        duplicateNumbers = newDuplicateNumbers;
                        numberOfRepetitions = newNumberOfRepetitions;
                        duplicateNumbers[index] = array[i];
                        numberOfRepetitions[index]++;
                        index++;
                    }
                }
            }
        }
        return duplicateNumbers[0];
    }

    private boolean isInTheArrayOfDuplicateNumbers(double x, double[] array) {
        boolean result = false;
        for (double element : array) {
            if (x == element) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int getIndexOfDuplicateNumber(double x, double[] array) {
        int help = 0;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                help = i;
                break;
            }
        }
        return help;
    }
    public int getFirstIndexOfNumber(double[] array, double number) {
        int help = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                help = i;
                break;
            }
        }
        return  help;
    }
    public void oppositeTheMaxAndMinElements(double[] array) {
        double maxElement = array[0], minElement = array[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxIndex = i;
            }
            if (array[i] < minElement) {
                minElement = array[i];
                minIndex = i;
            }
        }
        array[minIndex] = maxElement;
        array[maxIndex] = minElement;
    }
    public void bitwiseNegation(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ~array[i];
        }
    }
    }


