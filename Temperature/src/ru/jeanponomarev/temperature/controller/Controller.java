package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.model.temperature_converters.TemperatureScales;
import ru.jeanponomarev.temperature.view.View;

public class Controller {
    private final Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String[] getComboBoxElements() {
        return model.getComboBoxElements();
    }

    public void convertTemperature() {
        double inputTemperature;
        try {
            inputTemperature = view.getInputTemperature();
        } catch (NumberFormatException e) {
            view.showErrorMessage();
            return;
        }


        String leftScale = view.getLeftScale();
        String rightScale = view.getRightScale();

        String enumName = constructEnumName(leftScale, rightScale);
        TemperatureScales inputEnum = TemperatureScales.valueOf(enumName);

        double resultTemperature = model.convertTemperature(inputTemperature, inputEnum);
        view.setResultTemperature(resultTemperature);
        view.showResult();
    }

    private String constructEnumName(String leftScale, String rightScale) {
        if (leftScale.equals(rightScale)) {
            return "DEFAULT";
        }

        return leftScale.toUpperCase() + "_TO_" + rightScale.toUpperCase();
    }
}
