package br.com.ubiquesoftlib.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
			Log.i(getClass().getName(), "Iniciado");
		
			int bytesLidos;
			ByteArrayOutputStream bigBuffer = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];

			while ((bytesLidos = is.read(buffer)) > 0)
			{
				bigBuffer.write(buffer, 0, bytesLidos);
			}
			
			Log.i(getClass().getName(), "Finalizado com sucesso");
			
			return bigBuffer.toByteArray();
		} catch (Exception e) 
		{
			Log.i(getClass().getName(), new StringBuilder().append(R.string.error).append(e.getMessage()).toString());
		}
		return null;
	}
	
	public String InputStream(InputStream inputStream)
	{		
		Log.i(getClass().getName(), "Iniciado");
		
		try
		{			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);			
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder stringBuilder = new StringBuilder();

			String bufferedStrChunk = null;
			
			Log.i(getClass().getName(), "Iniciado while");

			while((bufferedStrChunk = bufferedReader.readLine()) != null)
			{
				stringBuilder.append(bufferedStrChunk);
			}
			
			Log.i(getClass().getName(), "Finalizado com sucesso");
			
			return stringBuilder.toString();			
        }
        catch (IOException e) {
        	Logs.LogError(getClass().getName(), e.getMessage());
		}
		
		return null;
	}
}
