package com.example.clickableimage;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showDonutOrder(View v){
        displayToast(getString(R.string.donut_order_message));
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
    public  void showIceCreamOrder(View v){
        displayToast(getString(R.string.ice_cream_order_message));
    }
    public void showFroyoOrder(View v){
        displayToast(getString(R.string.froyo_order_message));
    }
}