package com.leandro.jacome.pockeretrofit.data.model.desc;

import com.google.gson.annotations.SerializedName;


public class FlavorTextEntries {
    @SerializedName("flavor_text")
    private String flavorText;
    private Language language;

    public Language getLanguage() {
        return language;
    }

    public String getFlavorText() {
        return flavorText;
    }
}
