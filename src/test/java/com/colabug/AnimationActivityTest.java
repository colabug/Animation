package com.colabug;

/**
 * {@link AnimationActivity} test suite.
 *
 * @since 1.0
 */

import android.widget.TextView;

import com.colabug.support.AnimationTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.colabug.support.AnimationTestRunner.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AnimationTestRunner.class)

public class AnimationActivityTest {

    private TextView welcomeText;

    @Before
    public void setUp() throws Exception {
        AnimationActivity animationActivity = new AnimationActivity();
        animationActivity.onCreate(null);
        welcomeText = (TextView) animationActivity.findViewById(R.id.welcome_text);
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
}
