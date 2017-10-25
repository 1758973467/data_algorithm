package com.company.Heap;

public class PriorityQueueNode<T>implements Comparable<PriorityQueueNode> {
    private int priority;
    private int arrivalcode;
    private T element;
    private static int nextOrder=0;

    public PriorityQueueNode(T element, int priority) {
        this.element = element;
        this.priority = priority;
        arrivalcode=nextOrder;
        nextOrder++;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalcode() {
        return arrivalcode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public int compareTo(PriorityQueueNode o) {
        int result;
        if(this.priority>o.getPriority()){
            result=1;
        }else if(this.priority<o.getPriority()){
            result=-1;
        }else if(this.arrivalcode>o.getArrivalcode()){
            result=1;
        }else if(this.arrivalcode<o.getArrivalcode()){
            result=-1;
        }else result=-1;
        return result;
    }
}
