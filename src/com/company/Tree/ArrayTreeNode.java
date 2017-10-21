package com.company.Tree;

public class ArrayTreeNode<T> {
    //left right 数组的index
    private int left;
    private int right;
    private T element;

    public ArrayTreeNode() {
        this(null);
    }

    public ArrayTreeNode(T element) {
        this.element = element;
        this.left=-1;
        this.right=-1;
    }

    public ArrayTreeNode(int left, int right, T element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
