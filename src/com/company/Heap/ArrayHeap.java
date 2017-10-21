package com.company.Heap;

import com.company.List.ArrayUnOrderedList;

import java.util.Iterator;

public class ArrayHeap<T> implements HeapADT<T>{
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

    private void expandCapacity() {
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

    private void heapifyRemove() {
        T temp;
        int node=0;
        int left=1,right=2;
        int next;
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
            if(left>=tree.length&&right>=tree.length){
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

    @Override
    public T getRootElement() {
        return findMin();
    }

    @Override
    public boolean isEmpty() {
        return (size()<=0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(Object targetElement) {
        return false;
    }

    @Override
    public T find(Object targetElement) {
        int resultIndex=-1;
        for(int i=0;i<tree.length;++i){
            if(tree[i]!=null&&tree[i].equals(targetElement)){
                resultIndex=i;
                break;
            }
        }
        if(resultIndex!=-1)
            return tree[resultIndex];
        else return null;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorInOrder(0,list);
        return list.iterator();
    }

    private void _iteratorInOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{
            _iteratorInOrder(2*i+1,list);
            list.addToRear(tree[i]);
            _iteratorInOrder(2*i+2,list);
        }
    }


    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorPreOrder(0,list);
        return list.iterator();
    }

    private void _iteratorPreOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{
            list.addToRear(tree[i]);
            _iteratorInOrder(2*i+1,list);
            _iteratorInOrder(2*i+2,list);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorPostOrder(0,list);
        return list.iterator();

    }

    private void _iteratorPostOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{

            _iteratorInOrder(2*i+1,list);
            _iteratorInOrder(2*i+2,list);
            list.addToRear(tree[i]);
        }
    }
    //因为这本来是按层排序的
    @Override
    public Iterator<T> iteratorLevelOrder() {
        if(tree[0]==null) return null;
        else{
            ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
            for(int i=0;i<tree.length;++i){
                if(tree[i]!=null){
                    list.addToRear(tree[i]);
                }
            }
            return list.iterator();
        }
    }

}
