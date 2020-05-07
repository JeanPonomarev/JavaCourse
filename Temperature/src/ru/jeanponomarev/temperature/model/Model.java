package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

import java.util.List;

public interface Model {
    List<TemperatureScale> getTemperatureScales();

    double convertTemperature(double inputTemperature, TemperatureScale fromScaleName, TemperatureScale toScaleName);
}
