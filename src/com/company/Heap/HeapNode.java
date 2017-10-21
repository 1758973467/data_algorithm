package com.company.Heap;

public class HeapNode<T>implements Comparable<HeapNode> {
    T element;
    int prority;

    public HeapNode(T element, int prority) {
        this.element = element;
        this.prority = prority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPrority() {
        return prority;
    }

    public void setPrority(int prority) {
        this.prority = prority;
    }

    @Override
    public int compareTo(HeapNode o) {
        int result=0;
        if(this.prority>o.prority){
            result=1;
        }else if(this.prority<o.prority){
            result=-1;
        }else{
            result=0;
        }
        return result;
    }
}
