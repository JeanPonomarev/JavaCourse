package ru.jeanponomarev.temperature.model.temperature_converters;

public class KelvinToCelsiusConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.KELVIN_TO_CELSIUS;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return inputTemperature - 273.15;
    }
}
