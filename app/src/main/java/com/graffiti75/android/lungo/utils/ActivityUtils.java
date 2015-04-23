package com.graffiti75.android.lungo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * ActivityUtils class.
 * 
 * @author Rodrigo Cericatto
 * @since Set 9, 2012
 */
public class ActivityUtils {
	
	/**
	 * Opens the specified activity.
	 * 
	 * @param context The context that will start the activity.
	 * @param activityClass The activity class to be started.
	 */
	public static void openActivity(Context context, final Class<? extends Activity> activityClass) {
		openActivity(context, activityClass, null);
	}
	
	/**
	 * Opens the specified activity clearing the activity stack.
	 * 
	 * @param context The context that will start the activity.
	 * @param activityClass The activity class to be started.
	 */
	public static void openActivityClearingStack(Context context, final Class<? extends Activity> activityClass) {
		openActivityClearingStack(context, activityClass, null);
	}
	
	/**
	 * Opens the specified activity.
	 * 
	 * @param context The context that will start the activity.
	 * @param activityClass The activity class to be started.
	 */
	public static void openActivityForResult(Context context, final Class<? extends Activity> activityClass) {
		Intent intent = new Intent(context, activityClass);
		((Activity)context).startActivityForResult(intent, 1);
	}
	
	/**
	 * Opens the specified activity.
	 * 
	 * @param context The context that will start the activity.
	 * @param activityClass The activity class to be started.
	 * @param extras A bundle containing any extras to be sent to the activity.
	 */
	public static void openActivity(Context context, final Class<? extends Activity> activityClass, final Bundle extras) {
		Intent intent = new Intent(context, activityClass);
		if (extras != null) intent.putExtras(extras);
		context.startActivity(intent);
	}
	
	/**
	 * Opens the specified activity.
	 * 
	 * @param context The context that will start the activity.
	 * @param activityClass The activity class to be started.
	 * @param extras A bundle containing any extras to be sent to the activity.
	 */
	public static void openActivityClearingStack(Context context, final Class<? extends Activity> activityClass, final Bundle extras) {
		Intent intent = new Intent(context, activityClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		if (extras != null) intent.putExtras(extras);
		context.startActivity(intent);
	}
}