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
        else {
            T resultElement=null;
            Comparable<T>tComparable=(Comparable)targetElement;
            if(tComparable.compareTo(tree[0])==0){
                resultElement=tree[0];
                replaceElement(0);
            }else if(tComparable.compareTo(tree[0])>0) {
                resultElement=_removeElement(targetElement,2*0+2);
            }else{
                resultElement=_removeElement(targetElement,2*0+1);
            }
            return resultElement;
        }
    }

    private T _removeElement(T targetElement, int index) {
        T resultElement=null;
        if(index<tree.length){
            Comparable<T>tComparable=(Comparable)targetElement;
            if(tComparable.compareTo(tree[index])==0){
                resultElement=tree[index];
                replaceElement(index);
            }else if(tComparable.compareTo(tree[index])>0) {
                resultElement=_removeElement(targetElement,2*index+2);
            }else{
                resultElement=_removeElement(targetElement,2*index+1);
            }
        }
        return resultElement;
    }

    private void replaceElement(int index) {
        if(!checkIndexBounding(index))return;
        if(tree[2*index+1]==null&&tree[2*index+2]==null){
            tree[index]=null;
        }else if(tree[2*index+1]==null){
            int x=2*index+2;
            tree[index]=tree[2*index+2];
            copyRightTree(x);
        }else if(tree[2*index+2]==null){
            int x=2*index+1;
            tree[index]=tree[2*index+1];
            copyLeftTree(x);
        }else{
            if(2*(2*index+2)+2>=tree.length||tree[2*(2*index+2)+2]==null){
                tree[index]=tree[2*index+2];
                int x=2*index+2;
                copyRightTree(x);
            }else{
                int x=2*index+2;
                while(tree[2*x+1]!=null){
                    x=2*x+1;
                }

                tree[index]=tree[x];
                tree[x]=tree[2*x+2];
                x=2*x+2;
                copyRightTree(x);
            }
        }
    }

    private void copyLeftTree(int x) {
        if(x>=tree.length||2*x+1>=tree.length)return;
        tree[x]=tree[2*x+1];
        tree[2*x+1]=null;
        if(2*x+2>=tree.length)return;
        tree[x+1]=tree[2*x+2];
        tree[2*x+2]=null;
        copyLeftTree(2*x+1);
        copyLeftTree(2*x+2);
    }

    private void copyRightTree(int x) {
        if(x>=tree.length||2*x+1>=tree.length)return;
        tree[x-1]=tree[2*x+1];
        tree[2*x+1]=null;
        if(2*x+2>=tree.length)return;
        tree[x]=tree[2*x+2];
        tree[2*x+2]=null;
        copyRightTree(2*x+1);
        copyRightTree(2*x+2);
    }

    //只有两个都在范围内才会为true
    private boolean checkIndexBounding(int index) {
        boolean result=false;
        if(2*index+2>=tree.length){
            if(2*index+1>=tree.length){
               return result;
            }
            else{
                //只用2*index+1在
                if(tree[2*index+1]==null){
                    tree[index]=null;
                }else{//左子树在, 即tree.length==2*index+1
                    tree[index]=tree[2*index+1];
                    tree[2*index+1]=null;
                }
            }
        }else{//两个都在
            result=true;
        }

        return result;
    }

    @Override
    public T find(T targetElement){
        if(isEmpty()) return null;
        else{
            int start=0;
            Comparable<T>tComparable=(Comparable)targetElement;
            while(start<=tree.length&&tree[start]!=null){
                if(tComparable.compareTo(tree[start])>0){
                    start=start*2+2;
                }else if(tComparable.compareTo(tree[start])<0){
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
            while (start<tree.length&&tree[start]!=null){
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
            while (start<tree.length&&tree[start]!=null){
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
            while (start<tree.length&&tree[start]!=null){
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
            while (start<tree.length&&tree[start]!=null){
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
