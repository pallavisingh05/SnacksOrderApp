package com.example.justjava;

import android.view.View;

public class FoodItem {
    private String foodname="";
    private int number_of_fooditems=0;
    private int price_of_item=0;
    public FoodItem(String Foodname,int price){

        foodname=Foodname;
        price_of_item=price;
    }
    public int getPrice_of_item(){
        return price_of_item;
    }
    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int increment_the_num_of_item(View view){
        number_of_fooditems++;
        if(number_of_fooditems>100){
            number_of_fooditems=100;
        }
        return number_of_fooditems;
    }
    public int decrement_the_num_of_item(View view){
        number_of_fooditems--;
        if(number_of_fooditems<0){
            number_of_fooditems=0;
        }
        return number_of_fooditems;
    }

    public int getNumber_of_fooditems() {
        return number_of_fooditems;
    }
    public void setNumber_of_fooditems(int num){
        number_of_fooditems=0;
    }
}
