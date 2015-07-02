package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.helper.HttpConnection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Salah extends Activity {


    ArrayList<String> sala=new ArrayList<>();
    TextView[] txt2;
    TextView[] txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah);

        txt2=new TextView[5];
        txt2[0] = (TextView)findViewById(R.id.name1);
        txt2[1] = (TextView)findViewById(R.id.name2);
        txt2[2] = (TextView)findViewById(R.id.name3);
        txt2[3] = (TextView)findViewById(R.id.name4);
        txt2[4] = (TextView)findViewById(R.id.name5);

        txt=new TextView[5];
        txt[0] = (TextView)findViewById(R.id.time1);
        txt[1] = (TextView)findViewById(R.id.time2);
        txt[2] = (TextView)findViewById(R.id.time3);
        txt[3] = (TextView)findViewById(R.id.time4);
        txt[4] = (TextView)findViewById(R.id.time5);

        final RequestQueue queue = Volley.newRequestQueue(this);
        String dateFormat = "MM";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String month = sdf.format(new Date());
        final String day = (String) android.text.format.DateFormat.format("dd", new Date());
        String url="http://api.xhanch.com/islamic-get-prayer-time.php?lng=36.192548&lat=32.099170&yy=2015&mm="+month+"&gmt=3&m=json";
        final ProgressDialog pd = new ProgressDialog(this, AlertDialog.THEME_HOLO_LIGHT);
        pd.show();
        final StringRequest stringRequest=new StringRequest(Request.Method.GET,url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONObject jsonObject2=  jsonObject.getJSONObject(day);
                    sala.add(jsonObject2.getString("fajr"));
                    sala.add(jsonObject2.getString("sunrise"));
                    sala.add(jsonObject2.getString("zuhr"));
                    sala.add(jsonObject2.getString("asr"));
                    sala.add(jsonObject2.getString("maghrib"));
                    sala.add(jsonObject2.getString("isha"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(sala.size()>0) {
                    txt[0].setText(sala.get(0));
                    txt[1].setText(sala.get(2));
                    txt[2].setText(sala.get(3));
                    txt[3].setText(sala.get(4));
                    txt[4].setText(sala.get(5));
                }else{
                    Toast.makeText(getBaseContext(),"??? ?? ???????",Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TEST", error + "");
                pd.dismiss();
            }
        });
        queue.add(stringRequest);
    }
}
