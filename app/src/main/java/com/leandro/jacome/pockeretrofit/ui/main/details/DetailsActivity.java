package com.leandro.jacome.pockeretrofit.ui.main.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.base.BaseActivity;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.presenter.DetailsContract;
import com.leandro.jacome.pockeretrofit.presenter.DetailsPresenter;
import com.leandro.jacome.pockeretrofit.ui.main.adapter.DetailsPagerAdapter;

public class DetailsActivity extends BaseActivity implements DetailsContract.View {

    private DetailsContract.Presenter presenter;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private DetailsPagerAdapter pagerAdapter;

    /*public static void start(Context context, String name, String imageUrl, int id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("imageUrl", imageUrl);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        presenter = new DetailsPresenter();
        presenter.attachView(this);

        String name = getIntent().getStringExtra("name");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        int id = getIntent().getIntExtra("id", -1);

        setupUI();
        presenter.loadPokemonDetails(name, imageUrl, id);
    }

    private void setupUI() {
        tabLayout = findViewById(R.id.tabLayoutDetail);
        viewPager = findViewById(R.id.viewPagerDetail);

        pagerAdapter = new DetailsPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("About"); break;
                case 1: tab.setText("Stats"); break;
                case 2: tab.setText("Evolution"); break;
            }
        }).attach();
    }

    @Override
    public void showPokemonData(String name, String imageUrl, int id) {
        // Opcional: comunicar datos al fragment
    }

    public static void start(Context context, Pokemon pokemon, int id) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("name", pokemon.getName());
        intent.putExtra("imageUrl", pokemon.getImageUrl());
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}