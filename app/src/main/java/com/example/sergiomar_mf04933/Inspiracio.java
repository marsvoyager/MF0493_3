package com.example.sergiomar_mf04933;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sergiomar_mf04933.model.PeliculaGhibli;
import com.example.sergiomar_mf04933.retrofit.Retrofit1ClientInstance;
import com.example.sergiomar_mf04933.retrofit.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class Inspiracio extends AppCompatActivity {

    ArrayList<String> ghiblis = new ArrayList<String>();
    ListView lv_inspirfilm;
    ArrayAdapter<String> ghibliadpt;
    ProgressDialog progressdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiracio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv_inspirfilm = (ListView) findViewById(R.id.lvcelulghibliid);
        ghibliadpt =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                ghiblis
        );

        lv_inspirfilm.setAdapter(
                ghibliadpt
        );

        Service service =
                Retrofit1ClientInstance.getRetrofitInstance()
                        .create(Service.class);
        Call<List<PeliculaGhibli>> call =service.listGhiblis();

        progressdialog = ProgressDialog.show(Inspiracio.this,
                getString(R.string.msg_accessgh),
                getString(R.string.msg_accessghwt),
                 true);
        call.enqueue(
                new Callback<List<PeliculaGhibli>>() {
                    @Override
                    public void onResponse(Response<List<PeliculaGhibli>> response) {
                        progressdialog.dismiss();

                        Iterator it =response.body().iterator();
                        PeliculaGhibli p;
                        String resultext="";
                        while(it.hasNext())
                        {
                            p= (PeliculaGhibli) it.next();
                            ghiblis.add(p.getTitle());
                        }

                        ghibliadpt.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        progressdialog.dismiss();
                        Toast.makeText(getBaseContext(), "Error!" + t.getLocalizedMessage(),
                                Toast.LENGTH_LONG).show(); //Que fer amb les dades

                    }
                }
        );

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
        //return super.onSupportNavigateUp();
    }
}
