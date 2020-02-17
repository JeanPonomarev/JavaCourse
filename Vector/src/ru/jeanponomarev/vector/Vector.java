package ru.jeanponomarev.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше либо равна нулю");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше либо равна нулю");
        }

        this.components = Arrays.copyOf(components, components.length);

        if (getLength() == 0) {
            throw new IllegalArgumentException("Нельзя создавать вектор длины 0");
        }
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше либо равна нулю");
        }

        this.components = Arrays.copyOf(components, n);

        if (getLength() == 0) {
            throw new IllegalArgumentException("Нельзя создавать вектор длины 0");
        }
    }

    public int getSize() {
        return components.length;
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double component : components) {
            squaresSum += Math.pow(component, 2);
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double newComponent) {
        components[index] = newComponent;
    }

    public static Vector getVectorsSum(Vector firstVector, Vector secondVector) {
        firstVector.add(secondVector);

        Vector resultVector = new Vector(firstVector);

        firstVector.subtract(secondVector);

        return resultVector;
    }

    public static Vector getVectorsDifference(Vector firstVector, Vector secondVector) {
        firstVector.subtract(secondVector);

        Vector resultVector = new Vector(firstVector);

        firstVector.add(secondVector);

        return resultVector;
    }

    public static double getScalarProduct(Vector firstVector, Vector secondVector) {
        double scalarProduct = 0;

        int minComponentsLength = Math.min(firstVector.components.length, secondVector.components.length);

        for (int i = 0; i < minComponentsLength; i++) {
            scalarProduct += firstVector.components[i] * secondVector.components[i];
        }

        return scalarProduct;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector comparedVector = (Vector) obj;

        for (int i = 0; i < getSize(); i++) {
            if (components[i] != comparedVector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (double coordinate : components) {
            stringBuilder.append(coordinate).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
