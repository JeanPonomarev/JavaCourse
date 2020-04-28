package ru.jeanponomarev.temperature.model.temperature_scales;

public class FahrenheitScale implements TemperatureScale {
    @Override
    public double convertThisScaleToCelsius(double inputTemperature) {
        return (inputTemperature - 32) * 5.0 / 9;
    }

    @Override
    public double convertCelsiusToThisScale(double transitionTemperature) {
        return transitionTemperature * 9.0 / 5 + 32;
    }
}
