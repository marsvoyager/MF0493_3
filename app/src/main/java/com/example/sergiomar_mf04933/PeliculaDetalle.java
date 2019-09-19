package com.example.sergiomar_mf04933;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sergiomar_mf04933.R;
import com.example.sergiomar_mf04933.controller.PeliculaController;
import com.example.sergiomar_mf04933.model.Pelicula;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

public class PeliculaDetalle extends AppCompatActivity {

    EditText et_Tit, et_Desc, et_Anyop, et_Puntuac, et_ImgUrl;// tv_CogNom, tv_DirWeb, tv_Tlf;//et_Mail, et_Tlf, et_Naix; //Declaro un EditText
    TextView tv_uuid;
    ImageView iv_urlimgcartel;

    class IMGURLFocusChange
            implements View.OnFocusChangeListener
    {
        EditText et_ImgUrl;
        ImageView iv_urlimgcartel;

        public ImageView getIv_urlimgcartel() {
            return iv_urlimgcartel;
        }

        public void setIv_urlimgcartel(ImageView iv_urlimgcartel) {
            this.iv_urlimgcartel = iv_urlimgcartel;
        }

        public EditText getEt_ImgUrl() {
            return et_ImgUrl;
        }

        public void setEt_ImgUrl(EditText et_ImgUrl) {
            this.et_ImgUrl = et_ImgUrl;
        }
        @Override
        public void onFocusChange(View view, boolean b) {

            if(null == et_ImgUrl)
                return;
            if(et_ImgUrl.getText().toString().isEmpty())
                return;
            //Uri.parse(et_ImgUrl.getText().toString());


            Picasso.get().load(Uri.parse(et_ImgUrl.getText().toString()))
                    .placeholder(R.drawable.ic_loop_black_24dp)
                    .error(R.drawable.ic_error_black_24dp)
                    .into(iv_urlimgcartel);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_detalle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        et_Tit = findViewById(R.id.tbNomid);
        et_Desc= findViewById(R.id.tbDescid);
        et_Anyop = findViewById(R.id.tbAnyopid);
        et_Puntuac= findViewById(R.id.tbpuntuacid);
        tv_uuid= findViewById(R.id.lbuuidid);
        et_ImgUrl = findViewById(R.id.tbimgurl);

        iv_urlimgcartel = findViewById(R.id.iv_imgurlid);
        ///

        IMGURLFocusChange imgurlListener = new IMGURLFocusChange();
        imgurlListener.setEt_ImgUrl(et_ImgUrl);
        imgurlListener.setIv_urlimgcartel(iv_urlimgcartel);

        et_ImgUrl.setOnFocusChangeListener(
                imgurlListener
        );

        int idxPelicula = getIntent().getIntExtra("peliculaindex", -1);
        String uudiPelicula = getIntent().getStringExtra("peliculauuid");
        if(idxPelicula == -1)
        {
            Toast.makeText(getApplicationContext(),
                    getResources().getText(R.string.dataErr2), Toast.LENGTH_LONG).show();
            return;
        }

        if(getIntent().getBooleanExtra("modoEdicion", false)) {

            ((Button)findViewById(R.id.button)).setText(
                    getResources().getText(R.string.btn_del)
            );
            et_Tit.setEnabled(false);
            et_Desc.setEnabled(false);
            et_Anyop.setEnabled(false);
            et_Puntuac.setEnabled(false);
            et_ImgUrl.setVisibility(View.GONE);
            //((TextView)(findViewById(R.id.lbimgurl))).setVisibility(View.GONE);
            //((Button)findViewById(R.id.button)).setVisibility(View.GONE);

            List<Pelicula>
                    listp =
                    PeliculaController.get(getApplicationContext())
                            .getPeliculas();
            if (listp.isEmpty()) {
                et_Tit.setText("");
                et_Desc.setText("");
                et_Anyop.setText("");
                et_Puntuac.setText("");
                tv_uuid.setText("");
                et_ImgUrl.setText("");
                Toast.makeText(getApplicationContext(),
                        getResources().getText(R.string.dataErr2), Toast.LENGTH_LONG).show();
                return;
            }

            Pelicula p = listp.get(idxPelicula);
            if (p == null)
                return;

            et_Tit.setText(p.getTitulo());
            et_Desc.setText(p.getDescripcion());
            et_Anyop.setText(p.getAnyo_public());
            et_Puntuac.setText("" + p.getPuntuacion());
            tv_uuid.setText("Id:" + p.getId());
            et_ImgUrl.setText(p.getImagenUrl());

            if(!et_ImgUrl.getText().toString().isEmpty())
            {
                Picasso.get().load(Uri.parse(et_ImgUrl.getText().toString()))
                        .placeholder(R.drawable.ic_loop_black_24dp)
                        .error(R.drawable.ic_error_black_24dp)
                        .into(iv_urlimgcartel);
            }
            //pintent.putExtra("peliculaindex", position);
            //pintent.putExtra("peliculauuid", p.getId());

            if (idxPelicula > -1)
                Toast.makeText(getApplicationContext(), "click click abriendo indice" + idxPelicula + ":" + uudiPelicula, Toast.LENGTH_LONG).show();

        }
        else {
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
        //return super.onSupportNavigateUp();
    }

    public void AnyDestButPress(View view) {

        Boolean bDelete =getIntent().getBooleanExtra("modoEdicion", false);
        if(bDelete) {
            int idxPelicula = getIntent().getIntExtra("peliculaindex", -1);
            List<Pelicula>
                    listp =
                    PeliculaController.get(getApplicationContext())
                            .getPeliculas();
            Pelicula p = listp.get(idxPelicula);

            PeliculaController.get(this)
                    .delPelicula(p);
            Toast.makeText(getApplicationContext(),
                    getResources().getText(R.string.delOk)
                    .toString().replace(
                            "_NOMPEL",
                            p.getTitulo()
                    )
                    , Toast.LENGTH_LONG).show();
            finish();
            return;
        }


        if(!checkFields())
            return;

        Pelicula.emPuntuacion empunt;

        switch(Integer.parseInt(
                et_Puntuac.getText().toString()))
        {
            case 0:
                empunt =Pelicula.emPuntuacion._0;
                break;
            case 1:
                empunt =Pelicula.emPuntuacion._1;
                break;
            case 2:
                empunt =Pelicula.emPuntuacion._2;
                break;
            case 3:
                empunt =Pelicula.emPuntuacion._2;
                break;
            case 4:
                empunt =Pelicula.emPuntuacion._4;
                break;
            default:
                empunt =Pelicula.emPuntuacion._5;
                break;
        }

        Pelicula pel = new Pelicula(
                et_Tit.getText().toString(),
                et_Desc.getText().toString(),
                et_Anyop.getText().toString(),
                empunt,
                et_ImgUrl.getText().toString()
        );

        PeliculaController.get(this)
            .addPelicula(pel);

        finish();

    }


    private boolean checkFields()
    {
        if("".equals(et_Tit.getText().toString())){
            et_Tit.setError(getString(R.string.err_name));
            return false;
        }
        if("".equals(et_Anyop.getText().toString())){
            et_Anyop.setError(getString(R.string.err_anyop));
            return false;
        }
        try
        {
            int d = Integer.parseInt(et_Anyop.getText().toString());
        }
        catch(Exception e)
        {
            et_Anyop.setError(getString(R.string.err_anyop));
            return false;
        }

        if("".equals(et_Puntuac.getText().toString())){
            et_Puntuac.setError(getString(R.string.err_punt));
            return false;
        }

        try
        {
            int d = Integer.parseInt(et_Puntuac.getText().toString());
            if(d<0 || d >5)
                throw new Exception();
        }
        catch(Exception e)
        {
            et_Puntuac.setError(getString(R.string.err_punt));
            return false;
        }

        /*
        *         try
        {
            int d = Integer.parseInt(et_Anyop.getText().toString());
        }
        catch(Exception e)
        {
            et_Anyop.setError(getString(R.string.err_anyop));
            return;
        }

        * */




        /*if("".equals(et_ImgUrl.getText().toString())){
            et_ImgUrl.setError(getString(R.string.err_punt));
            return false;
        } */

        //URI imglURI= URI.create("");
        //imglURI.resolve()

    //Uri.parse("");


        return true;
    }

}
