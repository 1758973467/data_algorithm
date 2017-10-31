package com.company.Set;

import com.company.List.LinkedUnOrderedList;
import com.company.List.UnOrderedListADT;

import java.util.Collection;
import java.util.Iterator;


public class LinkedSet<T>implements Set<T> {
    private UnOrderedListADT<T>list=new LinkedUnOrderedList<>();
    @Override
    public boolean add(T element) {
        if(contains(element))return false;
        list.addToRear(element);
        return true;
    }

    @Override
    public boolean addAll(Collection<T> c) {
        boolean result=true;
        for(T temp:c){
            if(!add(temp)){
                result = false;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        while (!list.isEmpty()){
            list.removeFirst();
        }
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T>iterator=list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<T> c) {
        for(T temp:c){
            if(!contains(temp))return false;
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return list.remove((T)o)==null?false:true;
    }

    @Override
    public boolean removeAll(Collection<T> c) {
        boolean result=true;
        for(T temp:c){
            if(!remove(temp)){
                result=false;
            }
        }
        return result;
    }

    @Override
    public boolean retainsAll(Collection<T> c) {
        UnOrderedListADT<T>newList=new LinkedUnOrderedList<>();
        for(T temp:c){
            if(contains(temp)){
                newList.addToRear(temp);
            }
        }
        list=newList;

        return true;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object[] toArray() {
        Object[]array=new Object[list.size()];
        Iterator iterator=list.iterator();
        for(int i=0;i<list.size();++i){
            array[i]=iterator.next();
        }
        return array;
    }

}
