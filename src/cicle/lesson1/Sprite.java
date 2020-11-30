package cicle.lesson1;

import java.awt.*;

public abstract class Sprite {

    protected float x;
    protected float y;
    protected float width;
    protected float height;

    protected float getWidth() {
        return width;
    }

    protected float getHeight() {
        return height;
    }

    protected float getLeft() {
        return x;
    }

    protected void setLeft(float left) {
        x = left;
    }

    protected float getRight() {
        return x + width;
    }

    protected void setRight(float right) {
        x = right - width;
    }

    protected float getTop() {
        return y;
    }

    protected void setTop(float top) {
        y = top;
    }

    protected float getBottom() {
        return y + height;
    }

    protected void setBottom(float bottom) {
        y = bottom - height;
    }

    void update(GameCanvas canvas, float deltaTime) {
    }

    void render(GameCanvas canvas, Graphics g) {
    }
}
