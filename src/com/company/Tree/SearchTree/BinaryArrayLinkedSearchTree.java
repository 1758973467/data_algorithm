package com.company.Tree.SearchTree;

import com.company.Deque.ArrayDeque;
import com.company.Deque.DequeADT;
import com.company.Tree.ArrayTreeNode;
import com.company.Tree.BinaryArrayLinkedTree;


public class BinaryArrayLinkedSearchTree<T>extends BinaryArrayLinkedTree<T>implements BinarySearchTreeADT<T> {
    //数组中可用的位置
    protected DequeADT<Integer>deque;
    @SuppressWarnings("unchecked")
    public BinaryArrayLinkedSearchTree(int capacity) {
        assert(capacity>0);
        tree=new ArrayTreeNode[capacity];
        deque=new ArrayDeque<>();
        for(int i=0;i<DEFAULT_CAPACITY;++i){
            deque.addLast(i);
        }
    }
    public BinaryArrayLinkedSearchTree() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void addElement(T element) throws Exception {
        if(!(element instanceof Comparable))throw new Exception("not support");
        int parentindex=0;
        int targetIndex=getNextTargetIndex();
        ArrayTreeNode<T>node=new ArrayTreeNode<T>(element);

        tree[targetIndex]=node;
        if(targetIndex==0){
            tree[targetIndex]=node;
            return;
        }
        //非空树
        ArrayTreeNode<T>temp;
        while(tree[parentindex]!=null){
            Comparable<T>comparable=(Comparable<T>)element;
            temp=tree[parentindex];
            if(comparable.compareTo(temp.getElement())>=0){
                if(temp.getRight()>=0){
                    parentindex=temp.getRight();
                }else{
                    temp.setRight(targetIndex);
                    break;
                }
            }else{
                if(temp.getLeft()>=0){
                    parentindex=temp.getLeft();
                }else{
                    temp.setLeft(targetIndex);
                    break;
                }
            }
            if(parentindex>=tree.length){
                expandCapacity();
            }
        }

    }
//TODO error behavior
    @Override
    public T removeElement(T targetElement) {
        if(!(targetElement instanceof Comparable))return null;
        if(isEmpty())return null;
        //root
        T resultElement;
        int oldRootIndex=rootIndex;
        ArrayTreeNode<T>rootNode=tree[rootIndex];
        Comparable<T>tComparable=(Comparable<T>) targetElement;
        if(tComparable.compareTo(rootNode.getElement())==0){
            //单节点
            resultElement=rootNode.getElement();
            if(rootNode.getLeft()==-1&&rootNode.getRight()==-1){
                tree[rootIndex]=null;
            }else if( rootNode.getLeft()==-1){
                rootIndex=rootNode.getRight();
            }else if(rootNode.getRight()==-1){
                rootIndex=rootNode.getLeft();
            }else{//两个节点都存在，以right.left.left
                int right=rootNode.getRight();
                ArrayTreeNode<T>temp=tree[right];
                int parentIndex=-1,left=temp.getLeft();
                while(left!=-1){
                    temp=tree[left];
                    if(temp.getLeft()!=-1){
                        parentIndex=left;
                        left=temp.getLeft();
                    }else break;
                }
                if(parentIndex==-1){
                    parentIndex=right;
                }
                if(tree[right].getLeft()==-1){
                    ArrayTreeNode<T>rightNode=tree[right];
                    rightNode.setLeft(rootNode.getLeft());
                    rootIndex=right;
                }
                //如果未移动,即 root.right.left==-1
                else{
                    ArrayTreeNode<T>parentNode=tree[parentIndex],shiftNode=tree[left];
                    parentNode.setLeft(shiftNode.getRight());
                    shiftNode.setLeft(rootNode.getLeft());
                    shiftNode.setRight(rootNode.getRight());
                    rootIndex=left;
                }
            }
            tree[oldRootIndex]=null;
            deque.enqueue(oldRootIndex);
        }
        //非 root
        else if(tComparable.compareTo(rootNode.getElement())<0){
            resultElement=_removeElement(targetElement,rootNode.getLeft(),rootIndex);
        }else{
           resultElement= _removeElement(targetElement,rootNode.getRight(),rootIndex);
        }
        return resultElement;
    }

