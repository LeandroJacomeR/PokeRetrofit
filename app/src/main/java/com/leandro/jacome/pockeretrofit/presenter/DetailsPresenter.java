package com.leandro.jacome.pockeretrofit.presenter;

import static com.leandro.jacome.pockeretrofit.utils.Constants.MSG_ERROR;

import android.util.Log;

import com.leandro.jacome.pockeretrofit.data.api.ApiClient;
import com.leandro.jacome.pockeretrofit.data.api.ApiService;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;
    private ApiService service = ApiClient.getClient().create(ApiService.class);

    @Override
    public void attachView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadPokemonDetails(String name, String imageUrl, int id) {

        service.getPokemon(id).enqueue(new Callback<PokemonDetails>() {
            @Override
            public void onResponse(Call<PokemonDetails> call, Response<PokemonDetails> response) {
                if (view != null && response.isSuccessful() && response.body() != null) {
                    PokemonDetails pokemon = response.body();
                    view.showPokemonData(pokemon, imageUrl);
                } else if (view != null) {
                    view.showError(MSG_ERROR);
                } else {
                    view.showError(MSG_ERROR);
                }
            }

            @Override
            public void onFailure(Call<PokemonDetails> call, Throwable throwable) {
                if (view != null) {
                    view.hideLoading();
                    view.showError(MSG_ERROR);
                }
                Log.e("DetailsPresenter", "Error al cargar datos", throwable);
            }
        });
    }

    @Override
    public void loadDescription(int id) {
        service.getDescription(id).enqueue(new Callback<PokemonSpecies>() {
            @Override
            public void onResponse(Call<PokemonSpecies> call, Response<PokemonSpecies> response) {
                if (view != null && response.isSuccessful() && response.body() != null) {
                    PokemonSpecies desc= response.body();
                    view.showDescription(desc);
                }
            }

            @Override
            public void onFailure(Call<PokemonSpecies> call, Throwable throwable) {
                if (view != null) {
                    view.hideLoading();
                    view.showError(MSG_ERROR);
                }
                Log.e("DetailsPresenter", "Error al cargar datos", throwable);
            }
        });
    }
}
