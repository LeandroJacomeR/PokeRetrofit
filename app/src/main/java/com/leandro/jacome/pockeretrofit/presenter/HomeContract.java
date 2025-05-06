package com.leandro.jacome.pockeretrofit.presenter;

import com.leandro.jacome.pockeretrofit.base.BasePresenter;
import com.leandro.jacome.pockeretrofit.base.BaseView;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;

import java.util.List;

public interface HomeContract {
    interface View extends BaseView {
        void showPokemons(List<Pokemon> pokemonList);
    }

    interface Presenter extends BasePresenter<View> {
        void loadPokemons();
    }
}

