package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FWGC_DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_display);
    }

    public void displayFwgcLayout(View v) {
        Intent intent = new Intent(this, FWGC_Solver_Layout.class);
        startActivity(intent);
    }
}