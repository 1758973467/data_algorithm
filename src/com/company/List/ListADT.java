package com.company.List;

import java.util.Iterator;

public interface ListADT<T> {
    T removeFirst();
    T removeLast();
    T remove(T element);
    T first();
    boolean contains(T element);
    boolean isEmpty();
    int size();
    Iterator<T>iterator();
    //

}
