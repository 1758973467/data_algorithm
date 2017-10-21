package com.company.Stack.maze;

import com.company.Stack.LinearStack;
import com.company.Stack.StackADT;

public class MazeResolver {
    private Maze maze;

    public MazeResolver(Maze maze) {
        this.maze = maze;
    }

    public boolean traverse(Position start,Position end){
        boolean done=false;

        Position pos=start;

        StackADT<Position> stack=new LinearStack<>();
        stack.push(pos);
        while(!done&&!stack.isEmpty()){
            pos=stack.pop();
            maze.tryPosition(pos.getX(),pos.getY());
            if(pos.getX()==end.getX()&&pos.getY()==end.getY()){
                done=true;
            }else{
                push_new_pos(pos.getX()-1,pos.getY(),stack);
                push_new_pos(pos.getX()+1,pos.getY(),stack);
                push_new_pos(pos.getX(),pos.getY()-1,stack);
                push_new_pos(pos.getX(),pos.getY()+1,stack);
            }
        }
        return done;
    }

    private void push_new_pos(int x, int y, StackADT<Position> stack) {
        Position pos=new Position(x,y);
        if(maze.validPosition(x,y)){
            stack.push(pos);
        }
    }

}
