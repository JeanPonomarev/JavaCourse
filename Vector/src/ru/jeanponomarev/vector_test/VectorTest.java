package ru.jeanponomarev.vector_test;

import ru.jeanponomarev.vector.Vector;

public class VectorTest {
    public static void main(String[] args) {
        System.out.println("Вектор с нулевыми компонентами: " + new Vector(3));
        System.out.println();

        System.out.println("Вектор с заданными компонентами: " + new Vector(new double[]{1, 3, 5, 7}));
        System.out.println();

        System.out.println("Вектор с заданной размерностью и компонентами: " + new Vector(3, new double[]{1, 2, 3}));
        System.out.println();

        Vector vector1 = new Vector(new double[]{1, 4, 7});
        Vector vector2 = new Vector(new double[]{2, -3, 5});

        System.out.println("Нестатические методы:");

        System.out.print("Прибавление vector2 к vector1: ");
        vector1.add(vector2);
        System.out.println(vector1);

        System.out.print("Вычитание vector2 из vector1 ");
        vector1.subtract(vector2);
        System.out.println(vector1);

        System.out.print("Умножение vector1 на скаляр 2: ");
        vector1.multiplyByScalar(2);
        System.out.println(vector1);

        System.out.print("Разворот vector1: ");
        vector1.reverse();
        System.out.println(vector1);

        System.out.println("Длина vector2: " + vector2.getLength());

        System.out.println("Получение второй компоненты vector1: " + vector1.getComponent(1));

        System.out.print("Установка первой компоненты vector1 на число 7: ");
        vector1.setComponent(0, 7);
        System.out.println(vector1);
        System.out.println();

        System.out.println("hashCode vector1: " + vector1.hashCode());
        System.out.println("hashCode vector2: " + vector2.hashCode());
        System.out.println();

        System.out.println("Статические методы:");

        Vector resultVector1 = Vector.getVectorsSum(vector1, vector2);
        System.out.println("Сложение vector1 с vector2 с получением нового объекта: " + resultVector1);

        Vector resultVector2 = Vector.getVectorsDifference(vector1, vector2);
        System.out.println("Вычитание vector2 из vector1 с получением нового объекта: " + resultVector2);

        System.out.println("Скалярное произведение resultVector1 и resultVector2: " + Vector.getScalarProduct(resultVector1, resultVector2));
    }
}
