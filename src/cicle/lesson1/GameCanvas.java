package cicle.lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    MainCircles controller;
    long lastFrameTime;
    int SLEEP_TIMER = 17;
    Background background;

    GameCanvas(MainCircles controller) {
        this.lastFrameTime = System.nanoTime();
        this.controller = controller;
        background = new Background(this);
    }

    // запускаем автообновление канваса с периодичностью засыпания
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        controller.onDrawFrame(this, g, deltaTime);
        background.setBackgroundColor(deltaTime);
        try {
            Thread.sleep(SLEEP_TIMER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    // получаем координаты границ канваса
    public float getLeft() {
        return 0;
    }

    public float getRight() {
        return this.getWidth() - 1;
    }

    public float getTop() {
        return 0;
    }

    public float getBottom() {
        return this.getHeight() - 1;
    }


}
