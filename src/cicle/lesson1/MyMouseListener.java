package cicle.lesson1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// класс отслеживания кликов мыши по MainCircles
class MyMouseListener implements MouseListener {


    MainCircles controller;

    MyMouseListener(MainCircles controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            controller.addSprite();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            controller.delSprite();
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