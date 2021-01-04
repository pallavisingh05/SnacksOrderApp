package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OtherSnack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_snack);

        final ArrayList<FoodItem> snacks=new ArrayList<FoodItem>();
        snacks.add(new FoodItem("Samosa",5));
        snacks.add(new FoodItem("Pakora",10));
        snacks.add(new FoodItem("Kachori",6));
        snacks.add(new FoodItem("aloo-tikki",10));
        snacks.add(new FoodItem("bread-pakora",10));
        snacks.add(new FoodItem("gulab-jamun",5));
        snacks.add(new FoodItem("RasMalai",12));
        snacks.add(new FoodItem("Dhokla",4));
        snacks.add(new FoodItem("Khandvi",4));
        snacks.add(new FoodItem("Panner Pakora",15));
        snacks.add(new FoodItem("Pyaaz pakora",15));
        snacks.add(new FoodItem("Gujiya",15));
        snacks.add(new FoodItem("Jalebi",15));
        snacks.add(new FoodItem("Gajak",5));
        snacks.add(new FoodItem("Revari",5));
        snacks.add(new FoodItem("Gajar ka Halwa",25));
        snacks.add(new FoodItem("Dosha",13));
        snacks.add(new FoodItem("Wada",14));
        snacks.add(new FoodItem("Pav-bhaji",12));

        final FoodItemArrayAdapter listofsnacks=new FoodItemArrayAdapter(this,snacks);
        ListView list=(ListView)findViewById(R.id.indiansnack_rootview);
        list.setAdapter(listofsnacks);

        Button button1=(Button)findViewById(R.id.OrderButtonIndSnack);
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
        Button button2=(Button)findViewById(R.id.ResetButtonIndSnack);
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
