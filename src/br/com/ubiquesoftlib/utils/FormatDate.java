package br.com.ubiquesoftlib.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint("SimpleDateFormat")
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
	
	public static String ToString(Date data, String forString)
    {
		SimpleDateFormat dateFormat;
        try 
        {
            if (data != null) {
            	
            	if (forString!= null) {					
            		dateFormat = new SimpleDateFormat(forString);     
				}else{
					dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
				}
            	
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
	
	public static Date getDateTime(Date date)
	{	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(date));
		return date;
	}
	
	public static Date getDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return date;
	}
	
	
	public static Date somarSubtraiData(int year, int month, int day, int hour, int minute, int second)
	{
		GregorianCalendar gc = new GregorianCalendar();          
        gc.setTime(new Date());            
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        gc.add(Calendar.YEAR, year); 
        gc.add(Calendar.MONTH, month); 
        gc.add(Calendar.DAY_OF_MONTH, day); 
        gc.add(Calendar.HOUR, hour);  
        gc.add(Calendar.MINUTE, minute);  
        gc.add(Calendar.SECOND, second);            
//        System.out.println("HORA SOMADA: " + sdf.format(gc.getTime()));
		return gc.getTime(); 
	}

}
