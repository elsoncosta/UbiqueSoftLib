package br.com.ubiquesoftlib.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * @author ELson Costa, ellsoncostas@gmail.com
 *
 */
public class webClient {

	private final String url;
	private String auth_token;
	public String name_auth = "name_auth";
	
	public webClient(String url, String auth_token)
	{
		this.url = url;
		this.auth_token = auth_token;
	}
	
	/**
	 * @param json
	 * @return
	 * 0 tipy return; ex: autorized 200 or 400, 401
	 * 1 return json
	 */	
	public List<String> get()
	{		
		Log.i(getClass().getName(), "Iniciado");
		
		List<String> ret = new ArrayList<String>();
		int status = 0;
		
		int timeoutConnection = 3000;
		int timeoutSocket = 5000;
		
		HttpParams httpParams = new BasicHttpParams(); 
		HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
		HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket); 
		HttpClient httpclient = new DefaultHttpClient(httpParams);
		
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Accept", "application/json");
		httpget.setHeader("Content-type", "application/json");
		httpget.setHeader(name_auth, auth_token);

		try 
		{
			HttpResponse response = httpclient.execute(httpget);
			
			status = response.getStatusLine().getStatusCode();

			if (status != 0) 
			{
				HttpEntity entity = response.getEntity();

				if (entity != null)
				{				
					String result = new String(new inputStream().getBytes(entity.getContent()));
					
					Log.i("resultado get", result);
					
					ret.add(Integer.toString(status));
					
					Log.i(getClass().getName() + "Status: ", Integer.toString(status));
					
					ret.add(result);
					
					Log.i(getClass().getName(), new StringBuilder().append("get: ").append(ret.toString()).toString());
					
					return ret;
				}
			}
			
			Log.i(getClass().getName(), "Finalizado com sucesso.");
			
		} catch (Exception e) 
		{
			Logs.LogError(getClass(), e.getMessage());			
			return ret;
		}
		
		return ret = Arrays.asList(Integer.toString(status));
	}
	
	/**
	 * @param json
	 * @return
	 * 0 tipy return; ex: autorized 200 or 400, 401
	 * 1 return InputStream
	 */	
	public InputStream getInputStream()
	{		
		Log.i(getClass().getName(), "Iniciado");
		
		int status = 0;
		
		int timeoutConnection = 3000;
		int timeoutSocket = 5000;
		
		HttpParams httpParams = new BasicHttpParams(); 
		HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
		HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket); 
		HttpClient httpclient = new DefaultHttpClient(httpParams);
		
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Accept", "application/json");
		httpget.setHeader("Content-type", "application/json");
//		httpget.setHeader("Content-type", "text/htm");
		httpget.setHeader(name_auth, auth_token);

		try 
		{
			HttpResponse response = httpclient.execute(httpget);
			
			status = response.getStatusLine().getStatusCode();

			if (status != 0) 
			{
				HttpEntity entity = response.getEntity();

				if (entity != null)
				{
					Log.i(getClass().getName(), "Status: " + Integer.toString(status));
					Log.i(getClass().getName(), "Finalizado com sucesso.");
					return entity.getContent();
				}
			}
			
			
		} catch (Exception e) 
		{
			Logs.LogError(getClass(), e.getMessage());			
			return null;
		}
		
		return null;
	}
	
	/**
	 * @param json
	 * @return
	 * 0 tipy return; ex: autorized 200 or 400, 401
	 * 1 return json
	 */	
	public List<String> post(String json)
	{		
		List<String> ret = null;
		
		try
		{
			int timeoutConnection = 3000;
			int timeoutSocket = 5000;
			
			HttpParams httpParams = new BasicHttpParams(); 
			HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
			HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket); 
			HttpClient httpClient = new DefaultHttpClient(httpParams);            
			
			
			HttpPost post = new HttpPost(url);
			post.setEntity(new StringEntity(json));
			
			post.setHeader("Accept", "application/json");
			post.setHeader("Content-type", "application/json");
			post.setHeader(name_auth, auth_token);
			
			HttpResponse response = httpClient.execute(post);
			
			ret = Arrays.asList(Integer.toString(response.getStatusLine().getStatusCode()), EntityUtils.toString(response.getEntity()));
			
			Log.i(getClass().getName(), new StringBuilder().append("Post: ").append(ret.toString()).toString());
			
			return ret;
			
		} catch (Exception e) 
		{
			Logs.LogError(getClass(), e.getMessage());			
			return ret;
		}
	}
	
	/**
	 * @param json
	 * @return
	 * 0 tipy return; ex: autorized 200 or 400, 401
	 * 1 return json
	 */	
	public List<String> put(String json)
	{		
		List<String> ret = null;
		
		try
		{
			int timeoutConnection = 3000;
			int timeoutSocket = 5000;
			
			HttpParams httpParams = new BasicHttpParams(); 
			HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
			HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket); 
			HttpClient httpClient = new DefaultHttpClient(httpParams);   
			
			HttpPut put = new HttpPut(url);
			put.setEntity(new StringEntity(json));
			
			put.setHeader("Accept", "application/json");
			put.setHeader("Content-type", "application/json");
			put.setHeader(name_auth, auth_token);
			
			HttpResponse response = httpClient.execute(put);
			
			ret = Arrays.asList(Integer.toString(response.getStatusLine().getStatusCode()), EntityUtils.toString(response.getEntity()));
			
			Log.i(getClass().getName(), new StringBuilder().append("Put: ").append(ret.toString()).toString());
						
			return ret;
			
		} catch (Exception e) 
		{
			Logs.LogError(getClass(), e.getMessage());			
			return ret;
		}
	}

}
