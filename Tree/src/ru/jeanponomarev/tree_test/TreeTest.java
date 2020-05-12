package ru.jeanponomarev.tree_test;

import ru.jeanponomarev.tree.Tree;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Double> doubleTree = new Tree<>();

        doubleTree.add(8.0);
        doubleTree.add(3.0);
        doubleTree.add(10.0);
        doubleTree.add(1.0);
        doubleTree.add(6.0);
        doubleTree.add(4.0);
        doubleTree.add(7.0);
        doubleTree.add(14.0);
        doubleTree.add(13.0);
        doubleTree.add(6.5);
        doubleTree.add(7.5);
        doubleTree.add(6.4);
        doubleTree.add(6.45);

        System.out.println("Double tree:");
        System.out.println();

        System.out.println("Дерево содержит 6.4: " + doubleTree.contains(6.4));

        System.out.println("Обход в ширину");
        doubleTree.conductBreadthTraversal(System.out::println);

        System.out.println("Size: " + doubleTree.size());
        System.out.println();

        System.out.println("Удаляем 6");
        doubleTree.remove(6.0);

        System.out.println("Обход в глубину");
        doubleTree.conductDepthTraversal(System.out::println);

        System.out.println("Size: " + doubleTree.size());
        System.out.println();

        System.out.println("Удаляем 8.0");
        doubleTree.remove(8.0);

        System.out.println("Обход в глубину через рекурсию");
        doubleTree.conductDepthTraversalRecursive(System.out::println);

        System.out.println("Size: " + doubleTree.size());
        System.out.println();

        Tree<Integer> integerTree = new Tree<>();

        integerTree.add(1);
        integerTree.add(3);
        integerTree.add(2);
        integerTree.add(5);
        integerTree.add(6);

        System.out.println("Integer tree:");
        System.out.println();

        System.out.println("Удаляем 1");
        integerTree.remove(1);

        System.out.println("Обход в ширину");
        integerTree.conductBreadthTraversal(System.out::println);

        System.out.println("Size: " + integerTree.size());
    }
}
