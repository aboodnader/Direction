package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view){
        int id = view.getId();
        if(id == R.id.mathurat){
            startActivity(new Intent(this,PagerActivity.class));
        } else if(id == R.id.azkar){
            startActivity(new Intent(this,Azkar_main.class));
        } else if(id == R.id.gpa){
            startActivity(new Intent(this,GPA_Activity.class));
        } else if(id == R.id.folowings){
            startActivity(new Intent(this,Followings.class));
        } else if(id == R.id.facebook){
            startActivity(getOpenFacebookIntent(this));
        }
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1566985523524777"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/HuOrientation"));
        }
    }
}
