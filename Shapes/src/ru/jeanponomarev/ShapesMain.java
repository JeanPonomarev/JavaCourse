package ru.jeanponomarev;

import ru.jeanponomarev.shapes.Circle;
import ru.jeanponomarev.shapes.Rectangle;
import ru.jeanponomarev.shapes_comparators.ShapesAreaComparator;
import ru.jeanponomarev.shapes_comparators.ShapesPerimeterComparator;
import ru.jeanponomarev.shapes.Square;
import ru.jeanponomarev.shapes.Triangle;

import java.util.Arrays;

public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapesArray = new Shape[8];

        shapesArray[0] = new Square(2);
        shapesArray[1] = new Square(4);

        shapesArray[2] = new Triangle(1, 1, 5, 1, 5, 5);
        shapesArray[3] = new Triangle(0, 0, 7, 0, 7, 5);

        shapesArray[4] = new Rectangle(5, 2);
        shapesArray[5] = new Rectangle(3, 1);

        shapesArray[6] = new Circle(4);
        shapesArray[7] = new Circle(7);

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