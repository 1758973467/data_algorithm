package com.company.Queue;
//ERROR

public class ArrayQueue<T>implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY=10;
    private int capacity;
    private int head=0;//下一个填充的位置
    private T queue[];
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        head=0;
        queue=(T [])new Object[capacity];
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if(head>=capacity){
            expandCapacity();
        }
        queue[head]=element;
        head++;
    }

    private void expandCapacity() {
        T newqueue[]=(T [])new Object[capacity*2];
        System.arraycopy(queue,0,newqueue,0,capacity);
        queue=newqueue;
        capacity*=2;
    }

    @Override
    public T dequeue() {
        if(isEmpty())return null;
        T result=queue[0];


        head--;
        for(int i=0;i<head;++i){
            queue[i]=queue[i+1];
        }
        return result;
    }

    @Override
    public T first() {
        if(isEmpty())return null;
        return queue[0];
    }

    @Override
    public boolean isEmpty() {
        return head==0?true:false;
    }

    @Override
    public int size() {
        return head;
    }
}
