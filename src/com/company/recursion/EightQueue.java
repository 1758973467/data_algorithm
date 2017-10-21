package com.company.recursion;

/**
 * @author ljc
 */
public class EightQueue {
    private int count=0;
    public void solve(){
        int []array=new int[8];
        for(int i=0;i<8;++i){
            array[i]=-1;
        }
        placeQueue(array,0);
    }

    /**
     *
     * @param array
     * @param n 代表第几个皇后
     * @return void

     */
    private void placeQueue(int []array,int n) {
        if (n == 8) {
            //OK
            printResult(array);
        } else {
            for (int i = 0; i < 8; ++i) {
                if (validPosition(n, i, array, n)) {//第n个皇后ok
                    array[n] = i;
                    placeQueue(array, n + 1);
                }
             }
        }

    }

    private void printResult(int[] array) {
        count++;
        for(int i=0;i<array.length; ++i){
            System.out.print(array[i]+1);
        }
        System.out.println();
    }

    private boolean validPosition(int row, int col, int[] array, int length) {
        for(int i=0;i<length;++i){
            if(array[i]==col||Math.abs(array[i]-col)==Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
public static void main(String args[]){
    EightQueue eightQueue=new EightQueue();
    eightQueue.solve();
    System.out.println(eightQueue.count);
}

    public int getCount() {
        return count;
    }
}
