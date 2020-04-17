package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;
import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScaleName;

import java.util.ArrayList;
import java.util.List;

public class ModelDesktop extends Model {
    public ModelDesktop(List<TemperatureScale> temperatureScalesList) {
        super(temperatureScalesList);
    }

    @Override
    public List<String> getTemperatureScaleUINames() {
        List<String> temperatureScalesNames = new ArrayList<>();

        for (TemperatureScale temperatureScale : temperatureScalesList) {
            temperatureScalesNames.add(temperatureScale.getTemperatureScaleName().getUserInterfaceScaleName());
        }

        return temperatureScalesNames;
    }

    @Override
    public double convertTemperature(double inputTemperature, TemperatureScaleName fromScaleEnum, TemperatureScaleName toScaleEnum) {
        double resultTemperature = 0;

        for (TemperatureScale temperatureScaleFrom : temperatureScalesList) {
            if (temperatureScaleFrom.getTemperatureScaleName().equals(fromScaleEnum)) {
                for (TemperatureScale temperatureScaleTo : temperatureScalesList) {
                    if (temperatureScaleTo.getTemperatureScaleName().equals(toScaleEnum)) {
                        resultTemperature = temperatureScaleFrom.convertTemperature(temperatureScaleTo, inputTemperature);
                        break;
                    }
                }
            }
        }

        return resultTemperature;
    }
}
