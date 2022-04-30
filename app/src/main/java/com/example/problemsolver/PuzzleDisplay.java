package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PuzzleDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_display);
    }

    public void displayPuzzleLayout(View v) {
        Intent intent = new Intent(this, PuzzleSolverLayout.class);
        startActivity(intent);
    }
}