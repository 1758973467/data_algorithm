package com.company.Heap;

public class PriorityQueue<T>extends ArrayHeap<PriorityQueueNode<T>> {
    public PriorityQueue() {
        super();
    }

    public void addElement(T targetElement,int priority){
        PriorityQueueNode<T>obj=new PriorityQueueNode<>(targetElement,priority);
        super.addElement(obj);
    }
    public T removeNext(){
        PriorityQueueNode<T>obj=(PriorityQueueNode<T>)super.removeMin();
        return obj!=null?obj.getElement():null;
    }
}
