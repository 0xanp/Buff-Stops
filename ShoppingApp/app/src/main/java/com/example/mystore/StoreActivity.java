package com.example.mystore;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StoreActivity extends AppCompatActivity {
    // Declaring public variables for better modulations
    public ImageButton water, fruit_oatmeal, bacon_biscuit,
            egg_biscuit, sausage_biscuit, sausage_burrito, hotcakes;
    public Button process;
    public int water_quantity, fruit_oatmeal_quantity, bacon_biscuit_quantity, egg_biscuit_quantity,
            sausage_biscuit_quantity, sausage_burrito_quantity, hotcakes_quantity;
    final int MY_REQUEST_CODE  = 1;
    public String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        
        getID();

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processCart();
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Dasani Water");
            }
        });
        fruit_oatmeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Fruit Maple Oatmeal");
            }
        });
        bacon_biscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Bacon Egg Biscuit");
            }
        });
        egg_biscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Egg Sausage");
            }
        });
        sausage_biscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Sausage Biscuit");
            }
        });
        sausage_burrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Sausage Burrito");
            }
        });
        hotcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processItem("Hotcakes");
            }
        });
    }
    /************************************
    * Function: 
    * Arguments:
    * Returns:
    *************************************/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                water_quantity = data.getExtras().getInt("water_quantity",0);
                fruit_oatmeal_quantity = data.getExtras().getInt("fruit_oatmeal_quantity",0);
                bacon_biscuit_quantity = data.getExtras().getInt("bacon_biscuit_quantity",0);
                egg_biscuit_quantity = data.getExtras().getInt("egg_biscuit_quantity",0);
                sausage_biscuit_quantity = data.getExtras().getInt("sausage_biscuit_quantity",0);
                sausage_burrito_quantity = data.getExtras().getInt("sausage_burrito_quantity",0);
                hotcakes_quantity = data.getExtras().getInt("hotcakes_quantity",0);
            }
        }
    }
    /************************************
    * Function: 
    * Arguments:
    * Returns:
    *************************************/
    public void getID(){
        water = findViewById(R.id.dasani);
        fruit_oatmeal = findViewById(R.id.id_fruit_oatmeal);
        bacon_biscuit = findViewById(R.id.id_bacon_biscuit);
        egg_biscuit = findViewById(R.id.id_biscuit_egg);
        sausage_biscuit = findViewById(R.id.id_sausage_biscuit);
        sausage_burrito = findViewById(R.id.id_sausage_burrito);
        hotcakes = findViewById(R.id.hotcake);
        process = findViewById(R.id.id_process);
    }
    /************************************
    * Function: 
    * Arguments:
    * Returns:
    *************************************/
    public void processItem(String item){
        Intent intent = new Intent(StoreActivity.this, QuantityActivity.class);
        intent.putExtra("item_name", item);
        intent.putExtra("water_quantity",water_quantity);
        intent.putExtra("fruit_oatmeal_quantity",fruit_oatmeal_quantity);
        intent.putExtra("bacon_biscuit_quantity",bacon_biscuit_quantity);
        intent.putExtra("egg_biscuit_quantity",egg_biscuit_quantity);
        intent.putExtra("sausage_biscuit_quantity",sausage_biscuit_quantity);
        intent.putExtra("sausage_burrito_quantity",sausage_burrito_quantity);
        intent.putExtra("hotcakes_quantity",hotcakes_quantity);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }
    /************************************
    * Function: 
    * Arguments:
    * Returns:
    *************************************/
    public void processCart(){
        Intent intent = new Intent(StoreActivity.this, ProcessOrderActivity.class);
        intent.putExtra("water_quantity",water_quantity);
        intent.putExtra("fruit_oatmeal_quantity",fruit_oatmeal_quantity);
        intent.putExtra("bacon_biscuit_quantity",bacon_biscuit_quantity);
        intent.putExtra("egg_biscuit_quantity",egg_biscuit_quantity);
        intent.putExtra("sausage_biscuit_quantity",sausage_biscuit_quantity);
        intent.putExtra("sausage_burrito_quantity",sausage_burrito_quantity);
        intent.putExtra("hotcakes_quantity",hotcakes_quantity);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }
}

