package ru.jeanponomarev.range;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        Range range = new Range(1.5, 6.2);

        System.out.println("Длина интервала range1 = " + range.getIntervalLength());
        System.out.println();

        double number = 1.5;
        if (range.isInside(number)) {
            System.out.println("Данное число принадлежит интервалу range");
        } else {
            System.out.println("Данное число не принадлежит интервалу range");
        }

        System.out.println();

        Range range1 = new Range(0, 8);
        Range range2 = new Range(3, 5);

        try {
            System.out.println("Пересечение интервалов range1 и range2: " + Range.getIntersectionInterval(range1, range2).toString());
        } catch (NullPointerException e) {
            System.out.println("Интервалы не пересекаются");
        }

        System.out.println();

        System.out.println("Объединение интервалов range1 и range2: " + Arrays.toString(Range.getUnionInterval(range1, range2)));

        System.out.println();

        System.out.println("Разность интервалов range1 и range2 (range1 - range2): " + Arrays.toString(range1.getResidualInterval(range2)));
    }
}
