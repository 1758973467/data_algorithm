package com.company.Stack;

import com.company.LinearNode;

public class LinearStack<T> implements StackADT<T> {
    private int count=0;
    private LinearNode<T> top=null;
    public LinearStack() {
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0?true:false;
    }

    @Override
    public T pop() {
        if(isEmpty())return null;
        else {
            T result=top.getElement();
            top=top.getNext();
            --count;
            return result;
        }
    }

    @Override
    public void push(T element) {
        LinearNode<T>temp=new LinearNode<>(element);
        temp.setNext(top);
        top=temp;
        ++count;
    }

    @Override
    public T peek() {
        if(isEmpty())return null;
        else return top.getElement();
    }
}
