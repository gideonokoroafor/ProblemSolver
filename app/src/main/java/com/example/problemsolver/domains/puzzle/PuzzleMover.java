package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.domains.puzzle.PuzzleState.Location;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gideonokoroafor
 */
public class PuzzleMover extends Mover {
    private static final String TILE_1 = "SLIDE TILE 1";
    private static final String TILE_2 = "SLIDE TILE 2";
    private static final String TILE_3 = "SLIDE TILE 3";
    private static final String TILE_4 = "SLIDE TILE 4";
    private static final String TILE_5 = "SLIDE TILE 5";
    private static final String TILE_6 = "SLIDE TILE 6";
    private static final String TILE_7 = "SLIDE TILE 7";
    private static final String TILE_8 = "SLIDE TILE 8";
    private static final String TILE_9 = "SLIDE TILE 9";
    private static final String TILE_10 = "SLIDE TILE 10";
    private static final String TILE_11 = "SLIDE TILE 11";
    private static final String TILE_12 = "SLIDE TILE 12";
    private static final String TILE_13 = "SLIDE TILE 13";
    private static final String TILE_14 = "SLIDE TILE 14";
    private static final String TILE_15 = "SLIDE TILE 15";
    private PuzzleState puzzle;


    public PuzzleMover(int row, int col) {
        newPuzzle = new int[row][col];
        puzzle = new PuzzleState(newPuzzle);
        addName();
        int len = 0;
        int temp = 1;
        while(len < (row*col)-1) {
            final int num = temp;
            super.addMove(moveNames.get(len), s->moveSlide(s, num));
            len++;
            temp++;
        }
    }

    private void addName() {
        moveNames = new ArrayList();
        moveNames.add(TILE_1);
        moveNames.add(TILE_2);
        moveNames.add(TILE_3);
        moveNames.add(TILE_4);
        moveNames.add(TILE_5);
        moveNames.add(TILE_6);
        moveNames.add(TILE_7);
        moveNames.add(TILE_8);
        moveNames.add(TILE_9);
        moveNames.add(TILE_10);
        moveNames.add(TILE_11);
        moveNames.add(TILE_12);
        moveNames.add(TILE_13);
        moveNames.add(TILE_14);
        moveNames.add(TILE_15);
    }

    private State moveSlide(State puzz, int n){
        puzzle = (PuzzleState) puzz;
        Location num = this.puzzle.getLocation(n);
        Location zero = this.puzzle.getLocation(0);
        int numR = num.getRow(), zeroR = zero.getRow();
        int numC = num.getColumn(), zeroC = zero.getColumn();
        if(numR != zeroR && numC != zeroC) return null;
        if(numR != zeroR-1 && numR != zeroR+1 && numC != zeroC-1 && numC != zeroC+1) return null;
        return new PuzzleState(this.puzzle, num, zero);
    }

    // private field
    int[][] newPuzzle;
    List<String>moveNames;
}