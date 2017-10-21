package com.company.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ArrayList<T>implements ListADT<T> {
    protected static final int DEFAULT_CAPACITY=10;
    protected static final int NOT_FOUND = -1;
    protected int rear;//指向尾部，并显示当前列表数量
    protected T[] array;
    protected int capacity;
    protected int modCount;//指示数组修改的次数since constroctor

    public ArrayList(int capacity) {
        this.capacity = capacity;
        rear=0;
        modCount=0;
        array=(T [])new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public T removeFirst() {
        if(isEmpty())return null;
        T result=array[0];
        modCount++;
        rear--;
        //shift
        for(int i=0;i<rear;++i){
            array[i]=array[i+1];
        }
        return result;
    }

    @Override
    public T removeLast() {
        if(isEmpty())return null;
        T result=array[rear-1];
        modCount++;
        rear--;

        return result;
    }

    @Override
    public T remove(T element) {
        T result;
        int index=find(element);
        //found
        if(index==NOT_FOUND)return null;
        result=array[index];

        for(int i=index;i<rear;++i){
            array[i]=array[i+1];
        }
        modCount++;
        rear--;
        return result;
    }

    protected  int find(T element){
        for(int i=0;i<rear;++i){
            if(array[i].equals(element)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public T first() {
        if (isEmpty())return null;
        return array[rear-1];
    }

    @Override
    public boolean contains(T element) {
        return find(element)!=NOT_FOUND?true:false;
    }

    @Override
    public boolean isEmpty() {
        return size()>0?false:true;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    protected class ArrayListIterator implements Iterator<T>{
        protected int iteratorModCount;
        protected int current;

        public ArrayListIterator() {
            current=0;
            iteratorModCount=modCount;
        }

        @Override
        public boolean hasNext() {
            if(iteratorModCount!=modCount){
                throw new ConcurrentModificationException();
            }

            return rear>current?true:false;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T res=array[current];
            current++;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
