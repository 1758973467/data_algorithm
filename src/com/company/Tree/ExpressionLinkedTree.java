package com.company.Tree;


import java.util.Scanner;

public class ExpressionLinkedTree extends BinaryLinkedTree<ExpressionTreeOp> {
    public ExpressionLinkedTree() {
        super();
    }
    public void addElement(ExpressionTreeOp target){
        if(this.root!=null) {
            _addElement(this.root, target);
        }
        else{//root==null
            this.root=new BinaryTreeNode<>(target,null,null);
        }
    }

    private void _addElement(BinaryTreeNode<ExpressionTreeOp> rootNode, ExpressionTreeOp targetElement) {
        if(rootNode==null)return;
        if(targetElement.isOperator()){
            ExpressionTreeOp rootElement=rootNode.getElement();
            if(rootElement.isOperator()){
                if(targetElement.getAlertpriority()!=0){
                    //有括号 无视优先级
                    BinaryTreeNode<ExpressionTreeOp>tempNode=rootNode;
                    int alertPriority=targetElement.getAlertpriority();
                    while (tempNode.getRight()!=null&&alertPriority!=0&&tempNode.getElement().isOperator()){
                        tempNode=tempNode.getRight();
                        --alertPriority;
                    }
                    ExpressionTreeOp old=tempNode.getElement();
                    tempNode.setElement(targetElement);
                    tempNode.setLeft(new BinaryTreeNode<>(old,tempNode.getLeft(),tempNode.getRight()));
                    tempNode.setRight(null);
                }
                else {
                    if(rootElement.getPriority()>=targetElement.getPriority()){
                        ExpressionTreeOp old=rootNode.getElement();
                        rootNode.setElement(targetElement);
                        rootNode.setLeft(new BinaryTreeNode<>(old,rootNode.getLeft(),rootNode.getRight()));
                        rootNode.setRight(null);
                    }else{
                        if(rootNode.getRight()!=null){
                            _addElement(rootNode.getRight(),targetElement);
                        }else{
                            System.out.print("root Node right == null"+targetElement.getOperator());
                        }
                    }
                }
            }
            else{
                ExpressionTreeOp old=rootNode.getElement();
                rootNode.setElement(targetElement);
                rootNode.setLeft(new BinaryTreeNode<>(old,rootNode.getLeft(),rootNode.getRight()));
                rootNode.setRight(null);
            }
        }else{
            if(rootNode.getRight()==null){
                rootNode.setRight(new BinaryTreeNode<>(targetElement));
            }else{
                _addElement(rootNode.getRight(),targetElement);
            }
        }
    }

    public int evaluate(){
        //计算树 的结果
        return _evaluate(this.root);
    }
    private int _evaluate(BinaryTreeNode<ExpressionTreeOp> rootNode){
        int result=0;
        if(rootNode==null)return 0;
        else{
            ExpressionTreeOp elem=rootNode.getElement();
            if(elem.isOperator()){
                int op1=_evaluate(rootNode.getLeft());
                int op2=_evaluate(rootNode.getRight());
                result=computeTerm(elem.getOperator(),op1,op2);
            }else{
                result=elem.getValue();
            }

        }
        return result;
    }

    private int computeTerm(char operator, int op1, int op2) {
        int result=0;
        System.out.println(op1+" "+operator+" "+op2);
        switch (operator){
            case '+':
                result=op1+op2;
                break;
            case '-':
                result=op1-op2;
                break;
            case '*':
                result=op1*op2;
                break;
            case '/':
                result=op1/op2;
                break;
            default:
                System.out.print("ERROR Operator!");
        }
        return result;
    }


    public void build(String expression){
       // ExpressionLinkedTree expressionTree=new ExpressionLinkedTree();
        Scanner s=new Scanner(expression);
        int delta=0,priority;

        while(s.hasNext()){
            String temp=s.next();
            char operator=temp.charAt(0);
            if(operator=='+'||operator=='-'||operator=='*'||operator=='/'){
                if(operator=='+'||operator=='-')
                    priority=1;
                else
                    priority=2;

                addElement(new ExpressionTreeOp(1,operator,-1,priority,delta));
            }else if(operator=='('){
                ++delta;
            }else if(operator==')'){
                --delta;
            }else{//只能是数值
                addElement(new ExpressionTreeOp(0,'1',Integer.parseInt(temp),0,0));
            }
        }
    }
    public void buildIgnoreBrackets(String expression){

        String newexpression=expression.replaceAll("\\("," ").replaceAll("\\)"," ");
        System.out.println(newexpression);
        build(newexpression);
    }
}
