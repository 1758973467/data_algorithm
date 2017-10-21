package com.company.Heap;

import com.company.Deque.ArrayDeque;
import com.company.Deque.DequeADT;
import com.company.List.ArrayUnOrderedList;
import com.company.Tree.BinaryTreeNode;

import java.util.Iterator;

public class LinkedHeap<T>implements HeapADT<T> {
    private LinkedHeapNode<T>root;
    private LinkedHeapNode<T> lastNode;
    private int modCount;
    private LinkedHeapNode<T> nextParentAdd;

    @Override
    public void addElement(T element) {
        LinkedHeapNode<T> node = new LinkedHeapNode<>(element);
        if (root == null) {
            root = node;
        } else {
            LinkedHeapNode<T> nextParent = getNextParentAdd();
            if (nextParent.getLeft() == null) {
                nextParent.setLeft(node);
            } else
                nextParent.setRight(node);
            node.setParent(nextParent);
        }
        lastNode = node;
        modCount++;
        if (size() > 1) {
            heapifyAdd();
        }
    }
    private LinkedHeapNode<T> getNextParentAdd() {
        LinkedHeapNode<T>result=lastNode;
        while(result!=root&&result.getParent().getLeft()!=result){
            result=result.getParent();
        }
        if(result!=root){
            if(result.getParent().getRight()==null){
                result=result.getParent();
            }else{
                result=(LinkedHeapNode<T>)result.getParent().getRight();
                while(result.getLeft()!=null){
                    result=(LinkedHeapNode<T>) result.getLeft();
                }

            }

        }else{
            while(result.getLeft()!=null){
                result=(LinkedHeapNode<T>) result.getLeft();
            }
        }
        return result;
    }
    private void heapifyAdd() {
        T temp;LinkedHeapNode<T>next=lastNode;
        temp=next.getElement();
        while(next!=root&&(((Comparable<T>)temp).compareTo(next.getParent().getElement())<0)){
            next.setElement(next.getParent().getElement());
            next=next.getParent();
        }
        next.setElement(temp);

    }

    @Override
    public T removeMin() {
        if(isEmpty())return null;
        T resultElement=root.getElement();
        if(size()==1){
            root=null;
            lastNode=null;
        }else{
            LinkedHeapNode<T>nextLast=getNewLastParentNode();
            if(lastNode.getParent().getLeft()==lastNode){
                lastNode.getParent().setLeft(null);
            }else{
                lastNode.getParent().setRight(null);
            }
            root.setElement(lastNode.getElement());
            lastNode=nextLast;
            heapifyRemove();

        }
        modCount--;
        return resultElement;
    }

    private void heapifyRemove() {
        T temp;
        LinkedHeapNode<T>node=(LinkedHeapNode<T>)root;
        LinkedHeapNode<T>left=(LinkedHeapNode<T>)node.getLeft();
        LinkedHeapNode<T>right=(LinkedHeapNode<T>)node.getRight();
        LinkedHeapNode<T>next;
        if(left==null&&right==null){
            next=null;
        }else if(right==null){
            next=left;
        }else if(((Comparable<T>)left).compareTo(right.getElement())<0){
            next=left;
        }else{
            next=right;
        }
        temp=node.getElement();

        while(next!=null&&((Comparable)next).compareTo(temp)<0){
            node.setElement(next.getElement());
            node=next;
            left=(LinkedHeapNode<T>)node.getLeft();
            right=(LinkedHeapNode<T>)node.getRight();

            if(left==null&&right==null){
                next=null;
            }else if(right==null){
                next=left;
            }else if(((Comparable<T>)left).compareTo(right.getElement())<0){
                next=left;
            }else{
                next=right;
            }
        }
        node.setElement(temp);
    }

    private LinkedHeapNode<T> getNewLastParentNode() {
        LinkedHeapNode<T>result=lastNode;
        while(result!=root&&result.getParent().getLeft()==result){
            result=result.getParent();
        }
        if(result!=root){
            result=(LinkedHeapNode<T>) result.getParent().getLeft();
        }
        while(result.getRight()!=null){
            result=(LinkedHeapNode<T>) result.getRight();
        }
        return result;
    }

