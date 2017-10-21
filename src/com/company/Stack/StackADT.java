package com.company.Stack;

public interface StackADT<T> {
    int size();
    boolean isEmpty();
    T pop();
    void push(T element);
    T peek();

}
