package ru.jeanponomarev.application;

import ru.jeanponomarev.controller.Controller;
import ru.jeanponomarev.model.Model;
import ru.jeanponomarev.view.Window;

public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        Window window = new Window(controller);
        controller.setView(window);
        window.run();
    }
}
