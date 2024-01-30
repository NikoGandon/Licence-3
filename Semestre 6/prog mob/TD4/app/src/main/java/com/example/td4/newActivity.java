package com.example.td4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.td4.fragments.newActivityFragment;

import android.content.Intent;


public class newActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        if (getIntent().hasExtra("countChangeAct")) {
            String message = getIntent().getStringExtra("countChangeAct");

            newActivityFragment detailFragment = (newActivityFragment) getSupportFragmentManager().findFragmentById(R.id.newActivityFragment);
            if (detailFragment != null) {
                detailFragment.updateTextView(message);
            }
        }

        if (getIntent().hasExtra("COUNT_KEY")) {
            int count = getIntent().getIntExtra("COUNT_KEY", 0);

            newActivityFragment detailFragment = (newActivityFragment) getSupportFragmentManager().findFragmentById(R.id.newActivityFragment);
            if (detailFragment != null) {
                detailFragment.updateTextView(String.valueOf(count));
            }
        }
    }
}
