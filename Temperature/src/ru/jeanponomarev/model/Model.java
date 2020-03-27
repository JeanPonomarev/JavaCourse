package ru.jeanponomarev.model;

public class Model {
    public String[] comboBoxElements = {"Celsius", "Fahrenheit", "Kelvin"};

    public String[] getComboBoxElements() {
        return comboBoxElements;
    }

    private double roundResultTemperature(double resultTemperature) {
        resultTemperature = resultTemperature * 100;
        int resultTemperatureInteger = (int) Math.round(resultTemperature);
        return (double) resultTemperatureInteger / 100;
    }

    public double returnSameTemperature(double inputTemperature) {
        return roundResultTemperature(inputTemperature);
    }

    public double convertCelsiusToFahrenheit(double inputTemperature) {
        double resultTemperature = inputTemperature * 9.0 / 5 + 32;
        return roundResultTemperature(resultTemperature);
    }

    public double convertCelsiusToKelvin(double inputTemperature) {
        double resultTemperature = inputTemperature + 273.15;
        return roundResultTemperature(resultTemperature);
    }

    public double convertFahrenheitToCelsius(double inputTemperature) {
        double resultTemperature = (inputTemperature - 32) * 5.0 / 9;
        return roundResultTemperature(resultTemperature);
    }

    public double convertFahrenheitToKelvin(double inputTemperature) {
        double resultTemperature = (inputTemperature - 32) * 5.0 / 9 + 273.15;
        return roundResultTemperature(resultTemperature);
    }

    public double convertKelvinToCelsius(double inputTemperature) {
        double resultTemperature = inputTemperature - 273.15;
        return roundResultTemperature(resultTemperature);
    }

    public double convertKelvinToFahrenheit(double inputTemperature) {
        double resultTemperature = (inputTemperature - 273.15) * 9.0 / 5 + 32;
        return roundResultTemperature(resultTemperature);
    }
}
