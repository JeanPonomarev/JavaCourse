package ru.jeanponomarev;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    // делаем конструктор для тестов
    public SinglyLinkedList(T[] dataArray) {
        if (dataArray.length == 0) {
            head = null;
            count = 0;
            return;
        }

        head = new ListItem<T>(dataArray[0]);
        count = dataArray.length;

        ListItem<T> previousItem = head;
        ListItem<T> newItem;

        for (int i = 1; i < dataArray.length; i++) {
            newItem = new ListItem<T>(dataArray[i]);

            previousItem.setNext(newItem);
            previousItem = newItem;
        }
    }

    public SinglyLinkedList() {
        count = 0;
    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        return head.getData();
    }

    public T getData(int index) { // получение значения по индексу
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Указанный индекс лежит вне диапазона списка");
        }

        if (index == 0) {
            return head.getData();
        }

        ListItem<T> requestedItem = head;

        for (int i = 0; i < index; i++) {
            requestedItem = requestedItem.getNext();
        }

        return requestedItem.getData();
    }

    public T setData(int index, T newData) { // изменение значения по индексу
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Указанный индекс лежит вне диапазона списка");
        }

        T oldData;

        if (index == 0) {
            oldData = head.getData();
            head.setData(newData);

            return oldData;
        }

        ListItem<T> requestedItem = head;

        for (int i = 0; i < index; i++) {
            requestedItem = requestedItem.getNext();
        }

        oldData = requestedItem.getData();
        requestedItem.setData(newData);

        return oldData;
    }

    public T removeItemByIndex(int index) { // удаление элемента по индексу
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Указанный индекс лежит вне диапазона списка");
        }

        T removedData;

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            --count;

            return removedData;
        }

        ListItem<T> requestedItem = head;

        for (int i = 1; i < index; i++) {
            requestedItem = requestedItem.getNext();
        }

        removedData = requestedItem.getNext().getData();

        if (requestedItem.getNext().getNext() == null) {
            requestedItem.setNext(null);
        } else {
            requestedItem.setNext(requestedItem.getNext().getNext());
        }

        --count;

        return removedData;
    }

    public void add(ListItem<T> item) { // вставка элемента в начало
        if (head != null) {
            item.setNext(head);
        }

        head = item;
        ++count;
    }

    public void add(T data) { // вставка элемента в начало
        ListItem<T> item = new ListItem<>(data);

        if (head != null) {
            item.setNext(head);
        }

        head = item;
        ++count;
    }

    public void add(int index, T data) { // вставка элемента по индексу
        if (index > count || index < 0) {
            throw new IllegalArgumentException("Указанный индекс лежит вне диапазона списка");
        }

        ListItem<T> newItem = new ListItem<>(data);

        if (index == 0) {
            if (head != null) {
                newItem.setNext(head);
            }

            head = newItem;
            ++count;

            return;
        }

        ListItem<T> shiftedItem = head;
        ListItem<T> previousItem = null;

        for (int i = 0; i < index; i++) {
            previousItem = shiftedItem;
            shiftedItem = shiftedItem.getNext();
        }

        previousItem.setNext(newItem);

        if (shiftedItem != null) {
            newItem.setNext(shiftedItem);
        }

        ++count;
    }

    public boolean removeItemByData(T data) {
        if (head == null) {
            return false;
        }

        if (getSize() == 1) {
            if (head.getData() == data) {
                head = null;
                --count;

                return true;
            }

            return false;
        }

        ListItem<T> currentItem = head;

        int index = 0;
        boolean isFound = false;

        while (currentItem != null) {
            if (currentItem.getData() == data) {
                isFound = true;
                break;
            }

            currentItem = currentItem.getNext();

            ++index;
        }

        if (isFound) {
            removeItemByIndex(index);

            return true;
        }

        return false;
    }

    public T removeFirstItem() {
        if (head == null) {
            throw new NullPointerException("Список пуст");
        }

        T removedItem = head.getData();

        if (count > 1) {
            head = head.getNext();
        } else {
            head = null;
        }

        --count;

        return removedItem;
    }

    public void reverseList() {
        if (head == null || count == 1) {
            return;
        }

        ListItem<T> currentItem = head.getNext();
        ListItem<T> previousItem = head;

        for (int i = 1; i < count; i++) {
            head = currentItem;

            currentItem = currentItem.getNext();

            head.setNext(previousItem);

            previousItem = head;
        }

        this.head = previousItem;
    }

    public SinglyLinkedList<T> getListCopy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        for (int i = count - 1; i >= 0; i--) {
            listCopy.add(getData(i));
        }

        return listCopy;
    }
}