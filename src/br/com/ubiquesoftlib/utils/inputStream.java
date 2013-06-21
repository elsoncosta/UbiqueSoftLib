package br.com.ubiquesoftlib.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.util.Log;
import br.com.ubiquesoftlib.R;

/**
 * @author Elson Costa
 *	
 */
public class inputStream 
{
	
	public byte[] getBytes(InputStream is) 
	{
		try 
		{
			int bytesLidos;
			ByteArrayOutputStream bigBuffer = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];

			while ((bytesLidos = is.read(buffer)) > 0)
			{
				bigBuffer.write(buffer, 0, bytesLidos);
			}
			
			Log.i(getClass().getName(), bigBuffer.toString());
			
			return bigBuffer.toByteArray();
		} catch (Exception e) 
		{
			e.printStackTrace();
			Log.i(getClass().getName(), new StringBuilder().append(R.string.error).append(e.getMessage()).toString());
		}
		return null;
	}
}
