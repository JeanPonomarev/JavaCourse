package ru.jeanponomarev.temperature.view;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

public interface View {
    void showResult();

    void showErrorMessage();

    void run();

    double getInputTemperature();

    TemperatureScale getInitialScale();

    TemperatureScale getResultScale();

    void setResultTemperature(double resultTemperature);
}
