package com.leandro.jacome.pockeretrofit.utils;

public class Constants {

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";
    public static final String IMG_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    public static final String PNG_EXT = ".png";
    public static final String GIF_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/52427d467f3e3b22af3c9cefc807a7452196ccd7/sprites/pokemon/other/showdown/";
    public static final String GIF_EXT = ".gif";

    public static final String POKEDEX = "Pokedex";
    public static final String FAVORITES = "Favoritos";
    public static final String ABOUT = "Acerca de";
    public static final String STATS = "Estadisticas";
    public static final String EVOLUTION = "Evoluciones";

    public static final String NAME = "name";
    public static final String IMAGEURL = "imageUrl";
    public static final String GIFURL = "gifUrl";
    public static final String EVO_CHAIN_ID = "evolution_chain_id";
    public static final String ID = "id";
    public static final String TV_SET_XP = " XP";

    // Colors
    public static final String COLOR_RED = "red";
    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_GREEN = "green";
    public static final String COLOR_YELLOW = "yellow";
    public static final String COLOR_PURPLE = "purple";
    public static final String COLOR_BROWN = "brown";
    public static final String COLOR_PINK = "pink";
    public static final String COLOR_BLACK = "black";
    public static final String COLOR_WHITE = "white";

    // keys labels
    public static final String EN_STR_HP = "hp";
    public static final String EN_STR_ATTACK = "attack";
    public static final String EN_STR_DEFENSE = "defense";
    public static final String EN_STR_SP_ATTACK = "special-attack";
    public static final String EN_STR_SP_DEFENSE = "special-defense";
    public static final String EN_STR_SPEED = "speed";

    public static final String ES_STR_HP = "HP";
    public static final String ES_STR_ATTACK = "Ataque";
    public static final String ES_STR_DEFENSE = "Defensa";
    public static final String ES_STR_SP_ATTACK = "Atq. Esp.";
    public static final String ES_STR_SP_DEFENSE = "Def. Esp.";
    public static final String ES_STR_SPEED = "Velocidad";

    // Models
    public static final String UNKNOWN_COLOR = "desconocido";
    public static final String UNKNOWN_CATEGORY = "Categoría desconocida";
    public static final String UNKNOWN_DESCRIPTION = "Descripción no disponible";
    public static final String EVO_NOT_FOUND = "No se encontró evolución";
    public static final String ERROR_RED = "Error de red: ";
    public static final String HIDDEN_SKILL = " (oculta)";
    public static final String LANGUAGE_ES = "es";
    public static final String LANGUAGE_EN = "en";

    public static final String SER_NAME_FLAVOR = "flavor_text_entries";
    public static final String SER_NAME_GENERA = "genera";
    public static final String SER_NAME_HIDDEN = "is_hidden";
    public static final String SER_NAME_BASE_XP = "base_experience";
    public static final String SER_NAME_FRONT_DEFAULT = "front_default";
    public static final String SER_NAME_BASE_STAT = "base_stat";
    public static final String SER_EVO_CHAIN = "evolution_chain";
    public static final String SER_ENVOLVES_TO = "evolves_to";

    public static final String FORMAT_HEIGHT = "%.1f m";
    public static final String FORMAT_WEIGHT = "%.1f kg";

    // Endpoints
    public static final String GET_ALL_POKEMON = "pokemon";
    public static final String GET_POKEMON_ID = "pokemon/{id}";
    public static final String GET_POKEMON_DESC = "pokemon-species/{id}";
    public static final String GET_EVOLUTION = "evolution-chain/{id}";


    public static final String MSG_ERROR = "Error al cargar.";

    private Constants() {
    }
}
