package com.example.menu;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.english:
                Toast.makeText(MainActivity.this,"English selected",Toast.LENGTH_SHORT).show();
            case R.id.hindi:
                Toast.makeText(MainActivity.this,"Hindi selected",Toast.LENGTH_SHORT).show();
            case R.id.maithili:
                Toast.makeText(MainActivity.this,"Maithili selected",Toast.LENGTH_SHORT).show();
            case R.id.punjabi:
                Toast.makeText(MainActivity.this,"Punjabi selected",Toast.LENGTH_SHORT).show();
            default:
                return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}