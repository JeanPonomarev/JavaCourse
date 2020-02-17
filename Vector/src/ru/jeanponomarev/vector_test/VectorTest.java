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

        Vector firstVector = new Vector(new double[]{1, 4, 7});
        Vector secondVector = new Vector(new double[]{2, -3, 5});

        System.out.println("Нестатические методы:");

        System.out.print("Прибавление secondVector к firstVector: ");
        firstVector.add(secondVector);
        System.out.println(firstVector);

        System.out.print("Вычитание secondVector из firstVector ");
        firstVector.subtract(secondVector);
        System.out.println(firstVector);

        System.out.print("Умножение firstVector на скаляр 2: ");
        firstVector.multiplyByScalar(2);
        System.out.println(firstVector);

        System.out.print("Разворот firstVector: ");
        firstVector.reverse();
        System.out.println(firstVector);

        System.out.println("Длина secondVector: " + secondVector.getLength());

        System.out.println("Получение второй компоненты firstVector: " + firstVector.getComponent(1));

        System.out.print("Установка первой компоненты firstVector на число 7: ");
        firstVector.setComponent(0, 7);
        System.out.println(firstVector);
        System.out.println();

        System.out.println("hashCode firstVector: " + firstVector.hashCode());
        System.out.println("hashCode secondVector: " + secondVector.hashCode());
        System.out.println();

        System.out.println("Статические методы:");

        Vector firstResultVector = Vector.getVectorsSum(firstVector, secondVector);
        System.out.println("Сложение firstVector с secondVector с получением нового объекта: " + firstResultVector);

        Vector secondResultVector = Vector.getVectorsDifference(firstVector, secondVector);
        System.out.println("Вычитание secondVector из firstVector с получением нового объекта: " + secondResultVector);

        System.out.println("Скалярное произведение firstResultVector и secondResultVector: " + Vector.getScalarProduct(firstResultVector, secondResultVector));
    }
}
