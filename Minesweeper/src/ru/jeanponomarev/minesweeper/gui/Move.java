package ru.jeanponomarev.minesweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Move implements MouseMotionListener {
    private int mx;
    private int my;

    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("The mouse was moved");
        mx = e.getX();
        my = e.getY();

        //System.out.println("X: " + mx + " , Y: " + my);
    }
}
