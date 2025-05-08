package com.leandro.jacome.pockeretrofit.data.model;

import static com.leandro.jacome.pockeretrofit.utils.Constants.HIDDEN_SKILL;
import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_NAME_BASE_XP;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PokemonDetails implements Serializable {
    public int id;
    public String name;
    public int height;
    public int weight;
    @SerializedName(SER_NAME_BASE_XP)
    public int baseExperience;
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

    public String getAbilitiesAsString() {
        if (abilities == null) return "-";
        StringBuilder sb = new StringBuilder();
        for (AbilitySlot slot : abilities) {
            sb.append(slot.ability.name);
            if (slot.isHidden) sb.append(HIDDEN_SKILL);
            sb.append(", ");
        }
        return sb.length() > 2 ? sb.substring(0, sb.length() - 2) : sb.toString();
    }

    public String getTypesAsString() {
        if (types == null) return "-";
        StringBuilder sb = new StringBuilder();
        for (TypeSlot slot : types) {
            sb.append(slot.type.name).append(", ");
        }
        return sb.length() > 2 ? sb.substring(0, sb.length() - 2) : sb.toString();
    }

    public int getBaseExperience() {
        return baseExperience;
    }
}
