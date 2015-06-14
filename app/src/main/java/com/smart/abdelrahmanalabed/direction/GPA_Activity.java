package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class GPA_Activity extends Activity {

    EditText gpa ;
    EditText hours_count;

    EditText hours_count1;
    Spinner sp1;
    EditText hours_count2;
    Spinner sp2;
    EditText hours_count3;
    Spinner sp3;
    EditText hours_count4;
    Spinner sp4;
    EditText hours_count5;
    Spinner sp5;
    EditText hours_count6;
    Spinner sp6;
    EditText hours_count7;
    Spinner sp7;

    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        gpa = (EditText)findViewById(R.id.general_gpa);
        hours_count =(EditText)findViewById(R.id.hours_count);

        sp1 = (Spinner)findViewById(R.id.sp1);
        hours_count1 =(EditText)findViewById(R.id.hours_count1);
        sp2 = (Spinner)findViewById(R.id.sp2);
        hours_count2 =(EditText)findViewById(R.id.hours_count2);
        sp3 = (Spinner)findViewById(R.id.sp3);
        hours_count3 =(EditText)findViewById(R.id.hours_count3);
        sp4 = (Spinner)findViewById(R.id.sp4);
        hours_count4 =(EditText)findViewById(R.id.hours_count4);
        sp5 = (Spinner)findViewById(R.id.sp5);
        hours_count5 =(EditText)findViewById(R.id.hours_count5);
        sp6 = (Spinner)findViewById(R.id.sp6);
        hours_count6 =(EditText)findViewById(R.id.hours_count6);
        sp7 = (Spinner)findViewById(R.id.sp7);
        hours_count7 =(EditText)findViewById(R.id.hours_count7);

    }


    public void calculate(View view){

        double sum = 0;
        if (hours_count.getText().toString().equals("") || gpa.getText().toString().equals("")){
            String message ="please enter your GPA ";
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();
            return;
        }
        int hours = Integer.parseInt(hours_count.getText().toString());
        double gGpa = Double.parseDouble(gpa.getText().toString());
        sum += hours * gGpa;
        int thisSemesterHours = 0;

        int mark = (int)sp1.getSelectedItemId();
        String mhours = hours_count1.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp2.getSelectedItemId();
        mhours = hours_count2.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp3.getSelectedItemId();
        mhours = hours_count3.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp4.getSelectedItemId();
        mhours = hours_count4.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp5.getSelectedItemId();
        mhours = hours_count5.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp6.getSelectedItemId();
        mhours = hours_count6.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }
        mark = (int)sp7.getSelectedItemId();
        mhours = hours_count7.getText().toString();
        if (mark>0 && !mhours.equals("")){
            sum += getMark(mark) * Integer.parseInt(mhours);
            thisSemesterHours += Integer.parseInt(mhours);
        }

        result = (sum/(thisSemesterHours+hours))*100;
        result = Math.round(result)/100.0;
        new AlertDialog.Builder(this).setMessage(result+"").create().show();
    }

    private double getMark(int markID){
        switch(markID){
            case 1:return 4.0;
            case 2:return 3.75;
            case 3:return 3.5;
            case 4:return 3.25;
            case 5:return 3.0;
            case 6:return 2.75;
            case 7:return 2.5;
            case 8:return 2.25;
            case 9:return 2.0;
            case 10:return 1.75;
            case 11:return 1.5;
            case 12:return 0;
        }
        return 1000;
    }
}
