package com.company.Tree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
    T getRootElement();
    boolean isEmpty();
    int size();
    boolean contains(T targetElement);
    T find(T targetElement);
    @Override
    String toString();
    Iterator<T>iterator();
    Iterator<T>iteratorInOrder();
    Iterator<T>iteratorPreOrder();
    Iterator<T>iteratorPostOrder();
    Iterator<T>iteratorLevelOrder();
}
