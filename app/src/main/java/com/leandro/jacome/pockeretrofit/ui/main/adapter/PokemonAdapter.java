package com.leandro.jacome.pockeretrofit.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.ui.main.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList = new ArrayList<>();

    public void setData(List<Pokemon> list) {
        this.pokemonList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon p = pokemonList.get(position);
        String pokemonUpper = p.getName().substring(0, 1).toUpperCase() + p.getName().substring(1);

        holder.id.setText("#" + p.getId());
        holder.name.setText(pokemonUpper);

        Glide.with(holder.itemView.getContext()).load(p.getImageUrl()).into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            DetailsActivity.start(v.getContext(), p, p.getId());
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void updateList(List<Pokemon> newList) {
        pokemonList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView name, id;
        ImageView image;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pokemon_name);
            image = itemView.findViewById(R.id.pokemon_image);
            id = itemView.findViewById(R.id.tvNumber);
        }
    }
}
