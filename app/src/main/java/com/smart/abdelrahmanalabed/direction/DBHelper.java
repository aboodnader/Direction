package com.smart.abdelrahmanalabed.direction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "azkar";
    public static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_ENTRIES = "CREATE  TABLE  IF NOT EXISTS "+DATABASE_NAME
            +" ( "+ AzkarEntryContract.AzkarEntry.COLUMN_NAME_ID +" INTEGER PRIMARY KEY  NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_FAJER +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHA +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHOR +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_ASER +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_MAGREB +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_ISHA +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_SUNAN +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_WETER +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_AZKAR +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_WERD +" BOOL NOT NULL , "
            + AzkarEntryContract.AzkarEntry.COLUMN_NAME_SADAKA +" BOOL NOT NULL )";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + AzkarEntryContract.AzkarEntry.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
