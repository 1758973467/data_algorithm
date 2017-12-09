package com.company.Tree;

import java.util.Comparator;

public class BinaryTreeNode<T> implements Comparator<BinaryTreeNode<T>>{
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

    @Override
    public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {
        Comparable<T>tComparable1=(Comparable)o1.getElement();

        return tComparable1.compareTo((T)o2.getElement());
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "element=" + element +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
