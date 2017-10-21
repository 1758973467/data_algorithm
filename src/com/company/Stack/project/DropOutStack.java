package com.company.Stack.project;

import com.company.Stack.StackADT;

/**
 *
 * 如果栈的大小为n,当压入第n+1个元素时，将弃掉第一个元素
 * 用数组实现
 */
public class DropOutStack<T> implements StackADT<T>{
    final int DEFALUT_CAPCITY=16;
    int top=0;
    int capcity=0;//容量
    int size=0;//栈当前大小《=capcity
    T []stack=null;

    public DropOutStack(int capcity) {
        this.capcity = capcity;
        stack=(T[])new Object[capcity];

    }

    public DropOutStack() {
        stack=(T [])new Object[DEFALUT_CAPCITY];
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
        if(isEmpty()){
            System.out.print("ERROR");
            return null;
        }else{
            if(top==0){
                top=capcity-1;
            }
            else top = top -1;
            size=size-1;
            return stack[top];
        }
    }

    @Override
    public void push(T element) {
        size=size+1>=capcity?capcity:size+1;
        stack[top]=element;
        top = (top +1)%capcity;
    }

    @Override
    public T peek() {
        if(isEmpty())return null;
        else return stack[top];
    }
}
