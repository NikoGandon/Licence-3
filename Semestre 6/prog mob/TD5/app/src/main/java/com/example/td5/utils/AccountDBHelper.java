package com.example.td5.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AccountDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION  = 1;
    private static final String DB_NAME = "coucou";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "usr";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "psw";
    private static final String TABLE_ACCOUNTS = "Account";

    private static final String CREATE_TABLE_ACCOUNTS =
            "CREATE TABLE " + TABLE_ACCOUNTS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_USERNAME + " TEXT," +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_PASSWORD + " TEXT" +
                    ")";

    AccountDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ACCOUNTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String username, String email, String psw){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, psw);

        db.insert(TABLE_ACCOUNTS, null, values);
    }

    public List<String> getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> AccountList = new ArrayList<>();
        return AccountList;
    }
}
