package com.test.yosh.viewanimatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;


public class MainActivity extends AppCompatActivity {
    private ViewAnimator viewAnimator;
    private EditText txtMessage;
    private EditText txtName;
    private TextView txtResult;
    private TextView txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);

        txtMessage = (EditText) findViewById(R.id.txtMessage);
        txtName = (EditText) findViewById(R.id.txtName);

        txtResult = (TextView) findViewById(R.id.txtResult);
        txtSend = (TextView) findViewById(R.id.txtSend);
    }

    public void next(View view) {
        if (viewAnimator.getCurrentView().getId() != R.id.three) {
            String name = txtName.getText().toString();
            String message = txtMessage.getText().toString();

            if (!name.equalsIgnoreCase("") && !message.equalsIgnoreCase("")) {
                viewAnimator.showNext();
                txtResult.setText(getResources().getString(R.string.txtMessage) + ": " + message);
                txtSend.setText(name + ", " + getResources().getString(R.string.strSend));
            } else {
                Toast.makeText(getApplicationContext(), R.string.strError, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void previous(View view) {
        if (viewAnimator.getCurrentView().getId() != R.id.one) {
            viewAnimator.showPrevious();
        }
    }
}
