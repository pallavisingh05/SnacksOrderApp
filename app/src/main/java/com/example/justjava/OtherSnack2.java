package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class OtherSnack2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_snack2);
        final ArrayList<FoodItem> snacks=new ArrayList<FoodItem>();
        snacks.add(new FoodItem("Chinese Samosa",6));
        snacks.add(new FoodItem("Sezuan",7));
        snacks.add(new FoodItem("Chaumin",15));
        snacks.add(new FoodItem("Manchurian",15));
        snacks.add(new FoodItem("Momos",10));
        snacks.add(new FoodItem("Chicken Momos",20));
        snacks.add(new FoodItem("White Dough Bread",10));
        snacks.add(new FoodItem("Haka Noodles",15));
        snacks.add(new FoodItem("Chili potato",10));
        snacks.add(new FoodItem("Chili chicken",25));
        snacks.add(new FoodItem("Ducks",20));

        final FoodItemArrayAdapter listofsnacks=new FoodItemArrayAdapter(this,snacks);
        ListView list=(ListView)findViewById(R.id.chinesesnack_rootview);
        list.setAdapter(listofsnacks);

        Button button1=(Button)findViewById(R.id.OrderButtonChinSnack);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=(EditText)findViewById(R.id.Name_of_person);
                String message="Ordered By:"+name.getText().toString()+"\n";
                int pricetopay=0;
                for(FoodItem f:snacks){
                    if(f.getNumber_of_fooditems()!=0){
                        message+=f.getFoodname()+" "+f.getNumber_of_fooditems()+"\n";
                        pricetopay+=(f.getPrice_of_item()*f.getNumber_of_fooditems());
                    }
                }
                message+="Price: $"+pricetopay;
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL,"emailaddress@emailaddress.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Food Order For "+name.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        Button button2=(Button)findViewById(R.id.ResetButtonChinSnack);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=(EditText)findViewById(R.id.Name_of_person);
                name.setText("");
                for(FoodItem f:snacks){
                    if(f.getNumber_of_fooditems()!=0){
                        f.setNumber_of_fooditems(0);
                    }
                }
            }
        });

    }
}
