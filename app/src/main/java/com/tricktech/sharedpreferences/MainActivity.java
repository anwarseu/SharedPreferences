package com.tricktech.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btnSave,btnGet;
    public EditText edtValue;
    public SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnGet = (Button) findViewById(R.id.btnGet);

        edtValue = (EditText) findViewById(R.id.edtValue);

        sharedPref = getPreferences(Context.MODE_PRIVATE);

        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == btnSave){

            String message = edtValue.getText().toString();
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("value_save", message);
            editor.commit();

        }else if (view == btnGet){
            String message = sharedPref.getString("value_save","dummy data");
            edtValue.setText(message);
        }

    }
}
