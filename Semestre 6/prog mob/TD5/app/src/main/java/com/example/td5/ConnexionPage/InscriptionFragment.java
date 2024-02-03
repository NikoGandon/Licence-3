package com.example.td5.ConnexionPage;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.td5.R;

import java.io.FileOutputStream;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InscriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscriptionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InscriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InscriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InscriptionFragment newInstance(String param1, String param2) {
        InscriptionFragment fragment = new InscriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inscription, container, false);

        Button boutonInscription = view.findViewById(R.id.buttonCreerCompte);
        TextView Username = view.findViewById(R.id.Username);
        TextView email = view.findViewById(R.id.Email);
        TextView password = view.findViewById(R.id.Password);
        TextView confirmPassword = view.findViewById(R.id.ConfirmPassword);

        boutonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordText = password.getText().toString();
                String confirmPasswordText = confirmPassword.getText().toString();

                if (!confirmPasswordText.equals(passwordText)){
                    Toast.makeText(getContext(), "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                    return;
                }

                String usernameText = Username.getText().toString();
                String emailText = email.getText().toString();

                if (!ConnexionController.enregistrerCompte(usernameText, emailText, passwordText, getContext())){
                    Toast.makeText(getContext(), "Erreur lors de l'inscription", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}