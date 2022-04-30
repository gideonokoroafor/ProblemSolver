package com.example.problemsolver;
/*
  @author gideon okoroafor
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fifteenpuzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteenpuzzle);
    }

    public void display15PuzzleLayout(View v) {
        Intent intent = new Intent(this, FifteenPuzzleLayout.class);
        startActivity(intent);
    }

}