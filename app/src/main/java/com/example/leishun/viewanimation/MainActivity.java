package com.example.leishun.viewanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;

/**
 * Interpolators:插值器，调节动画的快慢
 * Accelerate –视图逐渐加速直到动画结束；
 * Decelerate –视图逐渐减速直到动画结束；
 * Anticipate –在以标准方式开始动画之前，视图先进行轻微反转；
 * Anticipate-Overshoot –与 Anticipate 类似，但动画过程中，回拉动作更为夸张；
 * BounceInterpolator – 视图动画结束之前会有‘反弹’效果；
 * LinearInterpolator – 视图以线型平滑的动画开始，直到结束；
 * OvershootInterpolator – 视图动画先放大给定值，再缩回原值。
 */
public class MainActivity extends AppCompatActivity {

    private FloatingActionButton FloatingButton;
    private Intent intent;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        mContext = this;

        FloatingButton = (FloatingActionButton) this.findViewById(R.id.FloatingButton);
        FloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareAnimation(FloatingButton);
                //Snackbar.make(v, "😯", Snackbar.LENGTH_SHORT).show();
            }
        });

        //跳转
        intent = new Intent(mContext, TestActivity.class);
    }

    //透明值动画
    public void animationAlpha(View view) {
        FloatingButton.animate().alpha(0.5f).setDuration(1000).setInterpolator(new FastOutSlowInInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                animator.setupStartValues();
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.setDuration(1000);
                animator.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        }).start();
    }

    //缩放动画
    public void animationScale(View view) {
        FloatingButton.animate()
                .scaleX(2f)
                .setDuration(2000)
                .scaleY(2f)
                .setInterpolator(new LinearInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        animation.setupStartValues();
                        animation.start();
                    }
                });
    }

    //平移动画
    public void animationTranslate(View view) {
        FloatingButton.animate()
                .translationY(200f)
                .setDuration(2000)
                .setInterpolator(new LinearInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        animation.setupStartValues();
                        animation.start();
                    }
                });
    }

    //旋转动画
    public void animationRotate(View view) {
        FloatingButton.animate()
                .rotation(180)
                .setDuration(2000)
                .setInterpolator(new LinearInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        animation.setupStartValues();
                        animation.start();
                    }
                });
    }

    //object属性动画
    public void objectAnimator(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(FloatingButton, "scaleX", 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(FloatingButton, "scaleY", 2f);
        scaleX.setDuration(2000);
        scaleY.setDuration(2000);
        scaleX.setInterpolator(new LinearOutSlowInInterpolator());
        scaleY.setInterpolator(new LinearOutSlowInInterpolator());
        scaleX.start();
        scaleY.start();
    }

    //爆炸效果
    public void ExplodeAnimator(View view) {
        Explode explode = new Explode();
        explode.setDuration(1500);
        getWindow().setReenterTransition(explode);
        intent.putExtra("transition", 0);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    //平移跳转
    public void SlideAnimator(View view) {
        Slide slide = new Slide();
        slide.setDuration(1500);
        slide.setSlideEdge(Gravity.TOP);
        getWindow().setReenterTransition(slide);
        intent.putExtra("transition", 1);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    //淡入淡出
    public void FadeAnimator(View view) {
        Fade fade = new Fade();
        fade.setDuration(1500);
        getWindow().setReenterTransition(fade);
        intent.putExtra("transition", 2);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    //共享元素
    public void shareAnimation(View view) {
        ActivityOptionsCompat transitionActivityOptions =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        mContext, view, getResources().getString(R.string.transition));

        ActivityCompat.startActivity(mContext,
                intent, transitionActivityOptions.toBundle());
    }
}
