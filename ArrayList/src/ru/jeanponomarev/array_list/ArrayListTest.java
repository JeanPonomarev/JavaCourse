package ru.jeanponomarev.array_list;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 3, 9, 7, 1));

        System.out.println("Содержимое списка: " + list);
        System.out.println("Изначальная длина списка: " + list.size());
        System.out.println();

        System.out.println("Список содерит 9: " + list.contains(9));
        System.out.println();

        Integer[] listArray = list.toArray(new Integer[0]);
        System.out.println("Преобразование списка в массив: " + Arrays.toString(listArray));
        System.out.println();

        list.add(10);
        System.out.println("Добавление числа 10 в список: " + list);

        list.add(4, 8);
        System.out.println("Вставка числа 8 по индексу 4: " + list);
        System.out.println();

        list.remove(4);
        System.out.println("Удаление элемента с индексом 4 (8): " + list);

        list.remove((Object) 10);
        System.out.println("Удаление числа 10 из списка: " + list);
        System.out.println();

        System.out.println("Получение элемента с индексом 3: " + list.get(3));
        System.out.println();

        list.set(1, 10);
        System.out.println("Изменение элемента с индексом 1 на 10: " + list);
        System.out.println();

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 9, 12));
        list.removeAll(set1);
        System.out.println("Удаление всех элементов, содержащихся в коллекции Set (1, 9, 12): " + list);
        System.out.println();

        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(5, 10, 3, 7));
        System.out.println("В списке имеются все элементы из коллекции set2 (5, 10, 3, 7): " + list.containsAll(set2));
        System.out.println();

        ArrayList<Integer> retainedList = new ArrayList<>(Arrays.asList(10, 7));
        list.retainAll(retainedList);
        System.out.println("Удаление из списка всех элементов, которые не содержаться с списке retainedList (10, 7): " + list);
    }
}
