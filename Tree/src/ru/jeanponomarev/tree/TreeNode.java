package ru.jeanponomarev.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private T data;

    private ParentState parentState;
    private ChildState childState;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public List<TreeNode<T>> getChildren() {
        return new ArrayList<>(Arrays.asList(leftChild, rightChild));
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ParentState getParentState() {
        return parentState;
    }

    public ChildState getChildState() {
        return childState;
    }

    public void setChildState(ChildState childState) {
        this.childState = childState;
    }

    public void setParentState() {
        if (leftChild == null && rightChild == null) {
            parentState = ParentState.NO_CHILDREN;
            return;
        }

        if (leftChild != null && rightChild == null) {
            parentState = ParentState.ONLY_LEFT_CHILD;
            return;
        }

        if (leftChild == null) {
            parentState = ParentState.ONLY_RIGHT_CHILD;
            return;
        }

        parentState = ParentState.TWO_CHILDREN;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return data.compareTo(o.data);
    }

    @Override
    public String toString() {
        T leftChildData;
        T rightChildData;

        if (leftChild != null) {
            leftChildData = leftChild.getData();
        } else {
            leftChildData = null;
        }

        if (rightChild != null) {
            rightChildData = rightChild.getData();
        } else {
            rightChildData = null;
        }

        return "Data: " + data + " LeftChild: " + leftChildData + " RightChild: " + rightChildData;
    }
}
