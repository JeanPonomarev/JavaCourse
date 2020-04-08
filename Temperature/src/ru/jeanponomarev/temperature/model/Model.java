package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_converters.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private String[] comboBoxElements = {"Celsius", "Fahrenheit", "Kelvin"};

    private static List<TemperatureConverter> temperatureConvertersList;

    static {
        temperatureConvertersList = new ArrayList<>(Arrays.asList(
                new CelsiusToFahrenheitConverter(),
                new CelsiusToKelvinConverter(),
                new FahrenheitToCelsiusConverter(),
                new FahrenheitToKelvinConverter(),
                new KelvinToCelsiusConverter(),
                new KelvinToFahrenheitConverter(),
                new DefaultConverter()
        ));
    }

    public String[] getComboBoxElements() {
        return comboBoxElements;
    }

    public double convertTemperature(double inputTemperature, TemperatureScales inputEnum) {
        double resultTemperature = 0;

        for (TemperatureConverter temperatureConverter : temperatureConvertersList) {
            if (temperatureConverter.getTemperatureScales().equals(inputEnum)) {
                resultTemperature = temperatureConverter.convertTemperature(inputTemperature);
                break;
            }
        }

        return resultTemperature;
    }
}
