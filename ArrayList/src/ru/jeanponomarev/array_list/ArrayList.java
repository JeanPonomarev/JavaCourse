package ru.jeanponomarev.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Выход за границы коллекции, возвращено null");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Изменение элементов коллекции при работе итератора");
            }

            ++currentIndex;

            return items[currentIndex];
        }
    }

    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[10];
    }

    public ArrayList(T[] dataArray) {
        items = Arrays.copyOf(dataArray, dataArray.length + 10);
        size = dataArray.length;
    }

    public ArrayList(List<T> list) {
        //noinspection unchecked
        items = (T[]) new Object[list.size() + 10];
        size = list.size();

        int i = 0;
        for (T element : list) {
            items[i] = element;
            i++;
        }
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Указана недопустимая вместимость массива");
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @SuppressWarnings("SuspiciousSystemArraycopy")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        System.arraycopy(items, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T item) {
        if (size >= items.length) {
            increaseCapacity();
        }

        items[size] = item;

        ++size;
        ++modCount;

        return true;
    }

    private void increaseCapacity() {
        if (items.length == 0) {
            items = Arrays.copyOf(items, 10);
        } else {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    public void ensureCapacity(int capacity) {
        if (capacity > items.length) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index != -1) {
            remove(index);
        }

        return index != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        verifyIndex(index, true);

        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(size + c.size());

        if (index != size) {
            System.arraycopy(items, index, items, index + c.size(), size - index);
        }

        int i = index;
        for (T element : c) {
            items[i] = element;
            i++;
        }

        size += c.size();
        ++modCount;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;

        for (int i = 0; i < size; ) {
            if (c.contains(items[i])) {
                remove(i);

                isRemoved = true;
            } else {
                i++;
            }
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRemoved = false;

        for (int i = 0; i < size; ) {
            if (!c.contains(items[i])) {
                remove(i);

                isRemoved = true;
            } else {
                i++;
            }
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
            ++modCount;
        }

        size = 0;
    }

    @Override
    public T get(int index) {
        verifyIndex(index, false);

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        verifyIndex(index, false);

        T replacedItem = items[index];

        items[index] = element;

        return replacedItem;
    }

    @Override
    public void add(int index, T element) {
        verifyIndex(index, true);

        if (size >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, size - index);

        items[index] = element;

        ++size;
        ++modCount;
    }

    @Override
    public T remove(int index) {
        verifyIndex(index, false);

        T removedItem = get(index);

        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }

        --size;
        ++modCount;

        return removedItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private void verifyIndex(int index, boolean canBeEqualsToSize) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс " + index + " лежит за пределами границ списка: [0, " + (size - 1) + "]");
        }

        if (canBeEqualsToSize) {
            if (index > size) {
                throw new IndexOutOfBoundsException("Индекс " + index + " лежит за пределами допустимого диапазона вставки: [0, " + size + "]");
            }
        } else {
            if (index >= size) {
                throw new IndexOutOfBoundsException("Индекс " + index + " лежит за пределами границ списка: [0, " + (size - 1) + "]");
            }
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
