package com.example.aplicacionenclases;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicacionenclases.WebServices.Asynchtask;
import com.example.aplicacionenclases.WebServices.WebService;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onclick  (View view){

        Map<String, String> datos = new HashMap<String, String>();

        WebService ws= new WebService(
                 "https://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=123",
                datos, LoginActivity.this, LoginActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtRespuesta = findViewById(R.id.txtRespuesta);
        txtRespuesta.setText(result);

    }
}