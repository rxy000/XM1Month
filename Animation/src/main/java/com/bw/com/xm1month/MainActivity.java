package com.bw.com.xm1month;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_1 = findViewById(R.id.text_1);
        //透明
        findViewById(R.id.btn_tm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_1, "alpha", 1f, 0f, 1f);
                animator.setDuration(5000);
                animator.start();
            }
        });
        //旋转动画
        findViewById(R.id.btn_xz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_1, "rotation", 0f, 360f);
                animator.setDuration(5000);
                animator.start();
            }
        });
        //平移动画
        findViewById(R.id.btn_py).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float curTranslationX = text_1.getTranslationX();
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_1, "translationX", curTranslationX, -500f, curTranslationX);
                animator.setDuration(5000);
                animator.start();
            }
        });
        //缩放动画
        findViewById(R.id.btn_sf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(text_1, "scaleY", 1f, 3f, 1f);
                animator.setDuration(5000);
                animator.start();
            }
        });
        //组合动画
        findViewById(R.id.btn_zh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(text_1, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(text_1, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(text_1, "alpha", 1f, 0f, 1f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(rotate).with(fadeInOut).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
            }
        });
    }
}
