package com.leandro.jacome.pockeretrofit.data.model.desc;

import static com.leandro.jacome.pockeretrofit.utils.Constants.LANGUAGE_EN;
import static com.leandro.jacome.pockeretrofit.utils.Constants.LANGUAGE_ES;
import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_NAME_FLAVOR;
import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_NAME_GENERA;
import static com.leandro.jacome.pockeretrofit.utils.Constants.UNKNOWN_CATEGORY;
import static com.leandro.jacome.pockeretrofit.utils.Constants.UNKNOWN_COLOR;
import static com.leandro.jacome.pockeretrofit.utils.Constants.UNKNOWN_DESCRIPTION;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PokemonSpecies implements Serializable {
    private Color color;
    @SerializedName(SER_NAME_FLAVOR)
    private List<FlavorTextEntries> flavorTextEntries;
    @SerializedName(SER_NAME_GENERA)
    private List<GenusEntry> genera;

    public List<GenusEntry> getGenera() {
        return genera;
    }

    public Color getColor() {
        return color;
    }

    public List<FlavorTextEntries> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public String getDescription() {
        if (flavorTextEntries == null || flavorTextEntries.isEmpty()) {
            return UNKNOWN_DESCRIPTION;
        }

        String spanishDesc = findDescriptionByLanguage(LANGUAGE_ES);
        if (!spanishDesc.isEmpty()) {
            return spanishDesc;
        }

        String englishDesc = findDescriptionByLanguage(LANGUAGE_EN);
        if (!englishDesc.isEmpty()) {
            return englishDesc;
        }

        return UNKNOWN_DESCRIPTION;
    }

    private String findDescriptionByLanguage(String languageCode) {
        for (FlavorTextEntries entry : flavorTextEntries) {
            if (entry != null &&
                    entry.getLanguage() != null &&
                    languageCode.equals(entry.getLanguage().getName()) &&
                    entry.getFlavorText() != null) {

                return entry.getFlavorText()
                        .replace("\n", " ")
                        .replace("\f", " ")
                        .trim();
            }
        }
        return "";
    }

    public String getCategoryEs() {
        if (genera == null) return UNKNOWN_CATEGORY;
        for (GenusEntry entry : genera) {
            if (LANGUAGE_ES.equals(entry.language.getName())) {
                return entry.genus;
            }
        }
        return UNKNOWN_CATEGORY;
    }

    public String getColorName() {
        return color != null ? color.getName() : UNKNOWN_COLOR;
    }
}
