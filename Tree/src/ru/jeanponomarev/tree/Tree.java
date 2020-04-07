package ru.jeanponomarev.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public void add(T data) {
        if (size == 0) {
            root = new TreeNode<>(data);
            ++size;
            return;
        }

        TreeNode<T> currentNode = root;

        while (true) {
            if (data.compareTo(currentNode.getData()) < 0) {
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
        TreeNode<T> currentNode = root;

        while (true) {
            if (data.compareTo(currentNode.getData()) == 0) {
                return true;
            }

            if (data.compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeftChild() != null) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    return false;
                }
            } else {
                if (currentNode.getRightChild() != null) {
                    currentNode = currentNode.getRightChild();
                } else {
                    return false;
                }
            }
        }
    }

    public boolean remove(T data) {
        Object[] childNodeAndParent = findChildAndParent(data);

        if (childNodeAndParent == null) {
            return false;
        }

        @SuppressWarnings("unchecked")
        TreeNode<T> childNode = (TreeNode<T>) childNodeAndParent[0];
        @SuppressWarnings("unchecked")
        TreeNode<T> parentNode = (TreeNode<T>) childNodeAndParent[1];

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

        childNode.setParentState();
        setChildState(childNode, parentNode);

        switch (childNode.getParentState()) {
            case NO_CHILDREN:
                removeLeaf(parentNode, childNode.getChildState());
                break;
            case ONLY_LEFT_CHILD:
                if (childNode.getChildState() == ChildState.RIGHT) {
                    parentNode.setRightChild(childNode.getLeftChild());
                } else {
                    parentNode.setLeftChild(childNode.getLeftChild());
                }
                break;
            case ONLY_RIGHT_CHILD:
                if (childNode.getChildState() == ChildState.RIGHT) {
                    parentNode.setRightChild(childNode.getRightChild());
                } else {
                    parentNode.setLeftChild(childNode.getRightChild());
                }
                break;
            case TWO_CHILDREN:
                Object[] minNodeAndParent = findMinNodeAndParent(childNode.getRightChild(), parentNode);

                @SuppressWarnings("unchecked")
                TreeNode<T> minChildNode = (TreeNode<T>) minNodeAndParent[0];
                @SuppressWarnings("unchecked")
                TreeNode<T> minParentNode = (TreeNode<T>) minNodeAndParent[1];

                if (minChildNode.getRightChild() != null) {
                    minParentNode.setLeftChild(minChildNode.getRightChild());
                } else {
                    minParentNode.setLeftChild(null);
                }

                if (childNode.getChildState() == ChildState.RIGHT) {
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

    private Object[] findChildAndParent(T data) {
        TreeNode<T> childNode = root;
        TreeNode<T> parentNode = null;

        while (true) {
            if (data.compareTo(childNode.getData()) == 0) {
                return new Object[]{childNode, parentNode};
            }

            if (data.compareTo(childNode.getData()) < 0) {
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

    private Object[] findMinNodeAndParent(TreeNode<T> startChildNode, TreeNode<T> startParentNode) {
        TreeNode<T> childNode = startChildNode;
        TreeNode<T> parentNode = startParentNode;

        while (childNode.getLeftChild() != null) {
            parentNode = childNode;
            childNode = childNode.getLeftChild();
        }

        return new Object[]{childNode, parentNode};
    }

    private void removeLeaf(TreeNode<T> parent, ChildState child) {
        switch (child) {
            case LEFT:
                parent.setLeftChild(null);
                break;
            case RIGHT:
                parent.setRightChild(null);
        }
    }

    private void setChildState(TreeNode<T> childNode, TreeNode<T> parentNode) {
        if (childNode == parentNode.getLeftChild()) {
            childNode.setChildState(ChildState.LEFT);
            return;
        }

        if (childNode == parentNode.getRightChild()) {
            childNode.setChildState(ChildState.RIGHT);
            return;
        }

        throw new IllegalStateException("Parent node is a leaf");
    }

    public void conductBreadthTraversal(Consumer<TreeNode<T>> consumer) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();
            consumer.accept(currentNode);

            if (currentNode.getLeftChild() != null) {
                queue.add(currentNode.getLeftChild());
            }

            if (currentNode.getRightChild() != null) {
                queue.add(currentNode.getRightChild());
            }
        }
    }

    public void conductDepthTraversal(Consumer<TreeNode<T>> consumer) {
        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode<T> currentNode = stack.removeLast();
            consumer.accept(currentNode);

            if (currentNode.getRightChild() != null) {
                stack.addLast(currentNode.getRightChild());
            }

            if (currentNode.getLeftChild() != null) {
                stack.addLast(currentNode.getLeftChild());
            }
        }
    }

    public void conductDepthTraversalRecursive(Consumer<TreeNode<T>> consumer) {
        visit(root, consumer);
    }

    private void visit(TreeNode<T> node, Consumer<TreeNode<T>> consumer) {
        consumer.accept(node);

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
