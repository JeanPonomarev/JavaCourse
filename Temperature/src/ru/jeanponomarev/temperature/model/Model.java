package ru.jeanponomarev.temperature.model;

import java.util.List;

public interface Model {
    List<String> getTemperatureScaleUINames();

    double convertTemperature(double inputTemperature, String fromScaleName, String toScaleName);
}
