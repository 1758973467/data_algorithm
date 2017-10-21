import com.company.List.*;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class testList {
    @Test
    public void testOrderedList()throws Exception{
        OrderedListADT<Integer>orderedList=new LinkedOrderedList<>();
        for(int i=0;i<8;++i){
            orderedList.add(i);
        }
        System.out.println(orderedList.size());
        int res=orderedList.remove(5);
        int size=orderedList.size();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeFirst());
        }
        System.out.println();
        Random random=new Random();

        for(int i=8;i>0;--i){
            int a=random.nextInt(100) ;
            System.out.print(a+" ");
            orderedList.add(a);
        }
        System.out.println();
        size=orderedList.size();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeLast()+" ");
        }
        System.out.println();
    }
    @Test
    public void testUnOrderedList(){
        UnOrderedListADT<Integer> orderedList=new LinkedUnOrderedList<>();
        for(int i=0;i<8;++i){
            orderedList.addToFront(i);
        }
        System.out.println(orderedList.size());
        int res=orderedList.remove(5);
        int size=orderedList.size();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeFirst());
        }
        System.out.println();
        Random random=new Random();

        for(int i=8;i>0;--i){
            int a=random.nextInt(100) ;
            System.out.print(a+" ");
            orderedList.addToRear(a);
        }
        System.out.println();
        size=orderedList.size();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeLast()+" ");
        }
        System.out.println();
    }
    @Test
    public void testIterator(){
        UnOrderedListADT<Integer> orderedList=new ArrayUnOrderedList<>();
        for(int i=0;i<8;++i){
            orderedList.addToFront(i);
        }
        System.out.println(orderedList.size());
        int res=orderedList.remove(5);
        int size=orderedList.size();
        Iterator<Integer>iterator=orderedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeFirst());
        }
        System.out.println();
        Random random=new Random();

        for(int i=8;i>0;--i){
            int a=random.nextInt(100) ;
            System.out.print(a+" ");
            orderedList.addToRear(a);
        }
        System.out.println();
        size=orderedList.size();
        for(int i=0;i<size;++i){
            System.out.print(orderedList.removeLast()+" ");
        }
        System.out.println();
    }
}
