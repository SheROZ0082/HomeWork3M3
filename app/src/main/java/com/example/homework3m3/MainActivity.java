package com.example.homework3m3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    Button SkipBtn, NextBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SkipBtn = findViewById(R.id.btn_skip1m);
        NextBtn = findViewById(R.id.btn_next1m);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.conteiner, medicFragment.class, null).commit();
        }

        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment() instanceof medicFragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.conteiner, new medic2Fragment()).commit();
                } else if (fragment() instanceof medic2Fragment) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.conteiner, new Medic3Fragment()).commit();
                }
            }

            private Fragment fragment() {
                return getSupportFragmentManager().findFragmentById(R.id.conteiner);
            }
        });
        SkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.conteiner, new Medic3Fragment()).commit();
            }
        });
    }
}