package com.graffiti75.android.lungo.utils;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * Updates the text view after the DatePickerDialog be used.
 * 
 * @author Rodrigo Cericatto
 * @since Aug 6, 2012
 */
public class DatePickerListener implements OnDateSetListener {
	
	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private Button mDayButton;
    private Button mMonthButton;
    private Button mYearButton;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	
	public DatePickerListener(Button day, Button month, Button year) {
        mDayButton = day;
        mMonthButton = month;
        mYearButton = year;
	}
	
	//--------------------------------------------------
	// Listener
	//--------------------------------------------------
	
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mDayButton.setText(DateHelper.formatDateTerm(dayOfMonth, true));
        mMonthButton.setText(DateHelper.getMonthInString(monthOfYear + 1));
        mYearButton.setText(DateHelper.formatDateTerm(year, false));
	}
}