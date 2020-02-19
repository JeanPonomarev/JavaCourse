package ru.jeanponomarev.shapes;

import ru.jeanponomarev.shape_interface.Shape;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Длина стороны не должна быть меньше или равна нулю");
        }

        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return width * 4;
    }

    @Override
    public String toString() {
        return "Квадрат " + System.lineSeparator() + "Длина стороны: " + getWidth()
                + System.lineSeparator() + "Площадь: " + getArea() + System.lineSeparator() + "Периметр: " + getPerimeter();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Square comparedSquare = (Square) obj;

        return width == comparedSquare.width;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(width);
    }
}
