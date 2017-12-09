package com.company.Recursion;

public class TowerOfHanoi {
    private int totalDisks;

    public TowerOfHanoi(int totalDisks) {
        this.totalDisks = totalDisks;
    }
    public void solve(){
        moveToTower(totalDisks,1,3,2);
    }

    private void moveToTower(int totalDisks, int start, int end, int temp) {
        if(totalDisks==1){
            moveOneDisk(start,end);
        }else{
            moveToTower(totalDisks-1,start,temp,end);
            moveOneDisk(start,end);
            moveToTower(totalDisks-1,temp,end,start);
        }
    }

    private void moveOneDisk(int start, int end) {
        System.out.println("Move one disk from "+start+" to "+end);
    }
}
