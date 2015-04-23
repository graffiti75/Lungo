package com.graffiti75.android.lungo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.graffiti75.android.lungo.R;

/**
 * GoalActivity.class.
 *
 * @author Rodrigo Cericatto
 * @since March 24, 2015
 */
public class GoalActivity extends Activity {

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
    }

    //--------------------------------------------------
    // MENU METHODS
    //--------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
