package com.leandro.jacome.pockeretrofit.data.model;

import static com.leandro.jacome.pockeretrofit.utils.Constants.SER_NAME_BASE_STAT;

import com.google.gson.annotations.SerializedName;

public class StatSlot {
    @SerializedName(SER_NAME_BASE_STAT)
    public int baseStat;
    public Stat stat;

    public int getBaseStat() {
        return baseStat;
    }

    public Stat getStat() {
        return stat;
    }
}
