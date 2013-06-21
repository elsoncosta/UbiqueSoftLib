package br.com.ubiquesoftlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

public class orientation 
{
	// Check what the screen orientation
	public static int getOrientation(Context context) 
	{
		int orientation = context.getResources().getConfiguration().orientation;
		return orientation;
	}

	// Checks if the screen orientation is vertical
	public static boolean isVertical(Context context) 
	{
		int orientation = context.getResources().getConfiguration().orientation;
		boolean vertical = orientation == Configuration.ORIENTATION_PORTRAIT;
		return vertical;
	}

	// Checks if the screen orientation is horizontal
	public static boolean isHorizontal(Context context) 
	{
		int orientation = context.getResources().getConfiguration().orientation;
		boolean horizontal = orientation == Configuration.ORIENTATION_LANDSCAPE;
		return horizontal;
	}

	// Calls to perform the activity in the vertical
	public static void setOrientationVertical(Activity context) 
	{
		context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	// Calls to perform the activity in the horizontal
	public static void setOrientationHorizontal(Activity context) 
	{
		context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
	
	//Checks if the screen orientation is horizontal tablet
	public static boolean isHorizontalTablet(Context context)
	{	
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE
				& context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
	}
	
	// Lock orientation
	public static void LockOrientation(Activity activity)
	{
		int currentOrientation = activity.getResources().getConfiguration().orientation;

		if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) 
		{
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
		} 
		else 
		{
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
		}
	}
	
	// Unlock orientation
	public static void unlockOrientation(Activity activity)
	{
		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
	}

}
