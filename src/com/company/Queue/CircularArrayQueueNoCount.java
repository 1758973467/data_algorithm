package com.company.Queue;

public class CircularArrayQueueNoCount<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY=10;
    private int capacity;
    private int head,rear;
    private T queue[];
    public CircularArrayQueueNoCount(int capacity) {
        this.capacity = capacity;

        head=capacity-1;
        rear=capacity-1;
        queue=(T [])new Object[capacity];
    }

    public CircularArrayQueueNoCount() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(T element) {
        if(size()>=capacity){
            expandCapacity();
        }
        queue[rear]=element;
        rear--;
        if(rear<0){
            rear=capacity-1;
        }

    }

    private void expandCapacity() {
        T newQueue[]=(T [])new Object[capacity*2];
        //head->rear ->newQueue
        int size=size();
        for(int i=capacity*2-1;i>=size;--i){
            int j=head;
            newQueue[i]=queue[j];
            head--;
            if(head<0)head=capacity-1;
        }
        capacity*=2;
        queue=newQueue;
        head=capacity-1;
        rear=size-1;
    }

    @Override
    public T dequeue() {
        if(isEmpty())return null;
        T result=queue[head];
        queue[head]=null;//default value
        head--;
        if(head<0){
            head=capacity-1;
        }

        return result;
    }

    @Override
    public T first() {
        if (isEmpty())return null;
        else return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return size()==0?true:false;
    }

    @Override
    public int size() {
        int count=0;
        if(head>rear){
            count=capacity-head+rear;
        }else if(rear>head){
            count=rear-head;
        }else{
            if(queue[rear]!=null)count=capacity;
            else count=0;
        }
        return count;
    }
}
