package com.leandro.jacome.pockeretrofit.base;

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showError(String message);
}
