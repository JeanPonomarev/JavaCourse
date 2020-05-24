package ru.jeanponomarev.minesweeper.gui;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JFrame frame;
    private Container container;
    private GridBagConstraints constraints;

    private Board board;
    private Move move;
    private Click click;

    private JPanel menuPanel;
    private JPanel conditionPanel;
    private JPanel gamePanel;

    public void run() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Minesweeper");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(1295, 829);
            //frame.setMinimumSize(new Dimension(400, 400));
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            //frame.pack();
            frame.setVisible(true);

//            container = frame.getContentPane();
//            container.setLayout(new GridBagLayout());
//
//            constraints = new GridBagConstraints();
//            constraints.fill = GridBagConstraints.VERTICAL;
//
//            constraints.gridx = 0;
//            constraints.gridy = 0;
//
//            menuPanel = new JPanel();
//            menuPanel.add(new JButton("Menu Panel"));
//
//            container.add(menuPanel, constraints);
//
//            constraints.gridy = 1;
//
//            conditionPanel = new JPanel();
//            conditionPanel.add(new Button("Condition"));
//
//            container.add(conditionPanel, constraints);
//
//            constraints.gridy = 2;
//
//            gamePanel = new JPanel();
//            container.add(gamePanel, constraints);
//
//            gamePanel.setLayout(new GridLayout(9, 9));
//
//            for (int i = 0; i < 81; i++) {
//                JButton button = new JButton(String.valueOf(i));
//                button.setPreferredSize(new Dimension(2, 2));
//
//                gamePanel.add(new JButton(String.valueOf(i)));
//            }
            Move move = new Move();
            frame.addMouseMotionListener(move);

            Click click = new Click();
            frame.addMouseListener(click);

            board = new Board(move, click);
            frame.setContentPane(board);
        });
    }
}
