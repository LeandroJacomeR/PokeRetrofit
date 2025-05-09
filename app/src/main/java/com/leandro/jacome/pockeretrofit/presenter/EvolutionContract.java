package com.leandro.jacome.pockeretrofit.presenter;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.List;

public interface EvolutionContract {
    interface View {
        void showEvolutionImages(List<CarouselItem> images);
        void showError(String message);
    }

    interface Presenter {
        void loadEvolutionChain(int chainId);
    }
}
