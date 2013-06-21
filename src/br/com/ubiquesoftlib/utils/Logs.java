package br.com.ubiquesoftlib.utils;

import android.util.Log;
import br.com.ubiquesoftlib.R;


public class Logs 
{
	public static <T> void LogError(Class<T> type, String e)
	{
		Log.i(type.getName(), new StringBuilder().append(R.string.error).append(e).toString());
	}
	
	public static void LogError(String tag, String e)
	{
		Log.i(tag, new StringBuilder().append(R.string.error).append(e).toString());
	}
}
