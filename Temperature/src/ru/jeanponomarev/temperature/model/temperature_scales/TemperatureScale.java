package ru.jeanponomarev.temperature.model.temperature_scales;

public interface TemperatureScale {
    double convertThisScaleToCelsius(double inputTemperature);

    double convertCelsiusToThisScale(double transitionTemperature);
}
