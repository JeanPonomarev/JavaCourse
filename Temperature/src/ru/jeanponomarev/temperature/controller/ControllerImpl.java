package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.view.View;

public class ControllerImpl implements Controller {
    private final Model model;
    private View view;

    public ControllerImpl(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public String[] getTemperatureScaleUINames() {
        return model.getTemperatureScaleUINames().toArray(new String[]{});
    }

    @Override
    public void convertTemperature(double inputTemperature) {
        String initialScaleName = view.getInitialScale();
        String resultScaleName = view.getResultScale();

        double resultTemperature = model.convertTemperature(inputTemperature, initialScaleName, resultScaleName);
        view.setResultTemperature(resultTemperature);
        view.showResult();
    }
}
