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
        welcomeText = findViewById(R.id.welcome_text);
        mainView = findViewById(R.id.main_view);

        // Animations
        animateView();
    }

    protected void animateView() {
        addEndlessColorAnimation();
        performXYViewAnimation();
    }

    private void performXYViewAnimation() {
        animate(welcomeText).setDuration(2000)
                            .rotationXBy(360)
                            .x(100)
                            .y(100);
    }

    private void addEndlessColorAnimation() {
        ValueAnimator colorAnim = ofInt(mainView,
                                        "backgroundColor",
                                        0xFFFF8080,
                                        0xFF8080FF);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
}
