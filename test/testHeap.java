import com.company.Heap.HeapADT;
import com.company.Heap.MaxHeap.MaxArrayHeap;
import com.company.Heap.MaxHeap.MaxHeapADT;
import com.company.Heap.QueueHeap;
import com.company.Heap.StackHeap;
import com.company.Queue.QueueADT;
import com.company.Stack.StackADT;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class testHeap {
    @Test
    public void testQueueHeap(){
        QueueADT<Integer> queue=new QueueHeap<>();
        for(int i=0;i<15;++i){
            queue.enqueue(i);
        }

        for(int i=0;i<5;++i){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.size());
        for(int i=0;i<8+6;++i){
            queue.enqueue(i+7);
        }
        while(!queue.isEmpty()){
            System.out.print(queue.dequeue()+" ");
        }
        System.out.println();
        System.out.println(queue.size());
    }
    @Test
    public void testHeapStack(){
        StackADT<Integer> stackADT=new StackHeap<Integer>();
        for(int i=0;i<5;++i){
            stackADT.push(i);
        }
        System.out.println(stackADT.size());
        int size=stackADT.size();
        for(int i=size;i>0;--i){
            System.out.println(stackADT.pop());
        }
    }
    @Test
    public void testMaxHeap(){
        MaxHeapADT<Integer>maxHeap=new MaxArrayHeap<>();
        Random random=new Random();
        for(int i=0;i<15;++i){
            int temp=random.nextInt()%100;
            System.out.print(temp+" ");
            maxHeap.addElement(temp);
        }
        System.out.println();
        Iterator iterator=maxHeap.iteratorLevelOrder();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.removeMax()+" ");
        }
        System.out.println();
    }

}
