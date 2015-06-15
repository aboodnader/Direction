package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Calendar;

public class Followings extends Activity {

    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;
    long dayInMiliSeconds = 8640000L;
    long currentMiliSeconds;
    long id;

    CheckBox fajer;
    CheckBox duha;
    CheckBox duhor;
    CheckBox aser;
    CheckBox magreb;
    CheckBox isha;
    CheckBox sunan;
    CheckBox weter;
    CheckBox sadaka;
    CheckBox werd;
    CheckBox azkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followings);

        fajer = (CheckBox)findViewById(R.id.f1);
        duha = (CheckBox)findViewById(R.id.f2);
        duhor = (CheckBox)findViewById(R.id.f3);
        aser = (CheckBox)findViewById(R.id.f4);
        magreb = (CheckBox)findViewById(R.id.f5);
        isha = (CheckBox)findViewById(R.id.f6);
        sunan = (CheckBox)findViewById(R.id.f7);
        weter = (CheckBox)findViewById(R.id.f8);
        azkar = (CheckBox)findViewById(R.id.f9);
        werd = (CheckBox)findViewById(R.id.f10);
        sadaka = (CheckBox)findViewById(R.id.f11);

        currentMiliSeconds = Calendar.getInstance().getTimeInMillis();
        currentMiliSeconds = currentMiliSeconds - ( currentMiliSeconds % dayInMiliSeconds );
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        String selectMax = "SELECT max(id) FROM azkar";
        String [] idcolumn = {"id"};
        Cursor cursor = db.query(AzkarEntryContract.AzkarEntry.TABLE_NAME, idcolumn, null, null, null, null, null);
        cursor.moveToFirst();
        if(cursor.getCount()!=0) {
            id = cursor.getLong(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ID));
            if (id == currentMiliSeconds) {
                String selectAll = "SELECT * FROM azkar WHERE id = " + id;
                cursor = db.rawQuery(selectAll, null);
                cursor.moveToFirst();
                fajer.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_FAJER)) > 0);
                duha.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHA)) > 0);
                duhor.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHOR)) > 0);
                aser.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ASER)) > 0);
                magreb.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_MAGREB)) > 0);
                isha.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ISHA)) > 0);
                sunan.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SUNAN)) > 0);
                weter.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WETER)) > 0);
                azkar.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_AZKAR)) > 0);
                werd.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WERD)) > 0);
                sadaka.setChecked(cursor.getInt(cursor.getColumnIndexOrThrow(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SADAKA)) > 0);
            }
        }
    }

    public void save(View view){

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();


        if( id != currentMiliSeconds ) {

            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ID, currentMiliSeconds );
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_FAJER,fajer.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHA, duha.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHOR, duhor.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ASER, aser.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_MAGREB, magreb.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ISHA, isha.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SUNAN, sunan.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WETER, weter.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_AZKAR, azkar.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WERD, werd.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SADAKA, sadaka.isChecked());

            long rowid = db.insert(
                    AzkarEntryContract.AzkarEntry.TABLE_NAME,
                    "null",
                    values);
        }else {

            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_FAJER,fajer.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHA, duha.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_DUHOR, duhor.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ASER, aser.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_MAGREB, magreb.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ISHA, isha.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SUNAN, sunan.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WETER, weter.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_AZKAR, azkar.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_WERD, werd.isChecked());
            values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_SADAKA, sadaka.isChecked());

            String selection = AzkarEntryContract.AzkarEntry.COLUMN_NAME_ID + " LIKE ?";
            String[] selectionArgs = { "" + id };

            int count = db.update(
                    AzkarEntryContract.AzkarEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs);
        }
    }
}
