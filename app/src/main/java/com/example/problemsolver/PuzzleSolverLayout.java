package com.example.problemsolver;
/*
  @author gideon okoroafor
 */
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.problemsolver.domains.puzzle.PuzzleProblem;
import com.example.problemsolver.framework.problem.Benchmark;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.solution.SolvingAssistant;
import com.example.problemsolver.framework.ui.ProblemGUI;

import java.util.ArrayList;
import java.util.List;

public class PuzzleSolverLayout extends AppCompatActivity {

    private SolvingAssistant solver;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_solver_layout);

        Problem problem = MainActivity.puzzleProblem;

        TextView startView = (TextView) findViewById(R.id.puzzle_currentView);
        TextView goalView = (TextView) findViewById(R.id.puzzle_goalView);
        TextView countView = (TextView) findViewById(R.id.puzzle_movecount);
        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.puzzle_btn_layout);
        TextView msgView = (TextView) findViewById(R.id.puzzle_msg);
        Button resetBtn = (Button) findViewById(R.id.puzzle_reset_btn);
        Button solveBtn = (Button) findViewById(R.id.puzzle_solve_btn);
        Button nextBtn = (Button) findViewById(R.id.puzzle_next_btn);
        LinearLayout controls = (LinearLayout) findViewById(R.id.puzzle_spinner_layout);
        TextView statistics = (TextView) findViewById(R.id.puzzle_stats_label);

        new ProblemGUI(
                new PuzzleProblem(),
                startView,
                goalView,
                countView,
                buttonsLayout,
                msgView,
                resetBtn,
                solveBtn,
                nextBtn,
                controls,
                statistics
        );
    }
}