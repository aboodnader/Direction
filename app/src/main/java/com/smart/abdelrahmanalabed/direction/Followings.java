package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.content.ContentValues;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followings);
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

    }

    public void save(View view){

        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        CheckBox fajer = (CheckBox)findViewById(R.id.f1);
        CheckBox duha = (CheckBox)findViewById(R.id.f2);
        CheckBox duhor = (CheckBox)findViewById(R.id.f3);
        CheckBox aser = (CheckBox)findViewById(R.id.f4);
        CheckBox magreb = (CheckBox)findViewById(R.id.f5);
        CheckBox isha = (CheckBox)findViewById(R.id.f6);
        CheckBox sunan = (CheckBox)findViewById(R.id.f7);
        CheckBox weter = (CheckBox)findViewById(R.id.f8);
        CheckBox azkar = (CheckBox)findViewById(R.id.f9);
        CheckBox werd = (CheckBox)findViewById(R.id.f10);
        CheckBox sadaka = (CheckBox)findViewById(R.id.f11);

        values.put(AzkarEntryContract.AzkarEntry.COLUMN_NAME_ID,Calendar.getInstance().getTime().toString());
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
        Toast.makeText(this,"done "+rowid,Toast.LENGTH_LONG).show();
    }
}
