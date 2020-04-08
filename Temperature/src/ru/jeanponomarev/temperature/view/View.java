package ru.jeanponomarev.temperature.view;

import javax.swing.*;

public interface View {
    void showResult();

    void showErrorMessage();

    JTextField getInputTextField();

    double getInputTemperature();

    JComboBox<String> getComboBoxLeft();

    String getLeftScale();

    JComboBox<String> getComboBoxRight();

    String getRightScale();

    void setResultTemperature(double resultTemperature);
}
