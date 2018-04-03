package com.example.admin.ch6_3_3;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
//implement 將介面和實作分開
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleBtn) ;
        //註冊傾聽者物件為自己
        //toggle.setOnCheckedChangeListener(this); //this是MainActivity物件自己
        toggle.setOnCheckedChangeListener(listener);

        Button btn_c = (Button) findViewById(R.id.btn_c);
        btn_c.setOnClickListener(listener1);
    }
    //實作介面的方法
    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener(){
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //畫面變橫向
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //畫面變直向
            }
        }
    };

    View.OnClickListener listener1 = new View.OnClickListener(){
        public void  onClick(View v){
            double height, weight, bmi; //宣告double變數
            //取得輸入值
            EditText edt_h = (EditText) findViewById(R.id.edt_h);
            EditText edt_w = (EditText) findViewById(R.id.edt_w);
            height = Double.parseDouble(edt_h.getText().toString());
            weight = Double.parseDouble(edt_w.getText().toString());

            //計算BMI值
            height = height / 100.00;
            bmi = weight / (height*height);

            //顯示BMI
            TextView output = (TextView) findViewById(R.id.txv_result);
            output.setText(Double.toString(bmi));
        }
    };


}
