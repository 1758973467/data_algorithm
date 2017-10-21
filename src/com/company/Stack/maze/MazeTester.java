package com.company.Stack.maze;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeTester {
    public static void main(String []args)throws FileNotFoundException{
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the name of the file containing the number");
        String filename=scanner.nextLine();
        Maze maze=new Maze(filename);
        System.out.println(maze);
        MazeResolver mazeResolver=new MazeResolver(maze);
        if(mazeResolver.traverse(new Position(0,0),new Position(5,5))){
            System.out.println("The maze was successfully traversed!");
        }else{
            System.out.println("There is no possible path!");
        }
        System.out.println(maze);
    }
}
