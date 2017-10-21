package com.company.Stack;

import java.util.Arrays;

//自己的小细节搞不清楚！！！
public class ArrayStack<T> implements StackADT<T> {
    final int DEFALUT_CAPCITY=16;
    int top=0;//当前大小
    int capcity=0;//容量
    T []stack=null;
    @SuppressWarnings("unchecked")
    public ArrayStack(int capcity) {
        this.capcity = capcity;
        stack=(T[])new Object[capcity];

    }
    @SuppressWarnings("unchecked")
    public ArrayStack() {

        stack=(T [])new Object[DEFALUT_CAPCITY];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {

        return top ==0?true:false;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.print("ERROR");
            return null;
        }else{
            top = top -1;
            return stack[top];
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void push(T element) {
        if(top==capcity){
            //stack is full
            capcity=capcity*2;
            T[] newarray=(T[])new Object[capcity];
            System.arraycopy(stack,0,newarray,0, top);
            stack=newarray;
        }
        stack[top]=element;
        top = top +1;
    }

    @Override
    public T peek() {
        if(!isEmpty()){
            return stack[top -1];
        }
        else return null;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "DEFALUT_CAPCITY=" + DEFALUT_CAPCITY +
                ", top=" + top +
                ", capcity=" + capcity +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
}
