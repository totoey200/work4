package com.example.lg.work4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class Var_Cal extends AppCompatActivity {

    EditText height, weight, area;
    Button bmi_cal, pts,stp;
    TextView bmi_result, area_result;
    LinearLayout area_layout, bmi_layout;
    TabHost tabHost;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var__cal);

        init();
    }

    void init(){
        tabHost = (TabHost)findViewById(R.id.tabhost);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        area = (EditText)findViewById(R.id.area);
        bmi_cal = (Button)findViewById(R.id.bmi_btn);
        pts = (Button) findViewById(R.id.pts);
        stp = (Button) findViewById(R.id.stp);
        bmi_result = (TextView) findViewById(R.id.bmi_result);
        area_result = (TextView) findViewById(R.id.area_result);
        area_layout = (LinearLayout) findViewById(R.id.area_layout);
        bmi_layout = (LinearLayout) findViewById(R.id.bmi_layout);
        frameLayout = (FrameLayout)findViewById(android.R.id.tabcontent);

        tab_init();
        setTitle("각종 계산기");
    }

    public void myClick(View view){
        if(view.getId()==R.id.bmi_btn){
            bmi_cal();
        }
        else if(view.getId()==R.id.pts){
            pts_cal();
        }
        else if(view.getId()==R.id.stp){
            stp_cal();
        }
    }

    void tab_init(){
        tabHost.setup();
        TabHost.TabSpec bmi_tab = tabHost.newTabSpec("bmi_layout").setIndicator("BMI 계산기").
                setContent(R.id.bmi_layout);
        TabHost.TabSpec area_tab = tabHost.newTabSpec("area_layout").setIndicator("면적 계산기").
                setContent(R.id.area_layout);
        tabHost.addTab(bmi_tab);
        tabHost.addTab(area_tab);
        tabHost.setCurrentTab(0);
        tab_control();
    }

    void tab_control(){
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                TabWidget tw = tabHost.getTabWidget();
                switch (tabId){
                    case "bmi_layout":
                        frameLayout.setBackgroundColor(Color.argb(255,255,243,42));
                        bmi_layout.setVisibility(View.VISIBLE);
                        area_layout.setVisibility(View.GONE);
                        break;
                    case "area_layout":
                        bmi_layout.setVisibility(View.GONE);
                        area_layout.setVisibility(View.VISIBLE);
                        frameLayout.setBackgroundColor(Color.argb(255,89,198,231));
                        break;
                }
            }
        });
    }
    void bmi_cal(){
        if(input_check(height)&&input_check(weight)){
            double height_num = convert(height);
            double weight_num = convert(weight);
            double result = weight_num/(height_num/100 * height_num/100);
            if(result<18.5){
                bmi_result.setText("체중부족입니다.");
                bmi_result.setTextColor(Color.rgb(245,177,43));
            }else if(result<23.0){
                bmi_result.setText("정상입니다.");
                bmi_result.setTextColor(Color.GREEN);
            }else if(result<25.0){
                bmi_result.setText("과체중입니다.");
                bmi_result.setTextColor(Color.rgb(245,177,43));
            }else{
                bmi_result.setText("비만입니다.");
                bmi_result.setTextColor(Color.RED);
            }
        }
    }
    void pts_cal(){
        if(input_check(area)){
            double result = convert(area);
            result *= 3.305785;
            area_result.setText(Double.toString(result)+" 제곱미터");
        }
    }
    void stp_cal(){
        if(input_check(area)){
            double result = convert(area);
            result *= 0.3025;
            area_result.setText(Double.toString(result)+" 평");
        }
    }
    boolean input_check(EditText view){
        String num = view.getText().toString();
        if(num.equals("")){
            return false;
        }
        else{
            view.requestFocus();
            bmi_result.setTextColor(Color.rgb(120,120,120));
            bmi_result.setText("값을 입력하세요");
            return true;
        }
    }
    double convert(EditText editText){
        String num = editText.getText().toString();
        return Double.parseDouble(num);
    }
}
