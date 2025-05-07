package com.leandro.jacome.pockeretrofit.data.model.desc;

import com.google.gson.annotations.SerializedName;

public class GenusEntry {
    @SerializedName("genus")
    public String genus;

    @SerializedName("language")
    public Language language;
}
