package com.company.List;

import com.company.DoubleNode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedList<T>implements ListADT<T> {
    //有哨兵节点
    protected DoubleNode<T>head,rear;
    protected int count;
    protected int modCount;

    public LinkedList() {
        head=new DoubleNode<>();
        rear=new DoubleNode<>();
        head.setNext(rear);
        rear.setPrev(head);
        count=0;
        modCount=0;
    }

    @Override
    public T removeFirst() {
        if(isEmpty())return null;
        else{
            DoubleNode<T>resultNode=head.getNext();
            DoubleNode<T>resultNodeNext=resultNode.getNext();
            head.setNext(resultNodeNext);
            resultNodeNext.setPrev(head);

            modCount++;
            count--;
            return resultNode.getElement();
        }
    }

    @Override
    public T removeLast() {
        if(isEmpty())return null;
        else{
            DoubleNode<T>resultNode=rear.getPrev();
            DoubleNode<T>resultNodePrev=resultNode.getPrev();
            rear.setPrev(resultNodePrev);
            resultNodePrev.setNext(rear);

            modCount++;
            count--;
            return resultNode.getElement();
        }
    }



    @Override
    public T remove(T element) {
        if(isEmpty())return null;
        DoubleNode<T>node=find(element);
        if(node==null){//NOT_FOUND
            return null;
        }
        DoubleNode<T>nodeNext=node.getNext();
        DoubleNode<T>nodePrev=node.getPrev();
        nodePrev.setNext(nodeNext);
        nodeNext.setPrev(nodePrev);
        count--;
        modCount++;
        return node.getElement();
    }

    protected DoubleNode<T> find(T element) {
        DoubleNode<T>current=head.getNext();
        while(current!=rear){
            if(current.getElement().equals(element)){
                return current;
            }
            current=current.getNext();
        }
        return null;
    }

    @Override
    public T first() {
        if(isEmpty())return null;
        else{
            return head.getNext().getElement();
        }
    }

    @Override
    public boolean contains(T element) {
        return find(element)!=null?true:false;
    }

    @Override
    public boolean isEmpty() {
        return size()>0?false:true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    protected class LinkedListIterator implements Iterator{
        protected int iteratorModCount;
        protected DoubleNode<T>current;
        public LinkedListIterator() {
            current=head;
            iteratorModCount=modCount;
        }

        @Override
        public boolean hasNext() {
            if(iteratorModCount!=modCount){
                throw new ConcurrentModificationException();
            }

            return current.getNext()!=rear?true:false;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            DoubleNode<T>res=current.getNext();
            current=current.getNext();
            return res.getElement();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
