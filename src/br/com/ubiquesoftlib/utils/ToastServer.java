package br.com.ubiquesoftlib.utils;

import android.app.Activity;
import android.view.Gravity;
import br.com.ubiquesoflib.alertaMensagem.ToastAlerta;
import br.com.ubiquesoftlib.R;

public class ToastServer 
{
	public static void show(Activity activity, Integer status)
	{
		switch (status) 
        {
            case 200:
                    ToastAlerta.showInfor(activity, R.string.sucesso, Gravity.BOTTOM, ToastAlerta.LENGTH_SHORT);                              
                    break;
            case 401:
            		ToastAlerta.showConfirm(activity, R.string.nao_autorizado, Gravity.BOTTOM, ToastAlerta.LENGTH_SHORT);
                    break;
            default:
                	ToastAlerta.showAlert(activity, R.string.erro_servidor, Gravity.BOTTOM, ToastAlerta.LENGTH_SHORT);
                    break;
        }
	}
}
