package com.leandro.jacome.pockeretrofit.presenter;

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View view;

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

        if (view != null) {
            view.showPokemonData(name, imageUrl, id);
        }
    }
}
