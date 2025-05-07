package com.leandro.jacome.pockeretrofit.data.api;

import static com.leandro.jacome.pockeretrofit.utils.Constants.GET_ALL_POKEMON;
import static com.leandro.jacome.pockeretrofit.utils.Constants.GET_POKEMON_DESC;
import static com.leandro.jacome.pockeretrofit.utils.Constants.GET_POKEMON_ID;

import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.PokemonResponse;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET(GET_ALL_POKEMON)
    Call<PokemonResponse> getPokemonList(@Query("limit") int limit);

    @GET(GET_POKEMON_ID)
    Call<PokemonDetails> getPokemon(@Path("id") int id);

    @GET(GET_POKEMON_DESC)
    Call<PokemonSpecies> getDescription(@Path("id") int id);
}
