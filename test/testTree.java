import com.company.Tree.SearchTree.BinaryArrayLinkedSearchTree;
import com.company.Tree.SearchTree.BinarySearchLinkedTree;
import com.company.Tree.SearchTree.BinarySearchTreeADT;
import org.junit.Test;

import java.util.Iterator;

public class testTree {

    //普通搜索树
    @Test
    public void testSearchTree()throws Exception{
        BinarySearchTreeADT<Integer>searchTree=new BinarySearchLinkedTree<>();
        for(int i=0;i<5;++i){
            searchTree.addElement(i+2);
        }
        for(int i=0;i>-5;--i){
            searchTree.addElement(i-2);
        }
        int a=searchTree.removeElement(4);
        System.out.println(" "+searchTree.size());
        searchTree.addElement(0);
        searchTree.addElement(1);
        Iterator<Integer> iterator=searchTree.iteratorInOrder();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        searchTree.removeElement(0);
        System.out.println(searchTree.size());
        iterator=searchTree.iteratorInOrder();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
    @Test
    public void testBruteForceTree()throws Exception{
        BinaryArrayLinkedSearchTree<Integer> tree=new BinaryArrayLinkedSearchTree<>();
        for(int i=0;i<5;++i){
            tree.addElement(i);
        }
        //System.out.println(tree.size());
        for(int i=0;i>-6;--i){
            tree.addElement(i);
        }
        Integer a=tree.removeElement(6);
        //System.out.println(tree.size());


/**
        int answer=tree.find(4);
        System.out.println(answer);
 **/
        //System.out.println(tree.findMax()+" "+tree.findMin());
        System.out.println(tree.removeMax()+" "+tree.removeMin());
        //System.out.println(tree.findMax()+" "+tree.findMin());
        tree.removeAllOccurrences(0);

        tree.removeElement(-2);
        Iterator iterator=tree.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        //error
        System.out.println(tree.size());
    }
}
