package com.company.Tree.SearchTree;

import com.company.Tree.BinaryTreeNode;

public class BinarySearchLinkedTreeNoReapeat<T> extends BinarySearchLinkedTree<T> {
    public BinarySearchLinkedTreeNoReapeat() {
        super();
    }

    public BinarySearchLinkedTreeNoReapeat(T elem) throws Exception {
        super(elem);
        if(!(elem instanceof Comparable)){
            throw new Exception("type "+elem.getClass().getName()+"Not Comparable");
        }
    }
    @Override
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
            }else if(comparableelem.compareTo(rootNode.getElement())>0){
                if(rootNode.getRight()==null){
                    rootNode.setRight(new BinaryTreeNode<>(element));
                }else{
                    _addElement(rootNode.getRight(),element);
                }
            }else{//相等

            }
        }
    }

    @Override
    public void removeAllOccurrences(T targetElement) {
        removeElement(targetElement);
    }
}
