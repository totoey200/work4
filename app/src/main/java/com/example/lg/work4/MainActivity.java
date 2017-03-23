package com.example.lg.work4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button varmenu,varcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        varmenu= (Button)findViewById(R.id.varmenu);
        varcal = (Button)findViewById(R.id.varcal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.varcal:
                act(2);
                break;
            case R.id.varmenu:
                act(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void act(int a){
        if(a==1) {
            Intent menu_intent = new Intent(MainActivity.this, Var_Menu.class);
            startActivity(menu_intent);
        }
        if(a==2) {
            Intent cal_intent = new Intent(MainActivity.this, Var_Cal.class);
            startActivity(cal_intent);
        }
    }
}
