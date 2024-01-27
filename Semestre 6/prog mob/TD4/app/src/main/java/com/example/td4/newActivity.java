package com.example.td4;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.td4.fragments.OnVariableListener;

public class newActivity extends AppCompatActivity {

    private Bundle extra;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.new_activity);
    }

    public String data() {
        return extra.getString("countChangeAct");
    }

}
