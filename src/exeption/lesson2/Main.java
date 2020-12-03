package exeption.lesson2;

public class Main {
    /**
     * Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
     * <p>
     * 10 3 1 2
     * 2 3 2 2
     * 5 6 7 1
     * 300 3 1 0
     * <p>
     * Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
     * 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
     * 3. Ваши методы должны бросить исключения в случаях:
     * Если размер матрицы, полученной из строки, не равен 4x4;
     * Если в одной из ячеек полученной матрицы не число; (например символ или слово)
     * 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
     * 5. * Написать собственные классы исключений для каждого из случаев
     */

    public static void main(String[] args) {
        String stringMatrix = "10 3 1 2\n2 3 ш 2\n5 6 7 1\n300 3 1 0";
        String[][] matrix;
        float sumMatrix;
        try {
            //Character.isDigit(stringMatrix.charAt(i)) &&
            matrix = stringToArray(stringMatrix);
            sumMatrix = sumArray(matrix);
            System.out.println("Закончил преобразование. Сумма элементов массива: " + sumMatrix);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    // вариант 1. Три отдельных метода. Один преобразует в массив. Один проверяет на число. Один суммирует и делит на 2

    // просуммировать массив и поделить на 2 + проверка на число
    public static float sumArray(String[][] arrayString) throws MyException {
        int sumMatrix = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isDigit(arrayString[i][j])) {
                    sumMatrix += Integer.parseInt(arrayString[i][j]);
                } else {
                    throw new MyException("Строка не число");
                }
            }
        }

        return sumMatrix / 2f;
    }

    // строку в массив
    // метод так же можно было реализовать через split - т.к. применение конкретных технологий не оговорено, то остается так как есть.
    // это тот самый момент, когда не одназначен выбор решения при выполнении дз. и не ясно, до какой глубины педантности нужно выполнять дз.
    // Иными словами при выполнении дз можно дойти до разработки фрэймворка - лишь бы времени хватило.
    public static String[][] stringToArray(String stringMatrix) throws MyException {
        String[][] matrix = new String[4][4];
        int column = 0;
        int row = 0;

        for (int i = 0; i < stringMatrix.length(); i++) {
            if (stringMatrix.charAt(i) == '\n') {
                row++;
                column = 0;
                if (row == 4) {
                    throw new MyException("Неверная структура. Не 4x4. Много строк!");
                }
            } else if (stringMatrix.charAt(i) == ' ') {
                column++;
                if (column == 4) {
                    throw new MyException("Неверная структура. Не 4x4. Много столбцов!");
                }
            } else if (matrix[row][column] == null) {
                matrix[row][column] = "" + stringMatrix.charAt(i);
            } else {
                matrix[row][column] += "" + stringMatrix.charAt(i);
            }
        }

        return matrix;
    }

    // проверка строки на число
    // метод выкидывает исключение если не число, и это проверяется дальше
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // вариант 2
    // сразу проверяет на число и вычисляет сумму без доп методов - так я сделал сразу, но понял, что это не по заданию. Но пусть остается здесь для истории
    public static float stringToArray2(String stringMatrix) throws Exception {
        float sumMatrix = 0;

        String[][] matrix = new String[4][4];
        int column = 0;
        int row = 0;

        for (int i = 0; i < stringMatrix.length(); i++) {
            if (stringMatrix.charAt(i) == '\n') {
                sumMatrix += Integer.parseInt(matrix[row][column]);
                row++;
                column = 0;
                if (row == 4) {
                    throw new Exception("неверная структура. Не 4x4. Много строк");
                }
            } else if (stringMatrix.charAt(i) == ' ') {
                sumMatrix += Integer.parseInt(matrix[row][column]);
                column++;
                if (column == 4) {
                    throw new Exception("неверная структура. Не 4x4. Много столбцов");
                }
            } else if (Character.isDigit(stringMatrix.charAt(i)) && matrix[row][column] == null) {
                matrix[row][column] = "" + stringMatrix.charAt(i);
            } else if (Character.isDigit(stringMatrix.charAt(i))) {
                matrix[row][column] += "" + stringMatrix.charAt(i);
            } else {
                throw new Exception("неверная структура строки. Не число");
            }
        }

        return sumMatrix / 2f;
    }


}


