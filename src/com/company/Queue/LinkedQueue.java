package com.company.Queue;

import com.company.LinearNode;

public class LinkedQueue<T> implements QueueADT<T> {
    private int count;
    private LinearNode<T> head,rear;

    @Override
    public String toString() {
        StringBuffer strbuffer=new StringBuffer("");
        LinearNode<T> current=head;
        if(isEmpty())return strbuffer.toString();
        while(current!=null){
            strbuffer.append(current.getElement());
            current=current.getNext();
        }
        return strbuffer.toString();
    }

    public LinkedQueue() {
        count=0;
        head=null;
        rear=null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T>temp=new LinearNode<>(element);
        if(isEmpty()){
            head=rear=temp;
            count++;
            return;
        }
        rear.setNext(temp);
        rear=temp;
        count++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            return null;
        }
        T result=head.getElement();
        head=head.getNext();
        count--;
        return result;
    }

    @Override
    public T first() {
        if(isEmpty())return null;
        return head.getElement();
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
