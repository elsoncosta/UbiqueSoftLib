package br.com.ubiquesoftlib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class network 
{
	public static boolean isConected(Context context) 
	{
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) 
		{
			return false;
		} 
		else 
		{
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) 
			{
				for (int i = 0; i < info.length; i++) 
				{
					if (info[i].getState() == NetworkInfo.State.CONNECTED) 
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
