package ru.jeanponomarev.temperature.model.temperature_converters;

public class FahrenheitToCelsiusConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.FAHRENHEIT_TO_CELSIUS;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return (inputTemperature - 32) * 5.0 / 9;
    }
}
