package com.example.td5.ConnexionPage;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConnexionController {



    ConnexionController() {

    }

    public static boolean connexion(String identifier, String password, Context context){
        // Lecture du fichier
        try {
            FileInputStream fileInputStream = context.openFileInput("comptes.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(";");

                if ((fields[0].equals(identifier) || fields[1].equals(identifier)) && fields[2].equals(password)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean enregistrerCompte(String username, String email, String password, Context context){
        FileOutputStream file = null;

        try{
            file =  context.openFileOutput("comptes.csv", Context.MODE_APPEND);
            String userData = username + ";" + email + ";" + password + "\n";

            file.write(userData.getBytes());

        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (file != null) file.close();
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static String getAllCompte(Context context) throws IOException {

        FileInputStream fileInputStream = context.openFileInput("comptes.csv");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }

        bufferedReader.close();

        return content.toString();

    }

    public static void afficherCompte(Context context){
        try{
            String content = getAllCompte(context);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Liste des comptes");
            builder.setMessage(content);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
