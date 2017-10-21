package com.company.Heap;

import com.company.Tree.BinaryTreeADT;

public interface HeapADT<T>extends BinaryTreeADT<T> {
    void addElement(T element);
    T removeMin();
    T findMin();

}
