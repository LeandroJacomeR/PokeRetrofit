package com.leandro.jacome.pockeretrofit.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;
import com.leandro.jacome.pockeretrofit.ui.main.details.AboutFragment;
import com.leandro.jacome.pockeretrofit.ui.main.details.EvolutionFragment;
import com.leandro.jacome.pockeretrofit.ui.main.details.StatsFragment;

public class DetailsPagerAdapter extends FragmentStateAdapter {

    private PokemonDetails pokemonDetails;
    private PokemonSpecies pokemonSpecies;
    private String imageUrl;

    private AboutFragment aboutFragment = new AboutFragment(); // mantenemos la instancia

    public DetailsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void setPokemonData(PokemonDetails details, String imgUrl) {
        this.pokemonDetails = details;
        this.imageUrl = imgUrl;
        aboutFragment.setData(pokemonDetails, imageUrl, pokemonSpecies);
        notifyDataSetChanged();
    }

    public void setDescription(PokemonSpecies desc) {
        this.pokemonSpecies = desc;
        aboutFragment.setData(pokemonDetails, imageUrl, pokemonSpecies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return aboutFragment;
            case 1: return new StatsFragment();
            case 2: return new EvolutionFragment();
            default: return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
