package com.example.admin.ch6_3_3;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
//implement 將介面和實作分開
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleBtn) ;
        //註冊傾聽者物件為自己
        toggle.setOnCheckedChangeListener(this); //this是MainActivity物件自己
    }
    //實作介面的方法
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if (isChecked)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //畫面變橫向
        else
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //畫面變直向
    }

}
