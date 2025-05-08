package com.leandro.jacome.pockeretrofit.utils;

public class Constants {

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";
    public static final String IMG_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    public static final String PNG_EXT = ".png";

    public static final String POKEDEX = "Pokedex";
    public static final String FAVORITES = "Favoritos";
    public static final String ABOUT = "Acerca de";
    public static final String STATS = "Estadisticas";
    public static final String EVOLUTION = "Evoluciones";
    public static final String NAME = "name";
    public static final String IMAGEURL = "imageUrl";
    public static final String ID = "id";
    public static final String TV_SET_XP = " XP";

    // Models
    public static final String UNKNOWN_COLOR = "desconocido";
    public static final String UNKNOWN_CATEGORY = "Categoría desconocida";
    public static final String UNKNOWN_DESCRIPTION = "Descripción no disponible";
    public static final String HIDDEN_SKILL = " (oculta)";
    public static final String LANGUAGE_ES = "es";
    public static final String LANGUAGE_EN = "en";
    public static final String SER_NAME_FLAVOR = "flavor_text_entries";
    public static final String SER_NAME_GENERA = "genera";
    public static final String SER_NAME_HIDDEN = "is_hidden";
    public static final String SER_NAME_BASE_XP = "base_experience";
    public static final String SER_NAME_FRONT_DEFAULT = "front_default";
    public static final String SER_NAME_BASE_STAT = "base_stat";
    public static final String FORMAT_HEIGHT = "%.1f m";
    public static final String FORMAT_WEIGHT = "%.1f kg";

    // Endpoints
    public static final String GET_ALL_POKEMON = "pokemon";
    public static final String GET_POKEMON_ID = "pokemon/{id}";
    public static final String GET_POKEMON_DESC = "pokemon-species/{id}";


    public static final String MSG_ERROR = "Error al cargar.";

    private Constants() {
    }
}
