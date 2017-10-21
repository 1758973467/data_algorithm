package com.company.List;

public class ArrayUnOrderedList<T>extends ArrayList<T> implements UnOrderedListADT<T>{
    public ArrayUnOrderedList(int capacity) {
        super(capacity);
    }

    public ArrayUnOrderedList() {
        super();
    }

    //无序列表
    @Override
    public void addToFront(T element) {
        //
        if(rear>=capacity){
            expandCapacity();
        }
        //shift
        for(int i=rear;i>0;--i){
            array[i]=array[i-1];
        }
        array[0]=element;
        rear++;
        modCount++;

    }

    @Override
    public void addToRear(T element) {
        if(rear>=capacity){
            expandCapacity();
        }
        array[rear]=element;
        rear++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        int index=find(target);
        if(index==NOT_FOUND){
            return;
        }
        for(int i=rear;i>index;--i){
             array[i]=array[i-1];
        }
        array[index]=element;
    }
    private void expandCapacity() {
        T newArray[]=(T [])new Object[capacity*2];
        System.arraycopy(array,0,newArray,0,capacity);
        //这里应该是要modCount++
        array=newArray;
        modCount++;
        capacity*=2;

    }
}
