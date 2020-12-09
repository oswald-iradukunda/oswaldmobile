package com.example.clickableimage;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";
    public String mOrderMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOrderMessage = getString(R.string.donut_order_message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDonutOrder(View v){
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