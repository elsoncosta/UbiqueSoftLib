package br.com.ubiquesoftlib.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;

public class OpenFile 
{
	public static String json(File file, Activity activity) 
	{
        StringBuilder json = new StringBuilder();
        try {             
            
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader ( fIn ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine();
            while ( readString != null) 
            {
                readString = buffreader.readLine();
            }

            isr.close ( ) ;

        } catch (IOException e) 
        {
        	Logs.LogError("OpenFile.Json", e.toString());
            return null;
        }
        return json.toString();
    }
}
