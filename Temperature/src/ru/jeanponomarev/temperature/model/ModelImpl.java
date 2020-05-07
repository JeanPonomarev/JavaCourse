package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_converter.TemperatureConverter;
import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

import java.util.List;

public class ModelImpl implements Model {
    private final List<TemperatureScale> temperatureScalesList;

    public ModelImpl(List<TemperatureScale> temperatureScalesList) {
        this.temperatureScalesList = temperatureScalesList;
    }

    @Override
    public List<TemperatureScale> getTemperatureScales() {
        return temperatureScalesList;
    }

    @Override
    public double convertTemperature(double inputTemperature, TemperatureScale initialTemperatureScale, TemperatureScale resultTemperatureScale) {
        return TemperatureConverter.convertTemperature(initialTemperatureScale, resultTemperatureScale, inputTemperature);
    }
}
