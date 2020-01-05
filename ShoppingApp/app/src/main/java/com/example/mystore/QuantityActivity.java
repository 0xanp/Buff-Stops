package com.example.mystore;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class QuantityActivity extends AppCompatActivity {
    EditText in_quantity;
    TextView item_order;
    String item_name;
    TableLayout table;
    TableRow tableRow;
    TextView tv1, tv2;
    int water_quantity, fruit_oatmeal_quantity, bacon_biscuit_quantity, egg_biscuit_quantity,
            sausage_biscuit_quantity, sausage_burrito_quantity, hotcakes_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        item_order = findViewById(R.id.order_item);
        table = findViewById(R.id.table_layout);
        in_quantity = findViewById(R.id.quantity);

        Bundle extras = getIntent().getExtras();
        item_name = extras.getString("item_name");
        item_order.setText(item_name);
        // get data from other activities
        water_quantity = extras.getInt("water_quantity",0);
        fruit_oatmeal_quantity = extras.getInt("fruit_oatmeal_quantity",0);
        bacon_biscuit_quantity = extras.getInt("bacon_biscuit_quantity",0);
        egg_biscuit_quantity = extras.getInt("egg_biscuit_quantity",0);
        sausage_biscuit_quantity = extras.getInt("sausage_biscuit_quantity",0);
        sausage_burrito_quantity = extras.getInt("sausage_burrito_quantity",0);
        hotcakes_quantity = extras.getInt("hotcakes_quantity",0);


        if (water_quantity > 0){
            addToTable(water_quantity,"Dasani Water");
        }
        if (fruit_oatmeal_quantity > 0){
            addToTable(fruit_oatmeal_quantity,"Fruit Maple Oatmeal");
        }
        if (bacon_biscuit_quantity > 0){
            addToTable(bacon_biscuit_quantity,"Bacon Egg Biscuit");
        }
        if (egg_biscuit_quantity > 0){
            addToTable(egg_biscuit_quantity,"Egg Sausage");
        }
        if (sausage_biscuit_quantity > 0){
            addToTable(sausage_biscuit_quantity,"Sausage Biscuit");
        }
        if (sausage_burrito_quantity > 0){
            addToTable(sausage_burrito_quantity,"Sausage Burrito");
        }
        if (hotcakes_quantity > 0){
            addToTable(hotcakes_quantity,"Hotcakes");
        }

    }
    /************************************
    * Function: 
    * Arguments
    * Returns:
    *************************************/
    public void addToTable(int q, String n){
        tv1 = new TextView(this);
        tv1.setText(n);
        tv1.setTextColor(Color.BLACK);
        tv1.setTextSize(18);
        tv1.setPadding(15,15,15,15);

        tv2 = new TextView(this);
        tv2.setText(String.valueOf(q));
        tv2.setTextColor(Color.BLACK);
        tv2.setTextSize(18);
        tv2.setPadding(15,15,15,15);

        tableRow = new TableRow(this);
        tableRow.addView(tv1);
        tableRow.addView(tv2);
        table.addView(tableRow);
    }
    /************************************
    * Function: 
    * Arguments
    * Returns:
    *************************************/
    public void finish(){
        int item_quantity = Integer.parseInt(in_quantity.getText().toString());
        if (item_name.equals("Dasani Water"))
            water_quantity += item_quantity;
        if (item_name.equals("Fruit Maple Oatmeal"))
            fruit_oatmeal_quantity += item_quantity;
        if (item_name.equals("Bacon Egg Biscuit"))
            bacon_biscuit_quantity += item_quantity;
        if (item_name.equals("Egg Sausage"))
            egg_biscuit_quantity += item_quantity;
        if (item_name.equals("Sausage Biscuit"))
            sausage_biscuit_quantity += item_quantity;
        if (item_name.equals("Sausage Burrito"))
            sausage_burrito_quantity += item_quantity;
        if (item_name.equals("Hotcakes"))
            hotcakes_quantity += item_quantity;
        processCart();
        super.finish();
    }
    /************************************
    * Function: 
    * Arguments
    * Returns:
    *************************************/
    public void processCart(){
        Intent intent = new Intent(QuantityActivity.this, ProcessOrderActivity.class);
        intent.putExtra("water_quantity",water_quantity);
        intent.putExtra("fruit_oatmeal_quantity",fruit_oatmeal_quantity);
        intent.putExtra("bacon_biscuit_quantity",bacon_biscuit_quantity);
        intent.putExtra("egg_biscuit_quantity",egg_biscuit_quantity);
        intent.putExtra("sausage_biscuit_quantity",sausage_biscuit_quantity);
        intent.putExtra("sausage_burrito_quantity",sausage_burrito_quantity);
        intent.putExtra("hotcakes_quantity",hotcakes_quantity);
        setResult(RESULT_OK, intent);
    }
}

