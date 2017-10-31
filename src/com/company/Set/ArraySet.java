package com.company.Set;

import java.util.Collection;
import java.util.Iterator;

public class ArraySet<T>implements Set<T> {
    protected T[]data;
    int count;
    protected final static int DEFAULT_CAPACITY=10;

    public ArraySet() {
        this(DEFAULT_CAPACITY);
    }

    public ArraySet(int capacity) {
        data=(T [])new Object[capacity];
        count=0;
    }

    @Override
    public boolean add(T element) {
        if(data==null)data=(T [])new Object[DEFAULT_CAPACITY];
        else if(count==data.length){
            expandCapacity();
        }
        //check duplicate
        boolean result=checkDuplicate(element);
        if(!result){
            data[count]=element;
            ++count;
        }
        return !result;
    }

    private void expandCapacity() {
        T[]newData=(T[])new Object[data.length*2];
        System.arraycopy(data,0,newData,0,data.length);
        data=newData;
    }

    private boolean checkDuplicate(T element) {
        for(T a:data){
            if(element.equals(a)){
                return true;
            }
        }
        return false;
    }
    //是否失败该rollback?
    @Override
    public boolean addAll(Collection<T> c) {
        boolean result=true;
        for(T a:c){
            if(!add(a)){
                result=false;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        count=0;
        data=null;

    }

    @Override
    public boolean contains(Object o) {
        for(T temp:data){
            if(o.equals(temp)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<T> c) {
        for(T col:c){
            boolean result=contains(col);
            if(!result)return false;
        }
        return true;
    }



    @Override
    public Iterator iterator() {
        Iterator<T>iterator=new Iterator<T>() {
            int now=0;

            @Override
            public boolean hasNext() {
                return now<count?true:false;
            }

            @Override
            public T next() {
                T res=data[now];
                now++;
                return res;
            }
        };
        return iterator;
    }

    @Override
    public boolean remove(Object o) {
        if(isEmpty()) return false;
        else{
            for(int i=0;i<count;++i){
                if(data[i].equals(o)){
                    //offset
                    while(i<count-1){
                        data[i]=data[i+1];
                    }
                    count--;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<T> c) {
        boolean result=true;
        for(T o:c){
            if(!remove(o)){
                result=false;
            }
        }
        return result;
    }

    @Override
    public boolean retainsAll(Collection<T> c) {
        T []temp=(T [])new Object[c.size()];
        int i=0;
        for(T o:c){
            if(contains(o)){
                temp[i]=o;
                ++i;
            }
        }
        data=temp;
        count=i;
        return true;
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
    public Object[] toArray() {
        return  data;
    }
}
