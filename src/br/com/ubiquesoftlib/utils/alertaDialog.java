package br.com.ubiquesoftlib.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import br.com.ubiquesoftlib.R;

public class alertaDialog 
{
	static String TAG = "alertaDialog";
	
	public static void message(final Context context, int message) {
		try 
		{
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			
			dialog.setTitle(context.getString(R.string.app_name));
			dialog.setMessage(message);
			
			dialog.setPositiveButton("Ok", new OnClickListener() 			
			{
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					dialog.dismiss();
				}
			});			
			dialog.create().show();
			
		} catch (Exception e) 
		{
			Log.e(TAG, e.getMessage(), e);
		}
	}
	
	public static void message(final Context context, String message) {
		try 
		{
			AlertDialog.Builder dialog = new AlertDialog.Builder(context);
			
			dialog.setTitle(context.getString(R.string.app_name));
			dialog.setMessage(message);
			
			dialog.setPositiveButton("Ok", new OnClickListener() 			
			{
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					dialog.dismiss();
				}
			});			
			dialog.create().show();
			
		} catch (Exception e) 
		{
			Log.e(TAG, e.getMessage(), e);
		}
	}
	
	public static void ifnor(Context context, String message)
	{
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		//TITULO DA MENSAGEM
		alertDialog.setTitle("Information");
		//MENSAGEM
		alertDialog.setMessage(message);
		//ICONE DA MENSAGEM
		//alertDialog.setIcon(drawable.infor);
		
		alertDialog.show();
		
	}
}
