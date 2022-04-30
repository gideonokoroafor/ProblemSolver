package com.example.problemsolver.framework.ui;
/*
  @author gideon okoroafor
 */

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.problemsolver.R;
import com.example.problemsolver.framework.problem.Benchmark;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.Solution;
import com.example.problemsolver.framework.solution.Solver;
import com.example.problemsolver.framework.solution.SolvingAssistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProblemGUI {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ProblemGUI (Problem newProblem, TextView current, TextView goal,
                       TextView count, LinearLayout movesView, TextView msg,
                       Button reset, Button solve_b, Button next, LinearLayout controls, TextView stats) {
        problem = newProblem;
        currentView = current;
        goalView = goal;
        countView = count;
        statsView = stats;
        msgView = msg;
        reset_btn = reset;
        solve_btn = solve_b;
        next_btn = next;
        btn_layout = movesView;
        controls_layout = controls;
        solver = new SolvingAssistant(problem);
        solve = new AStarSolver(problem);
        context = msgView.getContext();
        next_btn.setEnabled(false);
        displayStates();
        makeButtons();
        makeBenchmarks();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ProblemGUI (Problem newProblem, TextView current, TextView goal,
                       TextView count, TextView msg,
                       Button reset, Button solve_b, Button next, LinearLayout controls, TextView stats) {
        problem = newProblem;
        currentView = current;
        goalView = goal;
        countView = count;
        statsView = stats;
        msgView = msg;
        reset_btn = reset;
        solve_btn = solve_b;
        next_btn = next;
        controls_layout = controls;
        solver = new SolvingAssistant(problem);
        solve = new AStarSolver(problem);
        context = msg.getContext();
        next_btn.setEnabled(false);
        displayStates();
        layout_btn();
        makeBenchmarks();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void makeBenchmarks() {
        List<String> arr = new ArrayList<>();
        benchSpinner = new Spinner(context, Spinner.MODE_DROPDOWN);
        problem.getBenchmarks().forEach(b -> arr.add(b.toString()));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, arr);
        benchSpinner.setAdapter(adapter);
        benchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Benchmark b = problem.getBenchmarks().get(i);
                solver.reset();
                problem.setCurrentState(b.getStart());
                displayStates();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
        controls_layout.addView(benchSpinner);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void makeButtons() {
        problem.getMover().getMoveNames().forEach(m -> {
             Button button = new Button(btn_layout.getContext());
             button.setText(m);
             button.setTextAppearance(R.style.btn_font);
             button.setWidth(200);
             button.setHeight(129);
             button.setPadding(5, 5, 5, 5);
             buttonList.add(button);
             btn_layout.addView(button);
             button.setOnClickListener(view -> {
                 msgView.setVisibility(View.INVISIBLE);
                 solver.tryMove(m);
                 currentView.setText(problem.getCurrentState().toString());
                 countView.setText(getMoves());
                 if(!solver.isMoveLegal()){
                     msgView.setVisibility(View.VISIBLE);
                     msgView.setText(ILLEGAL_MOVE);
                     msgView.setTextColor(Color.rgb(173,0,0));
                 } else if(solver.isProblemSolved()){
                     msgView.setText(CONGRATS);
                     msgView.setTextColor(Color.rgb(0,0,185));
                     msgView.setVisibility(View.VISIBLE);
                     buttonList.forEach(action-> action.setEnabled(false));
                 }
            });
        });
        layout_btn();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void layout_btn() {
        reset_btn.setOnClickListener(view -> {
            solver.reset();
            statsView.setText("");
            solve_btn.setEnabled(true);
            buttonList.forEach(action-> {action.setEnabled(true); action.setTextColor(Color.BLACK);});
            displayStates();
            benchSpinner.setSelection(0);
            countView.setText(getMoves());
            msgView.setVisibility(View.INVISIBLE);
            next_btn.setEnabled(false);
            controls_layout.setEnabled(true);
            benchSpinner.setEnabled(true);
        });

        solve_btn.setOnClickListener(v -> {
            solve.solve();
            msgView.setVisibility(View.INVISIBLE);
            statsView.setText(solve.getStatistics().toString());
            solverState = solver.getProblem().getCurrentState();
            solution = solve.getSolution();
            next_btn.setEnabled(true);
            solve_btn.setEnabled(false);
            buttonList.forEach(action-> action.setEnabled(false));
            controls_layout.setEnabled(false);
            benchSpinner.setEnabled(false);
            solution.next();
        });

        next_btn.setOnClickListener(m -> {
            State sol = (State)solution.next().getData();
            String res = highlight(sol);
            buttonList.forEach(mn -> {
                if(Objects.equals(res, mn.getText().toString())){
                    mn.setTextColor(Color.RED);
                } else {
                    mn.setTextColor(Color.BLACK);
                }
            });
            solver.update(sol);
            currentView.setText(problem.getCurrentState().toString());
            countView.setText(getMoves());
            if(solver.isProblemSolved()){
                msgView.setText(CONGRATS);
                msgView.setTextColor(Color.rgb(0,0,185));
                msgView.setVisibility(View.VISIBLE);
                next_btn.setEnabled(false);
            }
        });
    }

    private void displayStates() {
        currentView.setText(problem.getCurrentState().toString());
        goalView.setText(problem.getFinalState().toString());
        countView.setText(getMoves());
    }

    private String getMoves(){
        return String.valueOf(solver.getMoveCount());
    }

    private String highlight(State input){
        for(String s: problem.getMover().getMoveNames()){
            State st = problem.getMover().doMove(s, solverState);
            if(st != null && st.equals(input)){
                solverState = st;
                return s;
            }
        }
        return null;
    }

    private final Problem problem;
    private final SolvingAssistant solver;
    private final Solver solve;
    private Solution solution;
    private State solverState;
    private final Context context;

    private final TextView currentView;
    private final TextView goalView;
    private final TextView countView;
    private final TextView statsView;
    private final TextView msgView;
    private final Button reset_btn;
    private final Button solve_btn;
    private final Button next_btn;
    private LinearLayout btn_layout;
    private final LinearLayout controls_layout;
    private Spinner benchSpinner;

    private final List<Button> buttonList = new ArrayList<>();
    public static final String ILLEGAL_MOVE = "Illegal move.";
    public static final String CONGRATS = "Congratulations.";



}
