package com.company.List;

import com.company.DoubleNode;

public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T> {


    //有序列表 从小到大
    @Override
    public void add(Object element)throws Exception {
        if(!(element instanceof Comparable)){
            throw new Exception("this  type is not Comparable");
        }

        Comparable<T>comparableElement=(Comparable<T>)element;
        DoubleNode<T>foundNode=head.getNext();
        while(foundNode!=rear&&comparableElement.compareTo(foundNode.getElement())<0){//element<resultNode.getElement()
            foundNode=foundNode.getNext();
        }
        DoubleNode<T>node=new DoubleNode(element);

        DoubleNode<T>nodePrev=foundNode.getPrev();
        nodePrev.setNext(node);
        node.setPrev(nodePrev);
        node.setNext(foundNode);
        foundNode.setPrev(node);
        count++;
        modCount++;
    }
}
