package com.example.leishun.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
    }

    public void test(View view) {
        finish();
        overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
    }
}
