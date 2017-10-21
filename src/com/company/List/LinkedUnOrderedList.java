package com.company.List;

import com.company.DoubleNode;

public class LinkedUnOrderedList<T>extends LinkedList<T>implements UnOrderedListADT<T> {
    @Override
    public void addToFront(T element) {
        DoubleNode<T>node=new DoubleNode<>(element);
        DoubleNode<T>nodeNext=head.getNext();
        head.setNext(node);
        node.setPrev(head);
        node.setNext(nodeNext);
        nodeNext.setPrev(node);
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode<T>node=new DoubleNode<>(element);
        DoubleNode<T>nodePrev=rear.getPrev();
        rear.setPrev(node);
        node.setNext(rear);
        node.setPrev(nodePrev);
        nodePrev.setNext(node);
        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        DoubleNode<T>foundNode=find(target);
        if(foundNode==null)return;
        DoubleNode<T>node=new DoubleNode<>(element);
        DoubleNode<T>nodeNext=foundNode.getNext();
        DoubleNode<T>nodePrev=foundNode;
        nodePrev.setNext(node);
        node.setNext(nodePrev);
        node.setNext(nodeNext);
        nodeNext.setPrev(node);
        count++;
        modCount++;
    }
}
