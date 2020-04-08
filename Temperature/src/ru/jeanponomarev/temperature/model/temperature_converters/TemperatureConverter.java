package ru.jeanponomarev.temperature.model.temperature_converters;

public interface TemperatureConverter {
    double convertTemperature(double inputTemperature);

    TemperatureScales getTemperatureScales();
}
