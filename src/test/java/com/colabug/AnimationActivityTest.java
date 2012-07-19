package com.colabug;

/**
 * {@link AnimationActivity} test suite.
 *
 * @since 1.0
 */

import android.view.View;
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

    private TextView welcomeText;
    private TestAnimationActivity animationActivity;
    private View mainView;

    @Before
    public void setUp() throws Exception {
        animationActivity = new TestAnimationActivity();
        animationActivity.onCreate(null);
        welcomeText = (TextView) animationActivity.findViewById(R.id.welcome_text);
        mainView = animationActivity.findViewById(R.id.main_view);
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

    class TestAnimationActivity extends AnimationActivity {
        protected boolean backgroundWasAnimated = false;
        protected boolean textViewWasAnimated = false;

        @Override
        protected void animateBackground() {
            backgroundWasAnimated = true;
        }

        @Override
        protected void performXYViewAnimation() {
            textViewWasAnimated = true;
        }
    }
}
