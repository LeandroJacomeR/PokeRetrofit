package com.leandro.jacome.pockeretrofit.data.model;

import java.util.List;

public class PokemonResponse {
    private int count;
    private String next;
    private String previous;
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }
}
