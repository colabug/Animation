package com.colabug;

/**
 * {@link AnimationActivity} test suite.
 *
 * @since 1.0
 */

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.colabug.support.AnimationTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.colabug.support.AnimationTestRunner.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AnimationTestRunner.class)

public class AnimationActivityTest {

    private TestAnimationActivity animationActivity;

    private View mainView;
    private ImageView sunEarthImage;

    @Before
    public void setUp() throws Exception {
        animationActivity = new TestAnimationActivity();
        animationActivity.onCreate(null);

        mainView = animationActivity.findViewById(R.id.main_view);
        sunEarthImage = (ImageView) animationActivity.findViewById(R.id.sun_earth_circle);
    }

    @Test
    public void shouldAnimateBackgroundColor() throws Exception {
        assertTrue(animationActivity.backgroundWasAnimated);
    }

    @Test
    public void sunEarthViewShouldAnimateWhenTouched() throws Exception {
        sunEarthImage.performClick();
        assertTrue(animationActivity.sunEarthWasRotated);
    }

    @Test
    public void sunEarthViewShouldVibrateWhenTouched() throws Exception {
        sunEarthImage.performClick();
        assertTrue(animationActivity.vibrationOccurred);
    }

    @Test
    public void shouldHaveImage() throws Exception {
        assertViewIsVisible(sunEarthImage);
    }

    @Test
    public void shouldHaveSunEarthImage() throws Exception {
        Drawable drawable = sunEarthImage.getDrawable();
        assertThat(drawable, equalTo(getResourceDrawable(R.drawable.sun_earth)));
    }

    class TestAnimationActivity extends AnimationActivity {
        protected boolean backgroundWasAnimated = false;
        protected boolean sunEarthWasRotated = false;
        protected boolean vibrationOccurred = false;

        @Override
        protected void animateBackground() {
            backgroundWasAnimated = true;
        }

        @Override
        protected void rotateView(View view) {
            sunEarthWasRotated = true;
        }

        @Override
        protected void vibrate() {
            vibrationOccurred = true;
        }
    }
}
