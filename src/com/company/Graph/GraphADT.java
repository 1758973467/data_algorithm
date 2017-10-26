package com.company.Graph;

import java.util.Iterator;

public interface GraphADT<T> {
    void addVertex(T vertex);
    void removeVertex(T vertex);
    void addEdge(T vertex1,T vertex2);
    void removeEdge(T vertex1,T vertex2);
    Iterator iteratorBFS(T startVertex);
    Iterator iteratorDFS(T startVertex);
    Iterator iteratorShortestPath(T startVertex,T targetVertex);
    boolean isEmpty();
    int size();

}
