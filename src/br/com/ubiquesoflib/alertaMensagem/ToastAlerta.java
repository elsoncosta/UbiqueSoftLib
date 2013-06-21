package br.com.ubiquesoflib.alertaMensagem;

import android.app.Activity;

public class ToastAlerta 
{
	public static int LENGTH_SHORT = 3000;
    public static int LENGTH_LONG = 5000;
	
    
	/**
	 * @param activity
	 * @param mensagem
	 * @param gravity TOP, BOTTOM, CENTER
	 * @param Durariton Duration alert
	 */
	public static void showInfor(Activity activity, int mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, activity.getString(mensagem), ToastAlertaMensagem.STYLE_INFO);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}
	
	/**
	 * @param activity
	 * @param mensagem
	 * @param gravity TOP, BOTTOM, CENTER
	 * @param Durariton Duration alert
	 */
	public static void showInfor(Activity activity, String mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, mensagem, ToastAlertaMensagem.STYLE_INFO);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}
	
	/**
	 * @param activity
	 * @param mensagem
	 * @param gravity TOP, BOTTOM, CENTER
	 * @param Durariton Duration alert
	 */
	public static void showAlert(Activity activity, int mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, activity.getString(mensagem), ToastAlertaMensagem.STYLE_ALERT);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}
	
	public static void showAlert(Activity activity, String mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, mensagem, ToastAlertaMensagem.STYLE_ALERT);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}
	
	/**
	 * @param activity
	 * @param mensagem
	 * @param gravity TOP, BOTTOM, CENTER
	 * @param Durariton Duration alert
	 */
	public static void showConfirm(Activity activity, int mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, activity.getString(mensagem), ToastAlertaMensagem.STYLE_CONFIRM);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}
	
	/**
	 * @param activity
	 * @param mensagem
	 * @param gravity TOP, BOTTOM, CENTER
	 * @param Durariton Duration alert
	 */
	public static void showConfirm(Activity activity, String mensagem, int gravity, int Durariton)
	{
		ToastAlertaMensagem alertaMensagem = ToastAlertaMensagem.makeText(activity, mensagem, ToastAlertaMensagem.STYLE_CONFIRM);
    	alertaMensagem.setDuration(Durariton);
    	alertaMensagem.setLayoutGravity(gravity);    	
    	alertaMensagem.show();
	}

}

