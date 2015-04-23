package com.graffiti75.android.lungo.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.graffiti75.android.lungo.R;

/**
 * ControlFragment.class.
 *
 * @author Rodrigo Cericatto
 * @since March 25, 2015
 */
public class ControlFragment extends Fragment {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	
	private TextView mSmokedCigarettesTextView;
    private TextView mSmokingNowTextView;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	
	public ControlFragment() {}

	//--------------------------------------------------
	// Fragments Life Cycle
	//--------------------------------------------------
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control, container, false);
        setLayout(view);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	setFonts();
    }
    
	//--------------------------------------------------
	// Methods
	//--------------------------------------------------

    public void setLayout(View view) {
        mSmokedCigarettesTextView = (TextView)view.findViewById(R.id.id_smoked_cigarettes_text_view);
        mSmokingNowTextView = (TextView)view.findViewById(R.id.id_smoking_now_text_view);
    }

	/**
	 * Sets fonts of all view components.
	 */
	public void setFonts() {
		Typeface gothamBook = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MYRIADPRO-REGULAR.OTF");
        mSmokedCigarettesTextView.setTypeface(gothamBook);
        mSmokingNowTextView.setTypeface(gothamBook);
	}
}