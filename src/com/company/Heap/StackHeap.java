package com.company.Heap;

import com.company.Stack.StackADT;

public class StackHeap<T>extends ArrayHeap<PriorityQueueNode<T>>implements StackADT<T> {
    int priority=0;
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public T pop() {
        PriorityQueueNode<T>temp=super.removeMin();
        if(temp!=null)return temp.getElement();
        else return null;
    }

    @Override
    public void push(T element) {
        PriorityQueueNode<T>temp=new PriorityQueueNode<>(element,priority);
        priority++;
        super.addElement(temp);
    }

    @Override
    public T peek() {
        PriorityQueueNode<T>temp=super.findMin();
        if(temp!=null)return temp.getElement();
        else return null;
    }


}
