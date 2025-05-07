package com.leandro.jacome.pockeretrofit.data.model.desc;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PokemonSpecies implements Serializable {
    private Color color;
    @SerializedName("flavor_text_entries")
    private List<FlavorTextEntries> flavorTextEntries;
    @SerializedName("genera")
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
            return "Descripción no disponible";
        }

        String spanishDesc = findDescriptionByLanguage("es");
        if (!spanishDesc.isEmpty()) {
            return spanishDesc;
        }

        String englishDesc = findDescriptionByLanguage("en");
        if (!englishDesc.isEmpty()) {
            return englishDesc;
        }

        return "Descripción no disponible";
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
        if (genera == null) return "Categoría desconocida";
        for (GenusEntry entry : genera) {
            if ("es".equals(entry.language.getName())) {
                return entry.genus;
            }
        }
        return "Categoría desconocida";
    }

    public String getColorName() {
        return color != null ? color.getName() : "desconocido";
    }
}
