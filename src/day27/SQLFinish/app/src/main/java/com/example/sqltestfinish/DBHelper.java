package com.example.sqltestfinish;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "info";
    public static final String INFO_ID = "_id";
    public static final String INFO_NAME = "name";
    public static final String INFO_AGE = "age";
    public static final String INFO_MOBILE = "mobile";

    public static final String[] ALL_COLUMNS = {INFO_ID, INFO_NAME, INFO_AGE, INFO_MOBILE};

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    INFO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    INFO_NAME + " TEXT, " +
                    INFO_AGE + " INTEGER, " +
                    INFO_MOBILE + " TEXT" +
                    ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
}
