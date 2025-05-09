# PokéRetrofit 🐾

Una aplicación Android que muestra información detallada sobre Pokémon utilizando la [PokéAPI](https://pokeapi.co/). Esta app está desarrollada con arquitectura MVP y hace uso de Retrofit para las llamadas de red.

## 📱 Características

- Búsqueda y vista de detalles de Pokémon individuales.
- Visualización de información como:
    - Altura y peso
    - Tipos
    - Habilidades
    - Experiencia base
    - Estadísticas base con barras dinámicas coloreadas
    - Evoluciones en formato carrusel (usando `WhyNotImageCarousel`)
- Imagen destacada en la parte superior de la pantalla de detalles.
- Compatibilidad con modos oscuros y colores dinámicos por especie.
- Manejo de errores y estados vacíos.

## 🧱 Tecnologías

- **Lenguaje:** Java
- **Arquitectura:** MVP (Model View Presenter)
- **Red:** Retrofit + Gson
- **UI:** Material Design + ViewPager2 + TabLayout
- **Imagen:** Glide
- **Carrusel:** [WhyNotImageCarousel](https://github.com/skydoves/WhyNotImageCarousel)
- **Compatibilidad mínima:** Android 6.0 (API 23)

