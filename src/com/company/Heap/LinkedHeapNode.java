package com.company.Heap;

import com.company.Tree.BinaryTreeNode;

public class LinkedHeapNode<T>extends BinaryTreeNode<T> {
    protected LinkedHeapNode<T>parent;

    public LinkedHeapNode(T element) {
        super(element);
        this.parent=null;
    }

    public LinkedHeapNode<T> getParent() {
        return parent;
    }

    public void setParent(LinkedHeapNode<T> parent) {
        this.parent = parent;
    }
}
