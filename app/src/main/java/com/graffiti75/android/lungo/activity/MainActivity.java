package com.graffiti75.android.lungo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.graffiti75.android.lungo.R;
import com.graffiti75.android.lungo.utils.ActivityUtils;

/**
 * MainActivity.class.
 *
 * @author Rodrigo Cericatto
 * @since March 25, 2015
 */
public class MainActivity extends Activity implements View.OnClickListener {

    //--------------------------------------------------
    // ATTRIBUTES
    //--------------------------------------------------

    private Button mStartButton;

    //--------------------------------------------------
    // ACTIVITY LIFE CYCLE
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createLayout();
    }

    //--------------------------------------------------
    // METHODS
    //--------------------------------------------------

    /**
     * Creates the layout.
     */
    public void createLayout() {
        mStartButton = (Button)findViewById(R.id.id_start_button);
        mStartButton.setOnClickListener(this);
    }

    //--------------------------------------------------
    // LISTENERS
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        ActivityUtils.openActivity(this, GoalActivity.class);
        overridePendingTransition(R.anim.slide_up_from_outside, R.anim.slide_up_to_outside);
    }
}