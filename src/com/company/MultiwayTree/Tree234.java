package com.company.MultiwayTree;
class DataItem{
    public long dData;

    public DataItem(long dData) {
        this.dData = dData;
    }
    public void displayItem(){
        System.out.print('/'+dData);
    }
}
class Node{
    private static final int ORDER=4;
    private int numItems;
    private Node parent;
    private Node childArray[]=new Node[ORDER];
    private DataItem itemArray[]=new DataItem[ORDER-1];
    public Node disconnectChild(int childNum){
        Node tempNode=childArray[childNum];
        childArray[childNum]=null;
        return tempNode;
    }
    public void connectChild(int childNum,Node child){
        childArray[childNum]=child;
        if(child!=null){
            child.parent=this;
        }
    }
    public boolean isLeaf(){
        return childArray[0]==null;
    }
    public Node getParent() {
        return parent;
    }
    public Node getChild(int childNum){
        return childArray[childNum];
    }
    public int getNumItems() {
        return numItems;
    }
    public DataItem getItem(int index){
        return itemArray[index];
    }
    public boolean isFull(){
        return numItems==ORDER-1;
    }
    public int findItem(long key){
        for(int i=0;i<ORDER;++i){
            if(itemArray[i]==null){
                break;
            }else if(itemArray[i].dData==key){
                return i;
            }
        }
        return -1;
    }
    public int insertItem(DataItem newItem){
        numItems++;
        long newKey=newItem.dData;
        for(int j=ORDER-2;j>0;--j){
            if(itemArray[j]==null){
                continue;
            }else{
                long itsKey=itemArray[j].dData;
                if(newKey<itsKey){
                    itemArray[j+1]=itemArray[j];
                }else{
                    itemArray[j+1]=newItem;
                    return j+1;
                }
            }
        }
        itemArray[0]=newItem;
        return 0;
    }
    public DataItem removeItem(){
        DataItem temp=itemArray[numItems-1];
        itemArray[numItems-1]=null;
        numItems--;
        return temp;
    }
    public void displayNode(){
        for(int i=0;i<numItems;++i){
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }
}
public class Tree234 {
    private Node root=new Node();
    public int find(long key){
        Node curNode=root;
        int childNumber;
        while(true){
            if((childNumber=curNode.findItem(key))!=-1){
                return childNumber;
            }else if(curNode.isLeaf()){
                return  -1;
            }else{
                curNode=getNextChild(curNode,key);
            }
        }
    }
    public void insert(long dValue){
        Node curNode=root;
        DataItem tempitem=new DataItem(dValue);
        while(true){
            if(curNode.isFull()){
                split(curNode);
                curNode=curNode.getParent();
                curNode=getNextChild(curNode,dValue);
            }
            else if(curNode.isLeaf()){
                break;
            }else{
                curNode=getNextChild(curNode,dValue);
            }
        }
        curNode.insertItem(tempitem);
    }

    private void split(Node curNode) {
        DataItem itemB,itemC;
        Node parent,child2,child3;
        int itemIndex;
        itemC=curNode.removeItem();
        itemB=curNode.removeItem();
        child2=curNode.disconnectChild(2);
        child3=curNode.disconnectChild(3);
        Node newRight=new Node();
        if(curNode==root){
            root=new Node();
            parent=root;
            root.connectChild(0,curNode);
        }else{
            parent=curNode.getParent();
        }
        itemIndex=curNode.getNumItems();
        for(int i=itemIndex-1;i>itemIndex;--i){
            Node temp=parent.disconnectChild(i);
            parent.connectChild(i+1,temp);
        }
        parent.connectChild(itemIndex+1,newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }

    private Node getNextChild(Node curNode, long key) {
        int i;
        int numItems=curNode.getNumItems();
        for(i=0;i<numItems;++i){
            if(key<curNode.getItem(i).dData){
                return curNode.getChild(i);
            }
        }
        return curNode.getChild(i);
    }

    public void displayTree(){
        reDisplayTree(root,0,0);
    }

    private void reDisplayTree(Node curNode, int level, int childNumebr) {
        System.out.print("level="+level+"child="+childNumebr+" ");
        curNode.displayNode();

        int numsItem=curNode.getNumItems();
        for(int i=0;i<numsItem+1;++i){
            Node nextNode=curNode.getChild(i);
            if(nextNode!=null){
                reDisplayTree(nextNode,level+1,i);
            }else return;
        }
    }
}
