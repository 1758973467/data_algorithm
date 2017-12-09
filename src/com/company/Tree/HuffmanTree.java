package com.company.Tree;


import com.company.Heap.PriorityQueueNode;

import java.util.*;

/**
 * 哈夫曼树 用于压缩数据，主要用于字符压缩
 */
public class HuffmanTree {

    public void Decode(String str){

    }
    public String Encode(String str){
        //遍历
        //生成字典
        BinaryTreeNode<PriorityQueueNode<Character>>root=BuildHuffmanTree(str);
        Map<Character,String>dict=generateDict(root);
        //输出字典并保存字典及encode 代码
        System.out.println(dict);
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<str.length();++i){
            stringBuffer.append(dict.get(str.charAt(i)));
        }

        return stringBuffer.toString();
    }
    //生成字典
    public Map<Character,String>generateDict(BinaryTreeNode<PriorityQueueNode<Character>> root){
        Map<Character,String>dict=new HashMap<>();
        String str="0";
        IteratorInOrder(root,dict,str);
        return dict;
    }

    private void IteratorInOrder(BinaryTreeNode<PriorityQueueNode<Character>> root, Map<Character, String> dict,String str) {
        if(root==null)return;
        if(root.isLeaf()){
            dict.put(root.getElement().getElement(),str);
        }
        IteratorInOrder(root.getLeft(),dict,str+"0");
        IteratorInOrder(root.getRight(),dict,str+"1");
    }

    public BinaryTreeNode<PriorityQueueNode<Character>> BuildHuffmanTree(String str){
        //counter str
        Map<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<str.length();++i){
            if(map.containsKey(str.charAt(i))){
               int temp= map.get(str.charAt(i));
               map.put(str.charAt(i),temp+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        //遍历
        Set<Character>set=map.keySet();

        Character[]array= set.toArray(new Character[set.size()]);
        List<BinaryTreeNode<PriorityQueueNode<Character>>>list=new LinkedList<>();
        for(Character temp:array){
            PriorityQueueNode node=new PriorityQueueNode(temp,map.remove(temp));
            list.add(new BinaryTreeNode<>(node));
        }
        //建立树
        list.sort( list.get(0));
        //test
        for(int i=0;i<list.size();++i){
            System.out.print(list.get(i)+" ");
        }
        BinaryTreeNode<PriorityQueueNode<Character>>node1,node2;
        while(list.size()!=1){
            node1=list.remove(0);
            node2=list.remove(0);
            int priority=node1.getElement().getPriority()+node2.getElement().getPriority();
            PriorityQueueNode<Character>temp=new PriorityQueueNode<>(null,priority);
            BinaryTreeNode<PriorityQueueNode<Character>>node3=new BinaryTreeNode<>(temp,node1,node2);
            int i=0;
            for(;i<list.size();++i){
                if(list.get(i).getElement().getPriority()>priority){
                   break;
                }
            }
            list.add(i,node3);
        }

        //if size==0
        //root huffman shu
        BinaryTreeNode<PriorityQueueNode<Character>>root=list.get(0);
        return root;

    }

}
