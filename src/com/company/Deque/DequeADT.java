package com.company.Deque;

import com.company.Queue.QueueADT;

public interface  DequeADT<T> extends QueueADT<T>{
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T peekFirst();
    T peekLast();

}
