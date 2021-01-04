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

public class Tea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);
    }
    int quantity=2;
    String Name="";
    public void increment(View view){
        quantity++;
        if(quantity>100){
            quantity=100;
        }
        display(quantity);
    }
    public void decrement(View view){
        quantity--;
        if(quantity<0){
            quantity=2;
        }
        display(quantity);
    }

    public void display(int num){
        TextView view_3=(TextView) findViewById(R.id.Text_of_Quantity);
        view_3.setText(""+quantity);
    }
    public void DisplayOrder(View view){
        TextView view_2=(TextView)findViewById(R.id.Price_of_Tea);
        EditText name=(EditText)findViewById(R.id.Name_of_person);
        Log.v("MainActivity","Name of the person who ordered coffee: "+name.getText().toString());

        int price=quantity*5;
        CheckBox Sugar=(CheckBox)findViewById(R.id.Sugar);
        CheckBox Ginger=(CheckBox)findViewById(R.id.Ginger);

        if(Sugar.isChecked()){
            price+=1;
        }
        if(Ginger.isChecked()){
            price+=5;
        }

        String message="";
        message+="Ordered by:"+name.getText().toString();
        message+="\nAdd the WhippedCream: "+(Sugar.isChecked()?"Yes":"No");
        message+="\nAdd the Chocolate Toppings: "+(Ginger.isChecked()?"Yes":"No");
        message+="\nNumber of Coffee: "+quantity;
        message+="\nPrice: $"+price;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL,"emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Food Order For "+name.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void ResetEveryThing(View view){
        EditText name=(EditText)findViewById(R.id.Name_of_person);
        name.setText("");
        CheckBox Sugar=(CheckBox)findViewById(R.id.Sugar);
        CheckBox Ginger=(CheckBox)findViewById(R.id.Ginger);
        Ginger.setChecked(false);
        Sugar.setChecked(false);
        quantity=2;
        TextView view_2=(TextView)findViewById(R.id.Price_of_Tea);
        view_2.setText("Price: ");
        TextView quan=(TextView)findViewById(R.id.Text_of_Quantity);
        quan.setText("2");
    }
}
