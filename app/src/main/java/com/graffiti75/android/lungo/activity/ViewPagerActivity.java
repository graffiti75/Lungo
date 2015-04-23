package com.graffiti75.android.lungo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.graffiti75.android.lungo.R;
import com.graffiti75.android.lungo.fragment.ControlFragment;
import com.graffiti75.android.lungo.fragment.StatisticsFragment;

/**
 * ViewPagerActivity.class.
 *
 * @author Rodrigo Cericatto
 * @since March 25, 2015
 */
public class ViewPagerActivity extends FragmentActivity implements View.OnClickListener {

    //--------------------------------------------------
    // CONSTANTS
    //--------------------------------------------------

    public static final int NUM_ITEMS = 2;

    //--------------------------------------------------
    // ATTRIBUTES
    //--------------------------------------------------

    private LungoPagerAdapter mPagesAdapter;
    private ViewPager mViewPager;

    private TextView mControlTitleTextView;
    private TextView mStatisticsTitleTextView;
    private ImageView mControlLineImageView;
    private ImageView mStatisticsLineImageView;

    //--------------------------------------------------
    // ACTIVITY LIFE CYCLE
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        setLayout();
        setViewPager();
    }

    //--------------------------------------------------
    // METHODS
    //--------------------------------------------------

    /**
     * Sets the {@link ViewPager}.
     */
    public void setViewPager() {
        mPagesAdapter = new LungoPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagesAdapter);

        // Attach the page change listener inside the activity.
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mControlLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                        mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_green));
                        break;
                    case 1:
                        mControlLineImageView.setBackground(getDrawable(R.color.lungo_green));
                        mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                        break;
                }
            }

            // This method will be invoked when the current page is scrolled.
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here.
            }

            // Called when the scroll state changes: SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING.
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here.
            }
        });
    }

    /**
     * Sets the view components.
     */
    public void setLayout() {
        // Layout components.
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);
        mControlTitleTextView = (TextView) findViewById(R.id.id_control_title_text_view);
        mControlTitleTextView.setOnClickListener(this);
        mStatisticsTitleTextView = (TextView) findViewById(R.id.id_statistics_title_text_view);
        mStatisticsTitleTextView.setOnClickListener(this);
        mControlLineImageView = (ImageView) findViewById(R.id.id_control_line_image_view);
        mControlLineImageView.setOnClickListener(this);
        mStatisticsLineImageView = (ImageView) findViewById(R.id.id_statistics_line_image_view);
        mStatisticsLineImageView.setOnClickListener(this);

        // Sets the default line.
        mControlLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
        mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_green));
    }

    //--------------------------------------------------
    // Listeners
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_control_title_text_view:
                mViewPager.setCurrentItem(0);
                mControlLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_green));
                break;
            case R.id.id_statistics_title_text_view:
                mViewPager.setCurrentItem(1);
                mControlLineImageView.setBackground(getDrawable(R.color.lungo_green));
                mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                break;
            case R.id.id_control_line_image_view:
                mViewPager.setCurrentItem(0);
                mControlLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_green));
                break;
            case R.id.id_statistics_line_image_view:
                mViewPager.setCurrentItem(1);
                mControlLineImageView.setBackground(getDrawable(R.color.lungo_green));
                mStatisticsLineImageView.setBackground(getDrawable(R.color.lungo_blue_dark));
                break;
        }
    }

    //--------------------------------------------------
    // Pager Adapter
    //--------------------------------------------------

    public class LungoPagerAdapter extends FragmentPagerAdapter {
        private Context mContext;

        public LungoPagerAdapter(Context context, FragmentManager fragmentManager) {
            super(fragmentManager);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = Fragment.instantiate(mContext, ControlFragment.class.getName());
                    break;
                case 1:
                    fragment = Fragment.instantiate(mContext, StatisticsFragment.class.getName());
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}