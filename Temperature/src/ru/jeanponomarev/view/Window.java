package ru.jeanponomarev.view;

import ru.jeanponomarev.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Window implements View {
    private final Controller controller;

    private JFrame frame;
    private Container container;
    private GridBagConstraints constraints;
    private JTextField inputTextField;
    private JTextField outputTextField;
    private JComboBox<String> comboBoxLeft;
    private JComboBox<String> comboBoxRight;
    private JButton convertButton;

    private double resultTemperature;

    @Override
    public JTextField getInputTextField() {
        return inputTextField;
    }

    @Override
    public JComboBox<String> getComboBoxLeft() {
        return comboBoxLeft;
    }

    @Override
    public JComboBox<String> getComboBoxRight() {
        return comboBoxRight;
    }

    public Window(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void setResultTemperature(double resultTemperature) {
        this.resultTemperature = resultTemperature;
    }

    @Override
    public void showResult() {
        outputTextField.setText(String.valueOf(resultTemperature));
    }

    @Override
    public void showErrorMessage() {
        JOptionPane.showMessageDialog(frame,
                "Были введены не цифровые данные",
                "Data error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void run() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Temperature converter");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            container = frame.getContentPane();
            container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            container.setLayout(new GridBagLayout());

            constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;

            inputTextField = new JTextField();
            constraints.weightx = 0.5;
            constraints.weighty = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(5, 5, 5, 5);
            container.add(inputTextField, constraints);

            outputTextField = new JTextField();
            outputTextField.setEditable(false);
            constraints.weightx = 0.5;
            constraints.weighty = 0.2;
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.insets = new Insets(5, 5, 5, 5);
            container.add(outputTextField, constraints);

            comboBoxLeft = new JComboBox<>(controller.getComboBoxElements());
            constraints.weightx = 0.5;
            constraints.weighty = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(5, 5, 5, 5);
            container.add(comboBoxLeft, constraints);

            comboBoxRight = new JComboBox<>(controller.getComboBoxElements());
            constraints.weightx = 0.5;
            constraints.weighty = 0.2;
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.insets = new Insets(5, 5, 5, 5);
            container.add(comboBoxRight, constraints);

            convertButton = new JButton("Convert");
            constraints.weightx = 0.5;
            constraints.weighty = 0.2;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.gridwidth = 2;
            constraints.gridx = 0;
            constraints.gridy = 2;
            container.add(convertButton, constraints);

            convertButton.addActionListener(e -> controller.processConvertButtonClick());
        });
    }
}
