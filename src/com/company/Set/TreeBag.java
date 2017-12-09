package com.company.Set;

import com.company.Tree.SearchTree.BinarySearchLinkedTree;

import java.util.Collection;
import java.util.Iterator;

//允许集合中有重复元素，基于树
public class TreeBag<T> implements Set<T>{
    private BinarySearchLinkedTree<T>tree;

    public TreeBag() {
        this.tree = new BinarySearchLinkedTree<>();
    }

    @Override
    public boolean add(T element) {
        try {
            tree.addElement(element);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<T> c) {
        for(T temp:c){
            add(temp);
        }
        return true;
    }

    @Override
    public void clear() {

        tree.removeAllElements();

    }

    @Override
    public boolean contains(Object o) {
        return tree.contains((T)o);
    }

    @Override
    public boolean containsAll(Collection<T> c) {
        boolean result=true;
        for(T temp:c){
            if(!contains(temp)){
                result=false;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return tree.iterator();
    }

    @Override
    public boolean remove(Object o) {

        return tree.removeElement((T)o)==null?false:true;
    }

    @Override
    public boolean removeAll(Collection<T> c) {
        boolean result=true;
        for(T temp:c){
            if(!remove(temp)){
                result=false;
            }
        }
        return result;
    }

    @Override
    public boolean retainsAll(Collection<T> c) {
        BinarySearchLinkedTree<T>newTree=new BinarySearchLinkedTree<>();
        for(T temp:c){
            if(contains(temp)){
                try {
                    newTree.addElement(temp);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        tree=newTree;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public Object[] toArray() {
        Iterator<T>iterator=tree.iterator();
        int size=tree.size();
        Object[]data=new Object[size];

        for(int i =0;i<tree.size();++i){
            data[i]=iterator.next();
        }
        return data;
    }
}
