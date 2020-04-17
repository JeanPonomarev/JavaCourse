package ru.jeanponomarev.temperature.model.temperature_scales;

public class ReaumurScale implements TemperatureScale {
    @Override
    public TemperatureScaleName getTemperatureScaleName() {
        return TemperatureScaleName.REAUMUR;
    }

    @Override
    public double convertThisScaleToCelsius(double inputTemperature) {
        return inputTemperature / 0.8;
    }

    @Override
    public double convertCelsiusToThisScale(double transitionTemperature) {
        return transitionTemperature * 0.8;
    }
}
