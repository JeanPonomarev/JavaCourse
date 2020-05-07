package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

public interface Controller {
    TemperatureScale[] getTemperatureScales();

    void convertTemperature(double inputTemperature);
}
