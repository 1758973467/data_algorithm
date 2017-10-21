package com.company.Tree;

import com.company.List.ArrayUnOrderedList;

import java.util.Iterator;
//计算策略
//对于元素n 其左孩子2*n+1 右孩子2*（n+1）
public class BinaryArrayCalcTree<T>implements BinaryTreeADT<T> {
    protected static final int DEFAULT_CAPACITY=10;
    //当前容量用tree.length代替
    protected T tree[];//root为tree[0]
    @SuppressWarnings("unchecked")
    public BinaryArrayCalcTree() {
        tree=(T [])new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T getRootElement() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return size()<=0;
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
        return (find(targetElement)!=null);
    }

    @Override
    public T find(T targetElement) {
        int resultIndex=-1;
        for(int i=0;i<tree.length;++i){
            if(tree[i]!=null&&tree[i].equals(targetElement)){
                resultIndex=i;
                break;
            }
        }
        if(resultIndex!=-1)
            return tree[resultIndex];
        else return null;
    }
    // inorder
    @Override
    public Iterator<T> iterator() {
        return iteratorInOrder();
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorInOrder(0,list);
        return list.iterator();
    }

    private void _iteratorInOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{
            _iteratorInOrder(2*i+1,list);
            list.addToRear(tree[i]);
            _iteratorInOrder(2*i+2,list);
        }
    }


    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorPreOrder(0,list);
        return list.iterator();
    }

    private void _iteratorPreOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{
            list.addToRear(tree[i]);
            _iteratorInOrder(2*i+1,list);
            _iteratorInOrder(2*i+2,list);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
        _iteratorPostOrder(0,list);
        return list.iterator();

    }

    private void _iteratorPostOrder(int i, ArrayUnOrderedList<T> list) {
        if(i>=tree.length||tree[i]==null)return;
        else{

            _iteratorInOrder(2*i+1,list);
            _iteratorInOrder(2*i+2,list);
            list.addToRear(tree[i]);
        }
    }
    //因为这本来是按层排序的
    @Override
    public Iterator<T> iteratorLevelOrder() {
        if(tree[0]==null) return null;
        else{
            ArrayUnOrderedList<T> list=new ArrayUnOrderedList<>();
            for(int i=0;i<tree.length;++i){
                if(tree[i]!=null){
                    list.addToRear(tree[i]);
                }
            }
            return list.iterator();
        }
    }
}
