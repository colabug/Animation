package com.colabug;

import android.view.View;
import android.widget.Button;
import com.colabug.support.AnimationTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.colabug.support.AnimationTestRunner.assertViewIsVisible;
import static com.colabug.support.AnimationTestRunner.getResourceString;
import static com.colabug.support.AnimationTestRunner.startFragment;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * {@link NewFragment} test suite.
 *
 * @since 1.0
 */
@RunWith (AnimationTestRunner.class)

public class NewFragmentTest
{
    private NewFragment newFragment;

    @Before
    public void setUp() throws Exception
    {
        newFragment = new NewFragment();
        startFragment( newFragment );
    }

    @Test
    public void shouldHaveButton() throws Exception
    {
        assertViewIsVisible( getViewById( R.id.back_to_animation_button ) );
    }

    @Test
    public void shouldHaveButtonText() throws Exception
    {
        Button button = (Button) getViewById( R.id.back_to_animation_button );
        assertThat( button.getText().toString(),
                    equalTo( getResourceString( R.string.GO_BACK_TEXT ) ) );
    }

    private View getViewById( int id )
    {
        return newFragment.getView().findViewById( id );
    }
}
