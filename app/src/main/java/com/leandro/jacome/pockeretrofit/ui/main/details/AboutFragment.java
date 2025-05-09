package com.leandro.jacome.pockeretrofit.ui.main.details;

import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_BLACK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_BLUE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_BROWN;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_GREEN;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_PINK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_PURPLE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_RED;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_WHITE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.COLOR_YELLOW;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_ATTACK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_DEFENSE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_HP;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_SPEED;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_SP_ATTACK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.EN_STR_SP_DEFENSE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_ATTACK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_DEFENSE;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_HP;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_SPEED;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_SP_ATTACK;
import static com.leandro.jacome.pockeretrofit.utils.Constants.ES_STR_SP_DEFENSE;
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
            EN_STR_HP, EN_STR_ATTACK, EN_STR_DEFENSE, EN_STR_SP_ATTACK, EN_STR_SP_DEFENSE, EN_STR_SPEED
    };

    private final String[] statLabels = {
            ES_STR_HP, ES_STR_ATTACK, ES_STR_DEFENSE, ES_STR_SP_ATTACK, ES_STR_SP_DEFENSE, ES_STR_SPEED
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
        if (isViewCreated && pokemonDetails != null && imageUrl != null && pokemonSpecies != null) {
            updateUI();
        }
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

                        int bgColor = getResources().getColor(R.color.default_stat); // Color por defecto

                        if (pokemonSpecies != null && pokemonSpecies.getColorName() != null) {
                            bgColor = getColorFromName(pokemonSpecies.getColorName());
                        }

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
            if (pokemonSpecies != null && pokemonSpecies.getColorName() != null) {
                int bgColor = getColorFromName(pokemonSpecies.getColorName());
                GradientDrawable drawable = (GradientDrawable) getResources().getDrawable(R.drawable.rounded_bottom_background);
                drawable.setColor(bgColor);
                background.setBackground(drawable);
            }
        }
    }
    public void setPokemonDetails(PokemonDetails pokemon, String imageUrl) {
        this.pokemonDetails = pokemon;
        this.imageUrl = imageUrl;
        if (isViewCreated) updateUI();
    }

    public void setPokemonSpecies(PokemonSpecies desc) {
        this.pokemonSpecies = desc;
        if (isViewCreated) updateUI();
    }

    private int getColorFromName(String name) {
        if (name == null) return getResources().getColor(R.color.default_bg);

        switch (name.toLowerCase()) {
            case COLOR_RED: return getResources().getColor(R.color.poke_red);
            case COLOR_BLUE: return getResources().getColor(R.color.poke_blue);
            case COLOR_GREEN: return getResources().getColor(R.color.poke_green);
            case COLOR_YELLOW: return getResources().getColor(R.color.poke_yellow);
            case COLOR_PURPLE: return getResources().getColor(R.color.poke_purple);
            case COLOR_BROWN: return getResources().getColor(R.color.poke_brown);
            case COLOR_PINK: return getResources().getColor(R.color.poke_pink);
            case COLOR_BLACK: return getResources().getColor(R.color.poke_black);
            case COLOR_WHITE: return getResources().getColor(R.color.poke_white);
            default: return getResources().getColor(R.color.default_bg);
        }
    }
}
