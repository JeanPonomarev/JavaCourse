package ru.jeanponomarev.temperature.view;

public interface View {
    void showResult();

    void showErrorMessage();

    void run();

    double getInputTemperature();

    String getInitialScale();

    String getResultScale();

    void setResultTemperature(double resultTemperature);
}
