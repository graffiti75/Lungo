package com.graffiti75.android.lungo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.graffiti75.android.lungo.R;
import com.graffiti75.android.lungo.utils.ActivityUtils;
import com.graffiti75.android.lungo.utils.DateHelper;
import com.graffiti75.android.lungo.utils.DatePickerListener;
import com.graffiti75.android.lungo.utils.DialogHelper;

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
        // Initialize main components.
        mUntilDayButton = (Button)findViewById(R.id.id_until_day_button);
        mUntilDayButton.setOnClickListener(this);
        mFromDayButton = (Button)findViewById(R.id.id_from_day_button);
        mFromDayButton.setOnClickListener(this);

        // Other buttons.
        Integer[] date = DateHelper.getCurrentFormattedDate();

        mDayButton = (Button)findViewById(R.id.id_day_button);
        mDayButton.setOnClickListener(this);
        mDayButton.setText(Integer.toString(date[0]));

        mMonthButton = (Button)findViewById(R.id.id_month_button);
        mMonthButton.setOnClickListener(this);
        mMonthButton.setText(DateHelper.getMonthInString(date[1]));

        mYearButton = (Button)findViewById(R.id.id_year_button);
        mYearButton.setOnClickListener(this);
        mYearButton.setText(Integer.toString(date[2]));

        mCreateGoalButton = (Button)findViewById(R.id.id_create_goal_button);
        mCreateGoalButton.setOnClickListener(this);

        // Set default behavior.
        setColorUntilDay(true);
    }

    /**
     * If is true, we have the default pattern. Else, we change the colors.
     *
     * @param value
     */
    public void setColorUntilDay(Boolean value) {
        if (value) {
            mUntilDayButton.setBackground(getDrawable(R.color.lungo_green));
            mUntilDayButton.setTextColor(getResources().getColor(R.color.lungo_white));

            mFromDayButton.setBackground(getDrawable(R.color.lungo_white));
            mFromDayButton.setTextColor(getResources().getColor(android.R.color.black));
        } else {
            mUntilDayButton.setBackground(getDrawable(R.color.lungo_white));
            mUntilDayButton.setTextColor(getResources().getColor(android.R.color.black));

            mFromDayButton.setBackground(getDrawable(R.color.lungo_green));
            mFromDayButton.setTextColor(getResources().getColor(R.color.lungo_white));
        }
    }

    @Override
    public void onClick(View view) {
        Integer day = Integer.valueOf(mDayButton.getText().toString());
        Integer month = DateHelper.getMonth(mMonthButton.getText().toString());
        Integer year = Integer.valueOf(mYearButton.getText().toString());

        switch (view.getId()) {
            case R.id.id_create_goal_button:
                ActivityUtils.openActivity(this, ViewPagerActivity.class);
                overridePendingTransition(R.anim.slide_up_from_outside, R.anim.slide_up_to_outside);
                break;
            case R.id.id_until_day_button:
                setColorUntilDay(true);
                break;
            case R.id.id_from_day_button:
                setColorUntilDay(false);
                break;
            case R.id.id_day_button:
                DialogHelper.showDatePickerDialog(this, new DatePickerListener(mDayButton, mMonthButton, mYearButton), day, month, year);
                break;
            case R.id.id_month_button:
                DialogHelper.showDatePickerDialog(this, new DatePickerListener(mDayButton, mMonthButton, mYearButton), day, month, year);
                break;
            case R.id.id_year_button:
                DialogHelper.showDatePickerDialog(this, new DatePickerListener(mDayButton, mMonthButton, mYearButton), day, month, year);
                break;
        }
    }
}