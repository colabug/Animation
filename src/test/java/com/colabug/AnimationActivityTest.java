package com.colabug;

/**
 * {@link AnimationActivity} test suite.
 *
 * @since 1.0
 */

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    private TextView welcomeText;
    private ImageView sunEarthImage;

    @Before
    public void setUp() throws Exception {
        animationActivity = new TestAnimationActivity();
        animationActivity.onCreate(null);

        welcomeText = (TextView) animationActivity.findViewById(R.id.welcome_text);
        mainView = animationActivity.findViewById(R.id.main_view);
        sunEarthImage = (ImageView) animationActivity.findViewById(R.id.sun_earth_circle);
    }

    @Test
    public void shouldHaveWelcomeText() throws Exception {
        assertViewIsVisible(welcomeText);
    }

    @Test
    public void shouldHaveWelcomeTextString() throws Exception {
        assertThat(welcomeText.getText().toString(),
                   equalTo(getResourceString(R.string.welcome_string)));
    }

    @Test
    public void shouldAnimateBackgroundColor() throws Exception {
        assertTrue(animationActivity.backgroundWasAnimated);
    }

    @Test
    public void welcomeViewShouldAnimateWhenTouched() throws Exception {
        mainView.performClick();
        assertTrue(animationActivity.textViewWasAnimated);
    }

    @Test
    public void welcomeViewShouldVibrateWhenTouched() throws Exception {
        mainView.performClick();
        assertTrue(animationActivity.backgroundVibrated);
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
        protected boolean textViewWasAnimated = false;
        protected boolean backgroundVibrated = false;

        @Override
        protected void animateBackground() {
            backgroundWasAnimated = true;
        }

        @Override
        protected void performXYViewAnimation() {
            textViewWasAnimated = true;
        }

        @Override
        protected void vibrate() {
            backgroundVibrated = true;
        }
    }
}
