package com.company.Heap;

import com.company.Tree.BinaryArrayCalcTree;

public class ArrayHeap<T> extends BinaryArrayCalcTree<T>implements HeapADT<T>{
    private final static int DEFAULT_CAPACITY=50;
    private int count;
    private int modCount;
    protected T[]tree;

    public ArrayHeap() {
        count=0;
        //modCount=0;
        tree=(T [])new Object[DEFAULT_CAPACITY];
    }
    public ArrayHeap(T element){
        count=1;
        tree=(T [])new Object[DEFAULT_CAPACITY];
        tree[0]=element;
    }
    @Override
    public void addElement(T element) {
        if(count==tree.length){
            expandCapacity();
        }
        tree[count]=element;
        count++;
        modCount++;
        if(count<1){
            heapifyAdd();
        }
    }

    protected void expandCapacity() {
        T newTree[]=(T [])new Object[tree.length*2];
        System.arraycopy(tree,0,newTree,0,tree.length);
        tree=newTree;
    }

    //进行heap 整理，满足最小
    private void heapifyAdd() {
        T temp;
        int next=count-1;
        temp=tree[next];
        while((next!=0)&&((Comparable)temp).compareTo(tree[(next-1)/2])<0){
            tree[next]=tree[(next-1)/2];
            next=(next-1)/2;
        }
        tree[next]=temp;
    }

    @Override
    public T removeMin() {
        if(isEmpty())return null;

        T minELement=tree[0];
        tree[0]=tree[count-1];
        heapifyRemove();
        count--;
        modCount--;
        return minELement;
    }
    //TODO 简单处理了Index Out of Bounded Exception , must refactor this code,more occur Out of Memory Exception

    private void heapifyRemove() {
        T temp;
        int node=0;
        int left=1,right=2;
        int next;
        if(left>=tree.length||right>=tree.length){
            expandCapacity();
        }
        if(tree[left]==null&&tree[right]==null){
            next=count;
        }else if(tree[right]==null){
            next=left;
        }else if(((Comparable)tree[left]).compareTo(tree[right])<0){
            next=left;
        }else{
            next=right;
        }
        temp=tree[node];
        while(next<count&&((Comparable)tree[next]).compareTo(temp)<0){
            tree[node]=tree[next];
            node=next;
            left=2*node+1;
            right=2*node+2;
            if(left>=tree.length||right>=tree.length){
                expandCapacity();
            }
            if(tree[left]==null&&tree[right]==null){
                next=count;
            }else if(tree[right]==null){
                next=left;
            }else if(((Comparable)tree[left]).compareTo(tree[right])<0){
                next=left;
            }else{
                next=right;
            }

        }
        tree[node]=temp;
    }

    @Override
    public T findMin() {
        if(isEmpty())return null;
        T minELement=tree[0];
        return minELement;
    }


}
