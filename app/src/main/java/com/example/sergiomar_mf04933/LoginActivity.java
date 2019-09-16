package com.example.sergiomar_mf04933;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_Mail, et_LogPassw;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_Mail = findViewById(R.id.etwlogemailid);
        et_LogPassw = findViewById(R.id.etlopasswid);
    }

    public void doLogin(View view) {
        String txt_result;
        if(!checkFields()){
            txt_result=getString(R.string.dataErr1);
        }
        else{
            txt_result=(
                    getString(R.string.dataOk2)
                            .replace("_EMAIL", et_Mail.getText().toString())
            );

            prefs = getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE);

            SharedPreferences.Editor shpred =  prefs.edit();
            shpred.putInt("UsuarioIdentificado", 1);
            shpred.commit();
            finish();

        }
        Toast.makeText(this, txt_result,Toast.LENGTH_LONG)
                .show();
    }
    public boolean checkFields() {
        boolean fieldsOk = true;

        if ("".equals(et_Mail.getText().toString())) {
            fieldsOk = false;
            et_Mail.setError(getString(R.string.errEmptyMail));
        }
        if ("".equals(et_LogPassw.getText().toString())) {
            fieldsOk = false;
            et_LogPassw.setError(getString(R.string.errEmptyLogPassw));
        }
        return fieldsOk;
    }
    public void obrePelicNaveg(View view) {
        TextView tvintWeb = findViewById(R.id.lbwebaddid);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(tvintWeb.getText().toString()));
        startActivity(intent);
    }

}
