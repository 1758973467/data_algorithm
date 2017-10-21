package com.company.Tree.SearchTree;

import com.company.Tree.BinaryArrayCalcTree;

public class BinaryArrayCalcSearchTree<T>extends BinaryArrayCalcTree<T>implements BinarySearchTreeADT<T> {
    @Override
    public void addElement(T element) throws Exception {
        if(!(element instanceof Comparable))throw new Exception("this operation not support");
        if(isEmpty()){
            tree=(T [])new Object[DEFAULT_CAPACITY];
            tree[0]=element;
        }
        else{
            int start=0;
            while(start<tree.length&&tree[start]!=null){
                if(((Comparable) element).compareTo(tree[start])>=0){
                    start=start*2+2;
                }else{
                    start=start*2+1;
                }
            }
            if(start>=tree.length){
                expandCapacity();
            }
            if(tree[start]==null){
                tree[start]=element;
            }
        }
    }

    private void expandCapacity() {
        T newTree[]=(T [])new Object[tree.length*2];
        System.arraycopy(tree,0,newTree,0,tree.length);
        tree=newTree;
    }

    @Override
    public T removeElement(T targetElement) {
        if(isEmpty()) return null;
        else{
            int start=0;
            while(start<=tree.length||tree[start]!=null){
                if(((Comparable)targetElement).compareTo(tree[start])>0){
                    start=start*2+2;
                }else if(((Comparable)targetElement).compareTo(tree[start])<0){
                    start=start*2+1;
                }else{//equals
                    break;
                }
            }
            //NOT_FOUND
            if(start>=tree.length||tree[start]==null){
                return null;
            }else{
                T elem=tree[start];
                if(start*2+1<tree.length&&tree[start*2+1]==null&&start*2+2<tree.length&&tree[start*2+2]==null){
                    tree[start]=null;
                }else if(start*2+1<tree.length&&tree[start*2+1]==null){
                    if(start*2+2<tree.length){
                        tree[start]=tree[start*2+2];
                        tree[start*2+2]=null;
                    }
                }else if(start*2+2<tree.length&&tree[start*2+2]==null){
                    if(start*2+1<tree.length){
                        tree[start]=tree[start*2+1];
                        tree[start*2+1]=null;
                    }
                }else{//两个都有，就用中序遍历的顺序
                    if(start*2+2<tree.length&&tree[start*2+2]!=null){
                        int right=start*2+2;
                        while(right*2+1<tree.length&&tree[right*2+1]!=null){
                            right=2*right+1;
                        }
                        if(start*2+2==right){//no move
                            //offsetSubTree();

                        }
                    }

                }
                //tree[start]=null;
                //TODO removeElement failed
                //Unsupport Expection

                return elem;
            }
        }
    }
    @Override
    public T find(T targetElement){
        if(isEmpty()) return null;
        else{
            int start=0;
            while(start<=tree.length||tree[start]!=null){
                if(((Comparable)targetElement).compareTo(tree[start])>0){
                    start=start*2+2;
                }else if(((Comparable)targetElement).compareTo(tree[start])<0){
                    start=start*2+1;
                }else{//equals
                    break;
                }
            }
            //NOT_FOUND
            if(start>=tree.length||tree[start]==null){
                return null;
            }else{
                return tree[start];
            }
        }
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
        else{
            int start=0,pre=-1;
            while (start<=tree.length||tree[start]!=null){
                pre=start;
                start=start*2+2;
            }
            T result=null;
            if(pre==-1){//只能是root
                result=tree[0];
                tree[0]=null;
            }else{
                result=tree[pre];
                tree[pre]=null;
            }

            return result;
        }
    }

    @Override
    public T removeMin() {
        if(isEmpty())return null;
        else{
            int start=0,pre=-1;
            while (start<=tree.length||tree[start]!=null){
                pre=start;
                start=start*2+1;
            }
            T result=null;
            if(pre==-1){//只能是root
                result=tree[0];
                tree[0]=null;
            }else{
                result=tree[pre];
                tree[pre]=null;
            }

            return result;
        }
    }

    @Override
    public T findMax() {
        if(isEmpty())return null;
        else{
            int start=0,pre=-1;
            while (start<=tree.length||tree[start]!=null){
                pre=start;
                start=start*2+2;
            }
            T result=null;
            if(pre==-1){//只能是root
                result=tree[0];
            }else{
                result=tree[pre];
            }
            return result;
        }
    }

    @Override
    public T findMin() {
        if(isEmpty())return null;
        else{
            int start=0,pre=-1;
            while (start<=tree.length||tree[start]!=null){
                pre=start;
                start=start*2+1;
            }
            T result=null;
            if(pre==-1){//只能是root
                result=tree[0];
            }else{
                result=tree[pre];
            }
            return result;
        }
    }
}
