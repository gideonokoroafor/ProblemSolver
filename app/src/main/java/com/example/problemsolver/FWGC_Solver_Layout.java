package com.example.problemsolver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.ui.ProblemGUI;

public class FWGC_Solver_Layout extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_solver_layout);

        Problem problem = MainActivity.farmerProblem;

        TextView startView = (TextView) findViewById(R.id.fwgc_currentView);
        TextView goalView = (TextView) findViewById(R.id.fwgc_goalView);
        TextView countView = (TextView) findViewById(R.id.fwgc_movecount);
        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.fwgc_btn_layout);
        TextView msgView = (TextView) findViewById(R.id.fwgc_msg);
        Button resetBtn = (Button) findViewById(R.id.fwgc_reset_btn);
        Button solveBtn = (Button) findViewById(R.id.fwgc_solve_btn);
        Button nextBtn = (Button) findViewById(R.id.fwgc_next_btn);
        LinearLayout controls = (LinearLayout) findViewById(R.id.fwgc_controls_layout);
        TextView statistics = (TextView) findViewById(R.id.fwgc_stats_label);

        new ProblemGUI(
                new FarmerProblem(),
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