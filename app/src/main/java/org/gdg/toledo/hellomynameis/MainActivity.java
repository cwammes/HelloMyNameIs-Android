package org.gdg.toledo.hellomynameis;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myName = (TextView) findViewById(R.id.myNameIs);
        myName.setText("Chris");

        myName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
                View dialogView = layoutInflater.inflate(R.layout.dialog, null);

                final EditText editText = (EditText) dialogView.findViewById(R.id.dialog);
                editText.setText(myName.getText());

                alertDialogBuilder.setView(dialogView);

                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myName.setText(editText.getText());
                    }
                });

                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });
    }
}
