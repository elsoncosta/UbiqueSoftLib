package br.com.ubiquesoftlib.application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.ubiquesoftlib.R;
import br.com.ubiquesoftlib.transaction.Transaction;
import br.com.ubiquesoftlib.transaction.TransactionTask;
import br.com.ubiquesoftlib.utils.alertaDialog;
import br.com.ubiquesoftlib.utils.network;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentMaster extends SherlockFragment 
{
	private int progressId = R.id.progress;
	protected void alert(int mensagem) 
	{
		alertaDialog.message(getActivity(), mensagem);
	}
	
	protected Activity getFragmentMasterActivity()
	{
		return getActivity();
	}
	
	// Initial thread
	public void startTransacao(Transaction transaction) 
	{
		// Start transaction
		TransactionTask task = new TransactionTask(getActivity(), transaction, progressId);
		task.execute();
	}
	
	// Initial thread
	public void startTransacaoRede(Transaction transaction) 
	{
		if (network.isConected(getActivity()))  
		{
			// Start transaction
			TransactionTask task = new TransactionTask(getActivity(), transaction, progressId);
			task.execute();
		} 
		else 
		{
			// is not conection
			alertaDialog.message(getActivity(),R.string.conexao_indisponivel);
		}
	}
		
	public void setProgressId(int progressId) 
	{
		this.progressId = progressId;
	}

	
	//Open new activity
	protected void show(Class<?> cls, Bundle bundle) 
	{
		Intent intent = new Intent(getActivity(), cls);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	//Open new activity
	protected void show(Class<?> cls) 
	{
		Intent intent = new Intent(getActivity(), cls);
		startActivity(intent);
	}
	
	protected void showRoot(Class<?> cls) {
		Intent intent = new Intent(getActivity(), cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
	
	public View findViewById(int id) 
	{
		View view = getView();
		return view != null ? view.findViewById(id) : null;
	}
	
	//Set values textview
	protected void setText(int id, String s) 
	{
		TextView t = (TextView) findViewById(id);
		if(t != null) {
			t.setText(s);
		}
	}
	
//	//verifica se existe a fragment do lado direito
//	protected boolean isDualLayout() 
//	{
//		boolean dual = getActivity().findViewById(R.id.layoutFrag2) != null;
//		return dual;
//	}
}
