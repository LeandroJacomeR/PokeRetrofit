package com.leandro.jacome.pockeretrofit.ui.main.details;

import static com.leandro.jacome.pockeretrofit.utils.Constants.EVO_CHAIN_ID;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EVO_NOT_FOUND;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.presenter.EvolutionContract;
import com.leandro.jacome.pockeretrofit.presenter.EvolutionPresenter;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.List;

public class EvolutionFragment extends Fragment implements EvolutionContract.View {

    private ImageCarousel carousel;
    private EvolutionContract.Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_evolution, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        carousel = view.findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());

        presenter = new EvolutionPresenter(this);

        if (getArguments() != null) {
            int evoId = getArguments().getInt(EVO_CHAIN_ID, -1);
            if (evoId != -1) {
                presenter.loadEvolutionChain(evoId);
            } else {
                showError(EVO_NOT_FOUND);
            }
        }
    }

    @Override
    public void showEvolutionImages(List<CarouselItem> images) {
        carousel.setData(images);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}