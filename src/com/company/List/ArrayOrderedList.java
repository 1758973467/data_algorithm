package com.company.List;

public class ArrayOrderedList<T>extends ArrayList<T>implements OrderedListADT<T> {
    public ArrayOrderedList(int capacity) {
        super(capacity);
    }

    public ArrayOrderedList() {
        super();
    }

    //有序列表 从小到大
    @Override
    public void add(T element)throws Exception {
        if(!(element instanceof Comparable)){
            throw new Exception("this type is not Compare");
        }
        if(rear>=capacity){
            expandCapacity();
        }
        //find element
        Comparable<T>comparableElement=(Comparable<T>) element;
        int index=0;
        while(index!=rear&&comparableElement.compareTo(array[index])>0){//element<array[index]
            index++;
        }

        //shift
        for(int i=rear;i>index;--i){
            array[i]=array[i-1];
        }
        array[index]=element;

        rear++;
        modCount++;
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
