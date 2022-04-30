package com.example.problemsolver;
/*
  @author gideon okoroafor
 */
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.problemsolver.domains.puzzle.FifteenPuzzleProblem;
import com.example.problemsolver.domains.puzzle.PuzzleProblem;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.ui.ProblemGUI;

public class FifteenPuzzleLayout extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen_puzzle_layout);

        Problem problem = MainActivity.fifteenpuzzle;

        TextView startView = (TextView) findViewById(R.id.puzz15_current);
        TextView goalView = (TextView) findViewById(R.id.puzz15_goal);
        TextView countView = (TextView) findViewById(R.id.puzzle15_movecount);
        TextView msgView = (TextView) findViewById(R.id.puzz15_msg);
        Button resetBtn = (Button) findViewById(R.id.puzz15_reset);
        Button solveBtn = (Button) findViewById(R.id.puzz15_solve);
        Button nextBtn = (Button) findViewById(R.id.puzz15_next);
        LinearLayout controls = (LinearLayout) findViewById(R.id.puzz15_layout);
        TextView statistics = (TextView) findViewById(R.id.puzz15_stats);

        new ProblemGUI(
                new FifteenPuzzleProblem(),
                startView,
                goalView,
                countView,
                msgView,
                resetBtn,
                solveBtn,
                nextBtn,
                controls,
                statistics
        );
    }
}