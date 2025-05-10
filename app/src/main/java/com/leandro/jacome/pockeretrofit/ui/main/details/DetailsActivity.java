package com.leandro.jacome.pockeretrofit.ui.main.details;

import static com.leandro.jacome.pockeretrofit.utils.Constants.ABOUT;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EVOLUTION;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ID;
import static com.leandro.jacome.pockeretrofit.utils.Constants.IMAGEURL;
import static com.leandro.jacome.pockeretrofit.utils.Constants.NAME;
import static com.leandro.jacome.pockeretrofit.utils.Constants.STATS;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.base.BaseActivity;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;
import com.leandro.jacome.pockeretrofit.presenter.DetailsContract;
import com.leandro.jacome.pockeretrofit.presenter.DetailsPresenter;
import com.leandro.jacome.pockeretrofit.ui.main.adapter.DetailsPagerAdapter;

public class DetailsActivity extends BaseActivity implements DetailsContract.View {

    private DetailsContract.Presenter presenter;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private DetailsPagerAdapter pagerAdapter;
    private ImageButton ibBack;
    private LinearLayout errorContainer;
    private TextView tvErrorMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        presenter = new DetailsPresenter();
        presenter.attachView(this);

        String name = getIntent().getStringExtra(NAME);
        String imageUrl = getIntent().getStringExtra(IMAGEURL);
        int id = getIntent().getIntExtra(ID, -1);

        setupUI();
        presenter.loadPokemonDetails(name, imageUrl, id);
        presenter.loadDescription(id);

        errorContainer = findViewById(R.id.errorContainer);
        tvErrorMessage = findViewById(R.id.tvErrorMessage);

        ibBack = findViewById(R.id.ibBack);
        ibBack.setOnClickListener(v -> finish());
    }

    private void setupUI() {
        tabLayout = findViewById(R.id.tabLayoutDetail);
        viewPager = findViewById(R.id.viewPagerDetail);

        pagerAdapter = new DetailsPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText(ABOUT); break;
                case 1: tab.setText(EVOLUTION); break;
            }
        }).attach();
    }

    @Override
    public void showPokemonData(PokemonDetails pokemon, String imgUrl) {
        if (pagerAdapter != null) {
            pagerAdapter.setPokemonData(pokemon, imgUrl);
        }
    }

    @Override
    public void showDescription(PokemonSpecies pokemonSpecies) {
        if (pagerAdapter != null) {
            pagerAdapter.setDescription(pokemonSpecies);
            pagerAdapter.setEvolutionChainId(extractIdFromUrl(pokemonSpecies.getEvolutionChain().getUrl()));
        }
    }

    @Override
    public void showError(String message) {
        super.showError(message);
        showErrorUI(message);
    }


    public static void start(Context context, Pokemon pokemon, int id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(NAME, pokemon.getName());
        intent.putExtra(IMAGEURL, pokemon.getImageUrl());
        intent.putExtra(ID, id);
        context.startActivity(intent);
    }

    private int extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    private void showErrorUI(String message) {
        if (tvErrorMessage != null) tvErrorMessage.setText(message);
        if (errorContainer != null) errorContainer.setVisibility(View.VISIBLE);
        if (viewPager != null) viewPager.setVisibility(View.GONE);
        if (tabLayout != null) tabLayout.setVisibility(View.GONE);
        findViewById(R.id.global_loader).setVisibility(View.GONE);
    }
}