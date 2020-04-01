package ru.jeanponomarev.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T[] dataArray) {
        if (dataArray.length == 0) {
            return;
        }

        head = new ListItem<>(dataArray[0]);
        count = dataArray.length;

        ListItem<T> previousItem = head;

        for (int i = 1; i < dataArray.length; i++) {
            ListItem<T> newItem = new ListItem<>(dataArray[i]);

            previousItem.setNext(newItem);
            previousItem = newItem;
        }
    }

    public SinglyLinkedList() {

    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }

        return head.getData();
    }

    public T getData(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Указанный индекс лежит вне диапазона списка");
        }

        return getItem(index).getData();
    }

    private ListItem<T> getItem(int index) {
        ListItem<T> requestedItem = head;

        for (int i = 0; i < index; i++) {
            requestedItem = requestedItem.getNext();
        }

        return requestedItem;
    }

    public T setData(int index, T newData) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Указанный индекс лежит вне диапазона списка");
        }

        ListItem<T> requestedItem = getItem(index);
        T oldData = requestedItem.getData();
        requestedItem.setData(newData);

        return oldData;
    }

    public T removeItemByIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Указанный индекс лежит вне диапазона списка");
        }

        if (index == 0) {
            return removeFirstItem();
        }

        ListItem<T> previousItem = getItem(index - 1);
        T removedData = previousItem.getNext().getData();
        previousItem.setNext(previousItem.getNext().getNext());
        --count;

        return removedData;
    }

    public void addFirstElement(T data) {
        ListItem<T> item = new ListItem<>(data);

        item.setNext(head);
        head = item;

        ++count;
    }

    public void add(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Указанный индекс лежит вне диапазона списка");
        }

        if (index == 0) {
            addFirstElement(data);

            return;
        }

        ListItem<T> newItem = new ListItem<>(data);

        ListItem<T> previousItem = getItem(index - 1);
        newItem.setNext(previousItem.getNext());
        previousItem.setNext(newItem);

        ++count;
    }

    public boolean removeItemByData(T data) {
        if (count == 0) {
            return false;
        }

        ListItem<T> currentItem = head;
        ListItem<T> previousItem = null;

        while (currentItem != null) {
            if (Objects.equals(currentItem.getData(), data)) {
                if (previousItem == null) {
                    head = currentItem.getNext();
                } else {
                    previousItem.setNext(currentItem.getNext());
                }

                --count;

                return true;
            }

            previousItem = currentItem;
            currentItem = currentItem.getNext();
        }

        return false;
    }

    public T removeFirstItem() {
        if (head == null) {
            throw new NoSuchElementException("Список пуст");
        }

        T removedItem = head.getData();
        head = head.getNext();
        --count;

        return removedItem;
    }

    public void reverse() {
        if (count <= 1) {
            return;
        }

        ListItem<T> currentItem = head.getNext();
        ListItem<T> previousItem = head;
        head.setNext(null);

        for (int i = 1; i < count; i++) {
            head = currentItem;
            currentItem = currentItem.getNext();
            head.setNext(previousItem);
            previousItem = head;
        }

        head = previousItem;
    }

    public SinglyLinkedList<T> getCopy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        if (count == 0) {
            return listCopy;
        }

        listCopy.addFirstElement(getHead());

        ListItem<T> currentItem = head.getNext();
        ListItem<T> currentCopiedItem = listCopy.head;

        for (int i = 1; i < count; i++) {
            currentCopiedItem.setNext(new ListItem<>(currentItem.getData()));

            currentCopiedItem = currentCopiedItem.getNext();
            currentItem = currentItem.getNext();
        }

        return listCopy;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}