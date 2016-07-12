package tv.superawesome.lib.sautils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by gabriel.coman on 12/07/16.
 */
public class SAProgressDialog {

    private static SAProgressDialog instance = new SAProgressDialog();
    private ProgressDialog progress;
    private SAProgressDialog(){}
    public static SAProgressDialog getInstance(){
        return instance;
    }

    public void showProgress (Context c) {
        progress = new ProgressDialog(c);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();
    }

    public void hideProgress () {
        progress.dismiss();
    }
}
