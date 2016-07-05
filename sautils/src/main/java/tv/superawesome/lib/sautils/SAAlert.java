package tv.superawesome.lib.sautils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gabriel.coman on 05/07/16.
 */
public class SAAlert {
    private AlertDialog dialog;
    private EditText input;

    public void show(Context c, String title, String message, String okTitle, String nokTitle, boolean hasInput, int inputType, final SAAlertInterface listener) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(c);
        alert.setCancelable(false);
        alert.setTitle(title);
        alert.setMessage(message);

        if (hasInput) {
            input = new EditText(c);
            input.setInputType(inputType);
            alert.setView(input);
        }

        alert.setPositiveButton(okTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (listener != null) {
                    if (input != null) {
                        listener.didClickOnOK(input.getText().toString());
                    } else {
                        listener.didClickOnOK(null);
                    }
                }
            }
        });

        alert.setNegativeButton(nokTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.didClickOnNOK();
                }
            }
        });

        dialog = alert.create();
        dialog.show();
    }
}
