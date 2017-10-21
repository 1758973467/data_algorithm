package com.company.Stack.project;

import com.company.LinearNode;
import com.company.Stack.StackADT;

public class DropOutLinearStack<T> implements StackADT<T>{
    private int capacity;
    private int size=0;
    private LinearNode<T>top=new LinearNode<>();//哨兵节点
    public DropOutLinearStack(int capacity) {
        this.capacity=capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0?true:false;
    }

    @Override
    public T pop() {
        if(isEmpty())return null;
        else{
            T result=top.getElement();
            size--;
            top=top.getNext();
            return result;
        }

    }

    @Override
    public void push(T element) {
        if(size+1>capacity){
            LinearNode<T>bottom=top;
            //遍历到倒数第二个
            for(int i=0;i<size-2;++i){
                bottom=bottom.getNext();
            }
            bottom.setNext(null);
        }
        LinearNode<T>temp=new LinearNode<>(element);
        temp.setNext(top);
        size=size+1>capacity?capacity:size+1;
        top=temp;

    }

    @Override
    public T peek() {
        if(isEmpty())return null;
        else return top.getElement();
    }
}
