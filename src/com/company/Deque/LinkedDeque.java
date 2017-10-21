package com.company.Deque;

import com.company.DoubleNode;

public class LinkedDeque<T> implements DequeADT<T> {
    private int count;
    private DoubleNode<T> head,rear;

    public LinkedDeque() {
        count=0;
        head=new DoubleNode<>();
        rear=new DoubleNode<>();
        head.setNext(rear);
        head.setPrev(null);
        rear.setNext(null);
        rear.setPrev(head);
    }

    @Override
    public void addFirst(T element) {
        DoubleNode<T> insertNode=new DoubleNode<>(element);
        DoubleNode<T> temp=head.getNext();
        head.setNext(insertNode);
        insertNode.setNext(temp);
        insertNode.setPrev(head);
        temp.setPrev(insertNode);
        count++;
    }

    @Override
    public void addLast(T element) {
        DoubleNode<T> insertNode=new DoubleNode<>(element);
        DoubleNode<T> temp=rear.getPrev();
        rear.setPrev(insertNode);
        insertNode.setNext(rear);
        insertNode.setPrev(temp);
        temp.setNext(insertNode);
        count++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty())return null;
        else{
            DoubleNode<T> resultNode=head.getNext();
            DoubleNode<T> resultNodeNext=resultNode.getNext();
            head.setNext(resultNodeNext);
            resultNodeNext.setPrev(head);
            count--;
            return resultNode.getElement();
        }

    }

    @Override
    public T removeLast() {
        if (isEmpty())return null;
        else{
            DoubleNode<T> resultNode=rear.getPrev();
            DoubleNode<T> resultNodePrev=resultNode.getPrev();
            rear.setPrev(resultNodePrev);
            resultNodePrev.setNext(rear);
            count--;
            return resultNode.getElement();
        }
    }

    @Override
    public T peekFirst() {
       if(isEmpty()) return null;
       else return head.getNext().getElement();
    }

    @Override
    public T peekLast() {
        if(isEmpty())return null;
        else return rear.getPrev().getElement();
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
        return count;
    }
}
