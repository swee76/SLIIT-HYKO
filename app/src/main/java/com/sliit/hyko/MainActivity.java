package com.sliit.hyko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navigationView = findViewById(R.id.bottomNavigationBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int i = 1;
                if (item.getItemId() == R.id.nav_home) {
                    fragmentManager.beginTransaction().replace(R.id.body_container, new HomeFragment()).setReorderingAllowed(true).addToBackStack("Home").commit();
                    return false;
                } else if (item.getItemId() == R.id.nav_search) {
                    fragmentManager.beginTransaction().replace(R.id.body_container, new SearchFragment()).setReorderingAllowed(true).addToBackStack("Search").commit();
                    return false;
                } else if (item.getItemId() == R.id.nav_post) {
                    fragmentManager.beginTransaction().replace(R.id.body_container, new AddPostFragment()).setReorderingAllowed(true).addToBackStack("Post").commit();
                    return false;
                } else if (item.getItemId() == R.id.nav_like) {
                    fragmentManager.beginTransaction().replace(R.id.body_container, new FavouritesFragment()).setReorderingAllowed(true).addToBackStack("Like").commit();
                    return false;
                } else if (item.getItemId() == R.id.nav_profile) {
                    fragmentManager.beginTransaction().replace(R.id.body_container, new ProfileFragment()).setReorderingAllowed(true).addToBackStack("Profile").commit();
                    return false;
                }

                return false;
            }
        });

    }
}