import com.company.Heap.PriorityQueueNode;
import com.company.Tree.BinaryTreeNode;
import com.company.Tree.HuffmanTree;
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

    public void testCalcTree(BinarySearchTreeADT<Integer> tree)throws Exception{

        for(int i=0;i<5;++i){
            tree.addElement(i);
        }
        for(int i=0;i>-6;--i){
            tree.addElement(i);
        }
        System.out.println(tree.size());
        Iterator iterator=tree.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        Integer a=tree.removeElement(6);
        System.out.println("delete 6 is:"+a);
        int answer=tree.find(4);
        System.out.println(answer);

        System.out.println(tree.removeMax()+" "+tree.removeMin());
        //System.out.println(tree.findMax()+" "+tree.findMin());
        tree.removeAllOccurrences(0);

        tree.removeElement(-2);
        tree.removeElement(-1);
        iterator=tree.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        //error
        System.out.println(tree.size());
    }
    @Test
    public void testLinkedTree()throws Exception{
        BinaryArrayLinkedSearchTree<Integer> tree=new BinaryArrayLinkedSearchTree<>();
        testCalcTree(tree);
    }
    @Test
    public void testHuffmanTree(){
        String str="123122";
        HuffmanTree huffmanTree=new HuffmanTree();
        String result=huffmanTree.Encode(str);
        assert(result.equals("011000100110000"));
        //System.out.println(root);
    }
}
