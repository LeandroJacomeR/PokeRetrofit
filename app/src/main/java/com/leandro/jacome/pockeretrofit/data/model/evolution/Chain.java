package com.leandro.jacome.pockeretrofit.data.model.evolution;

import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_ENVOLVES_TO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chain {
    private Species species;
    @SerializedName(SER_ENVOLVES_TO)
    private List<Chain> envolvesTo;

    public Species getSpecies() {
        return species;
    }

    public List<Chain> getEnvolvesTo() {
        return envolvesTo;
    }
}
