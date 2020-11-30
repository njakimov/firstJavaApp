package cicle.lesson1;

import java.awt.*;

public class Background {
    //Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
    GameCanvas gameCanvas;

    Background(GameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
    }

    // установка бэкгроунда канвы
    public void setBackgroundColor(float time) {
        if (time < 0.1) {
            time *= 10;
        }
        Color color = new Color(time, time, time);
//        System.out.println(color);
        gameCanvas.setBackground(color);

    }
}
