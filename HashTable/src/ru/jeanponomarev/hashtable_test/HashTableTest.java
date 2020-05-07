package ru.jeanponomarev.hashtable_test;

import ru.jeanponomarev.hashtable.HashTable;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(1);

        hashTable.add("One");
        hashTable.add("Two");
        hashTable.add("Three");
        hashTable.add("Four");

        for (String element : hashTable) {
            System.out.println(element);
        }
    }
}
