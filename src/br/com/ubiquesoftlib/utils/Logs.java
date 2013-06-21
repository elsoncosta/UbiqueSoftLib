package br.com.ubiquesoftlib.utils;

import android.util.Log;
import br.com.ubiquesoftlib.R;


public class Logs 
{
	public static <T> void LogError(Class<T> type, String e)
	{
		Log.e(type.getName(), new StringBuilder().append(R.string.error).append(e).toString());
	}
	
	public static void LogError(String tag, String e)
	{
		Log.e(tag, new StringBuilder().append(R.string.error).append(e).toString());
	}
}
