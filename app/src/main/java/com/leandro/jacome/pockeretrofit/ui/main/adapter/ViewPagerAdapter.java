package com.leandro.jacome.pockeretrofit.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.leandro.jacome.pockeretrofit.ui.main.MainActivity;
import com.leandro.jacome.pockeretrofit.ui.main.home.FragmentHome;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(MainActivity activity) {
        super(activity);
    }

    @Override
    public int getItemCount() {
        return 2; // Pokédex y Favoritos
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new FragmentHome(); // Pokédex
            case 1: return new FragmentHome(); // Debes crear este fragmento
            default: return new FragmentHome(); // Fallback
        }
    }

}
