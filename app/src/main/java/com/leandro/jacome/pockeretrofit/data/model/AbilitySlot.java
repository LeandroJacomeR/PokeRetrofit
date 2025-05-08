package com.leandro.jacome.pockeretrofit.data.model;

import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_NAME_HIDDEN;

import com.google.gson.annotations.SerializedName;

public class AbilitySlot {
    public Ability ability;
    @SerializedName(SER_NAME_HIDDEN)
    public boolean isHidden;
}