    @Override
    public T findMin() {
        if(isEmpty())return null;
        return root.getElement();
    }

    @Override
    public T getRootElement() {
        if(isEmpty())return null;
        return root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (size()<=0);
    }

    @Override
    public int size() {
        return _size(root,0);
    }

    private int _size(BinaryTreeNode<T> root,int count) {
        int size=count;
        if(root!=null){
            size++;
            size=_size(root.getLeft(),size);
            size=_size(root.getRight(),size);
        }
        return size;
    }

    @Override
    public boolean contains(T targetElement) {
        return find(targetElement)!=null;
    }
    //use minHeap sort advantage
    @Override
    public T find(T targetElement) {
        if(isEmpty())return null;
        if(!(targetElement instanceof Comparable))return null;
        T result;
        Comparable<T>tComparable=(Comparable<T>)targetElement;
        LinkedHeapNode<T>node=root;

        if(tComparable.compareTo(root.getElement())<0){
            result= null;//NOT FOUND;
        }
        else if(tComparable.compareTo(root.getElement())==0){
            result=root.getElement();
        }
        else {
            result=_find(targetElement,root);
        }
        return result;
    }

    private T _find(T targetElement, LinkedHeapNode<T> node) {
        T result;
        Comparable<T>tComparable=(Comparable<T>)targetElement;
        if(node==null) return null;
        else{
            if(tComparable.compareTo(node.getElement())<0){
                result= null;//NOT FOUND;
            }
            else if(tComparable.compareTo(node.getElement())==0){
                result=node.getElement();
            }
            else {
                result=_find(targetElement,(LinkedHeapNode<T>)node.getLeft());
                if(result==null){
                    result=_find(targetElement,(LinkedHeapNode<T>)node.getRight());
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {

        return iteratorInOrder();
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnOrderedList<T> tempList=new ArrayUnOrderedList<>();
        inorder(root,tempList);
        return tempList.iterator();
    }

    private void inorder(BinaryTreeNode<T> root, ArrayUnOrderedList<T> tempList) {
        if(root==null){
            return;
        }else{
            inorder(root.getLeft(),tempList);
            tempList.addToRear(root.getElement());
            inorder(root.getRight(),tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnOrderedList<T>tempList=new ArrayUnOrderedList<>();
        preorder(root,tempList);
        return tempList.iterator();
    }

    private void preorder(BinaryTreeNode<T> root, ArrayUnOrderedList<T> tempList) {
        if(root==null){
            return;
        }else{
            tempList.addToRear(root.getElement());
            preorder(root.getLeft(),tempList);
            preorder(root.getRight(),tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnOrderedList<T>tempList=new ArrayUnOrderedList<>();
        postorder(root,tempList);
        return tempList.iterator();
    }

    private void postorder(BinaryTreeNode<T> root, ArrayUnOrderedList<T> tempList) {
        if(root==null){
            return;
        }else{
            postorder(root.getLeft(),tempList);
            postorder(root.getRight(),tempList);
            tempList.addToRear(root.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        DequeADT<BinaryTreeNode<T>> tempList=new ArrayDeque<>();
        ArrayUnOrderedList<T>res=new ArrayUnOrderedList<>();
        tempList.addLast(root);
        levelOrder(tempList,res);
        return res.iterator();
    }

    private void levelOrder( DequeADT<BinaryTreeNode<T>> tempList,ArrayUnOrderedList<T>resultlist) {
        while(!tempList.isEmpty()){
            BinaryTreeNode<T>temp=tempList.dequeue();
            if(temp!=null){
                tempList.addLast(temp.getLeft());
                tempList.addLast(temp.getRight());
                resultlist.addToRear(temp.getElement());
            }
        }
    }

    public void removeRightSubtree(){
        if(root==null)return;
        root.setRight(null);

    }

    public void removeAllElements(){
        root=null;
    }

    public int depth(T target){
        //
        if(target==null)return -1;//无效
        return _depth(root,target,0);
    }

    private int _depth(BinaryTreeNode<T> root, T target,int count) {
        int size=count;
        if(root!=null){
            if(root==target){
                return size;
            }else{
                _depth(root.getLeft(),target,size+1);
                _depth(root.getRight(),target,size+1);
            }
        }
        return size;
    }
}
