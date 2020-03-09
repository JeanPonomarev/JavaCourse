package ru.jeanponomarev.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount = 0;

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            ++currentIndex;

            if (currentIndex >= size) {
                try {
                    throw new NoSuchFieldException("Выход за границы коллекции, возвращено null");
                } catch (NoSuchFieldException e) {
                    return null;
                }
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Изменение элементов коллекции при работе итератора");
            }

            return items[currentIndex];
        }
    }

    // конструкторы
    // пустой конструктор
    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[10];
    }

    // конструктор для массива
    public ArrayList(T[] dataArray) {
        items = Arrays.copyOf(dataArray, dataArray.length + 10);
        size = dataArray.length;
    }

    // конструктор для List
    public ArrayList(List<T> list) {
        //noinspection unchecked
        items = (T[]) new Object[list.size() + 10];
        size = list.size();

        for (int i = 0; i < size; i++) {
            items[i] = list.get(i);
        }
    }

    // конструктор со вместимостью
    public ArrayList(int capacity) {
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
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection unchecked
        a = (T1[]) Arrays.copyOf(items, a.length, a.getClass());

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
        items = Arrays.copyOf(items, items.length * 2);
    }

    public void ensureCapacity(int capacity) {
        if (capacity > size) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, size);
    }

    @Override
    public boolean remove(Object o) {
        boolean itemExisted = false;
        int index = 0;

        for (int i = 0; i < items.length; i++) {
            if (o.equals(items[i])) {
                itemExisted = true;
                index = i;

                break;
            }
        }

        if (itemExisted) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);

            --size;
            ++modCount;
        }

        return itemExisted;
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
        for (T element : c) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element : c) {
            add(index, element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element : c) {
            remove(element);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        ArrayList<Object> newList = new ArrayList<>(size);

        for (Object element : c) {
            if (contains(element) & !newList.contains(element)) {
                newList.add(element);
            }
        }

        size = newList.size;

        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            //noinspection unchecked
            items[j] = (T) newList.items[i];

            ++modCount;
        }

        return true;
    }

    @Override
    public void clear() {
        //noinspection unchecked
        items = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Индекс лежит за пределами списка");
        }

        T replacedItem = items[index];

        items[index] = element;

        ++modCount;

        return replacedItem;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Индекс лежит за пределами списка");
        }

        if (size >= items.length) {
            increaseCapacity();
        }

        //noinspection unchecked
        T[] bufferArray = (T[]) new Object[size - index + 1];

        bufferArray[0] = element;

        System.arraycopy(items, index, bufferArray, 1, size - index);

        System.arraycopy(bufferArray, 0, items, index, bufferArray.length);

        ++size;
        ++modCount;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Индекс лежит за пределами списка");
        }

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
            if (o.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(items[i])) {
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

    // Не реализовывать эти методы
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
