package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void IndianSnacks(View view){
        Intent in=new Intent(this,OtherSnack.class);
        startActivity(in);
    }
    public void ChineseSnacks(View view){
        Intent in=new Intent(this,OtherSnack2.class);
        startActivity(in);
    }
    public void ItalianSnacks(View view){
        Intent in=new Intent(this,OtherSnack3.class);
        startActivity(in);
    }
    public void Beverages_tea_coffee(View view){
        Intent in=new Intent(this,Beverages.class);
        startActivity(in);
    }

}
