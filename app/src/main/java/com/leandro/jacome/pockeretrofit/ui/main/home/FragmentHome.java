package com.leandro.jacome.pockeretrofit.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.leandro.jacome.pockeretrofit.R;
import com.leandro.jacome.pockeretrofit.data.model.Pokemon;
import com.leandro.jacome.pockeretrofit.presenter.HomeContract;
import com.leandro.jacome.pockeretrofit.presenter.HomePresenter;
import com.leandro.jacome.pockeretrofit.ui.main.adapter.PokemonAdapter;

import java.util.List;

public class FragmentHome extends Fragment implements HomeContract.View{

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HomeContract.Presenter presenter;
    private PokemonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
        recyclerView = view.findViewById(R.id.recyclerPokemon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PokemonAdapter();
        recyclerView.setAdapter(adapter);

        presenter = new HomePresenter(this);
        presenter.loadPokemons(); // Usa el nombre correcto del método

        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadPokemons());

        return view;
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        swipeRefreshLayout.setRefreshing(false);
        adapter.setData(pokemons);
    }

    @Override
    public void showError(String message) {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }
}