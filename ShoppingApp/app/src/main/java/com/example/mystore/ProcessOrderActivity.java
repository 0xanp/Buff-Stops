package com.example.mystore;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ProcessOrderActivity extends AppCompatActivity {
    int water_quantity, fruit_oatmeal_quantity, bacon_biscuit_quantity, egg_biscuit_quantity,
            sausage_biscuit_quantity, sausage_burrito_quantity, hotcakes_quantity;
    TableLayout table;
    TableRow tableRow;
    TextView tv1, tv2, tv3;
    double price;
    double subtotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_order);
        table = findViewById(R.id.table_layout1);
        Bundle extras = getIntent().getExtras();
        water_quantity = extras.getInt("water_quantity",0);
        fruit_oatmeal_quantity = extras.getInt("fruit_oatmeal_quantity",0);
        bacon_biscuit_quantity = extras.getInt("bacon_biscuit_quantity",0);
        egg_biscuit_quantity = extras.getInt("egg_biscuit_quantity",0);
        sausage_biscuit_quantity = extras.getInt("sausage_biscuit_quantity",0);
        sausage_burrito_quantity = extras.getInt("sausage_burrito_quantity",0);
        hotcakes_quantity = extras.getInt("hotcakes_quantity",0);
        if (water_quantity > 0){
            price = (double) Math.round((water_quantity * 2.00 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(water_quantity),"Dasani Water", " $2.00");
        }
        if (fruit_oatmeal_quantity > 0){
            price = (double) Math.round((fruit_oatmeal_quantity * 2.00 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(fruit_oatmeal_quantity),"Fruit Maple Oatmeal", " $2.00");
        }
        if (bacon_biscuit_quantity > 0){
            price = (double) Math.round((bacon_biscuit_quantity * 2.00 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(bacon_biscuit_quantity),"Bacon Egg Biscuit", " $2.00");
        }
        if (egg_biscuit_quantity > 0){
            price = (double) Math.round((egg_biscuit_quantity * 2.00 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(egg_biscuit_quantity),"Egg Sausage", " $2.00");
        }
        if (sausage_biscuit_quantity > 0){
            price = (double) Math.round((sausage_biscuit_quantity * 1.99 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(sausage_biscuit_quantity),"Sausage Biscuit", " $1.99");
        }
        if (sausage_burrito_quantity > 0){
            price = (double) Math.round((sausage_burrito_quantity * 2.00 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(sausage_burrito_quantity),"Sausage Burrito", " $2.00");
        }
        if (hotcakes_quantity > 0){
            price = (double) Math.round((hotcakes_quantity * 1.75 )*100) / 100.0;
            subtotal += price;
            addToTable(String.valueOf(hotcakes_quantity),"Hotcakes", " $1.75");
        }
        double tax = (double)Math.round((subtotal*0.0825)*100)/100.0;
        double total = subtotal + tax;
        String string_sub = String.valueOf(subtotal);
        string_sub = " $"+ string_sub;
        String string_tax = String.valueOf(tax);
        string_tax = " $"+ string_tax;
        String string_total = String.valueOf(total);
        string_total = " $"+string_total;
        addToTable("","Sub Total",string_sub);
        addToTable("","Tax(8.25%)",string_tax);
        addToTable("","Total",string_total);
    }

    /************************************
    * Function: 
    * Arguments
    * Returns:
    *************************************/
    public void addToTable(String q, String n, String p){
        tv1 = new TextView(this);
        tv1.setText(n);
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(15);
        tv1.setPadding(15,5,15,5);

        tv2 = new TextView(this);
        tv2.setText(q);
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(15);
        tv2.setPadding(15,5,15,5);

        tv3 = new TextView(this);
        tv3.setText(p);
        tv3.setTextColor(Color.BLACK);
        tv3.setTextSize(15);
        tv3.setPadding(5,5,5,5);
        tableRow = new TableRow(this);
        tableRow.addView(tv1);
        tableRow.addView(tv2);
        tableRow.addView(tv3);
        table.addView(tableRow);
    }
}
