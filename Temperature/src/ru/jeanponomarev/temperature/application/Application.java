package ru.jeanponomarev.temperature.application;

import ru.jeanponomarev.temperature.controller.ControllerImpl;
import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.model.ModelImpl;
import ru.jeanponomarev.temperature.model.temperature_scales.*;
import ru.jeanponomarev.temperature.view.View;
import ru.jeanponomarev.temperature.view.Window;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<TemperatureScale> temperatureScales = Arrays.asList(
                new CelsiusScale(),
                new FahrenheitScale(),
                new KelvinScale(),
                new ReaumurScale()
        );

        Model model = new ModelImpl(temperatureScales);
        ControllerImpl controller = new ControllerImpl(model);
        View window = new Window(controller);
        controller.setView(window);
        window.run();
    }
}
