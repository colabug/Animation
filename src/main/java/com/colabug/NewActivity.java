package com.colabug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Activity with one button.
 *
 * @since 1.0
 */
public class NewActivity extends Activity {
    public static Intent createIntent(Context context) {
        return new Intent(context, NewActivity.class);
    }
}
