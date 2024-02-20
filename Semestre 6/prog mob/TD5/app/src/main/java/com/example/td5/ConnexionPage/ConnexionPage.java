package com.example.td5.ConnexionPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.td5.R;

public class ConnexionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_page);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new ConnexionFragment())
                    .commit();
        }
    }

    public void afficherInscriptionFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new InscriptionFragment())
                .addToBackStack(null)
                .commit();
    }
    public void afficherConnexionFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new ConnexionFragment())
                .addToBackStack(null)
                .commit();
    }
}