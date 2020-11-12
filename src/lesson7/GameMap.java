package lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    private MainWindow mainWindow;
    private char[][] field;                                                                                      // само поле
    private JLabel[][] fieldComponent;                                                                        // массив компонентов
    private int fieldSize;                                                                                       // размер поля
    private int winLength;                                                                                       // длина победы (количество в ряд)

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
        fieldComponent = new JLabel[fieldSize][fieldSize];
        setLayout(new GridLayout(fieldSize, fieldSize));
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                fieldComponent[i][j] = new JLabel("" + field[i][j]);
                add(fieldComponent[i][j]);
            }
        }
        printField();
    }

    /**
     * Метод обновления игрового поля
     */
    void printField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                fieldComponent[i][j].setText("" + field[i][j]);
            }
        }
    }
}
