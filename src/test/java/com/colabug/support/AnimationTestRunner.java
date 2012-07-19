package com.colabug.support;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import org.junit.runners.model.InitializationError;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Custom unit test runner.
 *
 * @since 1.0
 */
public class AnimationTestRunner extends RobolectricTestRunner {

    public AnimationTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    public static String getResourceString(int resourceId) {
        return Robolectric.application.getApplicationContext().getString(resourceId);
    }

    public static void assertViewIsVisible(View view) {
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.VISIBLE));
    }
}
