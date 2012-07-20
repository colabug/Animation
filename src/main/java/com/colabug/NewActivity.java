package com.colabug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Activity with one button.
 *
 * @since 1.0
 */
public class NewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        View button = findViewById(R.id.back_to_animation_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, NewActivity.class);
    }
}
