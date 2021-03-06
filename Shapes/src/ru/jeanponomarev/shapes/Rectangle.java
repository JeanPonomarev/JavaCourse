package ru.jeanponomarev.shapes;

import ru.jeanponomarev.shape_interface.Shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Длины сторон не могут быть меньше либо равны нулю");
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Прямоугольник" + System.lineSeparator() + "Ширина: " + getWidth() + System.lineSeparator() + "Высота: " + getHeight()
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

        Rectangle comparedRectangle = (Rectangle) obj;

        return width == comparedRectangle.width && height == comparedRectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}
