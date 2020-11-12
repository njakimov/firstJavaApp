package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int MIN_WIN_SIZE = 3;
    private static final int MIN_WIN_LENGTH = 3;
    private static final String WIN_LENGTH_PREFIX = "Условия победы: ";
    private static final String FIELD_SIZE_PREFIX = "Размер игрового поля: ";
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 5;

    private MainWindow mainWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider sliderFieldSize;
    private JSlider slideWinLength;
    private int modeGame = GameMap.MODE_HVA;
    private int fieldSize = 3;
    private int winLength = 3;

    public int getModeGame() {
        return modeGame;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public int getWinLength() {
        return winLength;
    }

    Settings(MainWindow mainWindow) {
        // настройки самого модального окна
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);               // сразу дефолтно размеры
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);         // делаем закрытие только этого окна
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Настройки");

        // содержимое модалки
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addFieldMapControl();

        JButton btnPlay = new JButton("Начать игру");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayGameClick();
            }
        });

        add(btnPlay);

        setVisible(false);
    }

    public void setVisibleWindow(boolean visible) {
        this.setVisible(visible);
    }

    // установка режима игры (пк/человек)
    private void addGameModeSetup() {
        add(new JLabel("Выберите режим игры:"));

        humVSAI = new JRadioButton("Человек против ПК", true);
        humVSHum = new JRadioButton("Человек против человека");

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVSHum);

        add(humVSAI);
        add(humVSHum);
    }

    private void addFieldMapControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_SIZE);

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLength.setMaximum(currentValue);
            }
        });

        slideWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLength.getValue());
            }
        });

        add(new JLabel("Выберите размер игрового поля: "));

        add(lbFieldSize);
        add(sliderFieldSize);

        add(new JLabel("Выберите условие победы: "));
        add(lbWinLength);
        add(slideWinLength);
    }

    private void btnPlayGameClick() {
        int modeGame;

        if (humVSAI.isSelected()) {
            modeGame = GameMap.MODE_HVA;
        } else if (humVSHum.isSelected()) {
            modeGame = GameMap.MODE_HVH;
        } else {
            throw new RuntimeException("Неизвестный игровой режим");
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = slideWinLength.getValue();

        this.modeGame = modeGame;
        this.fieldSize = fieldSize;
        this.winLength = winLength;
        mainWindow.startNewGame(modeGame, fieldSize, winLength);
        setVisible(false);
        dispose();
    }
}
