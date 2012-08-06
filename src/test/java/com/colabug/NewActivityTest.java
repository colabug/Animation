package com.colabug;

import com.colabug.support.AnimationTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * {@link NewActivity} test suite.
 *
 * @since 1.0
 */
@RunWith (AnimationTestRunner.class)

public class NewActivityTest
{
    private NewActivity newActivity;

    @Before
    public void setUp() throws Exception
    {
        newActivity = new NewActivity();
        newActivity.onCreate( null );
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( newActivity );
    }

    @Test
    public void shouldHaveNewFragment() throws Exception
    {
        assertNotNull( newActivity.getSupportFragmentManager().findFragmentById( R.id.new_fragment ) );
    }
}
