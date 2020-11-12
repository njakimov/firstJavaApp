package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Game {

    /**
     * Полностью разобраться с кодом, попробовать переписать с нуля;                            - выполнено
     * ^ Усовершенствовать метод проверки победы (через циклы);                                 - выполнено
     * ^ Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.           - выполнено
     * ^^ Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока.    - не сделано
     */
    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final Scanner USERINPUT = new Scanner(System.in);                                                     // интерфейс ввода от пользователя
    public static final Random PCINPUT = new Random();                                                                  // генерация случайных чисел - иммитация ввода ПК

    public static int winLength = 3;                                                                                    // серия игры (три подряд по умолчанию)
    public static int fieldSize = 0;                                                                                    // размер поля
    public static char[][] field;                                                                                       // само поле

    /**
     * крестики нолики
     * алгоритм:
     * 1. инициализировать переменные (вводим размеры поля)
     * 2. выводим пустое поле на экран
     * 3. инициализировать ход первого игрока
     * 4. обеспечить ввод данных от пользователя
     * 5. обеспечить проверку введеных данных
     * 6. обеспечить проверку результатов игры
     * 7. проверить возможность дальнейшей игры и сменить играющего
     * 8. проверить на ничью
     * 9. сгенерировать ход ПК радномайзом
     * 10. сгенерировать ход игры с учетом хода пользователя (поиск двух в ряд и диагональ
     * 11. проверить результаты игры при ходе компьютером
     * 12. Спросить у пользователя досрочное завершение
     * 13. проверить возможность продолжения игры далее и если да то повторить 3-12
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Старт работы программы");

        init();                                                                                                         // инициализируем поле
        while (true) {
            tryHuman();
            printField();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("" +
                        "Пользователь выиграл!");
                break;
            }

            if (isFullField()) {
                System.out.println("Ничья");
                break;
            }

            tryPC();
            printField();
            if (checkWin(PC_DOT)) {
                System.out.println("" +
                        "Компьютер выиграл!");
                break;
            }

            System.out.println("Для окончания игры введите -1");
            if (USERINPUT.nextInt() == -1) {
                break;
            }
        }

        System.out.println("Окончание работы программы. До свидания");
    }

    /**
     * инициализируем игровое поле
     */
    public static void init() {
        System.out.println("Инициализируем игровое поле");
        System.out.println("Введите размеры игрового поля больше 3: ");
        while (true) {
            fieldSize = USERINPUT.nextInt();
            if (fieldSize == 3) {
                break;
            } else if (fieldSize > 3) {
                winLength = 4;                                                                                         // если размер поля больше 3 в ряд, то делаем серию игры равную 4
                break;
            } else {
                System.out.println("Размер игрового поля должен быть больше 3. Повторите ввод: ");
            }
        }
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
        printField();
    }

    /**
     * Метод вывода игрового поля
     */
    public static void printField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * метод обработки данных от пользователя
     */
    public static void tryHuman() {
        int userX = 0, userY = 0;                                                                                           // координаты ячейки, в которые вносим данные
        do {
            System.out.println("Введите координаты строки:");
            userX = USERINPUT.nextInt() - 1;
            System.out.println("Введите координаты столбца:");
            userY = USERINPUT.nextInt() - 1;
        } while (!isValidCell(userX, userY) || !isEmptyCell(userX, userY));
        field[userX][userY] = HUMAN_DOT;
    }

    /**
     * Метод проверяет данные на корректность
     * @param userX
     * @param userY
     * @return
     */
    public static boolean isValidCell(int userX, int userY) {
        return userX >= 0 && userX < fieldSize && userY >= 0 && userY < fieldSize;
    }

    /**
     * Метод проверки поля на пустоту (возможность ввода в данную ячейку)
     * @param userX
     * @param userY
     * @return
     */
    public static boolean isEmptyCell(int userX, int userY) {
        return field[userX][userY] == EMPTY_DOT;
    }

    /**
     * метод проверки выигрыша
     *
     * @param typeDot - Тип проверяемого значения (крестик или нолик)
     * @return
     */
    public static boolean checkWin(char typeDot) {
        for (int i = 0; i < fieldSize; i++) {
            int countRow = 0;                                                                                           // количество попаданий в ряд
            int countColumn = 0;                                                                                        // количество попаданий в столбец
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == typeDot) {
                    countRow++;
                    if (countRow == winLength) {
                        return true;
                    }
                } else {
                    countRow = 0;
                }

                if (field[j][i] == typeDot) {
                    countColumn++;
                    if (countColumn == winLength) {
                        return true;
                    }
                } else {
                    countColumn = 0;
                }
            }
        }

        for (int i = 0; i < fieldSize; i++) {
            if (checkDiagonal(i, typeDot)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Метод проверки диагональных элементов
     *
     * @param startX
     * @param typeDot
     * @return
     */
    public static boolean checkDiagonal(int startX, char typeDot) {
        int countDiagonalPositiveRow = 0;
        int countDiagonalPositiveColumn = 0;
        int countDiagonalNegativeRow = 0;
        int countDiagonalNegativeColumn = 0;
        for (int i = 0; i < fieldSize - startX; i++) {
            if (field[i][i + startX] == typeDot) {
                countDiagonalPositiveRow++;
                if (countDiagonalPositiveRow == winLength) {
                    return true;
                }
            } else {
                countDiagonalPositiveRow = 0;
            }

            if (field[i + startX][i] == typeDot) {
                countDiagonalPositiveColumn++;
                if (countDiagonalPositiveColumn == winLength) {
                    return true;
                }
            } else {
                countDiagonalPositiveColumn = 0;
            }

            if ((fieldSize - startX - i - 1) > 0 && field[i][fieldSize - 1 - startX - i] == typeDot) {
                countDiagonalNegativeRow++;
                if (countDiagonalNegativeRow == winLength) {
                    return true;
                }
            } else {
                countDiagonalNegativeRow = 0;
            }

            if ((fieldSize - startX - i - 1) > 0 && field[fieldSize - 1 - startX - i][i] == typeDot) {
                countDiagonalNegativeColumn++;
                if (countDiagonalNegativeColumn == winLength) {
                    return true;
                }
            } else {
                countDiagonalNegativeColumn = 0;
            }

        }
        return false;
    }

    /**
     * Метод генерации хода
     */
    public static void tryPC() {
        int pcX;
        int pcY;
        do {
            pcX = PCINPUT.nextInt(fieldSize);
            pcY = PCINPUT.nextInt(fieldSize);
        } while (!isEmptyCell(pcX, pcY));
        field[pcX][pcY] = PC_DOT;
    }

    /**
     * Метод проверки на заполненность всего поля
     * @return
     */
    public static boolean isFullField() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
