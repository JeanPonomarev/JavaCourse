package ru.jeanponomarev.temperature.controller;

import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.view.View;

public abstract class Controller {
    protected final Model model;
    protected View view;

    public Controller(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    abstract String[] getTemperatureScaleUINames();

    abstract void convertTemperature();
}
