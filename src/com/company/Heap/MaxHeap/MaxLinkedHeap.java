package com.company.Heap.MaxHeap;


import com.company.Heap.HeapNode;
import com.company.Tree.BinaryLinkedTree;

public class MaxLinkedHeap<T>extends BinaryLinkedTree<T>implements MaxHeapADT<T> {
    protected HeapNode<T> root;
    private HeapNode<T> lastNode;
    private int modCount;
    public MaxLinkedHeap() {
        lastNode =null;
    }

    @Override
    public T findMax() {
        if(isEmpty())return null;
        else return root.getElement();
    }

    @Override
    public T removeMax() {
        if (isEmpty()) return null;
        T resultElement = root.getElement();
        if (size() == 1) {
            root = null;
            lastNode = null;

        } else {
            HeapNode<T> nextLast = getNewLastParentNode();
            if (lastNode.getParent().getLeft() == lastNode) {
                lastNode.getParent().setLeft(null);
            } else {
                lastNode.getParent().setRight(null);
            }
            root.setElement(lastNode.getElement());
            lastNode = nextLast;
            heapifyRemove();
        }
        return resultElement;
    }

    private void heapifyRemove() {
        T temp;
        HeapNode<T>node=(HeapNode<T>)root;
        HeapNode<T>left=(HeapNode<T>)node.getLeft();
        HeapNode<T>right=(HeapNode<T>)node.getRight();
        HeapNode<T>next;
        if(left==null&&right==null){
            next=null;
        }else if(right==null){
            next=left;
        }else if(((Comparable<T>)left).compareTo(right.getElement())>0){
            next=left;
        }else{
            next=right;
        }
        temp=node.getElement();

        while(next!=null&&((Comparable)next).compareTo(temp)>0){
            node.setElement(next.getElement());
            node=next;
            left=(HeapNode<T>)node.getLeft();
            right=(HeapNode<T>)node.getRight();

            if(left==null&&right==null){
                next=null;
            }else if(right==null){
                next=left;
            }else if(((Comparable<T>)left).compareTo(right.getElement())>0){
                next=left;
            }else{
                next=right;
            }
        }
        node.setElement(temp);
    }

    @Override
    public void addElement(T targetElement) {
        HeapNode<T> node = new HeapNode<>(targetElement);
        if (root == null) {
            root = node;
            lastNode = node;
        } else {
            HeapNode<T> parentNode = getNextParentAdd();
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(node);
            } else parentNode.setRight(node);
            node.setParent(parentNode);
        }
        lastNode = node;
        modCount++;
        if (size() > 1) {
            heapifyAdd();
        }
    }

    private void heapifyAdd() {
        T temp;
        HeapNode<T>next= lastNode;
        temp=next.getElement();
        while(next!=root&&(((Comparable<T>)temp).compareTo(next.getParent().getElement())>0)){
            next.setElement(next.getParent().getElement());
            next=next.getParent();
        }
        next.setElement(temp);
    }

    public HeapNode<T> getNextParentAdd() {
        HeapNode<T>result= lastNode;
        while(result!=root&&result.getParent().getLeft()!=result){
            result=result.getParent();
        }
        if(result!=root){
            if(result.getParent().getRight()==null){
                result=result.getParent();
            }else{
                result=(HeapNode<T>)result.getParent().getRight();
                while(result.getLeft()!=null){
                    result=(HeapNode<T>) result.getLeft();
                }

            }

        }else{
            while(result.getLeft()!=null){
                result=(HeapNode<T>) result.getLeft();
            }
        }
        return result;

    }

    public HeapNode<T> getNewLastParentNode() {
        HeapNode<T>result=lastNode;
        while(result!=root&&result.getParent().getLeft()==result){
            result=result.getParent();
        }
        if(result!=root){
            result=(HeapNode<T>) result.getParent().getLeft();
        }
        while(result.getRight()!=null){
            result=(HeapNode<T>) result.getRight();
        }
        return result;
    }

    @Override
    public T find(T targetElement) {
        if(isEmpty())return null;
        if(!(targetElement instanceof Comparable))return null;
        T result;
        Comparable<T>tComparable=(Comparable<T>)targetElement;
        HeapNode<T>node=root;

        if(tComparable.compareTo(root.getElement())>0){
            result= null;//NOT FOUND;
        }
        else if(tComparable.compareTo(root.getElement())==0){
            result=root.getElement();
        }
        else {
            result=_find(targetElement,root);
        }
        return result;
    }

    private T _find(T targetElement, HeapNode<T> node) {
        T result;
        Comparable<T>tComparable=(Comparable<T>)targetElement;
        if(node==null) return null;
        else{
            if(tComparable.compareTo(node.getElement())>0){
                result= null;//NOT FOUND;
            }
            else if(tComparable.compareTo(node.getElement())==0){
                result=node.getElement();
            }
            else {
                result=_find(targetElement,(HeapNode<T>)node.getLeft());
                if(result==null){
                    result=_find(targetElement,(HeapNode<T>)node.getRight());
                }
            }
        }
        return result;
    }

}
