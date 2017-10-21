package com.company;


import com.company.Heap.ArrayHeap;

public class Sort<T extends Comparable<T>> {
    //顺序排序
    //插入排序，选择排序，冒泡排序
    //从小到大
    public static  <T extends Comparable<T>>void SelectionSort(T []array){
        for(int i=0;i<array.length;++i){
            int m=i;//min
            for(int j=i;j<array.length;++j){
                if(array[m].compareTo(array[j])>0){
                    m=j;
                }
            }
            swap(array,m,i);
        }
    }
    //从小到大
    public static <T extends Comparable<T>>void InsertSort(T []array){
        for(int i=1;i<array.length;++i){
            T temp=array[i];
            int j;
            for(j=i;j>0;--j){
                if(temp.compareTo(array[j-1])<0){
                    //shift
                    array[j]=array[j-1];
                }else break;
            }
            array[j]=temp;
        }
    }
    //从小到大
    public static  <T extends Comparable<T>> void BubbleSort(T []array){
        for(int i=array.length;i>0;--i){
            for(int j=0;j<i-1;++j){
                if(array[j].compareTo(array[j+1])>0){
                    swap(array,j,j+1);
                }
            }
        }
    }
    //从小到大，优化当子序列已排序时可以及时退出
    public static <T extends Comparable<T>>void BubbleSortImprove(T []array){
        for(int i=array.length-1;i>0;--i){
            int ok_count=0;//记录当前的0-i的子序列不交换次数 max :i即已排序
            for(int j=0;j<i;++j){
                if(array[j].compareTo(array[j+1])>0){
                    swap(array,j,j+1);
                }else{
                    ok_count++;
                }
            }
            if(ok_count==i)return;
        }
    }
    //从小到大，BubbleSort的一种变异形式
    public static <T extends Comparable<T>>void GapSort(T []array){
        int distance=array.length;
        while(distance>=1){
            for(int i=0;i<array.length;++i){
                if(i+distance<array.length){
                    if(array[i].compareTo(array[i+distance])>0){
                        swap(array,i,i+distance);
                    }
                }else if(i-distance>=0){
                    if(array[i].compareTo(array[i-distance])<0){
                        swap(array,i,i-distance);
                    }
                }

            }
            --distance;
        }
    }
    //快速排序 从小到大   太容易StackOverFlow 50个元素就不行了
    public static <T extends Comparable<T>>void QuickSort(T []array,int min,int max){
        if(min==max){
           return;
        }else if(min<max){
            int parat=PartitionElement(array,min,max);
            QuickSort(array,min,parat);
            QuickSort(array,parat+1,max);
        }
    }
    //找分区元素
    private static <T extends Comparable<T>>int PartitionElement(T[] array, int min, int max) {
        int middle=(min+max)/2;
        int trimiddle=(min+max+middle)/3;
        T key=array[trimiddle];
        swap(array,trimiddle,min);
        int left=min,right=max;
        while(left<right){
            while(left<=max&&key.compareTo(array[left])>=0){
                left++;
            }
            while(right>=min&&key.compareTo(array[right])<0){
                right--;
            }
            if(left<right){
                swap(array,left,right);
            }
        }
        swap(array,min,right);
        return right;
    }
    //归并排序
    public static <T extends Comparable<T>>void MergeSort(T []array,int min,int max){
        if(min==max){
            return;
        }else if(min<max){
            int middle=(min+max)/2;
            MergeSort(array,min,middle);
            MergeSort(array,middle+1,max);
            merge(array,min,middle,max);
        }

    }
    public static <T extends Comparable<T>>void HeapSort(T []array){
        ArrayHeap<T>temp=new ArrayHeap<>();
        for(int i=0;i<array.length;++i){
            temp.addElement(array[i]);
        }
        int count=0;
        while(!temp.isEmpty()){
            array[count]=temp.removeMin();
        }
    }
    private static <T extends Comparable<T>>void merge(T[] array, int first, int middle, int last) {


        T []tempArray=(T [])(new Comparable[array.length]);
        int first1=first,last1=middle;
        int first2=middle+1,last2=last;
        int index=first;
        while(first1<=last1 && first2<=last2){
            if(array[first1].compareTo(array[first2])<0){
                tempArray[index]=array[first1];
                first1++;
            }else{
                tempArray[index]=array[first2];
                first2++;
            }
            index++;
        }
        //copy array1 or array2
        for(int i=first1;i<=last1;++i,++index){
            tempArray[index]=array[i];
        }
        for(int i=first2;i<=last2;++i,++index){
            tempArray[index]=array[i];
        }
        System.arraycopy(tempArray,first,array,first,last-first+1);
    }

    private static  <T extends Comparable<T>> void swap(T []array,int a,int b){
        T temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

}
