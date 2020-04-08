package ru.jeanponomarev.temperature.model.temperature_converters;

public class KelvinToFahrenheitConverter implements TemperatureConverter {
    private final TemperatureScales temperatureScales = TemperatureScales.KELVIN_TO_FAHRENHEIT;

    @Override
    public TemperatureScales getTemperatureScales() {
        return temperatureScales;
    }

    @Override
    public double convertTemperature(double inputTemperature) {
        return (inputTemperature - 273.15) * 9.0 / 5 + 32;
    }
}
