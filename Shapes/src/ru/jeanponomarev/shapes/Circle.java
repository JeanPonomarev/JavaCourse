package ru.jeanponomarev.shapes;

import ru.jeanponomarev.shape_interface.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус не может быть меньше либо равен нулю");
        }

        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return "Окружность" + System.lineSeparator() + "Радиус: " + radius
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

        Circle comparedCircle = (Circle) obj;

        return radius == comparedCircle.radius;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }
}
