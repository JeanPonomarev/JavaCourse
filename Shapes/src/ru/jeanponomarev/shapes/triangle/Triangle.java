package ru.jeanponomarev.shapes.triangle;

import ru.jeanponomarev.shapes.Shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private static final double EPSILON = 1.0e-10;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double firstPartLineEquation = (x3 - x1) / (x2 - x1);
        double secondPartLineEquation = (y3 - y1) / (y2 - y1);

        if (Double.isNaN(firstPartLineEquation) || Double.isNaN(secondPartLineEquation) || Math.abs(firstPartLineEquation - secondPartLineEquation) <= EPSILON) {
            throw new IllegalArgumentException("Заданные точки лежат на одной прямой");
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return getMaximum(x1, x2, x3) - getMinimum(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMaximum(y1, y2, y3) - getMinimum(y1, y2, y3);
    }

    @Override
    public double getArea() {
        double[] sidesLength = getSidesLength();

        double halfPerimeter = getPerimeter() / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - sidesLength[0]) * (halfPerimeter - sidesLength[1]) * (halfPerimeter - sidesLength[2]));
    }

    @Override
    public double getPerimeter() {
        double[] sidesLength = getSidesLength();

        double perimeter = 0;

        for (double side : sidesLength) {
            perimeter += side;
        }

        return perimeter;
    }

    private double getMaximum(double coordinate1, double coordinate2, double coordinate3) {
        double maximum = Math.max(coordinate1, coordinate2);
        maximum = Math.max(maximum, coordinate3);
        return maximum;
    }

    private double getMinimum(double coordinate1, double coordinate2, double coordinate3) {
        double minimum = Math.min(coordinate1, coordinate2);
        minimum = Math.min(minimum, coordinate3);
        return minimum;
    }

    private double[] getSidesLength() {
        double firstSideLength = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double secondSideLength = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double thirdSideLength = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));

        return new double[]{firstSideLength, secondSideLength, thirdSideLength};
    }

    @Override
    public String toString() {
        return "Треугольник" + System.lineSeparator() + "Координаты вершин: [" + x1 + ", " + y1 + "], [" + x2 + ", " + y2 + "], [" + x2 + ", " + y2 + "]"
                + System.lineSeparator() + "Ширина: " + getWidth() + System.lineSeparator() + "Высота: " + getHeight()
                + System.lineSeparator() + "Площадь: " + getArea() + System.lineSeparator() + "Периметр: " + getPerimeter();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Triangle comparedTriangle = (Triangle) obj;

        return Math.abs(x1 - comparedTriangle.x1) <= EPSILON && Math.abs(y1 - comparedTriangle.y1) <= EPSILON
                && Math.abs(x2 - comparedTriangle.x2) <= EPSILON && Math.abs(y2 - comparedTriangle.y2) <= EPSILON
                && Math.abs(x3 - comparedTriangle.x3) <= EPSILON && Math.abs(y3 - comparedTriangle.y3) <= EPSILON;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}
