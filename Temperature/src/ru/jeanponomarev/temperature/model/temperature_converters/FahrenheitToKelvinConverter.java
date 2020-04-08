package ru.jeanponomarev.temperature.model.temperature_converters;

public class FahrenheitToKelvinConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.FAHRENHEIT_TO_KELVIN;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return (inputTemperature - 32) * 5.0 / 9 + 273.15;
    }
}
