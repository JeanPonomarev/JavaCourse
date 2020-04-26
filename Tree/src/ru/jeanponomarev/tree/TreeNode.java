package ru.jeanponomarev.tree;

import java.util.Arrays;
import java.util.List;

public class TreeNode<T> {
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private T data;

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
        return Arrays.asList(leftChild, rightChild);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        T leftChildData = leftChild != null ? leftChild.getData() : null;
        T rightChildData = rightChild != null ? rightChild.getData() : null;

        return "Data: " + data + " LeftChild: " + leftChildData + " RightChild: " + rightChildData;
    }
}
