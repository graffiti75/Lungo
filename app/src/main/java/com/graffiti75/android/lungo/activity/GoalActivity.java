package com.graffiti75.android.lungo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.graffiti75.android.lungo.R;
import com.graffiti75.android.lungo.utils.ActivityUtils;

/**
 * GoalActivity.class.
 *
 * @author Rodrigo Cericatto
 * @since March 24, 2015
 */
public class GoalActivity extends Activity implements View.OnClickListener {

    //--------------------------------------------------
    // ATTRIBUTES
    //--------------------------------------------------

    private Button mUntilDayButton;
    private Button mFromDayButton;
    private Button mDayButton;
    private Button mMonthButton;
    private Button mYearButton;
    private Button mCreateGoalButton;

    //--------------------------------------------------
    // ACTIVITY LIFE CYCLE
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        createLayout();
    }

    //--------------------------------------------------
    // METHODS
    //--------------------------------------------------

    /**
     * Creates the layout.
     */
    public void createLayout() {
        mUntilDayButton = (Button)findViewById(R.id.id_until_day_button);
        mFromDayButton = (Button)findViewById(R.id.id_from_day_button);
        mDayButton = (Button)findViewById(R.id.id_day_button);
        mMonthButton = (Button)findViewById(R.id.id_month_button);
        mYearButton = (Button)findViewById(R.id.id_year_button);
        mCreateGoalButton = (Button)findViewById(R.id.id_create_goal_button);
        mCreateGoalButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_create_goal_button:
                ActivityUtils.openActivity(this, ViewPagerActivity.class);
                overridePendingTransition(R.anim.slide_up_from_outside, R.anim.slide_up_to_outside);
                break;
        }
    }
}