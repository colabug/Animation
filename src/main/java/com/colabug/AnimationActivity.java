package com.colabug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ValueAnimator;

import static com.nineoldandroids.animation.ObjectAnimator.*;
import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class AnimationActivity extends Activity
{
    private View mainView;
    private View welcomeText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // View
        setContentView(R.layout.main);
        mainView = findViewById(R.id.main_view);
        welcomeText = findViewById(R.id.welcome_text);

        // TextView click
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performXYViewAnimation();
            }
        });

        animateBackground();
    }

    protected void performXYViewAnimation() {
        animate(welcomeText).setDuration(2000)
                            .rotationXBy(360)
                            .x(100)
                            .y(200);
    }

    protected void animateBackground() {
        ValueAnimator colorAnimation = ofInt(mainView,
                                             "backgroundColor",
                                             0xFFFF8080,
                                             0xFF8080FF);
        colorAnimation.setDuration(3000);
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.start();
    }
}
