package ru.jeanponomarev.temperature.application;

import ru.jeanponomarev.temperature.controller.ControllerDesktop;
import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.model.ModelDesktop;
import ru.jeanponomarev.temperature.model.temperature_scales.*;
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

        Model model = new ModelDesktop(temperatureScales);
        ControllerDesktop controller = new ControllerDesktop(model);
        Window window = new Window(controller);
        controller.setView(window);
        window.run();
    }
}
