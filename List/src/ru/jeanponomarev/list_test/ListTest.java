package ru.jeanponomarev.list_test;

import ru.jeanponomarev.list.SinglyLinkedList;

public class ListTest {
    public static void main(String[] args) {
        Integer[] array = {5, 3, 2, 7, 9, 4};

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(array);

        System.out.println("Элементы списка: " + list);
        System.out.println("Размер списка: " + list.getSize());
        System.out.println("Голова списка: " + list.getHead());

        System.out.println("Третий элемент списка: " + list.getData(2));

        System.out.println("Измененеие четвёртого элемента с " + list.setData(3, 6) + " на " + list.getData(3) + " : " + list);

        System.out.println("Удаление пятого элемента (" + list.removeItemByIndex(4) + "): " + list);

        list.add(10);
        System.out.println("Вставка 10 в начало списка: " + list);

        list.add(4, 9);
        System.out.println("Вставка числа 9 по индексу 4: " + list);

        list.removeItemByData(4);
        System.out.println("Удаление числа 4 из списка: " + list);

        System.out.println("Удаление первого элемента (" + list.removeFirstItem() + "): " + list);

        list.reverse();
        System.out.println("Разворот списка: " + list);

        System.out.println("Получение копии списка: " + list.getCopy());

        /*System.out.println(list.getSize());

        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.getData(i) + " ");
        }*/
    }
}
