package ru.jeanponomarev.temperature.model;

import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private List<TemperatureScale> temperatureScalesList;

    public ModelImpl(List<TemperatureScale> temperatureScalesList) {
        this.temperatureScalesList = temperatureScalesList;
    }

    @Override
    public List<String> getTemperatureScaleUINames() {
        List<String> temperatureScalesNames = new ArrayList<>();

        for (TemperatureScale temperatureScale : temperatureScalesList) {
            temperatureScalesNames.add(getTemperatureScaleName(temperatureScale));
        }

        return temperatureScalesNames;
    }

    private String getTemperatureScaleName(TemperatureScale temperatureScale) {
        String fullClassName = temperatureScale.getClass().getName();
        String[] fullClassNameParts = fullClassName.split("\\.");

        return fullClassNameParts[fullClassNameParts.length - 1].replace("Scale", "");
    }

    @Override
    public double convertTemperature(double inputTemperature, String initialScaleName, String resultScaleName) {
        double resultTemperature = 0;

        for (TemperatureScale temperatureScaleFrom : temperatureScalesList) {
            if (getTemperatureScaleName(temperatureScaleFrom).equals(initialScaleName)) {
                for (TemperatureScale temperatureScaleTo : temperatureScalesList) {
                    if (getTemperatureScaleName(temperatureScaleTo).equals(resultScaleName)) {
                        resultTemperature = temperatureScaleFrom.convertTemperature(temperatureScaleTo, inputTemperature);
                        break;
                    }
                }
            }
        }

        return resultTemperature;
    }
}
