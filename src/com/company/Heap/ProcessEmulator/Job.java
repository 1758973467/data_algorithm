package com.company.Heap.ProcessEmulator;

public class Job {
    String id;
    //执行秒数
    int len;
    int priority;
    public Job() {
    }

    public Job(String id, int len, int priority) {
        this.id = id;
        this.len = len;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
