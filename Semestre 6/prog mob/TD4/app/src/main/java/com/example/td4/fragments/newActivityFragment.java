package com.example.td4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.View;

import com.example.td4.R;

public class newActivityFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_activity, container, false);
        textView = view.findViewById(R.id.countChangeAct);

        return view;
    }

    // Méthode pour mettre à jour le TextView avec du texte
    public void updateTextView(String text) {
        if (textView != null) {
            textView.setText(text);
        }
    }
}
