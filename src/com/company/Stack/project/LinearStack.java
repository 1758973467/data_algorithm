package com.company.Stack.project;

import com.company.LinearNode;
import com.company.Stack.StackADT;

/**
 * 具有哨兵节点的链表栈实现
 * @param <T>
 */
public class LinearStack<T> implements StackADT<T> {
    private int count=0;
    private LinearNode<T> top=new LinearNode<>();
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
        return top.getElement();
    }
}
