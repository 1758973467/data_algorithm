package com.company.Heap.ProcessEmulator;

import com.company.Heap.PriorityQueue;
import com.company.Heap.PriorityQueueNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emulator {
    PriorityQueue<PriorityQueueNode<Job>>queue=new PriorityQueue<>();
    public void ReadJobObject(String filename)throws FileNotFoundException{
        File file=new File(filename);
        Scanner scanner=new Scanner(file);
        String id;
        int len;
        int priority;
        while(scanner.hasNext()){
            id=scanner.next();
            len=scanner.nextInt();
            priority=scanner.nextInt();
            Job job=new Job(id,len,priority);
            PriorityQueueNode node=new PriorityQueueNode(job,priority);
            queue.addElement(node);
        }
    }
    public void Process()throws InterruptedException{
        int threadSize=4;
        PriorityQueueNode[]works=new PriorityQueueNode[threadSize];
        //填充
        int count=0;
        for(int i=0;i<threadSize&&!queue.isEmpty();++i){
            works[i]=queue.removeNext();
            ++count;
        }
        long start =System.currentTimeMillis();
        List<mythread>mythreads=new ArrayList<>(threadSize);
        for(int i=0;i<count;++i){
            mythread temp=new mythread((Job)works[i].getElement());
            mythreads.add(temp);
            temp.start();
        }
        while(count!=0&&!queue.isEmpty()){
            //check threads isAlive ,end to replace and print this job
            for(int j=0;j<mythreads.size();++j){
                mythread a=mythreads.get(j);
                if(!a.isAlive()){
                    Job job=a.getJob();
                    System.out.println(job.id+" "+job.len+" "+job.priority+" "+(System.currentTimeMillis()-start));
                    mythreads.remove(a);
                    mythread temp=new mythread(queue.removeNext().getElement());
                    mythreads.add(temp);
                    temp.start();
                }
            }
        }

    }

}
class mythread extends Thread{
    Job job;

    public mythread(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public void run() {
        try {
            sleep(job.len);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
