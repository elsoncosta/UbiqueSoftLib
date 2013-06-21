package br.com.ubiquesoftlib.transaction;

import br.com.ubiquesoftlib.utils.alertaDialog;
import br.com.ubiquesoftlib.utils.orientation;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Classe para controlar a thread
 * 
 * @author Elson Costa
 * 
 */
public class TransactionTask extends AsyncTask<Void, Void, Boolean> {
	private final Activity activity;
	private final Transaction transacao;
	private ProgressDialog progresso;
	private Throwable exceptionErro;
	private int aguardeMsg;
	
	public TransactionTask(Activity activity, Transaction transacao, int aguardeMsg) 
	{
		this.activity = activity;
		this.transacao = transacao;
		this.aguardeMsg = aguardeMsg;
	}
	
	@Override
	protected void onPreExecute() 
	{
		super.onPreExecute();
		
		// Starts the window wait ...
		abrirProgress();
		
		//User orientation lock does not restart, the download again.
        orientation.LockOrientation(activity);
	}
	
	@Override
	protected Boolean doInBackground(Void... params) {
		try 
		{
			transacao.executar();
		} catch (Throwable e) 
		{
			Log.e(getClass().getName(), e.getMessage(), e);
			// Saves the error and returns false
			this.exceptionErro = e;
			return false;
		} finally 
		{
			try
			{
				fecharProgress();
			} catch (Exception e) 
			{
				Log.e(getClass().getName(), e.getMessage(), e);
			}
		}
		// OK
		return true;
	}
	@Override
	protected void onPostExecute(Boolean ok) {
		if (ok) 
		{
			// Transaction executed successfully
			transacao.atualizarView();
		} else 
		{
			// Erro
			alertaDialog.message(activity, "Erro: " + exceptionErro.getMessage());
		}
	}
	public void abrirProgress() 
	{		
		try
		{
			progresso = ProgressDialog.show(activity, "", activity.getString(aguardeMsg));
		} catch (Throwable e) 
		{
			Log.e(getClass().getName(), e.getMessage(), e);
			//Unlock orientation
	        orientation.unlockOrientation(activity);
		}
	}
	public void fecharProgress() 
	{
		try 
		{
			if (progresso != null) 
			{
				progresso.dismiss();
			}
		} catch (Throwable e) 
		{
			Log.e(getClass().getName(), e.getMessage(), e);
		}
		
		//Unlock orientation
        orientation.unlockOrientation(activity);
	}
}
