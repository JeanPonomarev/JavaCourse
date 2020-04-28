package ru.jeanponomarev.temperature.model.temperature_scales;

public interface TemperatureScale {
    double convertThisScaleToCelsius(double inputTemperature);

    double convertCelsiusToThisScale(double transitionTemperature);

    default double convertTemperature(TemperatureScale inputTemperatureScale, double inputTemperature) {
        double transitionTemperature = convertThisScaleToCelsius(inputTemperature);
        return inputTemperatureScale.convertCelsiusToThisScale(transitionTemperature);
    }
}
