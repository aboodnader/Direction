package com.smart.abdelrahmanalabed.direction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Azkar_main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_main);
    }

    public void open_according(View view){

        if(view.getId()==R.id.d1){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",0);
            startActivity(intent);
        } else if(view.getId()==R.id.d2){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",1);
            startActivity(intent);
        } else if(view.getId()==R.id.d3){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",2);
            startActivity(intent);
        } else if(view.getId()==R.id.d4){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",3);
            startActivity(intent);
        } else if(view.getId()==R.id.d5){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",4);
            startActivity(intent);
        } else if(view.getId()==R.id.d6){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",5);
            startActivity(intent);
        } else if(view.getId()==R.id.d7){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",6);
            startActivity(intent);
        } else if(view.getId()==R.id.d8){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",7);
            startActivity(intent);
        } else if(view.getId()==R.id.d9){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",8);
            startActivity(intent);
        } else if(view.getId()==R.id.d10){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",9);
            startActivity(intent);
        } else if(view.getId()==R.id.d11){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",10);
            startActivity(intent);
        } else if(view.getId()==R.id.d12){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",11);
            startActivity(intent);
        } else if(view.getId()==R.id.d13){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",12);
            startActivity(intent);
        } else if(view.getId()==R.id.d14){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",13);
            startActivity(intent);
        } else if(view.getId()==R.id.d15){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",14);
            startActivity(intent);
        } else if(view.getId()==R.id.d16){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",15);
            startActivity(intent);
        } else if(view.getId()==R.id.d17){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",16);
            startActivity(intent);
        } else if(view.getId()==R.id.d18){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",17);
            startActivity(intent);
        } else if(view.getId()==R.id.d19){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",18);
            startActivity(intent);
        } else if(view.getId()==R.id.d20){
            Intent intent = new Intent(this,azkar_sub.class);
            intent.putExtra("number",19);
            startActivity(intent);
        }
    }

}
