package com.example.problemsolver.framework.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * @author gideon okoroafor
 */

public class GraphCreator {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack();
        start = new Vertex(problem.getInitialState());
        stack.push(start);
        move = problem.getMover().getMoveNames();
        while(!stack.isEmpty()){
            u = stack.pop();
            move.forEach((m) -> {
                next = problem.getMover().doMove(m, (State)u.getData());
                if(next != null) {
                    v = new Vertex(next);
                    if(graph.getVertices().containsKey(v)){
                        v = graph.getVertices().get(v);
                    } else {
                        stack.push(v);
                    }
                    graph.addEdge(u, v);
                }
            });
        }
        return graph;
    }

    private Graph graph = null;
    private Stack<Vertex> stack = null;
    private Vertex start, u, v;
    private State next;
    private List<String> move;
}
