package com.company.recursion;



import java.util.ArrayList;
import java.util.List;

public class PascalTri {
    int []array;

    /**
     * 计算单个值
     * @param n 三角形第N行
     * @param m 第N行第M个
     * @return
     */
    public int calcOne(int n,int m){
        if(n==1||m==1||n==m)return 1;
        else return calcOne(n-1,m-1)+calcOne(n-1,m);
    }
    public List<Integer> clacRow(int n){
        List<Integer>res=new ArrayList<>(n);
        if(n==1){
            res.add(1);
            return res;
        }else{
            List<Integer>temp=clacRow(n-1);
            res.add(1);
            for(int i=1;i<temp.size();++i){
                res.add(i,temp.get(i-1)+temp.get(i));
            }
            res.add(1);
            return res;
        }
    }
}
