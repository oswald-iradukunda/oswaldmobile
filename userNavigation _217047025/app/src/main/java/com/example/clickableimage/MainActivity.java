package com.example.clickableimage;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void showDonutOrder(View v){
        String mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
        Intent intent = new Intent(MainActivity.this,OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
        startActivity(intent);
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