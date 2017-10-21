package com.company.Tree;

import com.company.Deque.ArrayDeque;
import com.company.Deque.DequeADT;
import com.company.List.ArrayUnOrderedList;

import java.util.Iterator;

public class BinaryLinkedTree<T> implements BinaryTreeADT<T>{
    protected BinaryTreeNode<T> root;

    public BinaryLinkedTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryLinkedTree() {
        this.root=null;
    }

    @Override
    public T getRootElement() {
        if(isEmpty())return null;//throw Exception
        return root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size()>0?false:true;
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
        return find(targetElement)!=targetElement?false:true;
    }
    //Not Use Find Method
    public boolean contains_not(T targetElement){
        return _contains(root,targetElement);
    }

    private boolean _contains(BinaryTreeNode<T> root, T targetElement) {
        boolean result=false;
        if(root==null){
            result=false;
        }else{
            if(root.getElement().equals(targetElement)){
                result=true;
            }else{
                result=_contains(root.getLeft(),targetElement);
                if(result==false){//已经找到不用找了
                    result=_contains(root.getRight(),targetElement);
                }

            }
        }
        return result;
    }

    @Override
    public T find(T targetElement) {
        BinaryTreeNode<T> res=_find(root,targetElement);
        if(res!=null)return res.getElement();
        else return null;
    }
    private BinaryTreeNode<T>_find(BinaryTreeNode<T>root,T target){
        if(root==null)return null;
        else{
            if(root.getElement().equals(target)){
                return root;
            }else{
                BinaryTreeNode<T>res;
                res=_find(root.getLeft(),target);
                if(res!=null)
                    res=_find(root.getRight(),target);
                return res;
            }
        }

    }

    /**
     * default Iterator Inorder
     * @return
     */
    @Override
    public Iterator<T> iterator() {

        return iteratorInOrder();
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnOrderedList<T>tempList=new ArrayUnOrderedList<>();
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
