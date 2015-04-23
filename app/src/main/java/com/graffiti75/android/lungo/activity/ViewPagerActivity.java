package com.graffiti75.android.lungo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.graffiti75.android.lungo.R;
import com.graffiti75.android.lungo.fragment.ControlFragment;
import com.graffiti75.android.lungo.fragment.StatisticsFragment;

/**
 * ViewPagerActivity.class.
 *
 * @author Rodrigo Cericatto
 * @since March 25, 2015
 */
public class ViewPagerActivity extends FragmentActivity {

    //--------------------------------------------------
    // CONSTANTS
    //--------------------------------------------------

    public static final int NUM_ITEMS = 2;

    //--------------------------------------------------
    // ATTRIBUTES
    //--------------------------------------------------

    private LungoPagerAdapter mPagesAdapter;
    private ViewPager mViewPager;

    //--------------------------------------------------
    // ACTIVITY LIFE CYCLE
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        setViewPager();
    }

    //--------------------------------------------------
    // METHODS
    //--------------------------------------------------

    public void setViewPager() {
        mPagesAdapter = new LungoPagerAdapter(this, getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.id_view_pager);
        mViewPager.setAdapter(mPagesAdapter);
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