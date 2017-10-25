package com.company.Heap.MaxHeap;

import com.company.Tree.BinaryTreeADT;

public interface MaxHeapADT<T> extends BinaryTreeADT<T>{
    T findMax();
    T removeMax();
    void addElement(T targetElement);

}
