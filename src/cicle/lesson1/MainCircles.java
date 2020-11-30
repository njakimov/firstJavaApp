package cicle.lesson1;

import javax.swing.*;
import java.awt.*;

// алгоритм:
// 1. создать форму, задать параметры и события по умолчанию по закрытию
// 2. создать классы шариков
// 3. проинициализировать шарики
// 4. создать канвас и вызвать его из главного контроллера, он по готовности запускает основную работу в контроллере
// 5. в классах шариков сделать поведение самостоятельное от размеров экрана
public class MainCircles extends JFrame {

    private static int X_FRAME = 100;
    private static int Y_FRAME = 100;
    private static int WIDTH_FRAME = 300;
    private static int HEIGHT_FRAME = 400;
    private Sprite[] sprites;

    /**
     * Конструктор приложения - инициализирует все приложение - центральная точка входа из функции main класса MainRun
     */
    MainCircles() {
        JFrame.setDefaultLookAndFeelDecorated(true);                                                                    // декорируем окно
        JFrame mainCircles = new JFrame();                                                                              // создаем главное окно
        mainCircles.setDefaultCloseOperation(EXIT_ON_CLOSE);                                                            // действие по закрытию окна
        mainCircles.setBounds(X_FRAME, Y_FRAME, WIDTH_FRAME, HEIGHT_FRAME);                                             // размеры по умолчанию
        GameCanvas gameCanvas = new GameCanvas(this);                                                           // создаем канву, на которой рисуем спрайты
        initApplication();                                                                                              // инициализируем по умолчанию приложение спрайтами
        gameCanvas.addMouseListener(new MyMouseListener(this));                                                 // добавляем обработчик нажатий кнопки мыши
        mainCircles.add(gameCanvas);                                                                                    // добавляем канву на клавное окно
        mainCircles.setVisible(true);                                                                                   // отображаем окно
    }

    /**
     * центральный вызов из канваса на обновление и перерисовку
     *
     * @param gameCanvas
     * @param g
     * @param deltaTime
     */
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
//        System.out.println(deltaTime);
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    /**
     * создаем спрайты по умолчанию
     */
    private void initApplication() {
        sprites = new Sprite[10];
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    /**
     * Добавление новых кружков по клику левой кнопки мыши
     */
    public void addSprite() {
        int lengthSprite = sprites.length + 1;
        Sprite[] tempSprite = sprites;

        sprites = new Sprite[lengthSprite];

        for (int i = 0; i < sprites.length; i++) {
            if (i < lengthSprite - 1) {
                sprites[i] = tempSprite[i];
            } else {
                sprites[i] = new Ball();
            }
        }
        System.out.println("Длина массива после добавления: " + lengthSprite);
    }

    /**
     * Удаление кружков по клику правой кнопки мыши
     */
    public void delSprite() {
        int lengthSprite = sprites.length - 1;
        if (lengthSprite != -1) {
            Sprite[] tempSprite = sprites;

            sprites = new Sprite[lengthSprite];

            for (int i = 0; i < lengthSprite; i++) {
                sprites[i] = tempSprite[i];
            }
        }
        System.out.println("Длина массива после удаления: " + lengthSprite);
    }

    /**
     * изменяет координаты спрайтов
     *
     * @param canvas
     * @param deltaTime
     */
    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    /**
     * обновляет канвас принудительно
     *
     * @param canvas
     * @param g
     */
    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
