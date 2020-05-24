package ru.jeanponomarev.minesweeper.gui;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Move move;
    private Click click;

    private int spacing = 5;

    public int mx = -100;
    public int my = -100;

    public Board(Move move, Click click) {
        this.move = move;
        this.click = click;
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0, 0, 1280, 800);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                graphics.setColor(Color.GRAY);

                System.out.println("X: " + move.getMx() + " , Y: " + move.getMy());

                if (move.getMx() >= spacing + i*80 && move.getMx() < spacing + i*80+80-2*spacing
                    && move.getMy() >= spacing + j*80+80 && move.getMy() < spacing + j*80+80+80-2*spacing
                ) {
                    graphics.setColor(Color.RED);
                }

                graphics.fillRect(spacing + i * 80, spacing + j * 80 + 80, 80 - 2 * spacing, 80 - 2 * spacing);
            }
        }
    }
}
