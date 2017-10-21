package com.company;

public class DoubleNode<T> {
    private T element;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    public DoubleNode() {
        this.next=null;
        this.prev=null;
        this.element=null;
    }

    public DoubleNode(T element) {
        this.element = element;
        this.next=null;
        this.prev=null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
}
