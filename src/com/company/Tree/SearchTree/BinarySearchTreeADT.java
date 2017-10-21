package com.company.Tree.SearchTree;

import com.company.Tree.BinaryTreeADT;

public interface BinarySearchTreeADT<T>extends BinaryTreeADT<T> {
    void addElement(T element) throws Exception;
    T removeElement(T targetElement);
    void removeAllOccurrences(T targetElement);
    T removeMax();
    T removeMin();
    T findMax();
    T findMin();
}
