package com.company.Tree.SearchTree.BruteForce;

import com.company.Tree.SearchTree.BinaryArrayCalcSearchTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchBalanceArrayCalcTree<T>extends BinaryArrayCalcSearchTree<T> {
    //每到达10个就会重新排序
    int rebalance=0;
    @Override
    public void addElement(T element) throws Exception {
        super.addElement(element);

        if(rebalance>=10){
            rebalanceTree();
            rebalance=0;
        }else{
            ++rebalance;
        }
    }
    @SuppressWarnings("unchecked")
    private void rebalanceTree() throws Exception{
        //allocate Tree size array;
        List<T> array=new ArrayList<>();
        Iterator<T> treeInOrderIterator=this.iteratorInOrder();
        //可能会Out of Memory
        while(treeInOrderIterator.hasNext()){
            array.add(treeInOrderIterator.next());
        }
        //set tree 0
        for(int i=0;i<tree.length;++i){
            tree[i]=null;
        }
        System.out.println("size:"+size()+" "+array.size());
        //middle generate balance search  Tree
        generateBalanceTree(array,0,array.size()-1);
    }

    private void generateBalanceTree(List<T> array, int start, int end) throws Exception{
        if(start<=end){
            int middle=(start+end)/2;
            super.addElement(array.get(middle));
            generateBalanceTree(array,start,middle-1);
            generateBalanceTree(array,middle+1,end);
        }

    }
    @Override
    public T removeElement(T targetElement) {
        T result= super.removeElement(targetElement);

        if(rebalance>=10){
            try {
                rebalanceTree();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rebalance=0;
        }else{
            ++rebalance;
        }
        return result;
    }
}
