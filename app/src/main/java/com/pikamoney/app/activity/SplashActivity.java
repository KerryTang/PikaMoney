/* Created by wei-shang on 2014/10/31.*/

package com.pikamoney.app.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.pikamoney.app.R;


public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 1100;
    private View mContentView;
    private int  mShortAnimationDuration;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContentView = findViewById(R.id.splash_logo);
        mContentView.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
        crossfade();

    }

    private void crossfade(){
        mContentView.setAlpha(0);
        mContentView.setVisibility(View.VISIBLE);
        mContentView.animate().alpha(1f).setDuration(mShortAnimationDuration).setListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mContentView.animate().alpha(0f).setDuration(mShortAnimationDuration).setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }, SPLASH_TIME_OUT);
            }

        });
    }
}
