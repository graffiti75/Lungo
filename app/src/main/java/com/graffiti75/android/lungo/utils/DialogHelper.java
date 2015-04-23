package com.graffiti75.android.lungo.utils;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;

/**
 * DialogHelper class.
 * 
 * @author Rodrigo Cericatto
 * @since Oct 2, 2013
 */
public class DialogHelper {

	//--------------------------------------------------
	// Methods
	//--------------------------------------------------
	
	/**
	 * Calls a date picker dialog.
	 * 
	 * @param context
	 * @param listener
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static DatePickerDialog showDatePickerDialog(Context context, OnDateSetListener listener, int year, int month, int day) {
		DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, year, month - 1, day);
		datePickerDialog.show();
		
		return datePickerDialog;
	}
}