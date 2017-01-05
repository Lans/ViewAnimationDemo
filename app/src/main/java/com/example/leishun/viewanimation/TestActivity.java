package com.example.leishun.viewanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TestActivity extends AppCompatActivity {

    private ImageView top_img = null;
    private TestActivity mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int transition = extras.getInt("transition");
            switch (transition) {
                case 0:
                    ExplodeAnimator();
                    break;
                case 1:
                    SlideAnimator();
                    break;
                case 2:
                    FadeAnimator();
                    break;
                default:
                    FadeAnimator();
                    break;
            }
        }


        top_img = (ImageView) this.findViewById(R.id.top_img);
        Glide.with(mContext).load(R.drawable.mv).asBitmap().into(top_img);
    }

    public void ExplodeAnimator() {
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setEnterTransition(explode);
    }

    public void SlideAnimator() {
        Slide slide = new Slide();
        slide.setDuration(1500);
        getWindow().setEnterTransition(slide);
    }

    public void FadeAnimator() {
        Fade fade = new Fade();
        fade.setDuration(1500);
        getWindow().setEnterTransition(fade);
    }
}
