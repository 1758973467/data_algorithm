package com.company.Deque;

public class ArrayDeque<T> implements DequeADT<T> {
    private static final int DEFAULT_CAPACITY=10;
    private int capacity;
    private T deque[];
    private int rear;

    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        //count=0;
        deque=(T [])new Object[capacity];
        rear=0;

    }

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void addFirst(T element) {
        //check array is full
        if(rear>=capacity){
            expandCapacity();
        }
        //offset 整个数组 1
        for(int i=rear;i>1;--i){
            deque[i]=deque[i-1];
        }
        deque[0]=element;
        rear++;
    }

    private void expandCapacity() {
        T newdeque[]=(T [])new Object[capacity*2];
        System.arraycopy(deque,0,newdeque,0,capacity);
        deque=newdeque;
        capacity=capacity*2;
    }

    @Override
    public void addLast(T element) {
        if(rear>=capacity){
            expandCapacity();
        }
        deque[rear]=element;
        rear++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty())return null;
        T result=deque[0];
        //offset 1
        for(int i=0;i<rear-1;++i){
            deque[i]=deque[i+1];
        }
        rear--;
        return result;
    }

    @Override
    public T removeLast() {
        if(isEmpty())return null;
        T result=deque[rear];
        rear--;
        return result;
    }

    @Override
    public T peekFirst() {
        if(isEmpty())return null;
        else return deque[0];
    }

    @Override
    public T peekLast() {
        if(isEmpty())return null;
        else return deque[rear];
    }

    @Override
    public void enqueue(T element) {
        addLast(element);
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public T first() {
        return peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return size()>0?false:true;
    }

    @Override
    public int size() {
        return rear;
    }
}
