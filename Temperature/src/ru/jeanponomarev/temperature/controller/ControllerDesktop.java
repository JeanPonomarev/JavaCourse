package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScaleName;

public class ControllerDesktop extends Controller{
    public ControllerDesktop(Model model) {
        super(model);
    }

    @Override
    public String[] getTemperatureScaleUINames() {
        return model.getTemperatureScaleUINames().toArray(new String[]{});
    }

    @Override
    public void convertTemperature() {
        double inputTemperature;
        try {
            inputTemperature = view.getInputTemperature();
        } catch (NumberFormatException e) {
            view.showErrorMessage();
            return;
        }

        String initialScale = view.getInitialScale();
        String resultScale = view.getResultScale();

        TemperatureScaleName initialScaleEnum = TemperatureScaleName.valueOf(initialScale.toUpperCase());
        TemperatureScaleName resultScaleEnum = TemperatureScaleName.valueOf(resultScale.toUpperCase());

        double resultTemperature = model.convertTemperature(inputTemperature, initialScaleEnum, resultScaleEnum);
        view.setResultTemperature(resultTemperature);
        view.showResult();
    }
}
