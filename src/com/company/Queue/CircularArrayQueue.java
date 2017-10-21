package com.company.Queue;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY=10;
    private int capacity;
    private int count;//队列数量
    private int head,rear;
    private T queue[];
    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        count=0;
        head=capacity-1;
        rear=capacity-1;
        queue=(T [])new Object[capacity];
    }

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if(count>=capacity){
            expandCapacity();
        }
        queue[rear]=element;
        rear--;
        if(rear<0){
            rear=capacity-1;
        }
        count++;
    }

    private void expandCapacity() {
        T newQueue[]=(T [])new Object[capacity*2];
        //head->rear ->newQueue

        for(int i=capacity*2-1;i>=count;--i){
            int j=head;
            newQueue[i]=queue[j];
            head--;
            if(head<0)head=capacity-1;
        }
        capacity*=2;
        queue=newQueue;
        head=capacity-1;
        rear=count-1;
    }

    @Override
    public T dequeue() {
        if(isEmpty())return null;
        T result=queue[head];
        head--;
        if(head<0){
            head=capacity-1;
        }
        count--;
        return result;
    }

    @Override
    public T first() {
        if (isEmpty())return null;
        else return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return count==0?true:false;
    }

    @Override
    public int size() {
        return count;
    }

}
