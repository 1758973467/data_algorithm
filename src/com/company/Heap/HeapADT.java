package com.company.Heap;

import com.company.Tree.BinaryTreeADT;
//TODO all Heap implement can override find to use heap attribute

public interface HeapADT<T>extends BinaryTreeADT<T> {
    void addElement(T element);
    T removeMin();
    T findMin();

}
