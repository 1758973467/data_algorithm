package com.company.Stack.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 迷宫
 */
public class Maze {
    private final int numberCols;
    private final int numberRows;
    private int [][]grid;
    private static final int TRIED=2;
    private static final int PATH=3;
    public Maze(String filename)throws FileNotFoundException{
        Scanner scan=new Scanner(new File(filename));
        numberRows=scan.nextInt();
        numberCols=scan.nextInt();
        grid=new int[numberRows][numberCols];
        for (int i=0;i<numberRows;++i){
            for (int j=0;j<numberCols;++j){
                grid[i][j]=scan.nextInt();
            }
        }
    }
    public void tryPosition(int row,int col){
        grid[row][col]=TRIED;
    }

    public int getRows() {
        return grid.length;
    }

    public int getColumns() {
        return grid[0].length;
    }
    public void markPath(int row,int col){
        grid[row][col]=PATH;
    }
    public boolean validPosition(int row,int col){
        boolean result=false;
        if(row>0&&row<numberRows&&col>0&&col<numberCols){
            if(grid[row][col]==1){
                result=true;
            }
        }
        return result;
    }
    @Override
    public String toString(){
        String result="\n";
        for (int row=0;row<numberRows;++row){
            for(int col=0;col<numberCols;++col){
                result+=grid[row][col]+" ";
            }
        }
        return result;
    }
}
