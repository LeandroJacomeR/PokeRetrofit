package com.leandro.jacome.pockeretrofit.ui.main.details;

import static com.leandro.jacome.pockeretrofit.utils.Constants.FORMAT_HEIGHT;
import static com.leandro.jacome.pockeretrofit.utils.Constants.FORMAT_WEIGHT;
import static com.leandro.jacome.pockeretrofit.utils.Constants.TV_SET_XP;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.StatSlot;
import com.leandro.jacome.pockeretrofit.data.model.desc.PokemonSpecies;

import java.util.HashMap;
import java.util.Map;

public class AboutFragment extends Fragment {

    private ImageView imageViewDetails;
    private TextView tvName, tvDescription, tvHeight, tvWeight, tvCategory, tvAbilities, tvTypes, tvBaseExperience;

    private PokemonDetails pokemonDetails;
    private PokemonSpecies pokemonSpecies;
    private String imageUrl;

    private final int[] statLayoutIds = {
            R.id.statHp, R.id.statAttack, R.id.statDefense,
            R.id.statSpAttack, R.id.statSpDefense, R.id.statSpeed
    };

    private final String[] statKeys = {
            "hp", "attack", "defense", "special-attack", "special-defense", "speed"
    };

    private final String[] statLabels = {
            "HP", "Ataque", "Defensa", "Atq. Esp.", "Def. Esp.", "Velocidad"
    };

    private boolean isViewCreated = false;

    public void setData(PokemonDetails pokemon, String imageUrl, PokemonSpecies desc) {
        this.pokemonDetails = pokemon;
        this.imageUrl = imageUrl;
        this.pokemonSpecies = desc;

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
        tvName = view.findViewById(R.id.tvName);
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
            String heightMeters = String.format(FORMAT_HEIGHT, pokemonDetails.getHeight() / 10.0);
            String weightKg = String.format(FORMAT_WEIGHT, pokemonDetails.getWeight() / 10.0);

            Glide.with(requireContext()).load(imageUrl).into(imageViewDetails);
            tvName.setText(pokemonDetails.getName().substring(0, 1).toUpperCase() + pokemonDetails.getName().substring(1));
            tvHeight.setText(heightMeters);
            tvWeight.setText(weightKg);
            tvAbilities.setText(pokemonDetails.getAbilitiesAsString());
            tvTypes.setText(pokemonDetails.getTypesAsString());
            tvBaseExperience.setText(pokemonDetails.getBaseExperience() + TV_SET_XP);

            // Lógica de stats
            Map<String, Integer> statMap = new HashMap<>();
            for (StatSlot s : pokemonDetails.getStats()) {
                statMap.put(s.getStat().getName(), s.getBaseStat());
            }

            View view = getView();
            if (view != null) {
                for (int i = 0; i < statKeys.length; i++) {
                    View statView = view.findViewById(statLayoutIds[i]);
                    if (statView != null) {
                        TextView tvStatName = statView.findViewById(R.id.tvStatName);
                        TextView tvStatValue = statView.findViewById(R.id.tvStatValue);
                        ProgressBar progressBar = statView.findViewById(R.id.progressStat);

                        tvStatName.setText(statLabels[i]);

                        int value = statMap.getOrDefault(statKeys[i], 0);
                        tvStatValue.setText(String.valueOf(value));

                        int bgColor = getColorFromName(pokemonSpecies.getColorName());

                        progressBar.setProgress(value);
                        Drawable progressDrawable = progressBar.getProgressDrawable();
                        if (progressDrawable instanceof LayerDrawable) {
                            LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
                            Drawable progress = layerDrawable.findDrawableByLayerId(android.R.id.progress);
                            if (progress != null) {
                                progress.setColorFilter(bgColor, PorterDuff.Mode.SRC_IN);
                            }
                        }

                    }

                }
            }
        }

        if (pokemonSpecies != null) {
            if (tvDescription != null) {
                tvDescription.setText(pokemonSpecies.getDescription());
            }
            if (tvCategory != null) {
                tvCategory.setText(String.valueOf(pokemonSpecies.getCategoryEs()));
            }

            FrameLayout background = requireView().findViewById(R.id.imageBackgroundContainer);
            if (background != null) {
                int bgColor = getColorFromName(pokemonSpecies.getColorName());
                GradientDrawable drawable = (GradientDrawable) getResources().getDrawable(R.drawable.rounded_bottom_background);
                drawable.setColor(bgColor);
                background.setBackground(drawable);
            }
        }
    }

    private int getColorFromName(String name) {
        if (name == null) return getResources().getColor(R.color.default_bg);

        switch (name.toLowerCase()) {
            case "red": return getResources().getColor(R.color.poke_red);
            case "blue": return getResources().getColor(R.color.poke_blue);
            case "green": return getResources().getColor(R.color.poke_green);
            case "yellow": return getResources().getColor(R.color.poke_yellow);
            case "purple": return getResources().getColor(R.color.poke_purple);
            case "brown": return getResources().getColor(R.color.poke_brown);
            case "pink": return getResources().getColor(R.color.poke_pink);
            case "black": return getResources().getColor(R.color.poke_black);
            case "white": return getResources().getColor(R.color.poke_white);
            default: return getResources().getColor(R.color.default_bg);
        }
    }
}
