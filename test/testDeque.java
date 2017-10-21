import com.company.Deque.ArrayDeque;
import com.company.Deque.DequeADT;
import com.company.Queue.LinkedQueue;
import com.company.Queue.QueueADT;
import com.company.Stack.LinearStack;
import com.company.Stack.StackADT;
import org.junit.Test;

import java.util.stream.IntStream;

public class testDeque {
    @Test
    public void testDeque(){
        DequeADT<Integer> queue=new ArrayDeque<>();
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
    //测试字符串是否回文
    public void testStringPalindrome(){
        StackADT<Integer> stack=new LinearStack<>();
        QueueADT<Integer> queue=new LinkedQueue<>();
        String str="123aa321";
        IntStream intStream=str.chars();
        int array[]=intStream.toArray();//ASCii 码
        for(int a:array){
            stack.push(a);
            queue.enqueue(a);
            System.out.print(a+" ");
        }
        System.out.println();
        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.dequeue())){
                System.out.println("this str is not  Palindrome");
            }
        }
        System.out.println("this str is Palindrome!");
    }
}
