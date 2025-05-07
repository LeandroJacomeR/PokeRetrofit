package com.leandro.jacome.pockeretrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class AbilitySlot {
    public Ability ability;
    @SerializedName("is_hidden")
    public boolean isHidden;
}
