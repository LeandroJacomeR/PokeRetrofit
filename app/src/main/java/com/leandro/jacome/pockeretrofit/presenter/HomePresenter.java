package com.leandro.jacome.pockeretrofit.presenter;

import static com.leandro.jacome.pockeretrofit.utils.Constants.MSG_ERROR;

import android.util.Log;

import com.leandro.jacome.pockeretrofit.data.api.ApiClient;
import com.leandro.jacome.pockeretrofit.data.api.ApiService;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.data.model.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadPokemons() {
        if (view != null) view.showLoading();

        ApiService service = ApiClient.getClient().create(ApiService.class);
        service.getPokemonList(1302).enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (view != null) {
                    view.hideLoading();
                    if (response.isSuccessful() && response.body() != null) {
                        List<Pokemon> list = response.body().getResults();
                        view.showPokemons(list);
                    } else {
                        view.showError(MSG_ERROR);
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                if (view != null) {
                    view.hideLoading();
                    view.showError(MSG_ERROR);
                }
                Log.e("HomePresenter", "Error al cargar datos", t);
            }
        });
    }
}
