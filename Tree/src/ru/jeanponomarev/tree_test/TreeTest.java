package ru.jeanponomarev.tree_test;

import ru.jeanponomarev.tree.Tree;

public class TreeTest {
    public static void main(String[] args) {
        Tree<Double> tree = new Tree<>();

        tree.add(8.0);
        tree.add(3.0);
        tree.add(10.0);
        tree.add(1.0);
        tree.add(6.0);
        tree.add(4.0);
        tree.add(7.0);
        tree.add(14.0);
        tree.add(13.0);
        tree.add(6.5);
        tree.add(7.5);
        tree.add(6.4);
        tree.add(6.45);

        System.out.println("Дерево содержит 6.4: " + tree.contains(6.4));

        System.out.println("Обход в ширину");
        tree.conductBreadthTraversal(System.out::println);

        System.out.println("Size: " + tree.size());
        System.out.println();

        System.out.println("Удаляем 6");
        tree.remove(6.0);

        System.out.println("Обход в глубину");
        tree.conductDepthTraversal(System.out::println);

        System.out.println("Size: " + tree.size());
        System.out.println();

        System.out.println("Удаляем 6.5");
        tree.remove(8.0);

        System.out.println("Обход в глубину через рекурсию");
        tree.conductDepthTraversalRecursive(System.out::println);

        System.out.println("Size: " + tree.size());
        System.out.println();
    }
}
