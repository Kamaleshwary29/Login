package com.example.mee3023loginfunction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
    private String editTextTextEmailAddress;

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(editTextTextEmailAddress Text primary key, editTextTextPassword Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String editTextTextEmailAddress, String editTextTextPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(editTextTextEmailAddress, editTextTextEmailAddress);
        contentValues.put(editTextTextPassword, editTextTextPassword);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1)  return false;
        else
            return true;
        }

    public Boolean checkeditTextTextEmailAddress(String editTextTextEmailAddress){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where editTextTextEmailAddress = ?", new String[] {editTextTextEmailAddress});
        if(cursor.getCount()>0)
             return true;
        else
             return false;
    }

    public Boolean checkeditTextTextEmailAddressEditTextTextPassword(String editTextTextUsername, String editTextTextPassword){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where editTextTextEmailAddress =? and editTextTextPassword = ?", new String[] {editTextTextEmailAddress,editTextTextPassword});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
