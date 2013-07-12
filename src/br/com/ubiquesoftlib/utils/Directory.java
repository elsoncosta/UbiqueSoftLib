package br.com.ubiquesoftlib.utils;

import java.io.File;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class Directory 
{
	public static boolean DiretoryExistInternal(Context context, String path)
    {       
       try 
       {
    	   String dr = context.getFilesDir().getAbsolutePath();
           
           File file = new File(dr, path);
           
           Log.i("DiretoryExist", file.getAbsolutePath());
           
           if (!file.exists()) 
           {
        	   return file.mkdirs();
           }
		
		} catch (Exception e) 
		{
			Logs.LogError("DiretoryExist", e.toString());
			return false;
		}
       
       return false;
    }
	
	 	
	public static String DiretoryExistExternal(Context activity, String path)
    {
		File file = null;
		
		try 
		{			
	        // creat path in sdcard
	        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) 
	        {
	            path = new StringBuilder().append(activity.getApplicationInfo().loadLabel(activity.getPackageManager()).toString()).append("/").append(path).toString();
	            file = new File(Environment.getExternalStorageDirectory(), path);
	        } else 
	        {
	        	file = activity.getCacheDir();
	        }
	        
	        Log.i("DiretoryExist", file.getAbsolutePath());
	        
	        if (!file.exists()) 
	        {
	        	//on create
	        	file.mkdirs();
	        }
	        
		} catch (Exception e) 
		{
			Logs.LogError("DiretoryExistExternal", e.toString());
		}
		
		return file.getAbsolutePath();
    }

    
    public static boolean FileExist(String path)
    {       
        File file = new File(path);
        
        return file.exists();
    }
    
    public static String PathArquivoInternal(Context context, String caminho)
    {
        try 
        {            
            String pathImagem = context.getFileStreamPath("").toString();
            
            return new StringBuilder().append(pathImagem).append("/").append(caminho).append("/").toString();
                
        } catch (Exception e) 
        {
            Logs.LogError("pathCaminhoArquivo", e.toString());
            return null;
        }
    }
    
    
    public static boolean ExcluirFile(File file)
    {
        try 
        {               
            if (file.exists()) 
            {
            	return file.delete();
            }
            else
            {
            	return false;
            }
                
        } catch (Exception e) 
        {
        	Logs.LogError("EcluirArquivo", e.toString());
        	return false;
        }
    }
}
