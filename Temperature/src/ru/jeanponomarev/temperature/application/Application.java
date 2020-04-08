package ru.jeanponomarev.temperature.application;

import ru.jeanponomarev.temperature.controller.Controller;
import ru.jeanponomarev.temperature.model.Model;
import ru.jeanponomarev.temperature.view.Window;

public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        Window window = new Window(controller);
        controller.setView(window);
        window.run();
    }
}
