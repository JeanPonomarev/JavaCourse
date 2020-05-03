package ru.jeanponomarev.tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {
    private TreeNode<T> root;
    private int size;
    private Comparator<? super T> comparator;

    public Tree() {

    }

    public Tree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object node1, Object node2) {
        if (comparator == null) {
            if (node1 == null) {
                if (node2 == null) {
                    return 0;
                }

                return -1;
            }

            if (node2 == null) {
                return 1;
            }

            return ((Comparable<? super T>) node1).compareTo((T) node2);
        }

        return comparator.compare((T) node1, (T) node2);
    }

    public void add(T data) {
        if (size == 0) {
            root = new TreeNode<>(data);
            ++size;
            return;
        }

        TreeNode<T> currentNode = root;

        while (true) {
            if (compare(data, currentNode.getData()) < 0) {
                if (currentNode.getLeftChild() != null) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode.setLeftChild(new TreeNode<>(data));
                    ++size;
                    return;
                }
            } else {
                if (currentNode.getRightChild() != null) {
                    currentNode = currentNode.getRightChild();
                } else {
                    currentNode.setRightChild(new TreeNode<>(data));
                    ++size;
                    return;
                }
            }
        }
    }

    public boolean contains(T data) {
        return findChildAndParent(data) != null;
    }

    public boolean remove(T data) {
        TreeNode<T>[] childNodeAndParent = findChildAndParent(data);

        if (childNodeAndParent == null) {
            return false;
        }

        TreeNode<T> childNode = childNodeAndParent[0];
        TreeNode<T> parentNode = childNodeAndParent[1];

        if (childNode == root && parentNode == null) {
            if (size == 1) {
                root = null;
                --size;
                return true;
            }

            TreeNode<T> newRoot = childNode.getRightChild();
            newRoot.setLeftChild(childNode.getLeftChild());

            root = newRoot;
            --size;
            return true;
        }

        if (childNode.getLeftChild() == null & childNode.getRightChild() == null) {
            removeLeaf(parentNode, childNode);
        } else if (childNode.getLeftChild() == null || childNode.getRightChild() == null) {
            removeOneChildNode(parentNode, childNode);
        } else {
            TreeNode<T>[] minNodeAndParent = findMinNodeAndParent(childNode.getRightChild(), childNode);

            TreeNode<T> minChildNode = minNodeAndParent[0];
            TreeNode<T> minParentNode = minNodeAndParent[1];

            if (minChildNode.getRightChild() != null) {
                if (childNode != minParentNode) {
                    minParentNode.setLeftChild(minChildNode.getRightChild());
                } else {
                    minParentNode.setRightChild(minChildNode.getRightChild());
                }
            } else {
                minParentNode.setLeftChild(null);
            }

            if (parentNode.getRightChild() == childNode) {
                parentNode.setRightChild(minChildNode);
            } else {
                parentNode.setLeftChild(minChildNode);
            }

            if (minChildNode != childNode.getLeftChild()) {
                minChildNode.setLeftChild(childNode.getLeftChild());
            } else {
                minChildNode.setLeftChild(null);
            }

            if (minChildNode != childNode.getRightChild()) {
                minChildNode.setRightChild(childNode.getRightChild());
            } else {
                minChildNode.setRightChild(null);
            }
        }

        --size;
        return true;
    }

    @SuppressWarnings("unchecked")
    private TreeNode<T>[] findChildAndParent(T data) {
        TreeNode<T> childNode = root;
        TreeNode<T> parentNode = null;

        while (true) {
            int comparisonResult = compare(data, childNode.getData());

            if (comparisonResult == 0) {
                return new TreeNode[]{childNode, parentNode};
            }

            if (comparisonResult < 0) {
                if (childNode.getLeftChild() != null) {
                    parentNode = childNode;
                    childNode = childNode.getLeftChild();
                } else {
                    return null;
                }
            } else {
                if (childNode.getRightChild() != null) {
                    parentNode = childNode;
                    childNode = childNode.getRightChild();
                } else {
                    return null;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private TreeNode<T>[] findMinNodeAndParent(TreeNode<T> startChildNode, TreeNode<T> startParentNode) {
        TreeNode<T> childNode = startChildNode;
        TreeNode<T> parentNode = startParentNode;

        while (childNode.getLeftChild() != null) {
            parentNode = childNode;
            childNode = childNode.getLeftChild();
        }

        return new TreeNode[]{childNode, parentNode};
    }

    private void removeLeaf(TreeNode<T> parentNode, TreeNode<T> childNode) {
        if (parentNode.getLeftChild() == childNode) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    private void removeOneChildNode(TreeNode<T> parentNode, TreeNode<T> childNode) {
        if (childNode.getLeftChild() != null) {
            if (parentNode.getRightChild() == childNode) {
                parentNode.setRightChild(childNode.getLeftChild());
            } else {
                parentNode.setLeftChild(childNode.getLeftChild());
            }
        } else {
            if (parentNode.getRightChild() == childNode) {
                parentNode.setRightChild(childNode.getRightChild());
            } else {
                parentNode.setLeftChild(childNode.getRightChild());
            }
        }
    }

    public void conductBreadthTraversal(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();
            consumer.accept(currentNode.getData());

            if (currentNode.getLeftChild() != null) {
                queue.add(currentNode.getLeftChild());
            }

            if (currentNode.getRightChild() != null) {
                queue.add(currentNode.getRightChild());
            }
        }
    }

    public void conductDepthTraversal(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode<T> currentNode = stack.removeLast();
            consumer.accept(currentNode.getData());

            if (currentNode.getRightChild() != null) {
                stack.addLast(currentNode.getRightChild());
            }

            if (currentNode.getLeftChild() != null) {
                stack.addLast(currentNode.getLeftChild());
            }
        }
    }

    public void conductDepthTraversalRecursive(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        visit(root, consumer);
    }

    private void visit(TreeNode<T> node, Consumer<T> consumer) {
        consumer.accept(node.getData());

        for (TreeNode<T> child : node.getChildren()) {
            if (child != null) {
                visit(child, consumer);
            }
        }
    }

    public int size() {
        return size;
    }
}
