package ru.jeanponomarev.array_list;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayListTest {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 3, 9, 7, 1));

        HashSet<Integer> set = new HashSet<>(Arrays.asList(5, 3, 1));

        list.removeAll(set);

        System.out.println(list);
        System.out.println(list.size());
    }
}
