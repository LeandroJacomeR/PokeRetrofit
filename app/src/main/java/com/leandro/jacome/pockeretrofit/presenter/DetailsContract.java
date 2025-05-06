package com.leandro.jacome.pockeretrofit.presenter;

import com.leandro.jacome.pockeretrofit.base.BasePresenter;
import com.leandro.jacome.pockeretrofit.base.BaseView;

public interface DetailsContract {
    interface View extends BaseView {
        void showPokemonData(String name, String imageUrl, int id);
    }

    interface Presenter extends BasePresenter<View> {
        void loadPokemonDetails(String name, String imageUrl, int id);
    }
}
