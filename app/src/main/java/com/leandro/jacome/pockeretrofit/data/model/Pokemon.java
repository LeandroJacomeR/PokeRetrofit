package com.leandro.jacome.pockeretrofit.data.model;

import static com.leandro.jacome.pockeretrofit.utils.Constants.IMG_URL;
import static com.leandro.jacome.pockeretrofit.utils.Constants.PNG_EXT;

public class Pokemon {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        String[] segments = url.split("/");
        return Integer.parseInt(segments[segments.length - 1]);
    }

    public String getImageUrl() {
        return IMG_URL + getId() + PNG_EXT;
    }
}
