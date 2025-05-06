package com.leandro.jacome.pockeretrofit.base;

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
