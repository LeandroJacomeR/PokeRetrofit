package com.leandro.jacome.pockeretrofit.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonDetails {
    public int id;
    public String name;
    public int height;
    public int weight;
    public List<TypeSlot> types;
    public List<StatSlot> stats;
    public List<AbilitySlot> abilities;
    public Sprites sprites;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public List<TypeSlot> getTypes() {
        return types;
    }

    public List<StatSlot> getStats() {
        return stats;
    }

    public List<AbilitySlot> getAbilities() {
        return abilities;
    }

    public Sprites getSprites() {
        return sprites;
    }
}
