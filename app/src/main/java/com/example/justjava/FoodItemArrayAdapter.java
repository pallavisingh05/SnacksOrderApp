package com.example.justjava;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FoodItemArrayAdapter extends ArrayAdapter<FoodItem> {
    public FoodItemArrayAdapter(Activity context, ArrayList<FoodItem> foods){
        super(context,0,foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final FoodItem currentitem=getItem(position);

        View listfooditemview=convertView;
        if(listfooditemview==null){
            listfooditemview= LayoutInflater.from(getContext()).inflate(R.layout.listitems_ke_liye_file,parent,false);
        }
        TextView nameoffitem=(TextView)listfooditemview.findViewById(R.id.food_item);
        nameoffitem.setText(currentitem.getFoodname());


        final TextView quantityofitem=(TextView)listfooditemview.findViewById(R.id.food_item_quantity);
        quantityofitem.setText(""+currentitem.getNumber_of_fooditems());

        Button DecButton=(Button)listfooditemview.findViewById(R.id.DecButton);
        DecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityofitem.setText(""+currentitem.decrement_the_num_of_item(v));
            }
        });

        Button IncButton=(Button)listfooditemview.findViewById(R.id.IncButton);
        IncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityofitem.setText(""+currentitem.increment_the_num_of_item(v));
            }
        });

        return listfooditemview;
    }
}
