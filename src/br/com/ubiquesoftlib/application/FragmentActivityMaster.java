package br.com.ubiquesoftlib.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.com.ubiquesoftlib.R;
import br.com.ubiquesoftlib.transaction.Transaction;
import br.com.ubiquesoftlib.transaction.TransactionTask;
import br.com.ubiquesoftlib.utils.alertaDialog;
import br.com.ubiquesoftlib.utils.network;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class FragmentActivityMaster extends SherlockFragmentActivity 
{
	private int progressId = R.id.progress;
	
	protected void alert(int mensagem) 
	{
		alertaDialog.message(this, mensagem);
	}
	
	// initial a thread
	public void startTransacao(Transaction transaction) 
	{
		// Inicia a transação
		TransactionTask task = new TransactionTask(this, transaction, progressId);
		task.execute();
	}
	
	// Initial a thread
	public void startTransacaoRede(Transaction transacao) 
	{
		if (network.isConected(this)) 
		{
			// Inicia a transação
			TransactionTask task = new TransactionTask(this, transacao, progressId);
			task.execute();
		} 
		else 
		{
			// is not conected
			alertaDialog.message(this, R.string.conexao_indisponivel);
		}
	}
		
	public void setProgressId(int progressId) 
	{
		this.progressId = progressId;
	}
	
	
	//Abre uma nova activity
	protected void show(Class<?> cls, Bundle bundle) 
	{
		Intent intent = new Intent(this, cls);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	//Abre uma nova activity
	protected void show(Class<?> cls) 
	{
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}
	
	protected void showRoot(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	
	//seta os valores de um textview
	protected void setText(int id, String s) 
	{
		TextView t = (TextView) findViewById(id);
		if(t != null) {
			t.setText(s);
		}
	}
	
//	public View findViewById(int id) 
//	{
//		View view = null;
//		return view != null ? findViewById(id) : null;
//	}
}
