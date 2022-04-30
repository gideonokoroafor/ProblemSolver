package com.example.problemsolver.framework.solution;

import com.example.problemsolver.framework.graph.Vertex;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author tcolburn
 * @author  gideonokoroafor
 */
public class Solution implements Iterator<Vertex> {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        stack = new Stack();
        do {
            stack.push(end);
            end = end.getPredecessor();
        } while(end.getPredecessor() != null && !stack.contains(end));
        stack.add(start);
    }

    /**
     * Gets the length of the solution.
     * This is the number of moves in the solution, not the
     * number of vertices.
     * @return the solution length
     */
    public final int getLength() {
        // You must provide
//        return head.getDistance();
        return this.stack.size()-1;
    }

    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    @Override
    public Vertex next() {
        // You must provide
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        head = stack.pop();
        current = head;
        head = head.getPredecessor();
        return current;
    }

    // Private instance fields here
    private static Vertex head;
    private static Vertex current;
    private Stack<Vertex> stack;

}