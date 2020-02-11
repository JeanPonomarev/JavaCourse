package ru.jeanponomarev.shapes;

import ru.jeanponomarev.shapes.circle.Circle;
import ru.jeanponomarev.shapes.rectangle.Rectangle;
import ru.jeanponomarev.shapes.square.Square;
import ru.jeanponomarev.shapes.triangle.Triangle;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(shapesArray, new SortShapesByArea());

        return shapesArray[shapesArray.length - 1];
    }

    public static Shape getSecondLargestPerimeterShape(Shape[] shapesArray) {
        Arrays.sort(shapesArray, new SortShapesByPerimeter());

        return shapesArray[shapesArray.length - 2];
    }
}

class SortShapesByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape firstShape, Shape secondShape) {
        return Double.compare(firstShape.getArea(), secondShape.getArea());
    }
}

class SortShapesByPerimeter implements Comparator<Shape> {
    @Override
    public int compare(Shape firstShape, Shape secondShape) {
        return Double.compare(firstShape.getPerimeter(), secondShape.getPerimeter());
    }
}
