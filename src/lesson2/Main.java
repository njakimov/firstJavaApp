package lesson2;

public class Main {
    // 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //      Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    // 2 Задать пустой целочисленный массив размером 8.
    //      Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    //      написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    // 4 Задать одномерный массив.
    //      Написать методы поиска в нём минимального и максимального элемента;
    // 5 ^ Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    //      заполнить его диагональные элементы единицами, используя цикл(ы);
    // 6 ^^ Написать метод, в который передается не пустой одномерный целочисленный массив,
    //      метод должен вернуть true если в массиве есть место,
    //      в котором сумма левой и правой части массива равны.
    //      Примеры:
    //          checkBalance([1, 1, 1, || 2, 1]) → true,
    //          checkBalance ([2, 1, 1, 2, 1]) → false,
    //          checkBalance ([10, || 1, 2, 3, 4]) → true.
    //      Абстрактная граница показана символами ||, эти символы в массив не входят.
    // 7 ^^^ Написать метод, которому на вход подаётся одномерный массив и число n
    //      (может быть положительным, или отрицательным),
    //      при этом метод должен циклически сместить все элементы массива на n позиций.
    //     [1,2,3,4,5], -2 => [3,4,5,1,2]
    //     [1,2,3,4,5], 2 => [4,5,1,2,3]

    public static void main(String[] args) {

        // 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
        //      Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //      Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
        int[] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray("Массив до   ", intArray);
        intArray = reverseArray(intArray);
        printArray("Массив после", intArray);
        System.out.println("\n");

        // 2 Задать пустой целочисленный массив размером 8.
        //      Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
        int[] intArray8 = new int[8];
        intArray8 = fillArray(intArray8);
        printArray("Массив 1 4 7 10 13 16 19 22   ", intArray8);
        System.out.println("\n");

        // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        //      написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
        int[] intArray12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray("Массив до      ", intArray12);
        intArray12 = multiTwoArray(intArray12);
        printArray("Массив <6 *2   ", intArray12);
        System.out.println("\n");

        // 4 Задать одномерный массив.
        //      Написать методы поиска в нём минимального и максимального элемента;
        printArray("Массив для поиска мин макс   ", intArray12);
        System.out.println("Минимальный элемент: " + minArray(intArray12));
        System.out.println("Максимальный элемент:" + maxArray(intArray12));
        System.out.println("\n");

        // 5 ^ Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        //      заполнить его диагональные элементы единицами, используя цикл(ы);
        int[][] intArraySquare = new int[5][5];
        fillSquareArray(intArraySquare);
        System.out.println("\n");

        // 6 ^^ Написать метод, в который передается не пустой одномерный целочисленный массив,
        //      метод должен вернуть true если в массиве есть место,
        //      в котором сумма левой и правой части массива равны.
        //      Примеры:
        //          checkBalance([1, 1, 1, || 2, 1]) → true,
        //          checkBalance ([2, 1, 1, 2, 1]) → false,
        //          checkBalance ([10, || 1, 2, 3, 4]) → true.
        //      Абстрактная граница показана символами ||, эти символы в массив не входят.
        int[] intArray1 = {1, 1, 1, 0, 2, 1};
        System.out.println("Баланс: " + checkBalance(intArray1));
        intArray1[2] = 6;
        System.out.println("Баланс: " + checkBalance(intArray1));
        intArray1[3] = 6;
        intArray1[4] = 1;
        System.out.println("Баланс: " + checkBalance(intArray1));
        System.out.println("\n");

        // 7 ^^^ Написать метод, которому на вход подаётся одномерный массив и число n
        //      (может быть положительным, или отрицательным),
        //      при этом метод должен циклически сместить все элементы массива на n позиций.
        //     [1,2,3,4,5], -2 => [3,4,5,1,2]
        //     [1,2,3,4,5], 2 => [4,5,1,2,3]
        printArray("Массив до              ", intArray1);
        printArray("Массив после сдвиг 1   ", moveArray(intArray1, 1));
        printArray("Массив после сдвиг -1  ", moveArray(intArray1, -1));
        printArray("Массив после сдвиг 6   ", moveArray(intArray1, 6));
        printArray("Массив после сдвиг -9  ", moveArray(intArray1, -9));
    }

