package com.leandro.jacome.pockeretrofit.ui.main.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.data.model.PokemonDetails;
import com.leandro.jacome.pockeretrofit.data.model.StatSlot;

import java.util.HashMap;
import java.util.Map;

public class StatsFragment extends Fragment {

    private PokemonDetails pokemonDetails;

    // IDs de los includes en el layout
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

    public void setData(PokemonDetails pokemonDetails) {
        this.pokemonDetails = pokemonDetails;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("hola 1");
        if (pokemonDetails != null) {
            System.out.println("hola 2");
            Map<String, Integer> statMap = new HashMap<>();
            System.out.println(pokemonDetails.getName());
            System.out.println(pokemonDetails.getId());
            for (StatSlot s : pokemonDetails.getStats()) {
                System.out.println(s.getStat().getName());
                System.out.println(s.getBaseStat());
                statMap.put(s.getStat().getName(), s.getBaseStat());
            }

            for (int i = 0; i < statKeys.length; i++) {
                View statView = view.findViewById(statLayoutIds[i]);
                TextView tvName = statView.findViewById(R.id.tvStatName);
                TextView tvValue = statView.findViewById(R.id.tvStatValue);
                ProgressBar bar = statView.findViewById(R.id.progressStat);

                tvName.setText(statLabels[i]);

                int value = statMap.getOrDefault(statKeys[i], 0);
                tvValue.setText(String.valueOf(value));
                bar.setProgress(value);
            }
        }
    }
}