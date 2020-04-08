package ru.jeanponomarev.temperature.model.temperature_converters;

public class DefaultConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.DEFAULT;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return inputTemperature;
    }
}
