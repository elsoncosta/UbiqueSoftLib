package br.com.ubiquesoftlib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GerarHash {
	
	public static String geraHash(File f) throws NoSuchAlgorithmException, FileNotFoundException  
    {  
        MessageDigest digest = MessageDigest.getInstance("MD5");  
        InputStream is = new FileInputStream(f);  
        
        byte[] buffer = new byte[8192];  
        int read = 0;  
        String output = null;  
        try  
        {  
            while( (read = is.read(buffer)) > 0)  
            {  
                digest.update(buffer, 0, read);  
            }  
            byte[] md5sum = digest.digest();  
            BigInteger bigInt = new BigInteger(1, md5sum);  
            output = bigInt.toString(16);  
            System.out.println("MD5: " + output);  
        }  
        catch(IOException e)  
        {  
            throw new RuntimeException("Não foi possivel processar o arquivo.", e);  
        }  
        finally  
        {  
            try  
            {  
                is.close();  
            }  
            catch(IOException e)  
            {  
            	throw new RuntimeException("Não foi possivel fechar o arquivo", e);  
            }  
        }  
  
        return output;  
    }
	
	
	public static String geraHash(String md5) throws NoSuchAlgorithmException  
    {  
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(md5.getBytes());
	        byte byteData[] = md.digest();
	 
	        //converter o byte para o m�todo formato hexadecimal 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	        //converter o byte para o m�todo formato hexadecimal 2
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
			
		} catch (Exception e) {
			throw new RuntimeException("Não foi possivel fechar o arquivo", e);  
		}
    	
    	return hexString.toString().toUpperCase();
    }
	
	public String geraHash(InputStream is, Boolean close)
    {  
        MessageDigest digest = null;
        String output = null; 
        
		try {
			digest = MessageDigest.getInstance("MD5");
		
	        byte[] buffer = new byte[8192];  
	        int read = 0;  
	        try  
	        {  
	            while( (read = is.read(buffer)) > 0)  
	            {  
	                digest.update(buffer, 0, read);  
	            }  
	            byte[] md5sum = digest.digest();  
	            BigInteger bigInt = new BigInteger(1, md5sum);  
	            output = bigInt.toString(16);  
	            System.out.println("MD5: " + output);  
	        }  
	        catch(IOException e)  
	        {  
	            throw new RuntimeException("Não foi possivel processar o arquivo.", e);  
	        }  
	        finally  
	        {  
	            if (close == true) {
	            	try  
		            {  
		                is.close(); 
		                System.out.println("fechou InputStream.");
		            }  
		            catch(IOException e)  
		            {  
		                throw new RuntimeException("Não foi possivel fechar o arquivo", e);  
		            }
				}  
	        }  
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
  
        return output;  
    }  
	
	public String checksum(File file) {
		  try {
		    InputStream fin = new FileInputStream(file);
		    java.security.MessageDigest md5er = MessageDigest.getInstance("MD5");
		    byte[] buffer = new byte[1024];
		    int read;
		    do {
		      read = fin.read(buffer);
		      if (read > 0)
		        md5er.update(buffer, 0, read);
		    } while (read != -1);
		    fin.close();
		    byte[] digest = md5er.digest();
		    if (digest == null)
		      return null;
		    String strDigest = "0x";
		    for (int i = 0; i < digest.length; i++) {
		      strDigest += Integer.toString((digest[i] & 0xff) 
		                + 0x100, 16).substring(1).toUpperCase();
		    }
		    return strDigest;
		  } catch (Exception e) {
		    return null;
		  }
		}
}
