package com.colabug.support;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
public class AnimationTestRunner extends RobolectricTestRunner
{

    public AnimationTestRunner( Class<?> testClass ) throws InitializationError
    {
        super( testClass );
    }

    public static void startFragment( Fragment fragment )
    {
        FragmentManager fragmentManager = new FragmentActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add( fragment, null );
        fragmentTransaction.commit();
    }

    public static String getResourceString( int resourceId )
    {
        return Robolectric.application.getApplicationContext().getString( resourceId );
    }

    public static Drawable getResourceDrawable( int resourceId )
    {
        return Robolectric.application.getApplicationContext().getResources().getDrawable( resourceId );
    }

    public static void assertViewIsVisible( View view )
    {
        assertNotNull( view );
        assertThat( view.getVisibility(), equalTo( View.VISIBLE ) );
    }
}
