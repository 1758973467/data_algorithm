import com.company.Queue.LinkedQueueNoCount;
import com.company.Queue.QueueADT;
import org.junit.Test;

public class testQueue {
    @Test
    public void testQueue(){
        QueueADT<Integer> queue=new LinkedQueueNoCount<>();
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
}
