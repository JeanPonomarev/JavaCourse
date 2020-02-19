package ru.jeanponomarev.shapes_main;

import ru.jeanponomarev.shape_interface.Shape;
import ru.jeanponomarev.shapes.Circle;
import ru.jeanponomarev.shapes.Rectangle;
import ru.jeanponomarev.shapes_comparators.ShapesAreaComparator;
import ru.jeanponomarev.shapes_comparators.ShapesPerimeterComparator;
import ru.jeanponomarev.shapes.Square;
import ru.jeanponomarev.shapes.Triangle;

import java.util.Arrays;

public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapesArray = {new Square(2), new Square(4), new Triangle(1, 1, 5, 1, 5, 5),
                new Triangle(0, 0, 7, 0, 7, 5), new Rectangle(5, 2),
                new Rectangle(3, 1), new Circle(4), new Circle(7)};

        System.out.println(getLargestAreaShape(shapesArray));
        System.out.println();
        System.out.println(getSecondLargestPerimeterShape(shapesArray));
    }

    public static Shape getLargestAreaShape(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new ShapesAreaComparator());

        return shapesArray[shapesArray.length - 1];
    }

    public static Shape getSecondLargestPerimeterShape(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new ShapesPerimeterComparator());

        return shapesArray[shapesArray.length - 2];
    }
}