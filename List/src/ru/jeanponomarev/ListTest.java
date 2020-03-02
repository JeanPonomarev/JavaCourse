package ru.jeanponomarev;

public class ListTest {
    public static void main(String[] args) {
        Integer[] array = {5, 3, 2, 7, 9};

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(array);

        // Пустой список
        //SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Список из одного элемента
        //SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        SinglyLinkedList<Integer> listCopy = list.getListCopy();
        System.out.println(listCopy.getSize());

        for (int i = 0; i < listCopy.getSize(); i++) {
            System.out.print(listCopy.getData(i) + " ");
        }
    }
}
