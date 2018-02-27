package com.example.joaocampos.mypersistenceapplication;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Pokedex pokedex;
    Call<Pokedex> callPokedex;
    AsyncTask<Void, Void, Void> asyncTask;
    private Retrofit retrofit;
    private PokemonService acessService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = RetrofitPokemon.getInstance();
        acessService = retrofit.create(PokemonService.class);

        if (!RetrofitPokemon.isNetworkAvailable(getApplicationContext())){
            Toast.makeText(getApplicationContext(), "Sem conexão com a internet", Toast.LENGTH_SHORT).show();
            return;
        }
        startCallAsync();
    }

    @SuppressLint("StaticFieldLeak")
    private void startCallAsync() {
        asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                getPokedex();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                verifyPokedex();
                super.onPostExecute(aVoid);
            }
        };
        asyncTask.execute();
    }

    private void getPokedex() {
        try {
            callPokedex = acessService.getPokedex();
            pokedex = callPokedex.execute().body();
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

    private void verifyPokedex() {
        if (pokedex == null) {
            Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Pikachu", Toast.LENGTH_SHORT).show();

        }
    }
}
