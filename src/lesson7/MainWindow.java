package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POSX = 650;
    private static final int WINDOW_POSY = 270;

    private Settings settingWindow;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);            // действие на крестике по умолчанию
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);   // сразу дефолтно координаты и размеры
//        setLocation(WINDOW_POSX, WINDOW_POSY);                            // алтернатива указания местоположения окна по умолчанию
//        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);                             // альтернатива указания размеров окна по умолчанию
        JButton btnStart = new JButton("Создать новую игру");          // создаем кнопку создать игру
        JButton btnClose = new JButton("Закрыть");                      // создаем кнопку закрыть
        JButton btnSetting = new JButton("Настройки");                  // создаем кнопку настройку

        // делаем панельку
        JPanel pnlBottom = new JPanel();
        // в нее кладем в сетку 1 на 2
        pnlBottom.setLayout(new GridLayout(2, 2));
        // кнопки кладем на в сетку последовательно
        pnlBottom.add(btnStart);
        pnlBottom.add(btnClose);
        pnlBottom.add(btnSetting);

        // панельку размещаем в подвале
        add(pnlBottom, BorderLayout.SOUTH);

        settingWindow = new Settings(this);
        gameMap = new GameMap(this);

        // событие вызова настроек игры
        btnSetting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisibleWindow(true);
            }
        });

        // событие старта игры
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNewGame(
                        settingWindow.getModeGame(),
                        settingWindow.getFieldSize(),
                        settingWindow.getWinLength()
                );
                gameMap.setVisibleWindow(true);
            }
        });

        // событие закрытия игры
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        setResizable(false);                                                // изменение размера запрещено
        setTitle("Крестики нолики");                                        // заголовок модалки
        setVisible(true);                                                   // показать модалку после выполнения всех методов

    }

    void startNewGame(int mode, int fieldSize, int winLength) {
        gameMap.startNewGame(mode, fieldSize, winLength);
        gameMap.setVisibleWindow(true);
    }
}
