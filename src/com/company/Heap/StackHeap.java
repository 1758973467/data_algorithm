package com.company.Heap;

import com.company.Stack.StackADT;

public class StackHeap<T>extends ArrayHeap<HeapNode<T>>implements StackADT<T> {
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
        HeapNode<T>temp=super.removeMin();
        if(temp!=null)return temp.element;
        else return null;
    }

    @Override
    public void push(T element) {
        HeapNode<T>temp=new HeapNode<>(element,priority);
        priority++;
        super.addElement(temp);
    }

    @Override
    public T peek() {
        HeapNode<T>temp=super.findMin();
        if(temp!=null)return temp.element;
        else return null;
    }


}
