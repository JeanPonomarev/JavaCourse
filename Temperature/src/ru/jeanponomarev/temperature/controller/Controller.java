package ru.jeanponomarev.temperature.controller;

public interface Controller {
    String[] getTemperatureScaleUINames();

    void convertTemperature(double inputTemperature);
}
