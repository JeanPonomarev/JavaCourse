package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;
import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScaleName;

import java.util.List;

public abstract class Model {
    protected List<TemperatureScale> temperatureScalesList;

    public Model(List<TemperatureScale> temperatureScalesList) {
        this.temperatureScalesList = temperatureScalesList;
    }

    public abstract List<String> getTemperatureScaleUINames();

    public abstract double convertTemperature(double inputTemperature, TemperatureScaleName fromScaleEnum, TemperatureScaleName toScaleEnum);
}
