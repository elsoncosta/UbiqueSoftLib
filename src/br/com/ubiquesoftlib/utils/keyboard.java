package br.com.ubiquesoftlib.utils;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class keyboard 
{
	public static void Close(Activity activity, EditText text)
    {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(text.getWindowToken(), 0); 
    }
    
    public static void Open(Activity activity, EditText text)
    {
            InputMethodManager mgr = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            mgr.showSoftInput(text, InputMethodManager.SHOW_IMPLICIT);
    }
}
