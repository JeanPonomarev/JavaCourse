package ru.jeanponomarev.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше либо равна нулю");
        } else {
            this.n = n;
        }

        components = new double[n];
        Arrays.fill(components, 0);
    }

    public Vector(Vector vector) {
        n = vector.n;
        components = vector.components;
    }

    public Vector(double[] components) {
        n = components.length;
        this.components = components;
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше либо равна нулю");
        } else {
            this.n = n;
        }

        if (components.length < n) {
            this.components = Arrays.copyOf(components, n);
        } else if (components.length == n) {
            this.components = components;
        } else {
            throw new IllegalArgumentException("Длина массива не должна быть больше размерности вектора");
        }

    }

    public int getSize() {
        return n;
    }

    public void add(Vector vector) {
        if (n > vector.n) {
            double[] vectorBufferArray = Arrays.copyOf(vector.components, n);

            for (int i = 0; i < n; i++) {
                components[i] += vectorBufferArray[i];
            }
        } else if (n == vector.n) {
            for (int i = 0; i < n; i++) {
                components[i] += vector.components[i];
            }
        } else {
            n = vector.n;
            components = Arrays.copyOf(components, vector.n);

            for (int i = 0; i < n; i++) {
                components[i] += vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        if (n > vector.n) {
            double[] vectorBufferArray = Arrays.copyOf(vector.components, n);

            for (int i = 0; i < n; i++) {
                components[i] -= vectorBufferArray[i];
            }
        } else if (n == vector.n) {
            for (int i = 0; i < n; i++) {
                components[i] -= vector.components[i];
            }
        } else {
            n = vector.n;
            components = Arrays.copyOf(components, vector.n);

            for (int i = 0; i < n; i++) {
                components[i] -= vector.components[i];
            }
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= -1;
        }
    }

    public double getLength() {
        double squareSum = 0;

        for (int i = 0; i < getSize(); i++) {
            squareSum += Math.pow(components[i], 2);
        }

        return Math.sqrt(squareSum);
    }

    public double getComponentByIndex(int index) {
        return components[index];
    }

    public void setComponentByIndex(int index, double newComponent) {
        components[index] = newComponent;
    }

    public static Vector addVectors(Vector firstVector, Vector secondVector) {
        double[] newVectorComponents = new double[Math.max(firstVector.n, secondVector.n)];

        if (firstVector.n > secondVector.n) {
            double[] newSecondVectorComponents = Arrays.copyOf(secondVector.components, firstVector.n);

            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = firstVector.components[i] + newSecondVectorComponents[i];
            }
        } else if (firstVector.n == secondVector.n) {
            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = firstVector.components[i] + secondVector.components[i];
            }
        } else {
            double[] newFirstVectorComponents = Arrays.copyOf(firstVector.components, secondVector.n);

            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = newFirstVectorComponents[i] + secondVector.components[i];
            }
        }

        return new Vector(newVectorComponents);
    }

    public static Vector subtractVectors(Vector firstVector, Vector secondVector) {
        double[] newVectorComponents = new double[Math.max(firstVector.n, secondVector.n)];

        if (firstVector.n > secondVector.n) {
            double[] newSecondVectorComponents = Arrays.copyOf(secondVector.components, firstVector.n);

            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = firstVector.components[i] - newSecondVectorComponents[i];
            }
        } else if (firstVector.n == secondVector.n) {
            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = firstVector.components[i] - secondVector.components[i];
            }
        } else {
            double[] newFirstVectorComponents = Arrays.copyOf(firstVector.components, secondVector.n);

            for (int i = 0; i < newVectorComponents.length; i++) {
                newVectorComponents[i] = newFirstVectorComponents[i] - secondVector.components[i];
            }
        }

        return new Vector(newVectorComponents);
    }

    public static double getScalarProduct(Vector firstVector, Vector secondVector) {
        double scalarProduct = 0;

        if (firstVector.n > secondVector.n) {
            double[] newSecondVectorComponents = Arrays.copyOf(secondVector.components, firstVector.n);

            for (int i = 0; i < firstVector.n; i++) {
                scalarProduct += firstVector.components[i] * newSecondVectorComponents[i];
            }
        } else if (firstVector.n == secondVector.n) {
            for (int i = 0; i < firstVector.n; i++) {
                scalarProduct += firstVector.components[i] * secondVector.components[i];
            }
        } else {
            double[] newFirstVectorComponents = Arrays.copyOf(firstVector.components, secondVector.n);

            for (int i = 0; i < secondVector.n; i++) {
                scalarProduct += newFirstVectorComponents[i] * secondVector.components[i];
            }
        }

        return scalarProduct;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Vector comparedVector = (Vector) obj;

        if (n != comparedVector.n) {
            return false;
        }

        double epsilon = 1.0e-10;

        for (int i = 0; i < getSize(); i++) {
            if (Math.abs(components[i] - comparedVector.components[i]) > epsilon) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (int i = 0; i < getSize(); i++) {
            hash = prime * hash + Double.hashCode(components[i]);
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder coordinatesBuilder = new StringBuilder();

        coordinatesBuilder.append("{");

        for (double coordinate : components) {
            coordinatesBuilder.append(coordinate).append(", ");
        }

        coordinatesBuilder.deleteCharAt(coordinatesBuilder.length() - 1);
        coordinatesBuilder.deleteCharAt(coordinatesBuilder.length() - 1);

        coordinatesBuilder.append("}");

        return coordinatesBuilder.toString();
    }
}
