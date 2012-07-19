package com.colabug;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ValueAnimator;

import static com.nineoldandroids.animation.ObjectAnimator.*;
import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class AnimationActivity extends Activity
{
    // Animation constants
    public static final int FULL_CIRCLE = 360;
    public static final int RED = 0xFFFF8080;
    public static final int BLUE = 0xFF8080FF;
    public static final int ANIMATION_DURATION = 2000;
    public static final int HAPTIC_DURATION_IN_MILLISECONDS = 50;
    public static final String BACKGROUND_COLOR_PROPERTY = "backgroundColor";

    // View
    private View mainView;
    private View sunEarthCircle;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // View
        setContentView(R.layout.main);
        mainView = findViewById(R.id.main_view);
        sunEarthCircle = findViewById(R.id.sun_earth_circle);

        // TextView click
        sunEarthCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateView(sunEarthCircle);
                vibrate();
            }
        });

        animateBackground();
    }

    protected void vibrate() {
        Vibrator v = (Vibrator) this.getSystemService(Service.VIBRATOR_SERVICE);
        v.vibrate(HAPTIC_DURATION_IN_MILLISECONDS);
    }

    protected void rotateView(View view) {
        animate(view).setDuration(ANIMATION_DURATION).rotation(FULL_CIRCLE);
    }

    protected void animateBackground() {
        ValueAnimator colorAnimation = ofInt(mainView,
                                             BACKGROUND_COLOR_PROPERTY,
                                             RED,
                                             BLUE);
        colorAnimation.setDuration(ANIMATION_DURATION);
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.start();
    }
}
