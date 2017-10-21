package com.company.Tree;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T>left;
    private BinaryTreeNode<T>right;

    public BinaryTreeNode(T element) {
        this.element = element;
        this.left=null;
        this.right=null;
    }

    public BinaryTreeNode() {
        this.element = null;
        this.left=null;
        this.right=null;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf(){
        if(this.left!=null||this.right!=null){
            return false;
        }else return true;
    }
}
