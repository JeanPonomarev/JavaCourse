package ru.jeanponomarev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (from > to) {
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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number <= to && number >= from;
    }

    public Range getIntersection(Range range) {
        if (to <= range.from || range.to <= from) {
            return null;
        } else {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }
    }

    public Range[] getUnion(Range range) {
        if (to < range.from || range.to < from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }
    }

    public Range[] getResidual(Range range) {
        if (from < range.from) {
            if (range.to >= to) {
                return to > range.from ? new Range[]{new Range(from, range.from)} : new Range[]{new Range(from, to)};
            } else {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }
        } else {
            if (to > range.to) {
                return range.to > from ? new Range[]{new Range(range.to, to)} : new Range[]{new Range(from, to)};
            } else {
                return new Range[]{};
            }
        }
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + "]";
    }
}
