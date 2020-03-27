package ru.jeanponomarev.controller;

import ru.jeanponomarev.model.Model;
import ru.jeanponomarev.view.View;

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

    public void processConvertButtonClick() {
        double inputTemperature;
        try {
            inputTemperature = Double.parseDouble(view.getInputTextField().getText());
        } catch (NumberFormatException e) {
            view.showErrorMessage();
            return;
        }

        @SuppressWarnings("ConstantConditions")
        double resultTemperature = convertTemperature(inputTemperature, (String) view.getComboBoxLeft().getSelectedItem(), (String) view.getComboBoxRight().getSelectedItem());
        view.setResultTemperature(resultTemperature);
        view.showResult();
    }

    public double convertTemperature(double inputTemperature, String leftScale, String rightScale) {
        if (leftScale.equals("Celsius")) {
            if (rightScale.equals("Celsius")) {
                return model.returnSameTemperature(inputTemperature);
            }

            if (rightScale.equals("Fahrenheit")) {
                return model.convertCelsiusToFahrenheit(inputTemperature);
            }

            return model.convertCelsiusToKelvin(inputTemperature);
        }

        if (leftScale.equals("Fahrenheit")) {
            if (rightScale.equals("Celsius")) {
                return model.convertFahrenheitToCelsius(inputTemperature);
            }

            if (rightScale.equals("Fahrenheit")) {
                return model.returnSameTemperature(inputTemperature);
            }

            return model.convertFahrenheitToKelvin(inputTemperature);
        }

        if (rightScale.equals("Celsius")) {
            return model.convertKelvinToCelsius(inputTemperature);
        }

        if (rightScale.equals("Fahrenheit")) {
            return model.convertKelvinToFahrenheit(inputTemperature);
        }

        return model.returnSameTemperature(inputTemperature);
    }
}
