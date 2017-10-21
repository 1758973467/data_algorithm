package com.company.Queue;

import com.company.LinearNode;

public class LinkedQueueNoCount<T> implements QueueADT<T> {
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

    public LinkedQueueNoCount() {
        head=null;
        rear=null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T>temp=new LinearNode<>(element);
        if(isEmpty()){
            head=rear=temp;
            return;
        }
        rear.setNext(temp);
        rear=temp;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            return null;
        }
        T result=head.getElement();
        head=head.getNext();
        return result;
    }

    @Override
    public T first() {
        if(isEmpty())return null;
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size()==0?true:false;
    }

    @Override
    public int size() {
        int count=0;
        LinearNode<T>current=head;
        if(head==null)count=0;
        else{
            for(;current!=null;++count){
                current=current.getNext();
            }
        }
        return count;
    }
}
