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
    }

    private void setupUI() {
        tabLayout = findViewById(R.id.tabLayoutDetail);
        viewPager = findViewById(R.id.viewPagerDetail);

        pagerAdapter = new DetailsPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText(ABOUT); break;
                case 1: tab.setText(STATS); break;
                case 2: tab.setText(EVOLUTION); break;
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
        }
    }

    public static void start(Context context, Pokemon pokemon, int id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(NAME, pokemon.getName());
        intent.putExtra(IMAGEURL, pokemon.getImageUrl());
        intent.putExtra(ID, id);
        context.startActivity(intent);
    }
}