package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class azkar_sub extends Activity {

    String [] items ;
    TextView text ;
    TextView title;
    String [] itemsTitles ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_sub);
        text = (TextView)findViewById(R.id.main_text);
        title = (TextView)findViewById(R.id.title);
        items = getResources().getStringArray(R.array.azkar_array);
        itemsTitles = getResources().getStringArray(R.array.azkar_titles);
        int itemNumber = getIntent().getIntExtra("number",-1);
        text.setText(items[itemNumber]);
        title.setText(itemsTitles[itemNumber]);
    }
}
