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
public class ControlFragment extends Fragment implements View.OnClickListener {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	
	private TextView mSmokedCigarettesTextView;
    private TextView mSmokingNowTextView;
    private Integer mCounter = 0;

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
        mSmokingNowTextView.setOnClickListener(this);
    }

	/**
	 * Sets fonts of all view components.
	 */
	public void setFonts() {
		Typeface gothamBook = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MYRIADPRO-REGULAR.OTF");
        mSmokedCigarettesTextView.setTypeface(gothamBook);
        mSmokingNowTextView.setTypeface(gothamBook);
	}

    /**
     * Changes the color of the mSmokingNowTextView.
     */
    public void changeColor() {
        Integer mod = mCounter % 8;

        switch (mod) {
            case 0:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_green_behavior));
                break;
            case 1:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_yellow_light_behavior));
                break;
            case 2:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_yellow_behavior));
                break;
            case 3:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_orange_light_behavior));
                break;
            case 4:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_orange_behavior));
                break;
            case 5:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_carrot_behavior));
                break;
            case 6:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_red_dark_behavior));
                break;
            case 7:
                mSmokingNowTextView.setBackground(getActivity().getDrawable(R.drawable.rounded_button_red_behavior));
                break;
        }
    }

    //--------------------------------------------------
    // Listeners
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        mCounter++;

        // Formats value.
        String value = mCounter.toString();
        if (mCounter < 10) {
            value = "0" + value;
        }

        // Change its value.
        mSmokedCigarettesTextView.setText(value);
        changeColor();
    }
}