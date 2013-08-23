package br.com.ubiquesoftlib.utils;

public class FormatString {
	
	/**
     * Remove o texto e deixa com o tamanho definido, e acresenta reticências '...'
     * @param valor
     * @param posicao
     * @return
     */
    public static String RemoverApartir(String valor, int posicao) 
    {
    	if (valor.length() > posicao) {
    		StringBuffer stringBuffer = new StringBuffer(valor);
    		stringBuffer.delete(posicao, valor.length());
    		return String.format("%s...", stringBuffer.toString());			
		}
    	return valor;
    }
    
    public static String RemoverApartirCaracter(String valor, String caracter) 
    {
        int posicao = 0;
        
        for(int i = 0;i<valor.length();i++)
        {  
            if (valor.substring(i,i+1).equals(caracter))
            {  
               posicao = i; 
            }
        }
        
        StringBuffer stringBuffer = new StringBuffer(valor);
        stringBuffer.delete(posicao, valor.length());
        return stringBuffer.toString();
    }

     /**
 * Remove espaços no começo, no fim da frase e substitui espaços duplos no meio da fase por espaço simples.
 * @param  Texto a ser modificado
 * @return Texto modificado
 */
public static String RemoveExcessoEspaco(String valeu)
{   
    while (valeu.contains("  ")){
            valeu = valeu.replace("  ", " ");
    }
    return valeu.trim();
}


/**
 * Remove todos os espaços do texto.
 * @param text a ser alterado
 * @return Texto alterado
 */
public static String RemoveTodoEspaco(String text)
{        
    return text.replaceAll(" ", "");
}


public static String FormatarTamanho(String Texto, int value)
{           
    if (Texto.length() > value) 
	{
		Texto = Texto.substring(0, value);
    }    
    return Texto;
}


/**
 * Método que valida um componente do tipo TextBox se o mesmo possui ou não caracteres especiais como: {,},',",%,|,#,[,]
 * @param value a ser alterado
 * @return valor aulterado
 */
public static String RemoveCaracterSpecial(String value)
{
    String[] verifica = { "{", "}", "'", "\"", "%", "|", "#", "[", "]", "<", ">", ".","-", "/", ",","@","$", "&","?","^","~"}; //string aspasDuplas = "\""; // aspas duplas

    for (int i = 0; i < verifica.length; i++)
    {
        if (value.contains(verifica[i]))
        {
            value = value.replace(verifica[i], "");
        }
    }
    return value;
}

}
