package com.company.List;

import com.company.Tree.SearchTree.BinarySearchLinkedTree;

public class BinarySearchLinkedTreeList<T>extends BinarySearchLinkedTree<T> implements ListADT<T>,OrderedListADT<T>,Iterable<T> {
    public BinarySearchLinkedTreeList() {
        super();
    }

    @Override
    public void add(T element) throws Exception {
        addElement(element);
    }

    @Override
    public T removeFirst() {
        return removeMin();
    }

    @Override
    public T removeLast() {
        return removeMax();
    }

    @Override
    public T remove(T element) {
        return remove(element);
    }

    @Override
    public T first() {
        return findMin();
    }

}
