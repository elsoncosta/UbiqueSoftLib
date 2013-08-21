package br.com.ubiquesoftlib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.util.Log;

public class FormatDate {
	
	/**
	 * @param format
	 * @return dd-MM-yyyy HH:mm:ss
	 */
	public static Date getNow(String format)
    {
            Date date = null;
            
            Log.i("FormatDate", "Initial");
            
            try 
            {
                SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
                String data = simpleFormat.format(new Date( System.currentTimeMillis()));
                date = simpleFormat.parse(data);
                    
            } catch (Exception e) 
            {
            	Logs.LogError("FormatDate.Now", e.getMessage());
            }
            return date;
    }
	public static String getNowString(String format)
	{		
        try
        {
    		if (format == null && format.length() > 0) {
    			format = "yyyy-MM-dd HH:mm:ss";
    		}

        	SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            
            return simpleFormat.format(new Date( System.currentTimeMillis()));
			
		} catch (Exception e) {
			Logs.LogError("FormatDate.Now", e.getMessage());
		}
		return null;
    }
	
	@SuppressLint("SimpleDateFormat")
	public static String ToString(Date data)
    {
        try 
        {
            if (data != null) {
            	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
                return dateFormat.format(data);
			}
                
        } catch (Exception e) 
        {
        	Logs.LogError("FormatDate.ToString", e.getMessage());
        }
        
        return "";
    }
	
	public static Date ToDate(String data)
	{
        Date date = null; 
        
        Log.i("FormatDate", "Initial");
        
        try 
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
            date = dateFormat.parse(data);
                
        } catch (Exception e) 
        {
        	Logs.LogError("FormatDate.Now", e.getMessage());
        }
        
        return date;
    }
	

	public static Date ToDate(Date data)
    {
        try 
        {
           if (data != null) 
           {
        	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
               return dateFormat.parse(dateFormat.format(data));
           }
                
        } catch (Exception e) 
        {
        	Logs.LogError("FormatDate.Now", e.getMessage());
        }
        
        return null;
    }

}
