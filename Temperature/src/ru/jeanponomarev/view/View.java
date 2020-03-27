package ru.jeanponomarev.view;

import javax.swing.*;

public interface View {
    void showResult();

    void showErrorMessage();

    JTextField getInputTextField();

    JComboBox<String> getComboBoxLeft();

    JComboBox<String> getComboBoxRight();

    void setResultTemperature(double resultTemperature);
}
