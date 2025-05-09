package com.leandro.jacome.pockeretrofit.ui.main.adapter;

import static com.leandro.jacome.pockeretrofit.utils.Constants.EVO_CHAIN_ID;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;
import com.leandro.jacome.pockeretrofit.ui.main.details.AboutFragment;
import com.leandro.jacome.pockeretrofit.ui.main.details.EvolutionFragment;

public class DetailsPagerAdapter extends FragmentStateAdapter {

    private PokemonDetails pokemonDetails;
    private PokemonSpecies pokemonSpecies;
    private String imageUrl;
    private int evolutionChainId;

    private final AboutFragment aboutFragment = new AboutFragment();

    public DetailsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void setEvolutionChainId(int id) {
        this.evolutionChainId = id;
    }

    public void setPokemonData(PokemonDetails details, String imgUrl) {
        this.pokemonDetails = details;
        this.imageUrl = imgUrl;
        aboutFragment.setPokemonDetails(details, imgUrl);
    }

    public void setDescription(PokemonSpecies desc) {
        this.pokemonSpecies = desc;
        aboutFragment.setPokemonSpecies(desc);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return aboutFragment;

            case 1:
                EvolutionFragment evolutionFragment = new EvolutionFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(EVO_CHAIN_ID, evolutionChainId);
                evolutionFragment.setArguments(bundle);
                return evolutionFragment;

            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
