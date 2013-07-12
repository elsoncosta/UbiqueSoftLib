package br.com.ubiquesoftlib.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;

public class OpenFile 
{
	public static String json(File file, Activity activity) 
	{
        String json = null;
        try {

            InputStream is =  activity.getResources().getAssets().open(file.getAbsolutePath());

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e) 
        {
        	Logs.LogError("OpenFile.Json", e.toString());
            return null;
        }
        return json;
    }
}
