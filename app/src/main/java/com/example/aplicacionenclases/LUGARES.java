package com.example.aplicacionenclases;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionenclases.WebServices.Asynchtask;
import com.example.aplicacionenclases.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LUGARES extends AppCompatActivity implements Asynchtask
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lugares);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AutoCompleteTextView autocListaLugares = findViewById(R.id.listaLugares);
        autocListaLugares.setOnItemClickListener((parent, view, position, id) -> {

            Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService("https://turismo.quevedoenlinea.gob.ec/lugar_turistico/json_getlistadoGridLT/" + (position+1),
                    datos, LUGARES.this, LUGARES.this);
            ws.execute("GET");

        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtSaludo = findViewById(R.id.resp);
        String lstLista="";
        JSONObject resultados = new JSONObject(result);
        JSONArray JSONlista = resultados.getJSONArray("data");
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco= JSONlista.getJSONObject(i);
            lstLista = lstLista + i + ".- " +
                    banco.getString("nombre_lugar").toString()
                    + " - " +
                    banco.getString("categoria").toString() + "\n" ;
        }
        txtSaludo.setText(lstLista);

    }
}