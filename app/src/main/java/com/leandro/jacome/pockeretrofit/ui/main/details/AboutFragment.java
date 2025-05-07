package com.leandro.jacome.pockeretrofit.ui.main.details;

import static com.leandro.jacome.pockeretrofit.utils.Constants.TV_SET_XP;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;

public class AboutFragment extends Fragment {

    private ImageView imageViewDetails;
    private TextView tvDescription, tvHeight, tvWeight, tvCategory, tvAbilities, tvTypes, tvBaseExperience;

    private PokemonDetails pokemonDetails;
    private PokemonSpecies pokemonSpecies;
    private String imageUrl;

    private boolean isViewCreated = false;

    public void setData(PokemonDetails pokemon, String imageUrl, PokemonSpecies desc) {
        this.pokemonDetails = pokemon;
        this.imageUrl = imageUrl;
        this.pokemonSpecies = desc;

        // Si la vista ya está creada, actualizamos
        if (isViewCreated) {
            updateUI();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageViewDetails = view.findViewById(R.id.imageViewDetails);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvHeight = view.findViewById(R.id.tvHeight);
        tvWeight = view.findViewById(R.id.tvWeight);
        tvCategory = view.findViewById(R.id.tvCategory);
        tvAbilities = view.findViewById(R.id.tvAbilities);
        tvTypes = view.findViewById(R.id.tvTypes);
        tvBaseExperience = view.findViewById(R.id.tvBaseExperience);


        isViewCreated = true;
        updateUI(); // Llamamos a actualizar la UI si los datos ya llegaron
    }

    private void updateUI() {
        if (pokemonDetails != null && imageUrl != null && imageViewDetails != null) {
            Glide.with(requireContext()).load(imageUrl).into(imageViewDetails);
            tvHeight.setText(String.valueOf(pokemonDetails.getHeight()));
            tvWeight.setText(String.valueOf(pokemonDetails.getWeight()));
            tvAbilities.setText(pokemonDetails.getAbilitiesAsString());
            tvTypes.setText(pokemonDetails.getTypesAsString());
            tvBaseExperience.setText(pokemonDetails.getBaseExperience() + TV_SET_XP);
        }

        if (pokemonSpecies != null && tvDescription != null) {
            tvDescription.setText(pokemonSpecies.getDescription());
            tvCategory.setText(String.valueOf(pokemonSpecies.getCategoryEs()));
        }
    }
}