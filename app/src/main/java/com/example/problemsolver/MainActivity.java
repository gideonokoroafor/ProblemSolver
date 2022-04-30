package com.example.problemsolver;
/**
 * @author gideon okoroafor
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.framework.problem.Problem;

public class MainActivity extends AppCompatActivity {


    public static Problem farmerProblem;
    public static Problem puzzleProblem;
    public static Problem fifteenpuzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayFwgc(View v) {
        Intent intent = new Intent(this, FWGC_DisplayActivity.class);
        startActivity(intent);
    }

    public void displayPuzzle(View v) {
        Intent intent = new Intent(this, PuzzleDisplay.class);
        startActivity(intent);
    }

    public void displayFifteenPuzzle(View v) {
        Intent intent = new Intent(this, Fifteenpuzzle.class);
        startActivity(intent);
    }
}