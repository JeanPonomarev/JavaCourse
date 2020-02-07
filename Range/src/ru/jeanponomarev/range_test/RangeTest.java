package ru.jeanponomarev.range_test;

import ru.jeanponomarev.range.Range;

import java.util.Arrays;

public class RangeTest {
    public static void main(String[] args) {
        Range range = new Range(1.5, 6.2);

        System.out.println("Длина интервала range = " + range.getLength());
        System.out.println();

        double number = 1.6;
        if (range.isInside(number)) {
            System.out.println("Данное число принадлежит интервалу range");
        } else {
            System.out.println("Данное число не принадлежит интервалу range");
        }

        System.out.println();

        Range range1 = new Range(0, 8);
        Range range2 = new Range(3, 5);

        System.out.println("Пересечение интервалов range1 и range2: " + range1.getIntersection(range2).toString());
        System.out.println();

        System.out.println("Объединение интервалов range1 и range2: " + Arrays.toString(range1.getUnion(range2)));
        System.out.println();

        System.out.println("Разность интервалов range1 и range2 (range1 - range2): " + Arrays.toString(range1.getResidual(range2)));
    }
}
