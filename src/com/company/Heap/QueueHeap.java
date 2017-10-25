package com.company.Heap;

import com.company.Queue.QueueADT;

public class QueueHeap<T>extends ArrayHeap<PriorityQueueNode<T>> implements QueueADT<T> {
    int arrivalOrder=0;
    @Override
    public void enqueue(T element) {
        PriorityQueueNode node=new PriorityQueueNode(element,arrivalOrder);
        arrivalOrder--;
        super.addElement(node);
    }

    @Override
    public T dequeue() {
        PriorityQueueNode a=super.removeMin();
        if(a!=null)return (T)a.getElement();
        else return null;
    }

    @Override
    public T first() {
        PriorityQueueNode a=super.findMin();
        if(a!=null)return (T)a.getElement();
        else return null;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

}
