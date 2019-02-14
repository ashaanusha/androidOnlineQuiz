package com.marolix.androidonlinequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBaseClass extends SQLiteOpenHelper {
    ArrayList<Map<String,String>> data;
    public static final String DB_NAME = "student";
    public static final String TABLE_NAME = "table_name";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String COLUMN_ID = "column_id";
    public static final String PASSWORD = "password";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME + " TEXT,"
                    + EMAIL + " TEXT,"
                    + PASSWORD + " TEXT"
                    + ")";

    public static final String TABLE_NAME1 = "table_name1";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final String COLUMN_ID1 = "column_id1";
    public static final String SELECTED = "selected";
    public static final String CREATE_TABLE1 =
            "CREATE TABLE " + TABLE_NAME1 + "("
                    + COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + QUESTION + " TEXT UNIQUE,"
                    + ANSWER + " TEXT,"
                    + SELECTED + " TEXT"
                    + ")";

    public static final String RESULT = "result";
    public static final String USERNAME = "username";
    public static final String SUBJECT = "subject";
    public static final String COLUMN_ID2 = "column_id";
    public static final String PERCENTAGE= "percentage";
    public static final String CREATE_TABLE2 =
            "CREATE TABLE " + RESULT + "("
                    + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USERNAME + " TEXT,"
                    + SUBJECT + " TEXT,"
                    + PERCENTAGE + " TEXT"
                    + ")";

    public static final String FOLLOWED1 = "followed1";
    public static final String USERNAME1 = "username";
    public static final String COLUMN_ID3 = "column_id";
    public static final String FOLLOWED= "followed";
    public static final String CREATE_TABLE3 =
            "CREATE TABLE " + FOLLOWED1 + "("
                    + COLUMN_ID3 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USERNAME1 + " TEXT,"
                    + FOLLOWED + " TEXT"
                    + ")";
    public DataBaseClass(Context context) {
        super(context ,DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);
        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + RESULT);
        db.execSQL("DROP TABLE IF EXISTS " + FOLLOWED1);
        onCreate(db);
    }
    public void insertValues(String name_str, String emial_str, String pass_str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name_str);
        values.put(EMAIL, emial_str);
        values.put(PASSWORD, pass_str);

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String,String>> getRetrive(String username,String password) {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME+ " where "+EMAIL+" = '"+username+"' and "+PASSWORD+" = '"+password+"'", null);

        if ( cursor.moveToFirst()) {

            do {
                Map<String,String> hmap= new HashMap<>();
                hmap.put(NAME,cursor.getString(cursor.getColumnIndex(NAME)));

                hmap.put(EMAIL,cursor.getString(cursor.getColumnIndex(EMAIL)));
                hmap.put(PASSWORD,cursor.getString(cursor.getColumnIndex(PASSWORD)));
                data.add(hmap);

            }while (cursor.moveToNext());
        }
        return data;
    }
    public void insertValues1(String question, String answer) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(QUESTION, question);
        values.put(ANSWER, answer);


        sqLiteDatabase.insert(TABLE_NAME1, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public boolean updateData1(String select,String question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SELECTED,select);

        db.update(TABLE_NAME1, contentValues, "QUESTION = ?",new String[] { question });
        return true;
    }
    public ArrayList<Map<String,String>> getRetrive1() {
        data = new ArrayList();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME1, null);

        if ( cursor.moveToFirst()) {

            do {
                Map<String,String> hmap= new HashMap<>();
                hmap.put(QUESTION,cursor.getString(cursor.getColumnIndex(QUESTION)));

                hmap.put(ANSWER,cursor.getString(cursor.getColumnIndex(ANSWER)));
                hmap.put(SELECTED,cursor.getString(cursor.getColumnIndex(SELECTED)));
                data.add(hmap);

            }while (cursor.moveToNext());
        }
        return data;
    }
    public void insert_result( String Username,String Subject,String percentage) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
       values.put(USERNAME, Username);
        values.put(SUBJECT, Subject);
        values.put(PERCENTAGE, percentage);

        sqLiteDatabase.insert(RESULT, null, values);
        sqLiteDatabase.close();
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String,String>> getResult(String name) {
        data = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + RESULT + " where "+ USERNAME +" = '"+ name +"'", null);

        if ( cursor.moveToFirst()) {

            do {
                Map<String,String> hmap= new HashMap<>();
                hmap.put(USERNAME,cursor.getString(cursor.getColumnIndex(USERNAME)));
                hmap.put(SUBJECT,cursor.getString(cursor.getColumnIndex(SUBJECT)));
                hmap.put(PERCENTAGE,cursor.getString(cursor.getColumnIndex(PERCENTAGE)));
                data.add(hmap);
            }while (cursor.moveToNext());
        }
        return data;
    }
    public void insert_Followed(String followed, String Username) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, Username);
        values.put(FOLLOWED, followed);
        sqLiteDatabase.insert(FOLLOWED1, null, values);
        // Toast.makeText(DataBaseClass.class, "successfully saved", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Map<String,String>> get_followed(String name) {
        data = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + FOLLOWED1+ " where "+USERNAME+" = '"+name+"'", null);

        if ( cursor.moveToFirst()) {

            do {
                Map<String,String> hmap= new HashMap<>();
                hmap.put(USERNAME,cursor.getString(cursor.getColumnIndex(USERNAME)));
                hmap.put(FOLLOWED,cursor.getString(cursor.getColumnIndex(FOLLOWED)));
                data.add(hmap);
            }while (cursor.moveToNext());
        }
        return data;
    }

}
