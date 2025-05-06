package com.leandro.jacome.pockeretrofit.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.leandro.jacome.pockeretrofit.R;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private View globalProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {
        globalProgressBar = findViewById(R.id.global_loader);
        if (globalProgressBar != null) globalProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        if (globalProgressBar != null) globalProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
