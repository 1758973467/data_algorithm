import com.company.Search;
import com.company.Sort;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class testSortSearch {
    Integer[]array;
    Integer[]orderArray;
    Random random=new Random();
    @Before
    public void testSpeedBefore(){

        array=new Integer[10];
        for(int i=0;i<array.length;++i){
            array[i]=random.nextInt()%40;
        }
        orderArray=new Integer[10];
        for(int i=0;i<orderArray.length;++i){
            orderArray[i]=i+5;
        }
    }

    @Test
    public void testSort(){
        //Integer []newarray={1,2,3,7,8,9,3,5};
        Sort.QuickSort(array,0,array.length-1);
        for(Integer a:array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    @Test
    public void testGapSortTime(){
        long start=System.currentTimeMillis();
        Sort.GapSort(array);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("GapSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.GapSort(orderArray);

        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("GapSort: orderArray "+cosumer+" ms");
    }

    @Test
    public void testQuickSortTime(){
        long start=System.currentTimeMillis();
        Sort.QuickSort(array,0,array.length-1);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("QuickSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.QuickSort(orderArray,0,orderArray.length-1);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("QuickSort: orderArray "+cosumer+" ms");
    }
    @Test
    public void testMergeSortTime(){
        long start=System.currentTimeMillis();
        Sort.MergeSort(array,0,array.length-1);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("MergeSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.MergeSort(orderArray,0,orderArray.length-1);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("MergeSort: orderArray "+cosumer+" ms");
    }
    @Test
    public void testBubbleSortTime(){
        long start=System.currentTimeMillis();
        Sort.BubbleSort(array);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("BubbleSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.BubbleSort(orderArray);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("BubbleSort: orderArray "+cosumer+" ms");
    }
    @Test
    public void testBubbleSortImproveTime(){
        long start=System.currentTimeMillis();
        Sort.BubbleSortImprove(array);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("BubbleSortImprove: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.BubbleSortImprove(orderArray);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("BubbleSortImprove: orderArray "+cosumer+" ms");
    }
    @Test
    public void testSelectionSortTime(){
        long start=System.currentTimeMillis();
        Sort.SelectionSort(array);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("SelectionSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.SelectionSort(orderArray);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("SelectionSort: orderArray "+cosumer+" ms");
    }
    @Test
    public void testInsertSortTime(){
        long start=System.currentTimeMillis();
        Sort.InsertSort(array);
        long end=System.currentTimeMillis();
        long cosumer=end-start;
        System.out.println("InsertSort: randomArray "+cosumer+" ms");
        start=System.currentTimeMillis();
        Sort.InsertSort(orderArray);
        end=System.currentTimeMillis();
        cosumer=end-start;
        System.out.println("InsertSort: orderArray "+cosumer+" ms");
    }
    @Test
    public void testHeapSortTime(){

        for(int i=0;i<array.length;++i){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        Sort.HeapSortEffcient(array);

        for(int i=0;i<array.length;++i){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    @Test
    public void testSearch(){
        int res= Search.BinarySearch(orderArray,0,orderArray.length-1,orderArray[orderArray.length-2]);
        System.out.println(res);
        res=Search.LinearSearch(array,array[array.length-1]);
        System.out.println(res);
    }

}
