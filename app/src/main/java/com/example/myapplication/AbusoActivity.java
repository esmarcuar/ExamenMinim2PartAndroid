package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.models.Abuso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AbusoActivity extends AppCompatActivity {

    EditText date;
    EditText informer;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abuso);

        date = findViewById(R.id.editFecha);
        informer = findViewById(R.id.editNombre);
        message = findViewById(R.id.editAbuso);
    }

    public void button2(android.view.View v) {
        if (date.getText().toString().isEmpty() || informer.getText().toString().isEmpty() || message.getText().toString().isEmpty() ) {
            Toast.makeText(AbusoActivity.this, "Please enter all the values", Toast.LENGTH_SHORT).show();

            return;
        }
        else
            postAbuso(this.date.getText().toString(), this.informer.getText().toString(), this.message.getText().toString());
    }

    public void postAbuso(String date, String informer, String message) {

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI gerritAPI = retrofit.create(RetrofitAPI.class);
        Call<Abuso> call = gerritAPI.abuso(new Abuso(date, informer, message));
        call.enqueue(new Callback<Abuso>() {
            @Override
            public void onResponse(Call<Abuso> call, Response<Abuso> response) {
                int variable = response.code();
                Log.i("QUESTION CODE", ":" + variable);
                if (response.isSuccessful()) {
                    Abuso abuso = response.body();
                    String date = abuso.getDate();
                    Log.i("Date", ":" + date);
                    String informer = abuso.getDate();
                    Log.i("Informer", ":" + informer);

                    String message = abuso.getMessage();
                    Log.i("Message", ":" + message);

                    Log.i("Abuso", "OK" + abuso);

                    Toast.makeText(AbusoActivity.this, "Abuso enviado correctamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(AbusoActivity.this, "Parametros incorrectos", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Abuso> call, Throwable t) {
                Log.e("LOGIN", "ERROR", t);
                Toast.makeText(AbusoActivity.this, "Usuario y/o password incorrectas", Toast.LENGTH_LONG).show();
            }
        });
    }
}