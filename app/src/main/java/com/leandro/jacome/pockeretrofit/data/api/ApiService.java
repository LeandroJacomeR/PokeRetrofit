package com.leandro.jacome.pockeretrofit.data.api;

import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonList(@Query("limit") int limit);

    @GET("pokemon/{id}")
    Call<PokemonDetails> getPokemon(int id);
}
