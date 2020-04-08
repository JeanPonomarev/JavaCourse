package ru.jeanponomarev.temperature.model.temperature_converters;

public class CelsiusToFahrenheitConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.CELSIUS_TO_FAHRENHEIT;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return inputTemperature * 9.0 / 5 + 32;
    }
}
