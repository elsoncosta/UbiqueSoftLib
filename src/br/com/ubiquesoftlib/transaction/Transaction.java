package br.com.ubiquesoftlib.transaction;

public interface Transaction 
{
	// Run the transaction in a separate thread
	public void executar() throws Exception;

	// Refresh the view synchronized with the main thread
	public void atualizarView();
}
