package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Beverages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);

        LinearLayout Tea=(LinearLayout)findViewById(R.id.Tea_view);
        ImageView img1=(ImageView)findViewById(R.id.Tea_image);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Beverages.this,Tea.class);
                startActivity(in);
            }
        });
        ImageView img2=(ImageView)findViewById(R.id.Coffee_ki_image);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Beverages.this,Coffee.class);
                startActivity(in);
            }
        });
    }

}
