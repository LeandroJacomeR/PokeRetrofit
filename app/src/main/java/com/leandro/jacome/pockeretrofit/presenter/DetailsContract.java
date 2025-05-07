package com.leandro.jacome.pockeretrofit.presenter;

import com.leandro.jacome.pockeretrofit.base.BasePresenter;
import com.leandro.jacome.pockeretrofit.base.BaseView;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;

public interface DetailsContract {
    interface View extends BaseView {
        void showPokemonData(PokemonDetails pokemon, String imgUrl);
        void showDescription(PokemonSpecies pokemonSpecies);
    }

    interface Presenter extends BasePresenter<View> {
        void loadPokemonDetails(String name, String imageUrl, int id);
        void loadDescription(int id);
    }
}
