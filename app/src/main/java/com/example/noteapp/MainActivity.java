package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNav= findViewById(R.id.bottomNav);
        NavHostFragment navhostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navhostFragment);
        assert navhostFragment != null;
        NavigationUI.setupWithNavController(bottomNav, navhostFragment.getNavController());




    }
}