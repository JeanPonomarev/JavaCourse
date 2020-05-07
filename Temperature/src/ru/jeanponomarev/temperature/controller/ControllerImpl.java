package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.model.temperature_scales.TemperatureScale;
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
    public TemperatureScale[] getTemperatureScales() {
        return model.getTemperatureScales().toArray(new TemperatureScale[]{});
    }

    @Override
    public void convertTemperature(double inputTemperature) {
        TemperatureScale initialTemperatureScale = view.getInitialScale();
        TemperatureScale resultTemperatureScale = view.getResultScale();

        double resultTemperature = model.convertTemperature(inputTemperature, initialTemperatureScale, resultTemperatureScale);
        view.setResultTemperature(resultTemperature);
        view.showResult();
    }
}
