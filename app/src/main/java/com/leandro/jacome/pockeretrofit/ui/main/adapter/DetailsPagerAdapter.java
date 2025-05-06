package com.leandro.jacome.pockeretrofit.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.leandro.jacome.pockeretrofit.ui.main.details.AboutFragment;
import com.leandro.jacome.pockeretrofit.ui.main.details.EvolutionFragment;
import com.leandro.jacome.pockeretrofit.ui.main.details.StatsFragment;

public class DetailsPagerAdapter  extends FragmentStateAdapter {

    public DetailsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new AboutFragment();
            case 1: return new StatsFragment();
            case 2: return new EvolutionFragment();
            default: return new AboutFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
