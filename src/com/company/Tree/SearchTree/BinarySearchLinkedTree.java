package com.company.Tree.SearchTree;

import com.company.Tree.BinaryLinkedTree;
import com.company.Tree.BinaryTreeNode;

public class BinarySearchLinkedTree<T> extends BinaryLinkedTree<T> implements BinarySearchTreeADT<T> {
    public BinarySearchLinkedTree() {
        super();
    }

    public BinarySearchLinkedTree(T elem) throws Exception {

        super(new BinaryTreeNode<>(elem));
        if(!(elem instanceof Comparable)){
            throw new Exception("type "+elem.getClass().getName()+"Not Comparable");
        }
    }

    @Override
    public void addElement(T element) throws Exception {
        if(!(element instanceof Comparable))throw new Exception("type"+element.getClass().getName()+" must implement Comparable interface");
        if(root==null){
            root=new BinaryTreeNode<>(element);
        }else{
            _addElement(root,element);
        }
    }
    @SuppressWarnings("unchecked")
    protected void _addElement(BinaryTreeNode<T> rootNode, T element) {
        if(rootNode==null)return;
        else{
            Comparable<T>comparableelem=(Comparable<T>)element;
            if(comparableelem.compareTo(rootNode.getElement())<0){
                if(rootNode.getLeft()==null){
                    rootNode.setLeft(new BinaryTreeNode<>(element));
                }else{
                    _addElement(rootNode.getLeft(),element);
                }
            }else{
                if(rootNode.getRight()==null){
                    rootNode.setRight(new BinaryTreeNode<>(element));
                }else{
                    _addElement(rootNode.getRight(),element);
                }
            }
        }
    }

    @Override
    public T removeElement(T targetElement) {
        if(root==null)return null;//空树
        else{//非空树
            //root节点特殊处理
            if(root.getElement().equals(targetElement)){
                T resElem=root.getElement();
                //0 个孩子
                if(root.getLeft()==null&&root.getRight()==null){
                    root=null;
                }else if(root.getLeft()==null){//只有right
                    root=root.getRight();
                }else if(root.getRight()==null){//只有 left
                    root=root.getLeft();
                }else{//两个孩子
                    BinaryTreeNode<T>temp=root.getLeft();
                    BinaryTreeNode<T>parent=root;
                    while(temp.getRight()!=null){
                        parent=temp;
                        temp=temp.getRight();
                    }
                    if(temp.getLeft()!=null){
                        parent.setRight(temp.getLeft());
                    }
                    root=temp;
                }
                //process root
                return resElem;
            }
            else {
                if(((Comparable<T>)targetElement).compareTo(root.getElement())>=0){
                    return _removeElement(root.getRight(),targetElement,root);
                }
                else{
                    return  _removeElement(root.getLeft(),targetElement,root);
                }

            }


        }
    }

    private T _removeElement(BinaryTreeNode<T> rootNode, T targetElement,BinaryTreeNode<T>parent) {
        if(rootNode==null)return null;
        else{//遍历来做，不应递归
            Comparable<T>comparableTarget=(Comparable<T>) targetElement;
            while(rootNode!=null){
                if(comparableTarget.compareTo(rootNode.getElement())>0){
                    parent=rootNode;
                    rootNode=rootNode.getRight();
                }else if(comparableTarget.compareTo(rootNode.getElement())<0){
                    parent=rootNode;
                    rootNode=rootNode.getLeft();
                }else{//相等
                    break;
                }
            }
            if(rootNode==null)return null;//No such element;
            T resElem=null;
            if(rootNode.getLeft()==null||rootNode.getRight()==null){
                if(parent.getRight()==rootNode){
                    parent.setRight(rootNode.getRight());
                }else{
                    parent.setLeft(rootNode.getLeft());
                }
                resElem=rootNode.getElement();
            }else{
                if(parent.getLeft()==rootNode){
                    //遍历
                    BinaryTreeNode<T>temp=rootNode;
                    while(temp.getRight()!=null){
                        parent=temp;
                        temp=temp.getRight();
                    }
                    if(temp!=rootNode){
                        parent.setRight(temp.getLeft());
                    }
                    temp.setLeft(rootNode.getLeft());
                    temp.setRight(rootNode.getRight());
                    resElem=rootNode.getElement();
                }else{
                    //遍历
                    BinaryTreeNode<T>temp=rootNode;
                    while(temp.getLeft()!=null){
                        parent=temp;
                        temp=temp.getLeft();
                    }
                    if(temp!=rootNode){
                        parent.setLeft(temp.getRight());
                    }
                    temp.setLeft(rootNode.getLeft());
                    temp.setRight(rootNode.getRight());
                    resElem=rootNode.getElement();
                }
            }
            return resElem;
        }
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        while (contains(targetElement)){
            removeElement(targetElement);
        }
    }

    @Override
    public T removeMax() {
        if(root==null){
            return null;
        }else{
            BinaryTreeNode<T>temp=root,parent=null;
            while(temp.getRight()!=null){
                parent=temp;
                temp=temp.getRight();
            }
            T resElem=null;
            if(parent==null){
                resElem=root.getElement();
                root=null;
            }else{
                resElem=temp.getElement();
                parent.setRight(temp.getLeft());

            }
            return resElem;
        }
    }

    @Override
    public T removeMin() {
        if(root==null){
            return null;
        }else{
            BinaryTreeNode<T>temp=root,parent=null;
            while(temp.getLeft()!=null){
                parent=temp;
                temp=temp.getLeft();
            }
            T resElem=null;
            if(parent==null){
                resElem=root.getElement();
                root=null;
            }else{
                resElem=temp.getElement();
                parent.setLeft(temp.getRight());
            }
            return resElem;
        }
    }

    @Override
    public T findMax() {
        if(root==null)return null;
        else{//
            BinaryTreeNode<T>temp=root;
            while(temp.getRight()!=null){
                temp=temp.getRight();
            }
            return temp.getElement();
        }
    }

    @Override
    public T findMin() {
        if(root==null)return null;
        else{//
            BinaryTreeNode<T>temp=root;
            while(temp.getLeft()!=null){
                temp=temp.getLeft();
            }
            return temp.getElement();
        }
    }
}
