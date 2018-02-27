package com.example.joaocampos.mypersistenceapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {

    @GET("pokemon/?limit=1000&offset=20%22")
    Call<Pokedex> getPokedex();
}
