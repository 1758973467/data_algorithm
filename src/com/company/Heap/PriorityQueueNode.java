package com.company.Heap;

import java.util.Comparator;

public class PriorityQueueNode<T>implements Comparable<PriorityQueueNode> ,Comparator<PriorityQueueNode>{
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

    @Override
    public int compare(PriorityQueueNode o1, PriorityQueueNode o2) {
        return o1.compareTo(o2);
    }

    @Override
    public String toString() {
        return "PriorityQueueNode{" +
                "priority=" + priority +
                ", arrivalcode=" + arrivalcode +
                ", element=" + element +
                '}';
    }
}