    private T _removeElement(T targetElement, int nodeIndex, int parentIndex) {
        Comparable<T>tComparable=(Comparable)targetElement;
        //get parentIndex
        while(nodeIndex!=-1){
            ArrayTreeNode<T>node=tree[nodeIndex];
            if(tComparable.compareTo(node.getElement())>0){
                if(node.getRight()!=-1){
                    parentIndex=nodeIndex;
                    nodeIndex=node.getRight();
                }else break;
            }else if(tComparable.compareTo(node.getElement())<0){
                if(node.getLeft()!=-1){
                    parentIndex=nodeIndex;
                    nodeIndex=node.getLeft();
                }else break;

            }else{//==
                break;
            }
        }
        //check nodeIndex NOT FOUND
        if(tComparable.compareTo(tree[nodeIndex].getElement())!=0)return null;

        ArrayTreeNode<T>parentNode=tree[parentIndex],targetNode=tree[nodeIndex];

        T resultElement=targetNode.getElement();
        if(targetNode.getLeft()==-1&&targetNode.getRight()==-1){
            if(parentNode.getRight()==nodeIndex){
                parentNode.setRight(-1);
            }else{
                parentNode.setLeft(-1);
            }
        }else if(targetNode.getRight()==-1){
            if(parentNode.getRight()==nodeIndex){
                parentNode.setRight(targetNode.getLeft());
            }else{
                parentNode.setLeft(targetNode.getLeft());
            }
        }else if(targetNode.getLeft()==-1){
            if(parentNode.getRight()==nodeIndex){
                parentNode.setRight(targetNode.getRight());
            }else{
                parentNode.setLeft(targetNode.getRight());
            }
        }else{
            if(parentNode.getRight()==nodeIndex){
                int leftIndex=tree[targetNode.getRight()].getLeft();
                int leftparentIndex=targetNode.getRight();
                while(leftIndex!=-1){
                    ArrayTreeNode<T>temp=tree[leftIndex];
                    if(temp.getLeft()!=-1){
                        leftparentIndex=leftIndex;
                        leftIndex=temp.getLeft();
                    }else break;
                }
                if(leftIndex==-1){//targetNode right left 不存在
                    tree[leftparentIndex].setLeft(targetNode.getLeft());
                    parentNode.setRight(leftparentIndex);
                }else {
                    tree[leftparentIndex].setLeft(tree[leftIndex].getRight());
                    tree[leftIndex].setRight(targetNode.getRight());
                    tree[leftIndex].setLeft(targetNode.getLeft());
                    parentNode.setRight(leftIndex);
                }

            }else{
                int rightIndex=tree[targetNode.getLeft()].getRight();
                int rightparentIndex=targetNode.getLeft();
                while(rightIndex!=-1){
                    ArrayTreeNode<T>temp=tree[rightIndex];
                    if(temp.getLeft()!=-1){
                        rightparentIndex=rightIndex;
                        rightIndex=temp.getRight();
                    }else break;
                }
                if(rightIndex==-1){
                    tree[rightparentIndex].setRight(targetNode.getRight());
                    parentNode.setLeft(rightparentIndex);
                }else{
                    tree[rightparentIndex].setRight(tree[rightIndex].getLeft());
                    tree[rightIndex].setRight(targetNode.getRight());
                    tree[rightIndex].setLeft(targetNode.getLeft());
                    parentNode.setLeft(rightIndex);
                }
            }
        }
        tree[nodeIndex]=null;
        deque.enqueue(nodeIndex);
        return resultElement;
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        while(contains(targetElement)){
            removeElement(targetElement);
        }
    }

    @Override
    public T removeMax() {
        if(isEmpty())return null;
        T resultElement;
        if(size()==1){
            resultElement=tree[rootIndex].getElement();
            tree[rootIndex]=null;
            return resultElement;
        }

        int parentindex=rootIndex;
        while(tree[parentindex].getRight()!=-1&&tree[tree[parentindex].getRight()].getRight()!=-1){
            parentindex=tree[parentindex].getRight();
        }
        int right=tree[parentindex].getRight();
        tree[parentindex].setRight(-1);

        resultElement=tree[right].getElement();

        tree[right]=null;
        deque.enqueue(right);
        return resultElement;
    }

    @Override
    public T removeMin() {
        if(isEmpty())return null;
        T resultElement;
        if(size()==1){
            resultElement=tree[rootIndex].getElement();
            tree[rootIndex]=null;
            return resultElement;
        }
        int parentindex=rootIndex;
        while(tree[parentindex].getLeft()!=-1&&tree[tree[parentindex].getLeft()].getLeft()!=-1){
            parentindex=tree[parentindex].getLeft();
        }
        int left=tree[parentindex].getLeft();
        tree[parentindex].setLeft(-1);

        resultElement=tree[left].getElement();

        tree[left]=null;
        deque.enqueue(left);
        return resultElement;
    }

    @Override
    public T find(T targetElement) {
        if(!(targetElement instanceof Comparable))return null;
        Comparable<T>tComparable=(Comparable)targetElement;
        //root
        if(isEmpty())return null;
        T resultElement=null;
        if(tComparable.compareTo(tree[rootIndex].getElement())>0){
          resultElement= _find(targetElement,tree[rootIndex].getRight());
        }else if(tComparable.compareTo(tree[rootIndex].getElement())<0){
            resultElement=_find(targetElement,tree[rootIndex].getLeft());
        }else{
            resultElement=tree[rootIndex].getElement();
        }

        return resultElement;
    }

    private T _find(T targetElement, int rootIndex) {
        Comparable<T>tComparable=(Comparable)targetElement;
        T resultElement=null;
        if(rootIndex==-1)return null;
        if(tComparable.compareTo(tree[rootIndex].getElement())>0){
            resultElement= _find(targetElement,tree[rootIndex].getRight());
        }else if(tComparable.compareTo(tree[rootIndex].getElement())<0){
            resultElement=_find(targetElement,tree[rootIndex].getLeft());
        }else{
            resultElement=tree[rootIndex].getElement();
        }
        return resultElement;
    }

    @Override
    public T findMax() {
        if(isEmpty())return null;
        T resultELement;
        int right=rootIndex;
        while(tree[right].getRight()!=-1){
            right=tree[right].getRight();
        }
        resultELement=tree[right].getElement();
        return resultELement;
    }

    @Override
    public T findMin() {
        if(isEmpty())return null;
        T resultELement;
        int left=rootIndex;
        while(tree[left].getLeft()!=-1){
            left=tree[left].getLeft();
        }
        resultELement=tree[left].getElement();
        return resultELement;
    }

    protected int getNextTargetIndex() {
        if(deque.isEmpty()){
            int oldlen=tree.length;
            expandCapacity();
            for(int i=oldlen;i<tree.length;++i){
                deque.addLast(i);
            }
        }
        return deque.dequeue();
    }

    private void expandCapacity() {
        ArrayTreeNode<T> newTree[]=new ArrayTreeNode[tree.length*2];
        System.arraycopy(tree,0,newTree,0,tree.length);
        tree=newTree;
    }

}
