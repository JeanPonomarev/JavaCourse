package ru.jeanponomarev.temperature.model.temperature_converter;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

public class TemperatureConverter {
    public static double convertTemperature(TemperatureScale initialTemperatureScale, TemperatureScale resultTemperatureScale, double inputTemperature) {
        double transitionTemperature = initialTemperatureScale.convertThisScaleToCelsius(inputTemperature);
        return resultTemperatureScale.convertCelsiusToThisScale(transitionTemperature);
    }
}
