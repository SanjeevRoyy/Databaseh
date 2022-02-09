package com.example.database.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.database.modelclass.ModelSubject;


public class DBHandler extends SQLiteOpenHelper {
    public static final String SUBJECT_TABLE = "subject_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASS = "pass_marks";
    public static final String COLUMN_FULL = "full_marks";


    public static final int DB_VERSION = 1;

    public static final String DB_NAME = "textdb";



    public DBHandler(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableQuery = "CREATE TABLE " + SUBJECT_TABLE + "( " + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + "TEXT, " + COLUMN_PASS + "TEXT," + COLUMN_FULL + "TEXT )";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean addsubject(ModelSubject modelsubject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME,modelsubject.getName());
        cv.put(COLUMN_PASS,modelsubject.getPass_marks());
        cv.put(COLUMN_FULL,modelsubject.getFull_marks());

        long insert = db.insert(SUBJECT_TABLE,null,cv);
        db.close();

        if (insert==1)
        {
            return false;
        }
        else
        {
            return true;

        }
    }

}
