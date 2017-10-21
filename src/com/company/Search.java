package com.company;



public class Search {
    public static <T >int LinearSearch(T []array,T target){
        for(int i=0;i<array.length;++i){
            if(array[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
    //从小到大
    public static <T extends Comparable<T>> int BinarySearch(T []array,int min,int max,T target){
        int found=-1;
        int middle=(min+max)/2;
        if(array[middle].equals(target)){
            found=middle;
        }
        else if(array[middle].compareTo(target)>0){
            if(min<=middle-1){
                found=BinarySearch(array, min, middle - 1, target);
            }
        }else{
            if(middle+1<=max){
                found=BinarySearch(array, middle + 1, max, target);
            }
        }

        return found;
    }

}
