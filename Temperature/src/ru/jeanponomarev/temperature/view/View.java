package ru.jeanponomarev.temperature.view;

public interface View {
    void showResult();

    void showErrorMessage();

    double getInputTemperature();

    String getInitialScale();

    String getResultScale();

    void setResultTemperature(double resultTemperature);
}
