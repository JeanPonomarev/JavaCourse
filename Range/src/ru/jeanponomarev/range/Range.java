package ru.jeanponomarev.range;

import java.util.Arrays;

public class Range {
    private double from;
    private double to;
    private static double epsilon = 1.0e-10;

    public Range(double from, double to) {
        if (from - to > epsilon) {
            throw new IllegalArgumentException("Левая граница интервала должна быть меньше правой");
        }

        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getIntervalLength() {
        return Math.abs(getTo() - getFrom());
    }

    public boolean isInside(double number) {
        return number - getTo() < epsilon && number - getFrom() > -epsilon;
    }

    public static Range getIntersectionInterval(Range range1, Range range2) {
        if (range1.isInside(range2.getFrom()) && !range1.isInside(range2.getTo())) {
            return new Range(range2.getFrom(), range1.getTo());
        } else if (range1.isInside(range2.getFrom()) && range1.isInside(range2.getTo())) {
            return new Range(range2.getFrom(), range2.getTo());
        } else {
            return null;
        }
    }

    public static Range[] getUnionInterval(Range range1, Range range2) {
        double leftBound;
        double rightBound;

        if (range1.isInside(range2.getFrom()) || range1.isInside(range2.getTo())) {
            leftBound = Math.min(range1.getFrom(), range2.getFrom());
            rightBound = Math.max(range1.getTo(), range2.getTo());

            return new Range[]{new Range(leftBound, rightBound)};
        }

        if (range1.getFrom() < range2.getFrom()) {
            return new Range[]{range1, range2};
        } else {
            return new Range[]{range2, range1};
        }
    }

    public Range[] getResidualInterval(Range range) {
        if (getFrom() < range.getFrom()) {
            if (isInside(range.getFrom()) && !isInside(range.getTo())) {
                return new Range[]{new Range(getFrom(), range.getFrom())};
            } else if (isInside(range.getFrom()) && isInside(range.getTo())) {
                return new Range[]{new Range(getFrom(), range.getFrom()), new Range(range.getTo(), getTo())};
            }
        } else {
            if (isInside(range.getTo()) && !isInside(range.getFrom())) {
                return new Range[]{new Range(range.getTo(), getTo())};
            } else if (isInside(range.getTo()) && isInside(range.getFrom())) {
                return new Range[]{new Range(getFrom(), range.getFrom()), new Range(range.getTo(), getTo())};
            }
        }

        return new Range[]{this};
    }

    @Override
    public String toString() {
        double[] rangeArray = new double[2];

        rangeArray[0] = getFrom();
        rangeArray[1] = getTo();

        return Arrays.toString(rangeArray);
    }
}
