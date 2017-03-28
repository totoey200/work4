package com.example.lg.work4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Var_Menu extends AppCompatActivity {
    FrameLayout layout;
    TextView tv;
    ImageView iv_chick,iv_spa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var__menu);
        init();
    }

    void init(){
        layout = (FrameLayout)findViewById(R.id.menulayout);
        tv = (TextView)findViewById(R.id.image_title);
        iv_chick = (ImageView)findViewById(R.id.image_chick);
        iv_spa = (ImageView)findViewById(R.id.image_spa);
        setTitle("메뉴를 눌러보세요");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.yellow:
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.blue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.spin:
                if(iv_chick.getVisibility()==View.VISIBLE)
                    iv_chick.setRotation(iv_chick.getRotation()+30);
                else if(iv_spa.getVisibility()==View.VISIBLE)
                    iv_spa.setRotation(iv_spa.getRotation()+30);
                break;
            case R.id.vis_title:
                if(item.isChecked()) {
                    item.setChecked(false);
                    tv.setVisibility(View.GONE);
                }
                else{
                    item.setChecked(true);
                    tv.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.zoom:
                if(item.isChecked()){
                   item.setChecked(false);
                    iv_chick.setScaleX(1);
                    iv_chick.setScaleY(1);
                    iv_spa.setScaleX(1);
                    iv_spa.setScaleY(1);
                }
                else{
                    item.setChecked(true);
                    iv_chick.setScaleX(2);
                    iv_chick.setScaleY(2);
                    iv_spa.setScaleX(2);
                    iv_spa.setScaleY(2);
                }
                break;
            case R.id.chick:
                iv_chick.setVisibility(View.VISIBLE);
                iv_spa.setVisibility(View.GONE);
                iv_spa.setRotation(0);
                tv.setText("겁나 맛있는 치킨");
                item.setChecked(true);
                break;
            case R.id.spa:
                iv_chick.setVisibility(View.GONE);
                iv_spa.setVisibility(View.VISIBLE);
                iv_chick.setRotation(0);
                tv.setText("새콤한 스파게티");
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
