package ru.jeanponomarev.temperature.model.temperature_converters;

public class CelsiusToKelvinConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.CELSIUS_TO_KELVIN;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return inputTemperature + 273.15;
    }
}