    /**
     * Метод, заменяющий в принятом массиве 0 на 1, 1 на 0
     */
    public static int[] reverseArray(int[] intArray) {
        int[] intReverseArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 1) {
                intReverseArray[i] = 0;
            } else {
                intReverseArray[i] = 1;
            }
        }
        return intReverseArray;
    }

    /**
     * Метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    public static int[] fillArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 3 + 1;
        }
        return intArray;
    }

    /**
     * Метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     */
    public static int[] multiTwoArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 6) {
                intArray[i] = intArray[i] * 2;
            }
        }
        return intArray;
    }

    /**
     * Метод поиска минимального элемента в массиве;
     */
    public static int minArray(int[] intArray) {
        int minEl = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (minEl < intArray[i]) {
                minEl = intArray[i];
            }
        }
        return minEl;
    }

    /**
     * Метод поиска максимального элемента в массиве;
     */
    public static int maxArray(int[] intArray) {
        int maxEl = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (maxEl > intArray[i]) {
                maxEl = intArray[i];
            }
        }
        return maxEl;
    }

    /**
     * Метод заполнения диагонали двухмерного массива;
     */
    public static void fillSquareArray(int[][] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < intArray[i].length; j++) {
                if (i == j) {
                    intArray[i][j] = 1;
                } else {
                    intArray[i][j] = 0;
                }
                System.out.print("\t" + intArray[i][j]);
            }
            System.out.println(" ]");
        }
    }

    /**
     * Метод должен вернуть true если в массиве есть место,
     * //      в котором сумма левой и правой части массива равны.
     * //      Примеры:
     * //          checkBalance([1, 1, 1, ||, 2, 1]) → true,
     * //          checkBalance ([2, 1, 1, 2, 1]) → false,
     * //          checkBalance ([10, || 1, 2, 3, 4]) → true.
     */
    public static boolean checkBalance(int[] intArray) {
        boolean isEmptyPlace = false;
        int leftSumArray = 0;
        int rightSumArray = 0;
        int flagCenter = 0;
        printArray("Массив checkBalance: ", intArray);

        // находим середину
        if (intArray.length % 2 == 0) {
            flagCenter = intArray.length / 2;
        } else {
            flagCenter = intArray.length / 2 + 1;
        }

        // считаем баланс
        for (int i = 0; i < intArray.length; i++) {
            if (flagCenter <= i) {
                leftSumArray += intArray[i];
            } else {
                rightSumArray += intArray[i];
            }
        }

        // сравниваем балансы
        if (leftSumArray == rightSumArray) {
            isEmptyPlace = true;
        }
        return isEmptyPlace;
    }

    /**
     * Метод, которому на вход подаётся одномерный массив и число n
     * //      (может быть положительным, или отрицательным),
     * //      при этом метод должен циклически сместить все элементы массива на n позиций.
     * //     [1,2,3,4,5], -2 => [3,4,5,1,2]
     * //     [1,2,3,4,5], 2 => [4,5,1,2,3]
     */
    public static int[] moveArray(int[] intArray, int n) {
        int[] intMoveArray = new int[intArray.length];
        int j = 0;

        if (n > intArray.length || (-1) * n > intArray.length){
            System.out.println("Лень отлаживать с остатком от деления и пересчитывать сдвиг n");
        }else{
            for (int i = 0; i < intArray.length; i++) {
                if (i + n + 1 > intArray.length) {
                    j = i + n - intArray.length;
                } else if (i + n + 1 <= 0) {
                    j = i + n + intArray.length;
                } else {
                    j = i + n;
                }
                intMoveArray[j] = intArray[i];
            }
        }

        return intMoveArray;
    }

    /**
     * Метод, распечатывающий массив в консоле
     */
    public static void printArray(String comment, int[] intArray) {
        System.out.print(comment + ": ");
        System.out.print("[ ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print("\t" + intArray[i]);
        }
        System.out.println(" ]");
    }
}
