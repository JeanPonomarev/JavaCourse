package ru.jeanponomarev.temperature.model.temperature_scales;

public class CelsiusScale implements TemperatureScale {
    @Override
    public double convertThisScaleToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertCelsiusToThisScale(double transitionTemperature) {
        return transitionTemperature;
    }
}
