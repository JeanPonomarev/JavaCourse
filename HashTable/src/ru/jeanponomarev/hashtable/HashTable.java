package ru.jeanponomarev.hashtable;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HashTable<T> implements Collection<T> {
    private List<T>[] hashTable;
    private int size;
    private int modCount;


    private class HashTableIterator implements Iterator<T> {
        private int currentArrayIndex = 0;
        private int currentListIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            System.out.println("Method hasNext");
            //return currentArrayIndex < hashTable.length & currentListIndex < hashTable[currentArrayIndex].size();
            return true;
        }

        @Override
        public T next() {
            System.out.println("Method next");
            if (!hasNext()) {
                throw new NoSuchElementException("Выход за границы коллекции, возвращено null");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Изменение элементов коллекции при работе итератора");
            }

            ++currentListIndex;

            if (hashTable[currentArrayIndex] == null) {
                System.out.println("Element is null");
                ++currentArrayIndex;
                currentListIndex = -1;
            }

            int thisListSize = hashTable[currentArrayIndex].size();

            T nextItem = hashTable[currentArrayIndex].get(currentListIndex);

            if (currentListIndex == thisListSize - 1) {
                ++currentArrayIndex;
                currentListIndex = -1;
            }

            return nextItem;
        }
    }

    public HashTable() {
        //noinspection unchecked
        hashTable = new ArrayList[10];
    }

    public HashTable(int size) {
        //noinspection unchecked
        hashTable = new ArrayList[size];
    }

    @Override
    public boolean add(T t) {
        if (size >= hashTable.length) {
            increaseCapacity();
        }

        int index = Math.abs(t.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        ++size;
        ++ modCount;

        return hashTable[index].add(t);
    }

    private void increaseCapacity() {
        if (hashTable.length == 0) {
            hashTable = Arrays.copyOf(hashTable, 10);
        } else {
            hashTable = Arrays.copyOf(hashTable, hashTable.length * 2);
        }
    }

    // TODO: исправить метод и добавить modCount
    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode() % hashTable.length);
        --size;

        return hashTable[index].remove(o);
    }

    @Override
    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            return false;
        }

        return hashTable[index].contains(o);
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
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashTableIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
