package com.company.Tree;

import com.company.Deque.ArrayDeque;
import com.company.Deque.DequeADT;
import com.company.List.ArrayUnOrderedList;

import java.util.Iterator;

public class BinaryArrayLinkedTree<T>implements BinaryTreeADT<T> {
    protected static final int DEFAULT_CAPACITY=10;
    protected ArrayTreeNode<T> tree[];
    protected int rootIndex;
    @Override
    public T getRootElement() {
        return tree[rootIndex].getElement();
    }

    @Override
    public boolean isEmpty() {
        return size()>0?false:true;
    }

    @Override
    public int size() {
        int count=0;
        for(int i=0;i<tree.length;++i){
            if(tree[i]!=null)++count;
        }
        return count;
    }

    @Override
    public boolean contains(T targetElement) {
        return find(targetElement)==null?false:true;
    }
    @Override
    public T find(T targetElement) {
        int size=size();
        T res=null;
        for(int i=0;i<size;++i){
            if(tree[i].getElement().equals(targetElement)){
                res=tree[i].getElement();
            }
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnOrderedList<T>list=new ArrayUnOrderedList<>();
        _iteratorInOrder(rootIndex,list);
        return list.iterator();
    }

    private void _iteratorInOrder(int i, ArrayUnOrderedList<T> list) {
        if(i<0||i>=tree.length||tree[i]==null)return;
        else{
            _iteratorInOrder(tree[i].getLeft(),list);
            list.addToRear(tree[i].getElement());
            _iteratorInOrder(tree[i].getRight(),list);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnOrderedList<T>list=new ArrayUnOrderedList<>();
        _iteratorPreOrder(rootIndex,list);
        return list.iterator();

    }

    private void _iteratorPreOrder(int i, ArrayUnOrderedList<T> list) {
        if(i<0||i>=tree.length||tree[i]==null)return;
        else{
            list.addToRear(tree[i].getElement());
            _iteratorInOrder(tree[i].getLeft(),list);

            _iteratorInOrder(tree[i].getRight(),list);
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnOrderedList<T>list=new ArrayUnOrderedList<>();
        _iteratorPostOrder(rootIndex,list);
        return list.iterator();
    }

    private void _iteratorPostOrder(int i, ArrayUnOrderedList<T> list) {
        if(i<0||i>=tree.length||tree[i]==null)return;
        else{
            _iteratorInOrder(tree[i].getLeft(),list);

            _iteratorInOrder(tree[i].getRight(),list);
            list.addToRear(tree[i].getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        if(tree[rootIndex]==null)return null;
        else{
            ArrayUnOrderedList<T>list=new ArrayUnOrderedList<>();
            DequeADT<Integer> deque=new ArrayDeque<>();
            _iteratorLevelOrder(list,deque);
            return list.iterator();
        }
    }

    private void _iteratorLevelOrder( ArrayUnOrderedList<T> list, DequeADT<Integer> deque) {
        deque.addLast(rootIndex);
        while(!deque.isEmpty()){
            int temp=deque.removeFirst();
            if(temp<0||temp>=tree.length)continue;
            ArrayTreeNode<T>node=tree[temp];
            if(node!=null){
                deque.addLast(node.getLeft());
                deque.addLast(node.getRight());
                list.addToRear(node.getElement());
            }
        }
    }
}
