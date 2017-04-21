package com.example.leishun.viewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
    }

    public void test(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_in));
    }
}
