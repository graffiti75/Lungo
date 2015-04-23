package com.graffiti75.android.lungo.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graffiti75.android.lungo.R;

/**
 * StatisticsFragment.class.
 *
 * @author Rodrigo Cericatto
 * @since March 25, 2015
 */
public class StatisticsFragment extends Fragment {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------



	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public StatisticsFragment() {}

	//--------------------------------------------------
	// Fragments Life Cycle
	//--------------------------------------------------
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    }
}