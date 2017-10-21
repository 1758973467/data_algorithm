package com.company.Tree;

public class ExpressionTreeOp {
    private int termType;
    private char operator;
    private int value;
    private int priority;
    private int alertpriority;//mark 括号

    public ExpressionTreeOp(int termType, char operator, int value, int priority, int alertpriority) {
        this.termType = termType;
        this.operator = operator;
        this.value = value;
        this.priority = priority;
        this.alertpriority = alertpriority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTermType() {
        return termType;
    }

    public boolean isOperator(){
        return (termType==1);
    }

    public char getOperator() {
        return operator;
    }

    public int getAlertpriority() {
        return alertpriority;
    }

    public int getValue() {
        return value;
    }
}
