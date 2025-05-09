package com.leandro.jacome.pockeretrofit.presenter;

import static com.leandro.jacome.pockeretrofit.utils.Constants.ERROR_RED;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EVO_NOT_FOUND;
import static com.leandro.jacome.pockeretrofit.utils.Constants.IMG_URL;
import static com.leandro.jacome.pockeretrofit.utils.Constants.PNG_EXT;

import com.leandro.jacome.pockeretrofit.data.api.ApiClient;
import com.leandro.jacome.pockeretrofit.data.api.ApiService;
import com.leandro.jacome.pockeretrofit.data.model.evolution.Chain;
import com.leandro.jacome.pockeretrofit.data.model.evolution.EvolutionChainResponse;
import com.leandro.jacome.pockeretrofit.data.model.evolution.Species;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvolutionPresenter implements EvolutionContract.Presenter {

    private EvolutionContract.View view;
    private final ApiService api = ApiClient.getClient().create(ApiService.class);

    public EvolutionPresenter(EvolutionContract.View view) {
        this.view = view;
    }

    @Override
    public void loadEvolutionChain(int chainId) {
        System.out.println(chainId);
        api.getEvolutionChain(chainId).enqueue(new Callback<EvolutionChainResponse>() {
            @Override
            public void onResponse(Call<EvolutionChainResponse> call, Response<EvolutionChainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<CarouselItem> items = new ArrayList<>();
                    extractImages(response.body().getChain(), items);
                    view.showEvolutionImages(items);
                } else {
                    view.showError(EVO_NOT_FOUND);
                }
            }

            @Override
            public void onFailure(Call<EvolutionChainResponse> call, Throwable t) {
                view.showError(ERROR_RED + t.getMessage());
            }
        });
    }

    private void extractImages(Chain chain, List<CarouselItem> items) {
        if (chain == null) return;

        Species species = chain.getSpecies();
        int id = getIdFromUrl(species.getUrl());
        String imgUrl = IMG_URL + id + PNG_EXT;
        items.add(new CarouselItem(imgUrl, capitalize(species.getName())));

        for (Chain evo : chain.getEnvolvesTo()) {
            extractImages(evo, items);
        }
    }

    private int getIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}

