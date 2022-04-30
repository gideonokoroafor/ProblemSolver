package com.example.problemsolver.framework.solution;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author gideon okoroafor
 */
public abstract class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue
     * (DEQUE) like the GraphSolver.
     * @param problem the problem being solved
     */
    public StateSpaceSolver(Problem problem) {
        super(problem);
        super.setQueue(new LinkedList<>());
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm.
     * @param u the vertex being expanded
     * @return the children of u in the state space search tree
     */
    @RequiresApi(api = Build.VERSION_CODES.N)  // remove
    @Override
    public List<Vertex> expand(Vertex u) {
        // you must provide
        mover = this.getProblem().getMover();
        moveNames = mover.getMoveNames();
        children = new LinkedList();
        moveNames.forEach(m -> {
            Vertex child = new Vertex(mover.doMove(m, (State)u.getData()));
            if(child.getData() != null) {
                child.setDistance(u.getDistance()+1);
                child.setPredecessor(u);
                children.add((Vertex) child);
            }
        });

        return children;
    }

    // private fields
    private List<Vertex> children;
    private List<String> moveNames;
    private Mover mover;
}