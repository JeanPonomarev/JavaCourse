package ru.jeanponomarev.temperature.model.temperature_scales;

public class KelvinScale implements TemperatureScale {
    @Override
    public double convertThisScaleToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertCelsiusToThisScale(double transitionTemperature) {
        return transitionTemperature + 273.15;
    }

    @Override
    public String toString() {
        return "Kelvin";
    }
}
