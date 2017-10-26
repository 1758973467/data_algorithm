package com.company.Heap.MaxHeap;

import com.company.Tree.BinaryArrayCalcTree;

public class MaxArrayHeap<T>extends BinaryArrayCalcTree<T> implements MaxHeapADT<T> {
    private int count;

    public MaxArrayHeap() {
        count=0;
    }

    @Override
    public T findMax() {
        if(isEmpty())return tree[0];
        else return null;
    }

    @Override
    public T removeMax() {
        if(isEmpty())return null;
        T result=tree[0];
        tree[0]=tree[count-1];
        heapifyRemove();

        --count;

        return result;
    }
    //TODO 简单处理了Index Out of Bounded Exception , must refactor this code
    private void heapifyRemove() {
        T temp=tree[0];
        int left=1,right=2;
        int next;
        if(left>=tree.length||right>=tree.length){
            expandCapacity();
        }
        if(tree[left]==null&&tree[right]==null){
            next=count;
        }else if(tree[right]==null){
            next=left;
        }else if(((Comparable<T>)tree[left]).compareTo(tree[right])>0){
            next=left;
        }else next=right;
        int parent=0;
        while(next!=count&&((Comparable<T>)temp).compareTo(tree[next])<0){
            tree[parent]=tree[next];
            parent=next;
            left=2*next+1;
            right=2*next+2;
            if(left>=tree.length||right>=tree.length){
                expandCapacity();
            }
            if(tree[left]==null&&tree[right]==null){
                next=count;
            }else if(tree[right]==null){
                next=left;
            }else if(((Comparable<T>)tree[left]).compareTo(tree[right])>0){
                next=left;
            }else next=right;
        }
        tree[next]=temp;
    }

    @Override
    public void addElement(T targetElement) {
        if(count==tree.length){
            expandCapacity();
        }
        tree[count]=targetElement;
        ++count;
        if(count>1){
            heapifyAdd();
        }
    }
    protected void expandCapacity() {
        T newTree[]=(T [])new Object[tree.length*2];
        System.arraycopy(tree,0,newTree,0,tree.length);
        tree=newTree;
    }
    private void heapifyAdd() {
        T temp= tree[count-1];
        int parent=count-1;
        while(parent!=0&&((Comparable<T>)temp).compareTo(tree[(parent-1)/2])>0){
            tree[parent]=tree[(parent-1)/2];
            parent=(parent-1)/2;

        }
        tree[parent]=temp;
    }

    @Override
    public T find(T targetElement) {
        if (isEmpty()) return null;
        if (!(targetElement instanceof Comparable)) return null;
        T resultElement = null;
        Comparable<T> tComparable = (Comparable) targetElement;
        if (tComparable.compareTo(tree[0]) > 0) {
            resultElement = null;
        } else if (tComparable.compareTo(tree[0]) == 0) {
            resultElement = tree[0];
        } else {
            resultElement = _find(targetElement, 2 * 0 + 1);
            if (resultElement != null) {
                resultElement = _find(targetElement, 2 * 0 + 2);
            }
        }
        return resultElement;
    }

    private T _find(T targetElement, int index) {
        T resultElement = null;
        if (index >= tree.length) {
            resultElement = null;
        }
        Comparable<T> tComparable = (Comparable) targetElement;
        if (tComparable.compareTo(tree[index]) > 0) {
            resultElement = null;
        } else if (tComparable.compareTo(tree[index]) == 0) {
            resultElement = tree[index];
        } else {
            resultElement = _find(targetElement, 2 * index + 1);
            if (resultElement != null) {
                resultElement = _find(targetElement, 2 * index + 2);
            }

        }
        return resultElement;
    }

    @Override
    public int size() {
        return count;
    }
}
