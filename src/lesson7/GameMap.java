package lesson7;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.*;
import java.util.Random;

public class GameMap extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';
    public static final Random PCINPUT = new Random();

    private MainWindow mainWindow;
    private char[][] field;                                                                                             // само поле
    private JLabel[][] fieldJLabel;                                                                                     // массив лейблов
    private Component[][] fieldComponent;                                                                               // массив компонентов
    private int fieldSize;                                                                                              // размер поля
    private int winLength;                                                                                              // длина победы (количество в ряд)

    GameMap(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);               // сразу дефолтно размеры
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);         // делаем закрытие только этого окна
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Игровое окно");
        setBackground(Color.BLACK);
        addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {

            }

            public void windowClosed(WindowEvent event) {
                for (int i = 0; i < fieldSize; i++) {
                    for (int j = 0; j < fieldSize; j++) {
                        remove(fieldComponent[i][j]);
                    }
                }
            }

            public void windowClosing(WindowEvent event) {

            }

            public void windowDeactivated(WindowEvent event) {

            }

            public void windowDeiconified(WindowEvent event) {

            }

            public void windowIconified(WindowEvent event) {

            }

            public void windowOpened(WindowEvent event) {

            }

        });
    }

    public void setVisibleWindow(boolean visible) {
        this.setVisible(visible);
    }

    void startNewGame(int mode, int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;
        init();
        System.out.println("mode = " + mode +
                "\n fieldSize = " + fieldSize +
                "\n winLength = " + winLength
        );
        repaint();
    }

    /**
     * инициализируем игровое поле
     */
    void init() {
        System.out.println("Инициализируем игровое поле");
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
        fieldJLabel = new JLabel[fieldSize][fieldSize];
        fieldComponent = new Component[fieldSize][fieldSize];
        setLayout(new GridLayout(fieldSize, fieldSize));
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                fieldJLabel[i][j] = new JLabel("" + field[i][j], SwingConstants.CENTER);
                fieldJLabel[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                fieldComponent[i][j] = add(fieldJLabel[i][j]);
                fieldJLabel[i][j].addMouseListener(new MyMouseListener(i, j));
                this.add(fieldJLabel[i][j]);
            }
        }
        printField();
    }

    class MyMouseListener implements MouseListener {

        private int i;
        private int j;

        MyMouseListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            fieldJLabel[i][j].setText("" + GameMap.HUMAN_DOT);
            field[i][j] = GameMap.HUMAN_DOT;
            if (checkWin(HUMAN_DOT)) {
                System.out.println("" +
                        "Пользователь выиграл!");
                mainWindow.setLbFieldWin("Пользователь выиграл!");
                setVisible(false);
                dispose();
                return;
            }

            if (isFullField()) {
                System.out.println("Ничья");
                mainWindow.setLbFieldWin("Ничья!");
                setVisible(false);
                dispose();
                return;
            }

            tryPC();
            if (checkWin(PC_DOT)) {
                System.out.println("" +
                        "Компьютер выиграл!");
                mainWindow.setLbFieldWin("Компьютер выиграл!");
                setVisible(false);
                dispose();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
        }

    }

    /**
     * Метод обновления игрового поля
     */
    void printField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                fieldJLabel[i][j].setText("" + field[i][j]);
            }
        }
    }

    /**
     * Метод проверяет данные на корректность
     *
     * @param userX
     * @param userY
     * @return
     */
    public boolean isValidCell(int userX, int userY) {
        return userX >= 0 && userX < fieldSize && userY >= 0 && userY < fieldSize;
    }

    /**
     * Метод проверки поля на пустоту (возможность ввода в данную ячейку)
     *
     * @param userX
     * @param userY
     * @return
     */
    public boolean isEmptyCell(int userX, int userY) {
        return field[userX][userY] == EMPTY_DOT;
    }

    /**
     * Метод генерации хода
     */
    public void tryPC() {
        int pcX;
        int pcY;
        do {
            pcX = PCINPUT.nextInt(fieldSize);
            pcY = PCINPUT.nextInt(fieldSize);
        } while (!isEmptyCell(pcX, pcY));
        field[pcX][pcY] = PC_DOT;
        fieldJLabel[pcX][pcY].setText("" + GameMap.PC_DOT);
        field[pcX][pcY] = GameMap.PC_DOT;
    }

    /**
     * метод проверки выигрыша
     *
     * @param typeDot - Тип проверяемого значения (крестик или нолик)
     * @return
     */
    public boolean checkWin(char typeDot) {
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
    public boolean checkDiagonal(int startX, char typeDot) {
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
     * Метод проверки на заполненность всего поля
     *
     * @return
     */
    public boolean isFullField() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponents(g);
//        render(g);
//        System.out.println("перерисовка");
//    }
//
//    private void render(Graphics g) {
//        int width = getWidth();
//        int height = getHeight();
//    }
}
